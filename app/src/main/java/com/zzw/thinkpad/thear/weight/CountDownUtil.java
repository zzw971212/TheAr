package com.zzw.thinkpad.thear.weight;

import android.os.CountDownTimer;
import android.widget.TextView;


/**
 * Created by zzw on 2018/5/22.
 */


public class CountDownUtil extends CountDownTimer {
    private TextView textView;
   // private ImageView imageView;

    public CountDownUtil(long millisInFuture, long countDownInterval,
                         TextView textView) {
        super(millisInFuture, countDownInterval);
        this.textView = textView;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        //imageView.setImageResource(R.mipmap.icon_unverify);
        textView.setClickable(false);
        textView.setText("("+millisUntilFinished /1000+")后可重新获取");
    }

    @Override
    public void onFinish() {
        //imageView.setImageResource(R.mipmap.icon_verify);
        textView.setClickable(true);
        textView.setText("("+"重新获取"+")");
    }
}

