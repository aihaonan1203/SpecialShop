package google.architecture.sort.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jaeger.library.StatusBarUtil;
import com.jzhson.communal.base.BaseActivity;
import com.jzhson.communal.util.UIUtils;

import java.util.List;

import google.architecture.sort.R;
import google.architecture.sort.adapter.GoodsAdapter;
import google.architecture.sort.bean.GoodsBean;
import google.architecture.sort.mvp.contract.GoodsListContract;
import google.architecture.sort.mvp.presenter.GoodsListPresenter;

public class GoodsListActivity extends BaseActivity implements GoodsListContract.View{

    private RecyclerView mRecyclerView;
    private String type;
    private GoodsListPresenter presenter;
    private GoodsAdapter goodsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);
        StatusBarUtil.setTranslucent(this);
        setShowAnimation(false);
        initToolbar();
        initView();
        presenter=new GoodsListPresenter(this);
        presenter.getData(type,1);
    }

    private void initToolbar() {
        type=getIntent().getStringExtra("type");
        Toolbar toolbar =  findViewById(R.id.id_toolbar);
        TextView titleText =  findViewById(R.id.toolbar_title);
        toolbar.setTitle("");
        titleText.setText(type);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    private void initView() {
        mRecyclerView = findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
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
        initAdapter(data);
    }

    private void initAdapter(List<GoodsBean> data) {
        if (goodsAdapter==null){
            goodsAdapter = new GoodsAdapter(data,this);
            mRecyclerView.setAdapter(goodsAdapter);
            goodsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    startActivity(new Intent(GoodsListActivity.this,GoodsInfoActivity.class));
                }
            });
        }else {
            goodsAdapter.setNewData(data);
        }
    }
}
