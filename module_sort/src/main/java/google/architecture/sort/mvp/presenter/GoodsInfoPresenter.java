package google.architecture.sort.mvp.presenter;

import com.jzhson.communal.base.BasePresenter;
import com.jzhson.communal.http.RxHelper;

import google.architecture.sort.bean.GoodsInfoBean;
import google.architecture.sort.mvp.contract.GoodsInfoContract;
import google.architecture.sort.mvp.model.GoodsInfoModel;
import io.reactivex.functions.Consumer;

/**
 * Created by Hjb on 2019/6/5.
 */

public class GoodsInfoPresenter extends BasePresenter<GoodsInfoContract.View> implements GoodsInfoContract.Presenter {

    private GoodsInfoModel model;

    public GoodsInfoPresenter(GoodsInfoContract.View view) {
        super(view);
        model=new GoodsInfoModel();
    }

    @Override
    public void getNetInfo(String token,String url, String origin_id, String user_type) {
        model.getData(token,url,origin_id,user_type)
                .compose(RxHelper.applySchedulers())
                .subscribe(new Consumer<GoodsInfoBean>() {
                    @Override
                    public void accept(GoodsInfoBean goodsInfoBean) throws Exception {
                        view.onDataChange(goodsInfoBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.onError();
                    }
                });
    }
}
