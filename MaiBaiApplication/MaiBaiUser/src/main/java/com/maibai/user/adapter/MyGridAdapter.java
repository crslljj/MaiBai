package com.maibai.user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.maibai.user.R;

/**
 * @author http://blog.csdn.net/finddreams
 * @Description:gridview的Adapter
 */
public class MyGridAdapter extends BaseAdapter {
    private Context mContext;
    public String[] img_text;
    public int[] imgs;

    public MyGridAdapter(Context context, String[] imgt, int[] imgs) {
        this.mContext = context;
        this.img_text = imgt;
        this.imgs = imgs;
    }

    public MyGridAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return img_text.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.grid_item, parent, false);
            viewHolder.tv_item = (TextView) convertView.findViewById(R.id.tv_item);
            viewHolder.iv_item = (ImageView) convertView.findViewById(R.id.iv_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.iv_item.setBackgroundResource(imgs[position]);
        viewHolder.tv_item.setText(img_text[position]);
        return convertView;
    }

    public final class ViewHolder {
        TextView tv_item;
        ImageView iv_item;
    }

}
