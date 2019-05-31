package com.jzhson.module_home;


import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jzhson.communal.base.ARouterPath;
import com.jzhson.communal.base.BaseFragment;

@Route(path = ARouterPath.HomeFgt)
public class FragmentHome extends BaseFragment {



    @Override
    protected void initBundle() {

    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_fragment_home;
    }

    @Override
    protected void initView(View view) {
        ARouter.getInstance().inject(FragmentHome.this);
    }

    @Override
    protected void initData() {

    }

}
