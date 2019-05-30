package com.jzhson.communal.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.apkfuns.logutils.LogUtils;

import java.lang.reflect.ParameterizedType;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by dxx on 2017/11/20.
 */

public class BaseViewModel<T> extends AndroidViewModel {

    //生命周期观察的数据
    private MutableLiveData<T>  liveObservableData = new MutableLiveData<>();
    //UI使用可观察的数据 ObservableField是一个包装类
    public ObservableField<T> uiObservableData = new ObservableField<>();

    private final CompositeDisposable mDisposable = new CompositeDisposable();

    private static final MutableLiveData ABSENT = new MutableLiveData();
    {
        //noinspection unchecked
        ABSENT.setValue(null);
    }


    public BaseViewModel(@NonNull Application application) {
        super(application);
        LogUtils.d("=======BaseViewModel--onCreate=========");
    }


    /**
     * LiveData支持了lifecycle生命周期检测
     * @return
     */
    public LiveData<T> getLiveObservableData() {
        return liveObservableData;
    }

    /**
     * 当主动改变数据时重新设置被观察的数据
     * @param product
     */
    public void setUiObservableData(T product) {
        this.uiObservableData.set(product);
    }

    public Class<T> getTClass(){
        Class<T> tClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return tClass;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mDisposable.clear();
        LogUtils.d("=======BaseViewModel--onCleared=========");
    }
}
