package google.architecture.sort.activity;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jaeger.library.StatusBarUtil;
import com.jzhson.communal.base.BaseActivity;
import com.jzhson.communal.base.BaseApplication;
import com.jzhson.communal.base.MessageWrap;
import com.jzhson.communal.util.ImageUtils;
import com.jzhson.communal.widget.MyScrollView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import google.architecture.sort.R;
import google.architecture.sort.bean.GoodsBean;
import google.architecture.sort.bean.GoodsInfoBean;
import google.architecture.sort.mvp.contract.GoodsInfoContract;
import google.architecture.sort.mvp.presenter.GoodsInfoPresenter;

public class GoodsInfoActivity extends BaseActivity implements MyScrollView.TranslucentListener, GoodsInfoContract.View {

    private Toolbar toolbar;
    private MyScrollView myScrollView;
    private WebView mWebview;
    private String mUrl;
    private GoodsInfoPresenter presenter;
    private TextView tv_money1;
    private GoodsBean bean;
    //    private Banner banner;
    private SimpleDraweeView simpleDraweeView;
    private TextView tv_money_tm;
    private TextView tv_sales_num;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_info);
        StatusBarUtil.setTranslucentForImageView(GoodsInfoActivity.this, 0, null);
        initToolbar();
        initView();
        presenter = new GoodsInfoPresenter(this);
        presenter.getNetInfo(BaseApplication.getIns().getToken(), bean.getCoupon_link(), bean.getOrigin_id(), bean.getUser_type());
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initView() {
        tv_money1 = findViewById(R.id.tv_money1);
        simpleDraweeView = findViewById(R.id.iv_image);
        myScrollView = findViewById(R.id.scrollView);
        mWebview = findViewById(R.id.mWebview);
        myScrollView.setTranslucentListener(this);
        tv_money_tm = findViewById(R.id.tv_money_tm);
        tv_sales_num = findViewById(R.id.tv_sales_num);
        tv_title = findViewById(R.id.tv_title);

        SpannableString spannableString = new SpannableString("券后价￥" + String.valueOf(this.bean.getCoupon_price()));
        spannableString.setSpan(new RelativeSizeSpan(1.6f), 4, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv_money1.setText(spannableString);
        tv_money_tm.setText(String.valueOf(getResources().getString(R.string.txt_tm_money,String.valueOf(bean.getOrigin_price()))));
        tv_money_tm.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tv_money_tm.getPaint().setAntiAlias(true);//抗锯齿
        tv_sales_num.setText(String.valueOf(getResources().getString(R.string.txt_sales_num,String.valueOf(bean.getSales_num()))));
        tv_title.setText(bean.getTitle());
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.id_toolbar);
        TextView titleText = findViewById(R.id.toolbar_title);
        toolbar.setTitle("");
        titleText.setText("商品详情");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setAlpha(0);
        setAndroidNativeLightStatusBar(this, true);
    }


    @Override
    public void onTranlucent(float x) {
        toolbar.setAlpha(1 - x);
    }

    @Override
    public void showToast(String s, int type) {

    }

    @Override
    public void showDialog(String s) {

    }

    @Override
    public void onError(Integer type) {

    }

    @Override
    public void onDataChange(GoodsInfoBean bean) {
//        banner.setImageLoader(new ImageLoader() {
//            @Override
//            public void displayImage(Context context, Object path, ImageView imageView) {
//                imageView.setImageURI(Uri.parse((String) path));
//            }
//
//            @Override
//            public ImageView createImageView(Context context) {
//                return new SimpleDraweeView(context);
//            }
//        });
//        //设置banner样式
//        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
//        banner.setImages();
//        banner.setDelayTime(5000);
//        banner.start();
        ImageUtils.loadNetImage(simpleDraweeView, this.bean.getThumb());
        WebSettings settings = mWebview.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        settings.setGeolocationEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setUseWideViewPort(true); // 关键点
        settings.setAllowFileAccess(true); // 允许访问文件
        settings.setSupportZoom(false); // 支持缩放
        settings.setLoadWithOverviewMode(true);
        settings.setDisplayZoomControls(false);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE); // 不加载缓存内容
        mUrl = "https://mdetail.tmall.com/templates/pages/desc?id=" + this.bean.getOrigin_id();
        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String s) {
                //必须重写的方法 解决了优酷 百度视频不播放视频加载失败的问题
                if (mUrl.startsWith("intent") || mUrl.startsWith("youku")) {
                    return true;
                } else {
                    return super.shouldOverrideUrlLoading(view, mUrl);
                }
            }
        });
        mWebview.loadUrl(mUrl);
    }

    @Override
    public void onError() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onGetMessage(MessageWrap<GoodsBean> message) {
        if (message.getType().equals(GoodsInfoActivity.class.getName())) {
            bean = message.getBean();
        }
    }
}
