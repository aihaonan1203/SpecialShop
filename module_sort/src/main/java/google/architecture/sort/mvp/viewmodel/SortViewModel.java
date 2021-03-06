package google.architecture.sort.mvp.viewmodel;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.apkfuns.logutils.LogUtils;

import com.jzhson.communal.base.BaseApplication;
import com.jzhson.communal.base.CommonBean;

import google.architecture.sort.bean.AllSortBean;
import google.architecture.sort.http.GankDataRepository;
import com.jzhson.communal.util.NetUtils;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 保存生命周期和UI所使用的数据
 * Created by dxx on 2017/11/10.
 */

public class SortViewModel extends AndroidViewModel {

    private static final MutableLiveData ABSENT = new MutableLiveData();
    {
        //noinspection unchecked
        ABSENT.setValue(null);
    }

    //生命周期观察的数据
    private LiveData<CommonBean<AllSortBean>> mLiveObservableData;
    //UI使用可观察的数据 ObservableField是一个包装类
    public ObservableField<CommonBean<AllSortBean>> uiObservableData = new ObservableField<>();

    private final CompositeDisposable mDisposable = new CompositeDisposable();

    public SortViewModel(@NonNull Application application) {
        super(application);
        Log.i("danxx", "GirlsViewModel------>");
        //这里的trigger为网络检测，也可以换成缓存数据是否存在检测
        mLiveObservableData = Transformations.switchMap(NetUtils.netConnected(application), new Function<Boolean, LiveData<CommonBean<AllSortBean>>>() {
            @Override
            public LiveData<CommonBean<AllSortBean>> apply(Boolean isNetConnected) {
                Log.i("danxx", "apply------>");
                if (!isNetConnected) {
                    return ABSENT; //网络未连接返回空
                }
                final MutableLiveData<CommonBean<AllSortBean>> applyData = new MutableLiveData<>();

                GankDataRepository.getFuliDataRepository(BaseApplication.getIns().getToken())
                .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<CommonBean<AllSortBean>>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                    mDisposable.add(d);
                            }

                            @Override
                            public void onNext(CommonBean<AllSortBean> value) {
                                Log.i("danxx", "setValue------>");
                                applyData.setValue(value);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.i("danxx", "onError------>");
                                e.printStackTrace();
                            }

                            @Override
                            public void onComplete() {
                                Log.i("danxx", "onComplete------>");
                            }
                        });
                return applyData;
            }
        });
    }
    /**
     * LiveData支持了lifecycle生命周期检测
     * @return
     */
    public LiveData<CommonBean<AllSortBean>> getLiveObservableData() {
        return mLiveObservableData;
    }

    /**
     * 设置
     * @param product
     */
    public void setUiObservableData(CommonBean product) {
        this.uiObservableData.set(product);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mDisposable.clear();
        LogUtils.d("=======GirlsViewModel--onCleared=========");
    }
}
