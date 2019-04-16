package com.zzw.thinkpad.thear.ui.activity.verified.View;


import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;

import butterknife.BindView;

public class UnverifiedActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    NormalToolbar toolbar;

    @Override
    protected int getContentView() {
        return R.layout.activity_unverified;
    }

    @Override
    protected void initViews() {
        initToolbar();
    }
    private void initToolbar() {
        toolbar.setLeftIv(R.mipmap.btn_back_white);
        toolbar.setTitle("未实名认证");
        toolbar.setRightIv(R.mipmap.my_img_point);
    }
}
