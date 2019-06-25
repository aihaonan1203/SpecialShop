package com.jzhson.communal.base;

import android.app.Application;
import android.util.Log;

import com.alibaba.sdk.android.BaseAlibabaSDK;
import com.alibaba.sdk.android.callback.InitResultCallback;
import com.apkfuns.logutils.LogUtils;
import com.jzhson.communal.util.Utils;

import java.util.List;


/**
 * 要想使用BaseApplication，必须在组件中实现自己的Application，并且继承BaseApplication；
 * 组件中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用；
 * 组件的Application需置于java/debug文件夹中，不得放于主代码；
 * 组件中获取Context的方法必须为:Utils.getContext()，不允许其他写法；
 * @name BaseApplication
 */
public class BaseApplication extends Application {

    public static final String ROOT_PACKAGE = "com.guiying.module";
    private static final String TAG = "BaseApplication";

    private static BaseApplication sInstance;

    private List<ApplicationDelegate> mAppDelegateList;


    public static BaseApplication getIns() {
        return sInstance;
    }

    private String token="eyJ1aWQiOjEsInRpbWVzdGFtcCI6MTU1ODg1NjM3MCwic2lnbiI6ImY2MDYzYjU0YWI5YTNjMjRlMzE2NGQxNmE3ZDQwOTI1In0";

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
//        Logger.init("pattern").logLevel(LogLevel.FULL);
        Utils.init(this);
        mAppDelegateList = ClassUtils.getObjectsWithInterface(this, ApplicationDelegate.class, ROOT_PACKAGE);
        for (ApplicationDelegate delegate : mAppDelegateList) {
            delegate.onCreate();
        }
        CrashHandler.getInstance().init();
        LogUtils.getLogConfig()
                .configAllowLog(true)
                .configTagPrefix("danxx")
                .configShowBorders(true)
                .configFormatTag("%d{HH:mm:ss:SSS} %t %c{-5}");
        BaseAlibabaSDK.asyncInit(this, new InitResultCallback() {
            @Override
            public void onSuccess() {
                Log.d(TAG,"BaseAlibabaSDK init successed");
            }

            @Override
            public void onFailure(int code, String msg) {
                Log.e(TAG,"BaseAlibabaSDK init failed");
            }
        });
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        for (ApplicationDelegate delegate : mAppDelegateList) {
            delegate.onTerminate();
        }
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        for (ApplicationDelegate delegate : mAppDelegateList) {
            delegate.onLowMemory();
        }
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        for (ApplicationDelegate delegate : mAppDelegateList) {
            delegate.onTrimMemory(level);
        }
    }
}
