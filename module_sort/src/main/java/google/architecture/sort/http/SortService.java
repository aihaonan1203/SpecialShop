package google.architecture.sort.http;


import com.jzhson.communal.base.CommonBean;

import google.architecture.sort.bean.AllSortBean;
import google.architecture.sort.bean.GoodsBean;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface SortService {

    @POST("amoy/goods/cate")
    Observable<CommonBean<AllSortBean>> getSortData(@Header("token")String token);


    @POST("amoy/goods/cate")
    @FormUrlEncoded
    Observable<CommonBean> test(@Header("token")String token, @Field("test")String string);

    @POST("amoy/user/search_goods")
    @FormUrlEncoded
    Observable<CommonBean<GoodsBean>> search_goods(@Header("token")String token, @Field("word")String word, @Field("page")int page);
}
