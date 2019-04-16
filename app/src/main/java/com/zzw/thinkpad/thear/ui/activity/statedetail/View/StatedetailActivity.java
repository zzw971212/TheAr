package com.zzw.thinkpad.thear.ui.activity.statedetail.View;
import android.view.View;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;

import butterknife.BindView;

public class StatedetailActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    NormalToolbar toolbar;

    @Override
    protected int getContentView() {
        return R.layout.activity_statedetail;
    }

    @Override
    protected void initViews() {
        toolbar.setTitle("动态详情");
        toolbar.setLeftIv(R.mipmap.btn_back_white);
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
            goActivity(ThreepointActivity.class);
            }
        });
    }
}
