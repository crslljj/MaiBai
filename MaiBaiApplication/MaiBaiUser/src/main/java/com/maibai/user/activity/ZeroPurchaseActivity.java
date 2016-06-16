package com.maibai.user.activity;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.maibai.user.R;
import com.maibai.user.adapter.MyGridAdapter;
import com.maibai.user.base.BaseActivity;

/**
 * Created by yangjie on 2016/6/16.
 */
public class ZeroPurchaseActivity extends BaseActivity {

    private LinearLayout ll_gridetableLayout;
    private GridView tablegrid;
    public String[] img_text = {"口腔诊所", "美容美发", "KTV", "旅行服务", "家具建材", "饭店餐饮",
            "电动车", "婚纱摄影"};
    public int[] imgs = {R.mipmap.icon_kouqiang, R.mipmap.icon_meirong,
            R.mipmap.icon_ktv, R.mipmap.icon_lvxing,
            R.mipmap.icon_jiaju, R.mipmap.icon_fandian,
            R.mipmap.icon_diandong, R.mipmap.icon_hunsha};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        MyGridAdapter adapter = new MyGridAdapter(mContext, img_text, imgs);
        tablegrid.setAdapter(adapter);
        ll_gridetableLayout.setLayoutParams(new FrameLayout.LayoutParams(//动态设置宽度
                100 * img_text.length,
                LinearLayout.LayoutParams.MATCH_PARENT));
    }

    @Override
    protected int setContentView() {
        return R.layout.activity_zero_purchase;
    }

    @Override
    protected void findViews() {
        ll_gridetableLayout =
                (LinearLayout) findViewById(R.id.linearLayout_gridtableLayout);
        tablegrid = (GridView) findViewById(R.id.tablegrid);
    }

    @Override
    protected void setListensers() {

    }
}
