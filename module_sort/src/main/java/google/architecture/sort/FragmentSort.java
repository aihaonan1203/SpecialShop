package google.architecture.sort;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jzhson.communal.base.ARouterPath;
import com.jzhson.communal.base.BaseFragment;
import com.jzhson.communal.base.CommonBean;
import com.jzhson.communal.util.UIUtils;
import com.jzhson.communal.widget.MyGridViewNoScroll;

import java.util.List;

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
public class FragmentSort extends BaseFragment implements MainContract.View {

    private VerticalTabLayout tablayout;
    private MyGridViewNoScroll rv_sort;
    private int tabId = 0;

    private MainPresenter presenter;
    private MainSortAdapter rightAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ARouter.getInstance().inject(FragmentSort.this);
        View view = inflater.inflate(R.layout.fragment_girls, container, false);
        initView(view);
        presenter = new MainPresenter(this, this);
        presenter.getNetData();
        return view;
    }

    private void initView(View view) {
        tablayout = view.findViewById(R.id.tablayout);
        rv_sort = view.findViewById(R.id.rv_sort);
    }

    @Override
    public void showToast(String s) {
        UIUtils.t(s, false, UIUtils.T_WARNING);
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
                        .setTextColor(0xffF4904F,getResources().getColor(R.color.txt_color))
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
        if (rightAdapter==null){
            rightAdapter=new MainSortAdapter(R.layout.sort_main_right_item,data);
            rv_sort.setAdapter(rightAdapter);
        }else {
            rightAdapter.setNewData(data);
        }
    }

}
