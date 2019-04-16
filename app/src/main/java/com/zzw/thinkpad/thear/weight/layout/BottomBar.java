package com.zzw.thinkpad.thear.weight.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zzw.thinkpad.thear.R;

/**
 * Created by thinkpad on 2018/12/6.
 */

public class BottomBar extends RelativeLayout {
    View contentView;
    ImageView line_1;
    ImageView line_2;
    ImageView line_3;
    LinearLayout ll_1;
    LinearLayout ll_2;
    LinearLayout ll_3;
    ImageView img_1;
    ImageView img_2;
    ImageView img_3;

    public BottomBar(Context context) {
        super(context);
        initView(context);
    }


    public BottomBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public BottomBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        contentView = LayoutInflater.from(context).inflate(R.layout.layout_bottom_bar, this)
                .findViewById(R.id.bottom_rl);
        line_1 = contentView.findViewById(R.id.line_1);
        line_2 = contentView.findViewById(R.id.line_2);
        line_3 = contentView.findViewById(R.id.line_3);
        ll_1 = findViewById(R.id.ll_1);
        ll_2 = findViewById(R.id.ll_2);
        ll_3 = findViewById(R.id.ll_3);
        img_1 = findViewById(R.id.img_1);
        img_2 = findViewById(R.id.img_2);
        img_3 = findViewById(R.id.img_3);

    }

    /**
     * 设置回调监听
     */
    public void setLeftClick(OnClickListener listener) {
        ll_1.setOnClickListener(listener);

    }

    public void setCentreClick(OnClickListener listener) {
        ll_2.setOnClickListener(listener);

    }

    public void setRightClick(OnClickListener listener) {
        ll_3.setOnClickListener(listener);
    }

    /***
     * 隐藏
     */
    public void showLeftLine() {
        line_2.setVisibility(View.INVISIBLE);
        line_3.setVisibility(View.INVISIBLE);
        line_1.setVisibility(View.VISIBLE);
        img_1.setImageResource(R.mipmap.state_bottom1);
        img_2.setImageResource(R.mipmap.bottom_arno);
        img_3.setImageResource(R.mipmap.bottom_my);
    }

    public void showTitleLine() {
        line_3.setVisibility(View.INVISIBLE);
        line_1.setVisibility(View.INVISIBLE);
        line_2.setVisibility(View.VISIBLE);
        img_1.setImageResource(R.mipmap.bottom_stateno);
        img_2.setImageResource(R.mipmap.bottom_ar1);
        img_3.setImageResource(R.mipmap.bottom_my);
    }

    public void showRightLine() {
        img_1.setImageResource(R.mipmap.bottom_stateno);
        img_3.setImageResource(R.mipmap.bottom_my1);
        line_2.setVisibility(View.INVISIBLE);
        line_1.setVisibility(View.INVISIBLE);
        line_3.setVisibility(View.VISIBLE);
        img_2.setImageResource(R.mipmap.bottom_arno);
    }
}
