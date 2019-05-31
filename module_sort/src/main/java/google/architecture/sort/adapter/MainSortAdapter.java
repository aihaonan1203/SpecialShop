package google.architecture.sort.adapter;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jzhson.communal.util.ImageUtils;

import java.util.List;

import google.architecture.sort.R;
import google.architecture.sort.bean.AllSortBean;


public class MainSortAdapter extends BaseAdapter{

    private int layoutResId;
    private List<AllSortBean.CateBean> data;

    public MainSortAdapter(int layoutResId, @Nullable List<AllSortBean.CateBean> data) {
        this.layoutResId=layoutResId;
        this.data=data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder holder;
        if (convertView==null){
            convertView= LayoutInflater.from(parent.getContext()).inflate(layoutResId,parent,false);
            holder=new MyViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder= (MyViewHolder) convertView.getTag();
        }
        holder.tv_title.setText(data.get(position).getCat_name());
        ImageUtils.loadNetImage(holder.image,data.get(position).getCat_icon());
        return convertView;
    }

    public void setNewData(List<AllSortBean.CateBean> newData) {
        this.data = newData;
        notifyDataSetChanged();
    }

    private class MyViewHolder{
        private TextView tv_title;
        private SimpleDraweeView image;

        public MyViewHolder(View view) {
            tv_title=view.findViewById(R.id.tv_title);
            image=view.findViewById(R.id.iv_image);
        }
    }
}
