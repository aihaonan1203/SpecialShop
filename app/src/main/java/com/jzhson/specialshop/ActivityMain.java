package com.jzhson.specialshop;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jzhson.communal.base.ARouterPath;
import com.jzhson.communal.base.BaseActivity;
import com.jzhson.communal.base.BaseFragment;
import com.jzhson.communal.widget.NoScrollViewPager;
import com.jzhson.specialshop.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class ActivityMain extends BaseActivity {

    ActivityMainBinding mainBinding;
    private NoScrollViewPager mPager;
    private List<BaseFragment> mFragments = new ArrayList<>();
    private FragmentAdapter mAdapter;

    public BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int i = item.getItemId();
            if (i == R.id.navigation_home) {
                mPager.setCurrentItem(0);
                return true;
            } else if (i == R.id.navigation_dashboard) {
                mPager.setCurrentItem(1);
                return true;
            } else if (i == R.id.navigation_notifications) {
                mPager.setCurrentItem(2);
                return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         mainBinding = DataBindingUtil.setContentView(ActivityMain.this, R.layout.activity_main);

         mainBinding.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
         mPager = mainBinding.containerPager;
         mPager.setOffscreenPageLimit(3);

        BaseFragment fragmentNews = (BaseFragment) ARouter.getInstance().build(ARouterPath.ClassifyFgt).navigation();
        BaseFragment fragmentGirls = (BaseFragment) ARouter.getInstance().build( ARouterPath.ClassifyFgt).navigation();
        BaseFragment fragmentAbout = (BaseFragment) ARouter.getInstance().build( ARouterPath.ClassifyFgt).navigation();

        mFragments.add(fragmentNews);
        mFragments.add(fragmentGirls);
        mFragments.add(fragmentAbout);

        mAdapter = new FragmentAdapter(getSupportFragmentManager(), mFragments);
        mainBinding.setViewPaAdapter(mAdapter);

    }
}
