package com.maibai.user.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import java.util.List;

/**
 * Created by zhangchi on 2016/6/17.
 */
public abstract class HorizontalGridViewAdapter<T> extends CommonAdapter<T> {
    private int mWidth;

    public HorizontalGridViewAdapter(Context context, List<T> datas, Handler handler) {
        super(context, datas, handler);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = getItemView(position, convertView, parent);
            AbsListView.LayoutParams param = new AbsListView.LayoutParams(mWidth, mWidth);
            convertView.setLayoutParams(param);
        }
        return convertView;
    }

    public void setmWidth(int mWidth) {
        this.mWidth = mWidth;
    }

    public abstract View getItemView(int position, View convertView, ViewGroup parent);

    public abstract int getItemCount();
}
