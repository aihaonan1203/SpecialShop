package google.architecture.sort.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jzhson.communal.util.ImageUtils;

import java.util.List;

import google.architecture.sort.R;
import google.architecture.sort.bean.GoodsBean;

/**
 * Created by Hjb on 2019/6/4.
 */

public class GoodsAdapter extends BaseQuickAdapter<GoodsBean,BaseViewHolder>{

    private Context context;

    public GoodsAdapter(@Nullable List<GoodsBean> data, Context context) {
        super(R.layout.goods_item_view, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsBean item) {
        ImageUtils.loadNetImage(helper.getView(R.id.iv_image),item.getThumb());
        helper.setText(R.id.tv_title,item.getTitle());
        helper.setText(R.id.tv_money,String.valueOf(context.getResources().getString(R.string.txt_money,item.getCoupon_price())));
        helper.setText(R.id.tv_money_tm,String.valueOf(context.getResources().getString(R.string.txt_tm_money,item.getOrigin_price())));
        helper.setText(R.id.tv_sales_num,String.valueOf(context.getResources().getString(R.string.txt_sales_num,item.getSales_num())));
        helper.setText(R.id.tv_money_quan,String.valueOf(context.getResources().getString(R.string.txt_quan,item.getCoupon_money())));
    }
}
