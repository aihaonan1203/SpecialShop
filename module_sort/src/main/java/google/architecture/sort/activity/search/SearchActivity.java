package google.architecture.sort.activity.search;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.jzhson.communal.base.BaseActivity;
import com.jzhson.communal.util.SPUtils;
import com.jzhson.communal.util.UIUtils;
import com.jzhson.communal.widget.FlowLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import google.architecture.sort.R;
import google.architecture.sort.activity.GoodsListActivity;

public class SearchActivity extends BaseActivity implements View.OnClickListener{

    private FlowLayout ls_flowLayout;
    private FlowLayout rm_flowLayout;
    private List<String> list;
    private EditText et_search;
    private LinearLayout ls_linelayout;

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
        ls_linelayout =findViewById(R.id.ls_linelayout);
        ls_flowLayout =findViewById(R.id.ls_flowLayout);
        rm_flowLayout =findViewById(R.id.rm_flowLayout);
        et_search=findViewById(R.id.et_search);
        list = new ArrayList<>();
        for (int i = 0; i <5; i++) {
            list.add("连衣裙");
            list.add("男士外套");
            list.add("海鲜");
            list.add("iphone");
            list.add("小米手机以及充电宝");
        }

        String search_txt = String.valueOf(SPUtils.get(this, "search_txt", ""));
        if (!search_txt.isEmpty()){
            List<String> list_search = Arrays.asList(search_txt.split(","));
            initFlowlayout(ls_flowLayout, list_search);
        }else {
            ls_linelayout.setVisibility(View.GONE);
        }
        initFlowlayout(rm_flowLayout, this.list);
        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String string = et_search.getText().toString();
                    StringBuilder search_txt =new StringBuilder(String.valueOf(SPUtils.get(SearchActivity.this,"search_txt","")));
                    if (search_txt.length()!=0){
                        if (search_txt.indexOf(string)==-1){
                            search_txt.insert(0,",").insert(0,string);
                        }
                    }else {
                        search_txt.append(string);
                    }
                    SPUtils.put(SearchActivity.this,"search_txt",search_txt.toString());
                    if (!search_txt.toString().isEmpty()){
                        ls_linelayout.setVisibility(View.VISIBLE);
                        List<String> list_search = Arrays.asList(search_txt.toString().split(","));
                        initFlowlayout(ls_flowLayout, list_search);
                    }
                    Intent intent = new Intent(SearchActivity.this, GoodsListActivity.class);
                    intent.putExtra("type",string);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
        findViewById(R.id.btn_clear).setOnClickListener(this);
    }

    private void initFlowlayout(FlowLayout flowLayout, List<String> data) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 5, 10, 5);
        if (flowLayout != null) {
            flowLayout.removeAllViews();
        }
        for (int i = 0; i < data.size(); i++) {
            TextView tv = new TextView(this);
            tv.setPadding(28, 10, 28, 10);
            tv.setText(data.get(i));
            tv.setMaxEms(10);
            tv.setSingleLine();
            tv.setBackgroundResource(R.drawable.bg_tv_search2);
            tv.setTextColor(0xffffffff);
            tv.setGravity(Gravity.CENTER);
            tv.setLayoutParams(layoutParams);
            int finalI = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SearchActivity.this, GoodsListActivity.class);
                    intent.putExtra("type",data.get(finalI));
                    startActivity(intent);
                }
            });
            assert flowLayout != null;
            flowLayout.addView(tv, layoutParams);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.tv_cancel){
            finish();
        }else if (v.getId()==R.id.btn_clear){
            SPUtils.remove(this,"search_txt");
            ls_flowLayout.removeAllViews();
            ls_linelayout.setVisibility(View.GONE);
        }
    }
}
