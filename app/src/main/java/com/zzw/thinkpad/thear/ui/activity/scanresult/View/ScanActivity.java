package com.zzw.thinkpad.thear.ui.activity.scanresult.View;


import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.ui.activity.game.View.GameActivity;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;

import butterknife.BindView;
import butterknife.OnClick;

public class ScanActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    NormalToolbar toolbar;
    @BindView(R.id.youxichongguan)
    Button youxichongguan;
    @BindView(R.id.shiyongfangfa)
    RelativeLayout shiyongfangfa;
    @BindView(R.id.tupian)
    LinearLayout tupian;
    @BindView(R.id.baise)
    ImageView baise;
    @BindView(R.id.pppp)
    TextView pppp;
    @BindView(R.id.xiayiye)
    TextView xiayiye;
    @BindView(R.id.xiangxia)
    ImageView xiangxia;
    @BindView(R.id.cha)
    ImageView cha;
    @Override
    protected int getContentView() {
        return R.layout.activity_scan;
    }

    @Override
    protected void initViews() {
        toolbar.setLeftIv(R.mipmap.btn_back_white);
        toolbar.setTitle("详情");
        toolbar.setRightIv(R.mipmap.my_img_point);
        toolbar.setRightClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showdialog();
            }
        });
        toolbar.setLeftClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @OnClick({R.id.youxichongguan,R.id.xiangxia,R.id.cha})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.youxichongguan:
                goActivity(GameActivity.class);
                break;
            case R.id.cha:
                shiyongfangfa.setVisibility(View.INVISIBLE);
                tupian.setVisibility(View.INVISIBLE);
                baise.setVisibility(View.INVISIBLE);
                pppp.setVisibility(View.INVISIBLE);
                xiayiye.setVisibility(View.INVISIBLE);
                youxichongguan.setClickable(true);
                break;
            case R.id.xiangxia:
                shiyongfangfa.setVisibility(View.VISIBLE);
                tupian.setVisibility(View.VISIBLE);
                baise.setVisibility(View.VISIBLE);
                pppp.setVisibility(View.VISIBLE);
                xiayiye.setVisibility(View.VISIBLE);
                youxichongguan.setClickable(false);
                break;
        }
    }
}
