package com.zzw.thinkpad.thear.ui.activity.myclass.View;

import android.support.v7.app.AlertDialog;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.ui.activity.mygarden.View.MygardenActivity;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;

import butterknife.BindView;

public class MyclassActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    NormalToolbar toolbar;
    private AlertDialog mydialog = null;
    @Override
    protected int getContentView() {
        return R.layout.activity_myclass;
    }

    @Override
    protected void initViews() {
        toolbar.setLeftIv(R.mipmap.btn_back_white);
        toolbar.setTitle("我的班级");
        toolbar.setRightClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showdialog();
            }
        });
        toolbar.setRightIv(R.mipmap.btn_add);
        toolbar.setLeftClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setRightClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            ShowDialog();
            }
        });
    }

    private void ShowDialog() {
        mydialog = new AlertDialog.Builder(MyclassActivity.this, R.style.MyDialogStyle).create();
        mydialog.show();
        Window window = mydialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        mydialog.getWindow().setContentView(R.layout.dialog_addclass);
        mydialog.findViewById(R.id.sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.dismiss();
            }
        });
        mydialog.findViewById(R.id.one_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.findViewById(R.id.one_no).setVisibility(View.INVISIBLE);
                mydialog.findViewById(R.id.one_yes).setVisibility(View.VISIBLE);
            }
        });
        mydialog.findViewById(R.id.one_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.findViewById(R.id.one_no).setVisibility(View.VISIBLE);
                mydialog.findViewById(R.id.one_yes).setVisibility(View.INVISIBLE);
            }
        });
        mydialog.findViewById(R.id.two_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.findViewById(R.id.two_no).setVisibility(View.INVISIBLE);
                mydialog.findViewById(R.id.two_yes).setVisibility(View.VISIBLE);
            }
        });
        mydialog.findViewById(R.id.two_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.findViewById(R.id.two_no).setVisibility(View.VISIBLE);
                mydialog.findViewById(R.id.two_yes).setVisibility(View.INVISIBLE);
            }
        });
        mydialog.findViewById(R.id.three_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.findViewById(R.id.three_no).setVisibility(View.INVISIBLE);
                mydialog.findViewById(R.id.three_yes).setVisibility(View.VISIBLE);
            }
        });
        mydialog.findViewById(R.id.three_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.findViewById(R.id.three_no).setVisibility(View.VISIBLE);
                mydialog.findViewById(R.id.three_yes).setVisibility(View.INVISIBLE);
            }
        });
        mydialog.findViewById(R.id.four_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.findViewById(R.id.four_no).setVisibility(View.INVISIBLE);
                mydialog.findViewById(R.id.four_yes).setVisibility(View.VISIBLE);
            }
        });
        mydialog.findViewById(R.id.four_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.findViewById(R.id.four_no).setVisibility(View.VISIBLE);
                mydialog.findViewById(R.id.four_yes).setVisibility(View.INVISIBLE);
            }
        });
        mydialog.getWindow().setGravity(Gravity.CENTER_VERTICAL);
        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay();  //为获取屏幕宽、高
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER_VERTICAL);//获取对话框当前的参数值
        lp.height = (int) (d.getHeight());   //高度设置为屏幕的0.6
        lp.width = (int) (d.getWidth());  //宽度设置为屏幕
        mydialog.getWindow().setAttributes(lp);     //设置生效
    }
}
