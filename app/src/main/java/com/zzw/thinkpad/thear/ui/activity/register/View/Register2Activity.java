package com.zzw.thinkpad.thear.ui.activity.register.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.internet.CustomCallBack;
import com.zzw.thinkpad.thear.internet.RemoteDataResult;
import com.zzw.thinkpad.thear.internet.RemoteOptionIml;
import com.zzw.thinkpad.thear.ui.activity.login.View.LoginActivity;
import com.zzw.thinkpad.thear.weight.ToastUtil;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Response;

public class Register2Activity extends BaseActivity {
    @BindView(R.id.toolbar)
    NormalToolbar toolbar;
    @BindView(R.id.btn_finish)
    Button btn_finish;
    @BindView(R.id.skip)
    TextView skip;
    @BindView(R.id.school)
    EditText school;
    @BindView(R.id.banji)
    EditText banji;
    @BindView(R.id.id_num)
    EditText id_num;
    String phone;
    @Override
    protected int getContentView() {
        return R.layout.activity_register2;
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

    @OnClick({R.id.btn_finish,R.id.skip})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_finish:
                url_final();

                break;
            case R.id.skip:
                goActivity(LoginActivity.class);
                break;
        }
    }

    private void url_final() {
        if (check())
        {
            RemoteOptionIml remoteOptionIml =new RemoteOptionIml();
            CustomCallBack<RemoteDataResult> customCallBack1 = new CustomCallBack<RemoteDataResult>() {
                @Override
                public void onSuccess(Response<RemoteDataResult> response) {
                    goActivity(LoginActivity.class);
                }

                @Override
                public void onFail(String message) {
                    ToastUtil.showLongToast(getBaseContext(),message);
                }
            };
            remoteOptionIml.register1(phone,school.getText().toString(),banji.getText().toString(),id_num.getText().toString(),customCallBack1);

        }

    }
    private boolean check() {
        if (school.getText().toString().isEmpty()) {
            ToastUtil.showShortToast(this, "学校不能为空！");
            return false;
        } else {
            if (banji.getText().toString().isEmpty()) {
                ToastUtil.showShortToast(this, "班级不能为空！");
                return false;
            }  if (id_num.getText().toString().isEmpty()) {
                ToastUtil.showShortToast(this, "学号或姓名不能为空！");
                return false;
            } else
                return true;
        }
    }
}
