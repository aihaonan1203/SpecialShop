package google.architecture.sort.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jaeger.library.StatusBarUtil;
import com.jzhson.communal.base.BaseActivity;
import com.jzhson.communal.util.UIUtils;

import java.util.List;

import google.architecture.sort.R;
import google.architecture.sort.bean.GoodsBean;
import google.architecture.sort.mvp.contract.GoodsListContract;
import google.architecture.sort.mvp.presenter.GoodsListPresenter;

public class GoodsListActivity extends BaseActivity implements GoodsListContract.View{

    private Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private String type;
    private GoodsListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);
        StatusBarUtil.setTranslucent(this, 50);
        initView();
        presenter=new GoodsListPresenter(this);
        presenter.getData(type,1);
    }


    private void initView() {
        type=getIntent().getStringExtra("type");
        toolbar = findViewById(R.id.toolbar);
        mRecyclerView = findViewById(R.id.mRecyclerView);
        setSupportActionBar(toolbar);
        toolbar.setTitle(type);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void showToast(String s,int type) {
        UIUtils.t(s,false,type);
    }

    @Override
    public void showDialog(String s) {

    }

    @Override
    public void onError(Integer type) {

    }

    @Override
    public void initList(List<GoodsBean> data) {

    }
}
