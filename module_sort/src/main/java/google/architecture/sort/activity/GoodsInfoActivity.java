package google.architecture.sort.activity;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jaeger.library.StatusBarUtil;
import com.jzhson.communal.base.BaseActivity;
import com.jzhson.communal.widget.MyScrollView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.Arrays;

import google.architecture.sort.R;

public class GoodsInfoActivity extends BaseActivity implements MyScrollView.TranslucentListener {

    String[] urls = {
            "https://image.yunifang.com/yunifang/images/goods/2076/goods_img/170930212555714134276722977.jpg",
            "https://image.yunifang.com/yunifang/images/goods/492/goods_img/171011191068814258195256706.jpg",
            "https://image.yunifang.com/yunifang/images/goods/2076/goods_img/170930212555714134276722977.jpg",
            "https://image.yunifang.com/yunifang/images/goods/492/goods_img/171011191068814258195256706.jpg",
            "https://image.yunifang.com/yunifang/images/goods/2076/goods_img/170930212555714134276722977.jpg",
            "https://image.yunifang.com/yunifang/images/goods/492/goods_img/171011191068814258195256706.jpg"
    };
    private Toolbar toolbar;
    private MyScrollView myScrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_info);
        StatusBarUtil.setTranslucentForImageView(GoodsInfoActivity.this, 0,null);
        initToolbar();
        Banner banner=findViewById(R.id.banner);
        myScrollView=findViewById(R.id.scrollView);
        myScrollView.setTranslucentListener(this);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                imageView.setImageURI(Uri.parse((String) path));
            }

            @Override
            public ImageView createImageView(Context context) {
                return new SimpleDraweeView(context);
            }
        });
        //设置banner样式
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        banner.setImages(Arrays.asList(urls));
        banner.setDelayTime(5000);
        banner.start();
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.id_toolbar);
        TextView titleText =  findViewById(R.id.toolbar_title);
        toolbar.setTitle("");
        titleText.setText("商品详情");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setAlpha(0);
        setAndroidNativeLightStatusBar(this,true);
    }


    @Override
    public void onTranlucent(float x) {
        toolbar.setAlpha(1-x);
    }
}
