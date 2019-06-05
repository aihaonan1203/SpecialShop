package google.architecture.sort.http;


import com.jzhson.communal.base.CommonBean;

import google.architecture.sort.bean.AllSortBean;
import google.architecture.sort.bean.GoodsBean;
import google.architecture.sort.bean.GoodsInfoBean;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;


public interface SortService {

    @POST("amoy/goods/cate")
    Observable<CommonBean<AllSortBean>> getSortData(@Header("token")String token);


    @POST("amoy/goods/cate")
    @FormUrlEncoded
    Observable<CommonBean> test(@Header("token")String token, @Field("test")String string);

    @POST("amoy/user/search_goods")
    @FormUrlEncoded
    Observable<CommonBean<GoodsBean>> search_goods(@Header("token")String token, @Field("word")String word, @Field("page")int page);

    @POST("amoy/user/goods_details")
    @FormUrlEncoded
    Observable<GoodsInfoBean> getGoodsInfo(@Header("token")String token, @Field("url")String url, @Field("origin_id")String origin_id, @Field("user_type")String user_type);
}
