package com.zzw.thinkpad.thear.ui.activity.statedetail.View;


import android.view.View;
import android.widget.TextView;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;

import butterknife.BindView;

public class ThreepointActivity extends BaseActivity{

    @BindView(R.id.cancel)
    TextView cancel;

    @Override
    protected int getContentView() {
        return R.layout.activity_threepoint;
    }

    @Override
    protected void initViews() {
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
