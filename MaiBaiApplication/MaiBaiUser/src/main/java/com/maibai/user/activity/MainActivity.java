package com.maibai.user.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;

import com.maibai.user.R;
import com.maibai.user.adapter.MyViewPagerAdapter;
import com.maibai.user.base.BaseActivity;
import com.maibai.user.fragment.CreditFragment;
import com.maibai.user.fragment.MyFragment;
import com.maibai.user.fragment.ZeroYuanBuyFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener{

    private RadioButton rb_zero_yuan_buy, rb_credit, rb_my;

    private ZeroYuanBuyFragment mZeroYuanBuyFragment;
    private CreditFragment mCreditFragment;
    private MyFragment mMyFragment;
    private ViewPager vp_main;
    private ArrayList<Fragment> mFragmentList;
    private MyViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitView();
    }

    @Override
    protected int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void findViews() {
        rb_zero_yuan_buy = (RadioButton)findViewById(R.id.rb_zero_yuan_buy);
        rb_credit = (RadioButton)findViewById(R.id.rb_credit);
        rb_my = (RadioButton) findViewById(R.id.rb_my);
        vp_main = (ViewPager) findViewById(R.id.vp_main);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_zero_yuan_buy:
                selectFragment(0);
                break;
            case R.id.rb_credit:
                selectFragment(1);
                break;
            case R.id.rb_my:
                selectFragment(2);
                break;
            default:
                break;
        }
    }

    @Override
    protected void setListensers() {
        rb_zero_yuan_buy.setOnClickListener(this);
        rb_credit.setOnClickListener(this);
        rb_my.setOnClickListener(this);
        vp_main.setOnPageChangeListener(this);
    }


    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int id) {
        switch (id) {
            case 0:
                rb_zero_yuan_buy.setChecked(true);
                break;
            case 1:
                rb_credit.setChecked(true);
                break;
            case 2:
                rb_my.setChecked(true);
                break;
            default:
                break;
        }
    }

    public void selectFragment(int position) {
        vp_main.setCurrentItem(position);
    }


    private void addFragment() {
        if (mZeroYuanBuyFragment == null) {
            mZeroYuanBuyFragment = new ZeroYuanBuyFragment();
        }
        if (mCreditFragment == null) {
            mCreditFragment = new CreditFragment();
        }
        if (mMyFragment == null) {
            mMyFragment = new MyFragment();
        }
        if (mMyFragment == null) {
            mMyFragment = new MyFragment();
        }

        if (mFragmentList == null) {
            mFragmentList = new ArrayList<Fragment>();// 初始化数据
            mFragmentList.add(mZeroYuanBuyFragment);
            mFragmentList.add(mCreditFragment);
            mFragmentList.add(mMyFragment);
        }
    }
    private void setViewPager() {
        if (mViewPagerAdapter == null) {
            mViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), mFragmentList);
            vp_main.setAdapter(mViewPagerAdapter);
            vp_main.setOffscreenPageLimit(4);
        }
    }

    private void InitView() {
        addFragment();
        setViewPager();
        rb_zero_yuan_buy.performClick();
    }
}
