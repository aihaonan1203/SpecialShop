package google.architecture.sort.http;

import com.jzhson.communal.http.ApiClient;

import com.jzhson.communal.base.CommonBean;

import google.architecture.sort.bean.AllSortBean;
import io.reactivex.Observable;

public class GankDataRepository {

    public static Observable<CommonBean<AllSortBean>>  getFuliDataRepository(String token){
        return ApiClient.initService(SortService.class).getSortData(token);
    }


}
