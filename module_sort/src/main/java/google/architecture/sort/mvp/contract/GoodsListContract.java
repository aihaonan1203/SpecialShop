package google.architecture.sort.mvp.contract;

import com.jzhson.communal.base.BaseView;

import java.util.List;

import google.architecture.sort.bean.GoodsBean;

/**
 * Created by Hjb on 2019/5/31.
 */

public interface GoodsListContract {
    interface Model {
    }

    interface View extends BaseView{
        void initList(List<GoodsBean> data,int state);
    }

    interface Presenter {

    }
}
