package google.architecture.sort.mvp.model;

import com.jzhson.communal.base.CommonBean;
import com.jzhson.communal.http.ApiClient;

import google.architecture.sort.bean.GoodsBean;
import google.architecture.sort.bean.GoodsInfoBean;
import google.architecture.sort.http.SortService;
import google.architecture.sort.mvp.contract.GoodsInfoContract;
import io.reactivex.Observable;

/**
 * Created by Hjb on 2019/6/5.
 */

public class GoodsInfoModel implements GoodsInfoContract.Model {


    @Override
    public Observable<GoodsInfoBean> getData(String token, String url, String origin_id, String user_type) {
        return ApiClient.initService(SortService.class).getGoodsInfo(token,url,origin_id,user_type);
    }
}
