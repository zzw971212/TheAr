package com.zzw.thinkpad.thear.ui.activity.signin.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.ui.activity.home.View.HomeActivity;
import com.zzw.thinkpad.thear.ui.activity.register.View.RegisterActivity;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;

import javax.xml.transform.Templates;

import butterknife.BindView;
import butterknife.OnClick;

public class SigninActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    NormalToolbar toolbar;
@BindView(R.id.btn_sign)
    Button btn_sign;
@BindView(R.id.btn_yiqiandao)
Button btn_yiqiandao;
@BindView(R.id.one1)
    ImageView one1;
@BindView(R.id.view1)
View view1;
@BindView(R.id.tv_sign)
    TextView tv_sign;
    @Override
    protected int getContentView() {
        return R.layout.activity_signin;
    }

    @Override
    protected void initViews() {
        toolbar.setLeftIv(R.mipmap.btn_back_white);
        toolbar.setTitle("签到");
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
    @OnClick({R.id.btn_sign})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_sign:
                btn_yiqiandao.setVisibility(View.VISIBLE);
                one1.setVisibility(View.VISIBLE);
                view1.setVisibility(View.VISIBLE);
                tv_sign.setText("再签到六天就能够领取能量值哦");
                btn_sign.setClickable(false);
                break;

        }
    }
}
