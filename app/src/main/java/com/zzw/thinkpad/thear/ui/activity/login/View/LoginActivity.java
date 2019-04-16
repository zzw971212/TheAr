package com.zzw.thinkpad.thear.ui.activity.login.View;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.internet.CustomCallBack;
import com.zzw.thinkpad.thear.internet.RemoteDataResult;
import com.zzw.thinkpad.thear.internet.RemoteOptionIml;
import com.zzw.thinkpad.thear.ui.activity.home.View.HomeActivity;
import com.zzw.thinkpad.thear.ui.activity.login.Bean.LoginGet;
import com.zzw.thinkpad.thear.ui.activity.login.Bean.LoginPost;
import com.zzw.thinkpad.thear.ui.activity.register.View.RegisterActivity;
import com.zzw.thinkpad.thear.weight.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.tv_register)
    TextView tv_register;
    @BindView(R.id.btn_login)
    Button btn_login;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.password)
    EditText password;
    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {


    }

    @OnClick({R.id.tv_register,R.id.btn_login})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.tv_register:
                goActivity(RegisterActivity.class);
                break;
            case R.id.btn_login:
                url_login();
                break;
        }
    }
    private void url_login() {
if(check()){

            RemoteOptionIml remoteOptionIml = new RemoteOptionIml();
            CustomCallBack<RemoteDataResult<LoginGet>> callBack = new CustomCallBack<RemoteDataResult<LoginGet>>() {
                @Override
                public void onSuccess(Response<RemoteDataResult<LoginGet>> response) {
                    LoginGet get = response.body().getData();

                    Bundle bundle = new Bundle();
                    bundle.putString("uniqueId", get.getUniqueId());
                    bundle.putString("phone",get.getPhone());
                    goActivity(HomeActivity.class,bundle);
                }
                @Override
                public void onFail(String message) {

                }
            };
            remoteOptionIml.login(phone.getText().toString(), password.getText().toString(),callBack);

    }
    }
    private boolean check() {
        if (phone.getText().toString().isEmpty()) {
            ToastUtil.showShortToast(this, "用户名不能为空！");
            return false;
        } else {
            if (password.getText().toString().isEmpty()) {
                ToastUtil.showShortToast(this, "密码不能为空！");
                return false;
            } else
                return true;
        }
    }
}
