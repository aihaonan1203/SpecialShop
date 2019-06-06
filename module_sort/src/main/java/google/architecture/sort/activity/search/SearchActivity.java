package google.architecture.sort.activity.search;

import android.os.Bundle;
import android.view.View;

import com.jaeger.library.StatusBarUtil;
import com.jzhson.communal.base.BaseActivity;

import google.architecture.sort.R;

public class SearchActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setShowAnimation(false);
        StatusBarUtil.setTranslucentForImageView(this, 0, findViewById(R.id.view));
        initView();
    }

    private void initView() {
        findViewById(R.id.tv_cancel).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_cancel:
                finish();
                break;
        }
    }
}
