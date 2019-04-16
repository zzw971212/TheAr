package com.zzw.thinkpad.thear.ui.activity.game.View;



import android.view.View;
import android.widget.Button;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.ui.activity.Test.view.Test1Activity;
import com.zzw.thinkpad.thear.ui.activity.answequestion.View.AnswerquestionActivity;
import com.zzw.thinkpad.thear.ui.activity.escape.View.EscapeActivity;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;

import butterknife.BindView;
import butterknife.OnClick;

public class GameActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    NormalToolbar toolbar;
    @BindView(R.id.btn_answer)
    Button btn_answer;
    @BindView(R.id.btn_shizhan)
    Button btn_shizhan;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @Override
    protected int getContentView() {
        return R.layout.activity_game;
    }

    @Override
    protected void initViews() {
        toolbar.setLeftIv(R.mipmap.btn_back_white);
        toolbar.setTitle("游戏冲关");
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

    @OnClick({R.id.btn_answer,R.id.btn_shizhan,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_answer:
                goActivity(Test1Activity.class);
                break;
            case R.id.btn_shizhan:
                goActivity(EscapeActivity.class);
                break;
            case R.id.btn1:
                btn1.setBackgroundResource(R.mipmap.rasr);
                btn2.setClickable(false);
                btn3.setClickable(false);
                btn4.setClickable(false);
                break;
            case R.id.btn2:
                btn2.setBackgroundResource(R.mipmap.rasr);
                btn1.setClickable(false);
                btn3.setClickable(false);
                btn4.setClickable(false);
                break;
            case R.id.btn3:
                btn3.setBackgroundResource(R.mipmap.rasr);
                btn2.setClickable(false);
                btn1.setClickable(false);
                btn4.setClickable(false);
                break;
            case R.id.btn4:
                btn4.setBackgroundResource(R.mipmap.rasr);
                btn2.setClickable(false);
                btn3.setClickable(false);
                btn1.setClickable(false);
                break;
        }
    }
}
