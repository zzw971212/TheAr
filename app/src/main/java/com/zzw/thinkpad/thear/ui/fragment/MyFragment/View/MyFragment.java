package com.zzw.thinkpad.thear.ui.fragment.MyFragment.View;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseFragment;
import com.zzw.thinkpad.thear.ui.activity.addwork.View.AddworkActivity;
import com.zzw.thinkpad.thear.ui.activity.home.View.HomeActivity;
import com.zzw.thinkpad.thear.ui.activity.myclass.View.MyclassActivity;
import com.zzw.thinkpad.thear.ui.activity.mygarden.View.MygardenActivity;
import com.zzw.thinkpad.thear.ui.activity.myinfor.View.MyinforActivity;
import com.zzw.thinkpad.thear.ui.activity.praise.View.PraiseActivity;
import com.zzw.thinkpad.thear.ui.activity.register.View.RegisterActivity;
import com.zzw.thinkpad.thear.ui.activity.schoolannouncement.View.SchoolannouncementActivity;
import com.zzw.thinkpad.thear.ui.activity.setup.View.SetupActivity;
import com.zzw.thinkpad.thear.ui.activity.signin.View.SigninActivity;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by thinkpad on 2018/12/7.
 */

public class MyFragment extends BaseFragment {
    @BindView(R.id.toolbar)
    NormalToolbar toolbar;
    @BindView(R.id.mygarden)
    RelativeLayout mygarden;
    @BindView(R.id.addwork)
    RelativeLayout addwork;
    @BindView(R.id.num_praise)
    RelativeLayout num_praise;
    @BindView(R.id.rl_choolannouncement)
    RelativeLayout rl_choolannouncement;
    @BindView(R.id.rl_signin)
    RelativeLayout rl_signin;
    @BindView(R.id.setup)
    RelativeLayout setup;
    @BindView(R.id.img_my)
    ImageView img_my;
    @BindView(R.id.myclass)
    RelativeLayout myclass;


    @Override
    protected void initViews(View rootView) {
        initToolbar();
    }

    private void initToolbar() {
        toolbar.setLeftIv(R.mipmap.btn_back_white);
        toolbar.setTitle("我的");
        toolbar.setRightIv(R.mipmap.my_img_point);
    }

    @Override
    protected int getContentViewID() {
        return R.layout.fragment_my;
    }

    @OnClick({R.id.mygarden, R.id.myclass,R.id.setup,R.id.addwork, R.id.img_my, R.id.num_praise, R.id.rl_choolannouncement, R.id.rl_signin})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.mygarden:
                goActivity(MygardenActivity.class);
                break;
            case R.id.addwork:
                goActivity(AddworkActivity.class);
                break;
            case R.id.img_my:
                goActivity(MyinforActivity.class);
                break;
            case R.id.num_praise:
                goActivity(PraiseActivity.class);
                break;
            case R.id.rl_choolannouncement:
                goActivity(SchoolannouncementActivity.class);
                break;
            case R.id.rl_signin:
                goActivity(SigninActivity.class);
                break;
            case R.id.setup:
                goActivity(SetupActivity.class);
                break;
            case R.id.myclass:
                goActivity(MyclassActivity.class);
                break;
        }
    }
}
