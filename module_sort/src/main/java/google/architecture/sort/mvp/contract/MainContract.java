package google.architecture.sort.mvp.contract;

import com.jzhson.communal.base.BaseView;
import com.jzhson.communal.base.CommonBean;

import java.util.List;

import google.architecture.sort.bean.AllSortBean;

/**
 * Created by Hjb on 2019/5/30.
 */

public interface MainContract {
    interface Model {
    }

    interface View extends BaseView{
        void initVerticalTabLayout(CommonBean<AllSortBean> bean);
        void initRightAdapter(List<AllSortBean.CateBean> data);
    }

    interface Presenter {
    }
}
