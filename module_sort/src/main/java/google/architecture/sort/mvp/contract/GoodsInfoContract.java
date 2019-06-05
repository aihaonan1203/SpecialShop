package google.architecture.sort.mvp.contract;

import com.jzhson.communal.base.BasePresenter;
import com.jzhson.communal.base.BaseView;
import com.jzhson.communal.base.CommonBean;


import google.architecture.sort.bean.GoodsBean;
import google.architecture.sort.bean.GoodsInfoBean;
import io.reactivex.Observable;

/**
 * Created by Hjb on 2019/6/5.
 */

public interface GoodsInfoContract {
    interface Model {
        Observable<GoodsInfoBean> getData(String token,String url, String origin_id, String user_type);

    }

    interface View extends BaseView{
        void onDataChange(GoodsInfoBean bean);
        void onError();
    }

    interface Presenter{
        void getNetInfo(String token,String url, String origin_id, String user_type);
    }
}
