package com.jzhson.specialshop;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jaeger.library.StatusBarUtil;
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
            } else if (i == R.id.navigation_sort) {
                mPager.setCurrentItem(1);
                return true;
            } else if (i==R.id.navigation_range){
                mPager.setCurrentItem(2);
                return true;
            }else if (i == R.id.navigation_my) {
                mPager.setCurrentItem(3);
                return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setTranslucentForImageView(this, 0, findViewById(R.id.view));
        mainBinding = DataBindingUtil.setContentView(ActivityMain.this, R.layout.activity_main);
        mainBinding.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        mPager = mainBinding.containerPager;
        mPager.setOffscreenPageLimit(3);
        mainBinding.navigation.setLabelVisibilityMode(1);
        BaseFragment fragmentHome = (BaseFragment) ARouter.getInstance().build(ARouterPath.HomeFgt).navigation();
        BaseFragment fragmentSort = (BaseFragment) ARouter.getInstance().build( ARouterPath.ClassifyFgt).navigation();
        BaseFragment fragmentRange = (BaseFragment) ARouter.getInstance().build( ARouterPath.RangeFgt ).navigation();
        BaseFragment fragmentMy = (BaseFragment) ARouter.getInstance().build( ARouterPath.MyFgt ).navigation();

        mFragments.add(fragmentHome);
        mFragments.add(fragmentSort);
        mFragments.add(fragmentRange);
        mFragments.add(fragmentMy);

        mAdapter = new FragmentAdapter(getSupportFragmentManager(), mFragments);
        mainBinding.setViewPaAdapter(mAdapter);
    }
}
