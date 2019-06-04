package com.jzhson.communal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ScrollView;

/**
 * Created by Hjb on 2019/6/4.
 */

public class MyScrollView extends ScrollView {

    private TranslucentListener listener;


    public void setTranslucentListener(TranslucentListener listener) {
        this.listener = listener;
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        Log.i("onScrollChanged","l="+l+",t="+t+",oldl="+oldl+",oldt="+oldt+",getScrollY="+getScrollY());
        if(listener!=null){
            int scrollY = getScrollY();
            int screen_height = getContext().getResources().getDisplayMetrics().heightPixels;
            if(scrollY<=screen_height/3f){
                listener.onTranlucent(1-scrollY/(screen_height/3f));
            }
        }
    }

    public interface TranslucentListener{
        void onTranlucent(float x);
    }

}
