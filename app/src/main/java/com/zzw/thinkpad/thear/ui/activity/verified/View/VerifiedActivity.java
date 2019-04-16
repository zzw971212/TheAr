package com.zzw.thinkpad.thear.ui.activity.verified.View;

import android.view.View;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;

import butterknife.BindView;

public class VerifiedActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    NormalToolbar toolbar;

    @Override
    protected int getContentView() {
        return R.layout.activity_verified;
    }

    @Override
    protected void initViews() {
        initToolbar();
    }
    private void initToolbar() {
        toolbar.setLeftIv(R.mipmap.btn_back_white);
        toolbar.setTitle("已实名认证");
        toolbar.setRightIv(R.mipmap.my_img_point);
        toolbar.setLeftClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
