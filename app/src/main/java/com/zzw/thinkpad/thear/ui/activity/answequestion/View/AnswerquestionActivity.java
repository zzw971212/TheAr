package com.zzw.thinkpad.thear.ui.activity.answequestion.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.ui.activity.game.View.GameActivity;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;

import butterknife.BindView;
import butterknife.OnClick;

public class AnswerquestionActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    NormalToolbar toolbar;
    @BindView(R.id.tianranqi)
    ImageView tianranqi;
    @BindView(R.id.jiaodaan)
    Button jiaodaan;
    @BindView(R.id.lltianranqi)
    LinearLayout lltianranqi;
    @BindView(R.id.dahuoji)
    LinearLayout dahuoji;
    @BindView(R.id.dui)
    ImageView dui;
    @BindView(R.id.cuo)
    ImageView cuo;
    @Override
    protected int getContentView() {
        return R.layout.activity_answerquestion;
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
    @OnClick({R.id.lltianranqi,R.id.jiaodaan})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.lltianranqi:
                tianranqi.setImageResource(R.mipmap.dddddy);
                break;
            case R.id.jiaodaan:
                dui.setVisibility(View.VISIBLE);
                cuo.setVisibility(View.VISIBLE);
                break;

        }
    }
}
