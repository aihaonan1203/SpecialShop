package google.architecture.sort.mvp.presenter;

import com.jzhson.communal.base.BaseApplication;
import com.jzhson.communal.base.CommonBean;
import com.jzhson.communal.http.ApiClient;
import com.jzhson.communal.http.RxExceptionUtil;
import com.jzhson.communal.http.RxHelper;
import com.jzhson.communal.util.UIUtils;

import java.util.List;

import google.architecture.sort.bean.GoodsBean;
import google.architecture.sort.http.SortService;
import google.architecture.sort.mvp.contract.GoodsListContract;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Hjb on 2019/5/31.
 */

public class GoodsListPresenter implements GoodsListContract.Presenter {

    private GoodsListContract.View view;

    public GoodsListPresenter(GoodsListContract.View view) {
        this.view = view;
    }


    public void getData(String type,int page) {
        ApiClient.initService(SortService.class).search_goods(BaseApplication.getIns().getToken(),type,page)
                .compose(RxHelper.applySchedulers())
                .subscribe(new Observer<CommonBean<GoodsBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CommonBean<GoodsBean> value) {
                        List<GoodsBean> data = value.getData();
                        view.initList(data);
                        view.showToast(value.getMsg(), UIUtils.T_SUCCESS);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showToast(RxExceptionUtil.exceptionHandler(e), UIUtils.T_ERROR);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
