package com.maibai.user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.maibai.user.R;

import java.util.List;

/**
 * Created by yangjie on 2016/6/16.
 */
public class RecommendedNearbyAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mList;

    public RecommendedNearbyAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (viewHolder == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_recommended_nearby, null);
            viewHolder.iv_item_shop_img = (ImageView) convertView.findViewById(R.id.iv_item_shop_img);
            viewHolder.tv_item_shop_name = (TextView) convertView.findViewById(R.id.tv_item_shop_name);
            viewHolder.tv_item_shop_distance = (TextView) convertView.findViewById(R.id.tv_item_shop_distance);
            viewHolder.tv_item_shop_reduce = (TextView) convertView.findViewById(R.id.tv_item_shop_reduce);
            viewHolder.bt_item_shop_check = (Button) convertView.findViewById(R.id.bt_item_shop_check);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String item = mList.get(position);
        if (item != null) {
            viewHolder.tv_item_shop_name.setText(item);
        }
        return convertView;
    }

    public final class ViewHolder {
        ImageView iv_item_shop_img;
        TextView tv_item_shop_name;
        TextView tv_item_shop_distance;
        TextView tv_item_shop_reduce;
        Button bt_item_shop_check;
    }
}
