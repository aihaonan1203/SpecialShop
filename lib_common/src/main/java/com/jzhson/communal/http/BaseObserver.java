package com.jzhson.communal.http;

/**
 * Created by Hjb on 2019/6/3.
 */

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 创建Base抽象类实现Observer
 */
public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {
    private static final String TAG = "BaseObserver";
    @Override
    public void onSubscribe(Disposable d) {
        Log.e(TAG, "onSubscribe: " );
    }
    @Override
    public void onNext(BaseResponse<T> response) {
        //在这边对 基础数据 进行统一处理  举个例子：
        if(response.getRes_code()==200){
            onSuccess(response.getDemo());
        }else{
            onFailure(null,response.getErr_msg());
        }
    }
    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "Throwable: " + e.getMessage());
        onFailure(e,"");
    }

    @Override
    public void onComplete() {
        Log.e(TAG, "onComplete: " );
    }

    public abstract void onSuccess(T demo);

    public abstract void onFailure(Throwable e,String errorMsg);
}
