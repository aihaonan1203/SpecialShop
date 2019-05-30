package google.architecture.sort.adapter;

import com.chad.library.adapter.base.BaseViewHolder;

import google.architecture.sort.bean.AllSortBean;
import android.support.annotation.Nullable;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jzhson.communal.util.ImageUtils;
import java.util.List;

import google.architecture.sort.R;
import google.architecture.sort.bean.AllSortBean;


public class MainSortAdapter extends BaseQuickAdapter<AllSortBean.CateBean,BaseViewHolder> {


    public MainSortAdapter(int layoutResId, @Nullable List<AllSortBean.CateBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AllSortBean.CateBean item) {
        TextView tv_title = helper.getView(R.id.tv_title);
        SimpleDraweeView image = helper.getView(R.id.iv_image);
        tv_title.setText(item.getCat_name());
        ImageUtils.loadNetImage(image,item.getCat_icon());
    }
}
