package com.zzw.thinkpad.thear.ui.activity.Test.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class Test8Activity extends BaseActivity {
    @BindView(R.id.right)
    TextView right;
    @BindView(R.id.answer_a)
    ImageView answer_a;
    @BindView(R.id.answer_b)
    ImageView answer_b;
    private  int score;
    @BindView(R.id.cuo)
    ImageView cuo;
    @BindView(R.id.dui)
    ImageView dui;
    @Override
    protected int getContentView() {
        return R.layout.activity_test8;
    }

    @Override
    protected void initViews() {
        Bundle bundle=getIntent().getExtras();
        score=bundle.getInt("score");
    }
    @OnClick({R.id.answer_a,R.id.right,R.id.answer_b})
    public void onClicked(View v){
        switch (v.getId()){
            case R.id.answer_a:
                score= score;
                answer_a.setEnabled(false);
                answer_b.setEnabled(false);
                answer_a.setImageResource(R.mipmap.xuanze);
               // answer_a.setImageResource(R.mipmap.choose_a);
                dui.setVisibility(View.VISIBLE);
                break;
            case R.id.answer_b:
                score= score+10;
                answer_a.setEnabled(false);
                answer_b.setEnabled(false);
                answer_b.setImageResource(R.mipmap.xuanze);
                cuo.setVisibility(View.VISIBLE);
                break;
            case R.id.right:
                Bundle bundle =new Bundle();
                bundle.putInt("score",score);
                goActivity(Test9Activity.class,bundle);
                break;
        }}
}
