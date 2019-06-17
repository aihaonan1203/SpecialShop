package google.architecture.sort;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jaeger.library.StatusBarUtil;
import com.jzhson.communal.base.ARouterPath;
import com.jzhson.communal.base.BaseFragment;
import com.jzhson.communal.base.CommonBean;
import com.jzhson.communal.util.UIUtils;
import com.jzhson.communal.widget.MyGridViewNoScroll;

import java.util.List;

import google.architecture.sort.activity.search.SearchActivity;
import google.architecture.sort.adapter.MainSortAdapter;
import google.architecture.sort.bean.AllSortBean;
import google.architecture.sort.mvp.contract.MainContract;
import google.architecture.sort.mvp.presenter.MainPresenter;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;


/**
 * @Desc FragmentGirls
 */
@Route(path = ARouterPath.ClassifyFgt)
public class FragmentSort extends BaseFragment implements MainContract.View,View.OnClickListener {

    private VerticalTabLayout tablayout;
    private MyGridViewNoScroll rv_sort;
    private int tabId = 0;

    private MainPresenter presenter;
    private MainSortAdapter rightAdapter;
    private TextView tv_search;


    @Override
    protected void initBundle() {
    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_girls;
    }

    @Override
    protected void initView(View view) {
//        StatusBarUtil.setTranslucentForImageView(getActivity(), 0, view.findViewById(R.id.view));
        StatusBarUtil.setTranslucentForImageView(getActivity(), 0,null);
        ARouter.getInstance().inject(FragmentSort.this);
        tv_search=view.findViewById(R.id.tv_search);
        tablayout = view.findViewById(R.id.tablayout);
        rv_sort = view.findViewById(R.id.rv_sort);
        tv_search.setOnClickListener(this);
    }


    @Override
    protected void initData() {
        presenter = new MainPresenter(this, this);
        presenter.getNetData();
    }

    @Override
    public void showToast(String s, int type) {
        UIUtils.t(s, false, type);
    }

    @Override
    public void showDialog(String s) {

    }

    @Override
    public void onError(Integer type) {

    }

    @Override
    public void initVerticalTabLayout(final CommonBean<AllSortBean> bean) {
        final List<AllSortBean> data = bean.getData();
        tablayout.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return data.size();
            }

            @Override
            public TabView.TabBadge getBadge(int position) {
                return new TabView.TabBadge.Builder()
                        .build();
            }

            @Override
            public TabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public TabView.TabTitle getTitle(int position) {
                AllSortBean allSortBean = data.get(position);
                String cat_name = allSortBean.getCat_name();
                return new ITabView.TabTitle.Builder()
                        .setContent(cat_name)
                        .setTextColor(0xffF4904F, getResources().getColor(R.color.txt_color))
                        .build();
            }

            @Override
            public int getBackground(int position) {
                return R.color.white;
            }
        });
        tablayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                tab.setBackgroundColor(0xfff4f4f4);
                tablayout.getTabAt(tabId).setBackgroundColor(0xffffffff);
                tabId = position;
                initRightAdapter(data.get(position).getCate());
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });
        TabView tabAt = tablayout.getTabAt(tabId);
        tabAt.setBackgroundColor(0xfff4f4f4);
        initRightAdapter(data.get(0).getCate());
    }

    @Override
    public void initRightAdapter(List<AllSortBean.CateBean> data) {
        if (rightAdapter == null) {
            rightAdapter = new MainSortAdapter(R.layout.sort_main_right_item, data);
            rv_sort.setAdapter(rightAdapter);
        } else {
            rightAdapter.setNewData(data);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.tv_search){
            startActivity(new Intent(getActivity(), SearchActivity.class));
        }
    }
}
