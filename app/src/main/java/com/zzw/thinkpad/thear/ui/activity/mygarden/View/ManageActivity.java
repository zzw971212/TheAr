package com.zzw.thinkpad.thear.ui.activity.mygarden.View;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.ui.activity.mygarden.Bean.Water;
import com.zzw.thinkpad.thear.ui.activity.mygarden.Bean.WaterView;
import com.zzw.thinkpad.thear.weight.CountdownImage;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class ManageActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    NormalToolbar toolbar;
    @BindView(R.id.gif_image)
    GifImageView gif_image;
    private GifDrawable gifDrawable;
    @BindView(R.id.farmer)
    ImageView farmer;
    @BindView(R.id.num_grow)
    TextView num_grow;
    @BindView(R.id.num_energy)
     TextView num_energy;
     int grownum;
     @BindView(R.id.flower)
     ImageView flower;
     @BindView(R.id.sprout)
     ImageView sprout;
    @Override
    protected int getContentView() {
        return R.layout.activity_manage;
    }
    private WaterView mWaterView;
    private List<Water> mWaters = new ArrayList<>();
    {
        for (int i = 0; i <10; i++) {
            mWaters.add(new Water("能量" + i,(int) (i + Math.random() * 4)));
        }
    }
    @Override
    protected void initViews() {
        mWaterView = findViewById(R.id.wv_water);
        mWaterView.setWaters(mWaters);
        grownum= Integer.parseInt(num_grow.getText().toString())+mWaterView.num;
        num_grow.setText(String.valueOf(grownum));
        gif_image.setVisibility(View.INVISIBLE);
        toolbar.setLeftClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbar.setLeftIv(R.mipmap.btn_back_white);
        toolbar.setTitle("我的花园");
    }
    private CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {//第一个参数表示总时间，第二个参数表示间隔时间。

        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            mWaterView.setWaters(mWaters);
        }
    };
    @OnClick({R.id.farmer})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.farmer:
                initGif_image();
                break;

        }
    }

    private void initGif_image() {
        CountdownImage countdownImage =new CountdownImage(3000,1000,farmer,gif_image,num_grow,num_energy);
        countdownImage.start();
        if (Integer.parseInt(num_grow.getText().toString())>200)
        {
            sprout.setVisibility(View.INVISIBLE);
            flower.setVisibility(View.VISIBLE);
        }
    }
}
