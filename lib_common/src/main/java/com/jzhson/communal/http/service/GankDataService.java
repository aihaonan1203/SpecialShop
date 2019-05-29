package com.jzhson.communal.http.service;


import com.jzhson.communal.http.entities.GirlsData;
import com.jzhson.communal.http.entities.NewsData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by dxx on 2017/11/8.
 */

public interface GankDataService {

    @GET  ("api/data/福利/{size}/{index}")
    Observable<GirlsData> getFuliData(@Path("size") String size, @Path("index") String index);

    @GET("api/data/Android/{size}/{index}")
    Observable<NewsData> getAndroidData(@Path("size") String size, @Path("index") String index);

}
