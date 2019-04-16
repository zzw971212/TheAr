package com.zzw.thinkpad.thear.weight;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class CountdownImage extends CountDownTimer {
    private ImageView ImageView;
    private GifImageView imageView;
    private TextView textView;
    private TextView textView1;
    int grow;
    int en;
    public CountdownImage(long millisInFuture, long countDownInterval, ImageView ImageView, GifImageView imageView, TextView textView, TextView textView1) {
        super(millisInFuture, countDownInterval);
        this.ImageView=ImageView;
        this.imageView=imageView;
        this.textView=textView;
        this.textView1=textView1;
    }

    @Override
    public void onTick(long l) {
        imageView.setVisibility(View.VISIBLE);
        ImageView.setClickable(false);
        grow= Integer.parseInt(textView.getText().toString())+10;
        textView.setText(String.valueOf(grow));
        en= Integer.parseInt(textView1.getText().toString())-10;
        textView1.setText(String.valueOf(en));
    }

    @Override
    public void onFinish() {
        if (Integer.parseInt(textView1.getText().toString())<20) {
            ImageView.setClickable(false);
            imageView.setVisibility(View.INVISIBLE);
        } else {
            ImageView.setClickable(true);
            imageView.setVisibility(View.INVISIBLE);
        }

    }
}
