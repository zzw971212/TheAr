package com.zzw.thinkpad.thear.ui.activity.addwork.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;

import butterknife.BindView;

public class AddworkActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    NormalToolbar toolbar;

    @Override
    protected int getContentView() {
        return R.layout.activity_addwork;
    }

    @Override
    protected void initViews() {
        toolbar.setLeftIv(R.mipmap.btn_back_white);
        toolbar.setTitle("我的花园");
        toolbar.setRightIv(R.mipmap.my_img_point);
        toolbar.setLeftClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setRightClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showdialog();
            }
        });
    }
}
