package com.jzhson.communal.http.repository;

import com.jzhson.communal.http.ApiClient;
import com.jzhson.communal.util.JsonUtil;
import com.jzhson.communal.util.SwitchSchedulers;


import io.reactivex.Observable;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;

/**
 * Created by dxx on 2017/11/20.
 * 动态url数据获取
 */

public class DynamicDataRepository {

    public static <T>Observable getDynamicData(String pullUrl, final Class<T> clazz) {

        return
                ApiClient
                .getDynamicDataService()
                .getDynamicData(pullUrl)
                .compose(SwitchSchedulers.applySchedulers())
                .map(new Function<ResponseBody, T>() {
                    @Override
                    public T apply(ResponseBody responseBody) throws Exception {
                        return JsonUtil.Str2JsonBean(responseBody.string(), clazz);
                    }
                });
    }

}