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

public class Test2Activity extends BaseActivity {

    @BindView(R.id.right)
    TextView right;
    @BindView(R.id.answer_a)
    ImageView answer_a;
    @BindView(R.id.answer_b)
    ImageView answer_b;
    @BindView(R.id.answer_c)
    ImageView answer_c;
    @BindView(R.id.cuo)
    ImageView cuo;
    @BindView(R.id.cuo1)
    ImageView cuo1;
    @BindView(R.id.dui)
    ImageView dui;
    private  int score;
    @Override
    protected int getContentView() {
        return R.layout.activity_test2;
    }

    @Override
    protected void initViews() {
        iniscore();

    }

    private void iniscore() {
        Bundle bundle=getIntent().getExtras();
        score=bundle.getInt("score");
    }

    @OnClick({R.id.answer_a,R.id.right,R.id.answer_b,R.id.answer_c})
    public void onClicked(View v){
        switch (v.getId()){
            case R.id.answer_a:
                score= score+10;
                answer_b.setEnabled(false);
                answer_c.setEnabled(false);
                answer_a.setImageResource(R.mipmap.xuanze);
                dui.setVisibility(View.VISIBLE);
                break;
            case R.id.answer_b:
                score= score;
                answer_a.setEnabled(false);
                answer_b.setEnabled(false);
                answer_c.setEnabled(false);
                answer_b.setImageResource(R.mipmap.xuanze);
                cuo.setVisibility(View.VISIBLE);
                break;
            case R.id.answer_c:
                score= score;
                answer_a.setEnabled(false);
                answer_b.setEnabled(false);
                answer_c.setEnabled(false);
                answer_c.setImageResource(R.mipmap.xuanze);
                cuo1.setVisibility(View.VISIBLE);
                break;
            case R.id.right:
                Bundle bundle =new Bundle();
                bundle.putInt("score",score);
                goActivity(Test3Activity.class,bundle);
                break;

        }
    }
}
