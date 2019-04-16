package com.zzw.thinkpad.thear.ui.activity.register.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.internet.CustomCallBack;
import com.zzw.thinkpad.thear.internet.RemoteDataResult;
import com.zzw.thinkpad.thear.internet.RemoteOptionIml;
import com.zzw.thinkpad.thear.weight.ToastUtil;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Response;

public class Register1Activity extends BaseActivity {
    @BindView(R.id.toolbar)
    NormalToolbar toolbar;
    @BindView(R.id.btn_next)
    Button btn_next;
    @BindView(R.id.rgname_1)
    EditText rgname_1;
    @BindView(R.id.psw_1)
    EditText psw_1;
    @BindView(R.id.cim_psw)
    EditText cim_psw;
    String phone;

    @Override
    protected int getContentView() {
        return R.layout.activity_register1;
    }

    @Override
    protected void initViews() {
        toolbar.hideTitle();
        toolbar.hideRight();
        toolbar.setLeftIv(R.mipmap.btn_back);
        toolbar.setLeftClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Bundle bundle = getIntent().getExtras();
        phone = bundle.getString("phone");
    }

    @OnClick({R.id.btn_next,})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                url_Rg1();

                break;
        }
    }

    private void url_Rg1() {

        RemoteOptionIml remoteOptionIml = new RemoteOptionIml();
        CustomCallBack<RemoteDataResult> customCallBack1 = new CustomCallBack<RemoteDataResult>() {
            @Override
            public void onSuccess(Response<RemoteDataResult> response) {
                Bundle bundle =new Bundle();
                bundle.putString("phone",phone);
                goActivity(Register2Activity.class);
            }

            @Override
            public void onFail(String message) {
                ToastUtil.showLongToast(getBaseContext(),message);
            }
        };
        remoteOptionIml.register(phone,rgname_1.getText().toString(),psw_1.getText().toString(),customCallBack1);
        //  remoteOptionIml.register1(RegisterPost,customCallBack1 );
    }

    private boolean check() {
        if (rgname_1.getText().toString().isEmpty()) {
            ToastUtil.showShortToast(this, "用户名不能为空！");
            return false;
        } else {
            if (psw_1.getText().toString().isEmpty()) {
                ToastUtil.showShortToast(this, "密码不能为空！");
                return false;
            } else {
                if (cim_psw.getText().toString().isEmpty()) {
                    ToastUtil.showShortToast(this, "密码不能为空！");
                    if (cim_psw.getText().toString() != psw_1.getText().toString())
                        ToastUtil.showShortToast(this, "输入的两次密码不同");
                    return false;
                } else
                    return true;
            }
        }
    }
}
