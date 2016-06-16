package com.maibai.user.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.maibai.user.R;
import com.maibai.user.adapter.MyGridAdapter;
import com.maibai.user.adapter.RecommendedNearbyAdapter;
import com.maibai.user.base.BaseFragment;
import com.maibai.user.view.MyGridView;
import com.maibai.user.view.ScrollListView;

import java.util.ArrayList;
import java.util.List;

public class ZeroYuanBuyFragment extends BaseFragment {

    private LinearLayout ll_gridetableLayout;
    private ScrollListView lv_zero_shop;
    private MyGridView gv_zero_shop;
    private String[] img_text = {"口腔诊所", "美容美发", "KTV", "旅行服务", "家具建材", "饭店餐饮",
            "电动车", "婚纱摄影", "婚纱摄影", "婚纱摄影", "婚纱摄影"};
    private int[] imgs = {R.mipmap.icon_kouqiang, R.mipmap.icon_meirong,
            R.mipmap.icon_ktv, R.mipmap.icon_lvxing,
            R.mipmap.icon_jiaju, R.mipmap.icon_fandian,
            R.mipmap.icon_diandong, R.mipmap.icon_hunsha, R.mipmap.icon_hunsha, R.mipmap.icon_hunsha, R.mipmap.icon_hunsha};
    private List<String> mList = new ArrayList<String>();
    private RecommendedNearbyAdapter mRecommendedNearbyAdapter;

    @Override
    protected void initVariable() {
        init();
    }

    private void init() {
        {
            for (int i = 0; i < 10; i++) {
                mList.add("维多利亚渔港");
            }
            mRecommendedNearbyAdapter = new RecommendedNearbyAdapter(mContext, mList);
            lv_zero_shop.setAdapter(mRecommendedNearbyAdapter);
            MyGridAdapter adapter = new MyGridAdapter(mContext, img_text, imgs);
            gv_zero_shop.setAdapter(adapter);
            ll_gridetableLayout.setLayoutParams(new FrameLayout.LayoutParams(//动态设置宽度
                    135 * img_text.length,
                    LinearLayout.LayoutParams.MATCH_PARENT));
        }
    }

    @Override
    protected int setContentView() {
        return R.layout.activity_zero_purchase;
    }

    @Override
    protected void findViews(View rootView) {
        ll_gridetableLayout =
                (LinearLayout) rootView.findViewById(R.id.linearLayout_gridtableLayout);
        gv_zero_shop = (MyGridView) rootView.findViewById(R.id.gv_zero_shop);
        lv_zero_shop = (ScrollListView) rootView.findViewById(R.id.lv_zero_shop);
    }

    @Override
    protected void setListensers() {

    }
}
