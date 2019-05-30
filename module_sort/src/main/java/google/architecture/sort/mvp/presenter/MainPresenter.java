package google.architecture.sort.mvp.presenter;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;

import com.jzhson.communal.base.BaseFragment;
import com.jzhson.communal.base.CommonBean;

import google.architecture.sort.mvp.contract.MainContract;
import google.architecture.sort.bean.AllSortBean;
import google.architecture.sort.viewmodel.SortViewModel;

public class MainPresenter implements MainContract.Presenter {

    private BaseFragment fragment;
    private MainContract.View mView;

    public MainPresenter(BaseFragment fragment, MainContract.View mView) {
        this.fragment = fragment;
        this.mView = mView;
    }

    public void getNetData(){
        SortViewModel model= ViewModelProviders.of(fragment).get(SortViewModel.class);
        model.getLiveObservableData().observe(fragment, new Observer<CommonBean<AllSortBean>>() {
            @Override
            public void onChanged(@Nullable CommonBean<AllSortBean> bean) {
                mView.initVerticalTabLayout(bean);
            }
        });
    }


}
