package google.architecture.sort;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jzhson.communal.base.ARouterPath;
import com.jzhson.communal.base.BaseFragment;

import q.rorbin.badgeview.QBadgeView;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;


/**
 * @Desc FragmentGirls
 */
@Route(path = ARouterPath.ClassifyFgt)
public class FragmentSort extends BaseFragment {

    private VerticalTabLayout tablayout;
    private int tabId=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ARouter.getInstance().inject(FragmentSort.this);
        View view = inflater.inflate(R.layout.fragment_girls, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tablayout = view.findViewById(R.id.tablayout);
        tablayout.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return 25;
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
                return  new ITabView.TabTitle.Builder()
                        .setContent("生鲜")
                        .build();
            }

            @Override
            public int getBackground(int position) {
                return R.drawable.ic_arrow_back;
            }
        });
        tablayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                tab.setBackgroundColor(0xfff4f4f4);
                tablayout.getTabAt(tabId).setBackgroundColor(0xffffffff);
                tabId=position;
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });
    }
}
