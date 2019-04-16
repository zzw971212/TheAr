package com.zzw.thinkpad.thear.ui.activity.myinfor.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.ui.activity.addwork.View.AddworkActivity;
import com.zzw.thinkpad.thear.ui.activity.mygarden.View.MygardenActivity;
import com.zzw.thinkpad.thear.ui.activity.verified.View.UnverifiedActivity;
import com.zzw.thinkpad.thear.ui.activity.verified.View.VerifiedActivity;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;

import butterknife.BindView;
import butterknife.OnClick;

public class MyinforActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    NormalToolbar toolbar;
    @BindView(R.id.real_name)
    TextView real_name;

    @Override
    protected int getContentView() {
        return R.layout.activity_myinfor;
    }

    @Override
    protected void initViews() {
        initToolbar();

    }

    private void initToolbar() {
        toolbar.setLeftIv(R.mipmap.btn_back);
        toolbar.hideTitle();
        toolbar.hideRight();
        toolbar.setLeftClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setLeftClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick({R.id.real_name})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.real_name:
                if (real_name.getText().toString().equals("实名认证：已认证")) {
                    goActivity(VerifiedActivity.class);
                } else {
                    goActivity(UnverifiedActivity.class);
                }
                break;
            case R.id.addwork:
                goActivity(AddworkActivity.class);
                break;
            case R.id.img_my:
                goActivity(MyinforActivity.class);
                break;
        }
    }
}
