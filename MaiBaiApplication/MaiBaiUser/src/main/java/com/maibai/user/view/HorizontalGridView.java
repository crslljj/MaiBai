package com.maibai.user.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.maibai.user.R;
import com.maibai.user.adapter.HorizontalGridViewAdapter;
import com.maibai.user.utils.LogUtil;

/**
 * Created by zhangchi on 2016/6/16.
 */
public class HorizontalGridView extends LinearLayout {

    private Context mContext;
    private MyGridView gridView;
    private final int VISIBLECOLUMN = 4;
    private final int HORSPACE = 1;
    private int mItemWidth;

    public HorizontalGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setHorizontalScrollBarEnabled(true);
        mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.horizontal_grid_view, this);
        gridView = (MyGridView) view.findViewById(R.id.grid);
    }

    public void setAdapter(HorizontalGridViewAdapter mAdapter) {
        int size = mAdapter.getItemCount();
        int columns = size % 2 == 0 ? size / 2 : size / 2 + 1;
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
        int mItemWidth = (dm.widthPixels - (int) (HORSPACE * (VISIBLECOLUMN - 1) * density)) / VISIBLECOLUMN;
        int gridviewWidth = (int) (columns * mItemWidth);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                gridviewWidth, LinearLayout.LayoutParams.MATCH_PARENT);
        gridView.setLayoutParams(params); // 设置GirdView布局参数,横向布局的关键
        gridView.setColumnWidth(mItemWidth); // 设置列表项宽
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setNumColumns(columns); // 设置列数量=列表集合数
        mAdapter.setmWidth(mItemWidth);
        gridView.setAdapter(mAdapter);
        LogUtil.d("setAdapter", "setAdapter");
    }
}
