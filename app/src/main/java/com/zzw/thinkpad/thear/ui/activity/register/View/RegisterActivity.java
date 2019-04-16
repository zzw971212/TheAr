package com.zzw.thinkpad.thear.ui.activity.register.View;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.weight.CountDownUtil;
import com.zzw.thinkpad.thear.weight.ToastUtil;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    NormalToolbar toolbar;
    @BindView(R.id.btn_next)
    Button btn_next;
    @BindView(R.id.code)
    TextView code;
    @BindView(R.id.num_code)
    EditText num_code;
    @BindView(R.id.phone_num)
    EditText phone_num;
    @Override
    protected int getContentView() {
        return R.layout.activity_register;
    }

    @Override
    protected void initViews() {
        initToolBar(toolbar);
    }

    private void initToolBar(NormalToolbar toolbar) {
        toolbar.hideTitle();
        toolbar.hideRight();
        toolbar.setLeftIv(R.mipmap.btn_back);
        toolbar.setLeftClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    @OnClick({R.id.btn_next,R.id.code})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                url_Rg();
                break;
            case R.id.code:
                code.setVisibility(View.VISIBLE);
                url_code();
                break;
        }
    }

    private void url_code() {
        CountDownUtil countDown = new CountDownUtil(60000,
                1000, code);
        countDown.start();
    }

    private void url_Rg() {
        if(check())
        {
            Bundle bundle =new Bundle();
            bundle.putString("phone",phone_num.getText().toString());
            goActivity(Register1Activity.class,bundle);
        }
    }

    private boolean check() {
        if (phone_num.getText().toString().isEmpty()) {
            ToastUtil.showShortToast(this, "电话不能为空！");
            return false;
        } else {
            if (num_code.getText().toString().isEmpty()) {
                ToastUtil.showShortToast(this, "验证码不能为空！");
                return false;
            } else
                return true;
        }
    }
}
