package com.zzw.thinkpad.thear.weight.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zzw.thinkpad.thear.R;

/**
 * Created by thinkpad on 2018/12/5.
 */

public class NormalToolbar extends RelativeLayout {
    View contentView;
    ImageView iv_left;
    TextView tv_title;
    ImageView iv_right;
    RelativeLayout rv;

    public NormalToolbar(Context context) {
        super(context);
        initView(context);
    }

    public NormalToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public NormalToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initView(Context context){
        contentView = LayoutInflater.from(context).inflate(R.layout.layout_toolbar,this)
                .findViewById(R.id.rv);
        iv_left =contentView.findViewById(R.id.left);
        iv_right =contentView.findViewById(R.id.right);
        tv_title =contentView.findViewById(R.id.title);
    }
    /**
     * 设置回调监听
     */
    public void setLeftClick(OnClickListener listener){
        iv_left.setOnClickListener(listener);
    }
    public void setRightClick(OnClickListener listener){
        iv_right.setOnClickListener(listener);
    }
    /**
     * 设置标题
     */
    public void setTitle(String title){
        tv_title.setText(title);
    }
    public  void setTitleColor(int resourceId){tv_title.setTextColor(resourceId);}
    public String getTitle(){
        return tv_title.getText().toString();
    }

    public void setRightIv(int resourceId){
        Glide.with(getContext()).load(resourceId).into(iv_right);
    }
    public void setLeftIv(int resourceId){
        Glide.with(getContext()).load(resourceId).into(iv_left);
    }
    public void setBg(int resourceId){
        rv.setBackgroundResource(resourceId);
    }
    /***
     * 隐藏
     */
    public void hideLeft(){
        iv_left.setVisibility(View.INVISIBLE);
    }
    public void hideTitle(){
        tv_title.setVisibility(View.INVISIBLE);
    }

    public void hideRight(){
        iv_right.setVisibility(View.INVISIBLE);
    }
    /**
     * 点击功能
     */
    public void LeftClick(boolean flag){
        iv_left.setClickable(flag);
    }
    public void RightClick(boolean flag){
        iv_right.setClickable(flag);
    }

}
