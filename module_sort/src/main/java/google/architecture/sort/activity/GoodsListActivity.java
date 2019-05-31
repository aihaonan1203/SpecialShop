package google.architecture.sort.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jaeger.library.StatusBarUtil;
import com.jzhson.communal.base.BaseActivity;

import google.architecture.sort.R;

public class GoodsListActivity extends BaseActivity {

    private Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);
        StatusBarUtil.setTranslucent(this, 50);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        type=getIntent().getStringExtra("type");
        toolbar = findViewById(R.id.toolbar);
        mRecyclerView = findViewById(R.id.mRecyclerView);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
