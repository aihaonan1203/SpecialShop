package com.jzhson.communal.http;

/**
 * Created by Hjb on 2019/6/3.
 */

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 调度类
 */
public class RxHelper {

    public static   <T> ObservableTransformer<T, T> applySchedulers() {
        return (ObservableTransformer<T, T>) new ObservableTransformer() {
            @Override
            public ObservableSource apply(Observable upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
