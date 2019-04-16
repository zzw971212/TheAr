package com.zzw.thinkpad.thear.ui.activity.praise.View;


import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;

import butterknife.BindView;
import butterknife.OnClick;

public class Praise_recordActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    NormalToolbar toolbar;
    @BindView(R.id.huozan)
    Button huozan;
    @BindView(R.id.zhichu)
    Button zhichu;
    @BindView(R.id.ll_zhichu)
    LinearLayout ll_zhichu;
    @BindView(R.id.ll_huozan)
    LinearLayout ll_huozan;
    @Override
    protected int getContentView() {
        return R.layout.activity_praise_record;
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
    @OnClick({R.id.huozan,R.id.zhichu})
    public void onViewClicked (View v){
        switch (v.getId()) {
            case R.id.huozan:
                ll_zhichu.setVisibility(View.INVISIBLE);
                ll_huozan.setVisibility(View.VISIBLE);
                break;
            case R.id.zhichu:
                ll_zhichu.setVisibility(View.VISIBLE);
                ll_huozan.setVisibility(View.INVISIBLE);
                break;

        }
    }
}
