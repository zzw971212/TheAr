package com.zzw.thinkpad.thear.weight.layout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.zzw.thinkpad.thear.R;

/**
 * Created by thinkpad on 2018/12/7.
 */

public class LayoutScan extends LinearLayout {
    View view;
    LinearLayout ll_code;
    LinearLayout ll_thing;
    LinearLayout ll_pic;
    public LayoutScan(Context context) {
        super(context);
        initView(context);
    }

    public LayoutScan(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LayoutScan(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        view = LayoutInflater.from(context).inflate(R.layout.layout_scan, this)
                .findViewById(R.id.layout_scan);
        ll_code =view.findViewById(R.id.ll_code);
        ll_thing =view.findViewById(R.id.ll_thing);
        ll_pic=view.findViewById(R.id.ll_pic);

    }
    /**
     * 设置回调监听
     */
    public void setCodeClick(OnClickListener listener){
        ll_code.setOnClickListener(listener);
    }
    public void setThingClick(OnClickListener listener){
        ll_thing.setOnClickListener(listener);
    }
    public void setPicClick(OnClickListener listener){
        ll_pic.setOnClickListener(listener);
    }
    /***
     * 隐藏
     */
    public void showLeftBg() {
        ll_code.setBackgroundResource(R.mipmap.scan_btn_bg);
        ll_thing.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        ll_pic.setBackgroundColor(getResources().getColor(android.R.color.transparent));
    }

    public void showTitleBg() {
        ll_thing.setBackgroundResource(R.mipmap.scan_btn_bg);
        ll_code.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        ll_pic.setBackgroundColor(getResources().getColor(android.R.color.transparent));
    }

    public void showRightBg() {
        ll_pic.setBackgroundResource(R.mipmap.scan_btn_bg);
        ll_code.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        ll_thing.setBackgroundColor(getResources().getColor(android.R.color.transparent));
    }
}
