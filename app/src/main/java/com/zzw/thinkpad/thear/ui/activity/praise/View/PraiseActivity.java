package com.zzw.thinkpad.thear.ui.activity.praise.View;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.zzw.thinkpad.thear.BuildConfig;
import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;

import butterknife.BindView;
import butterknife.OnClick;

public class PraiseActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    NormalToolbar toolbar;
    @BindView(R.id.praise_record)
    RelativeLayout praise_record;
    @BindView(R.id.button)
    Button button;
    @Override
    protected int getContentView() {
        return R.layout.activity_praise;
    }

    @Override
    protected void initViews() {
        toolbar.setLeftIv(R.mipmap.btn_back_white);
        toolbar.setTitle("获赞记录");
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
    @OnClick({R.id.praise_record,R.id.button})
    public void onViewClicked (View v){
        switch (v.getId()) {
            case R.id.praise_record:
                goActivity(Praise_recordActivity.class);
                break;
            case R.id.button:
                goActivity(ChangeActivity.class);
                break;

        }
    }
}
