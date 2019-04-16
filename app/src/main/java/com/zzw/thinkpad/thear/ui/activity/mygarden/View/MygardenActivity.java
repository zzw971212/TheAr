package com.zzw.thinkpad.thear.ui.activity.mygarden.View;


import android.support.v7.app.AlertDialog;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.ui.activity.home.View.HomeActivity;
import com.zzw.thinkpad.thear.ui.activity.register.View.RegisterActivity;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;

import butterknife.BindView;
import butterknife.OnClick;

public class MygardenActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    NormalToolbar toolbar;
    @BindView(R.id.tv_annu)
    TextView tv_annu;
    private AlertDialog mydialog = null;
    @BindView(R.id.planting)
    TextView planting;

    @Override
    protected int getContentView() {
        return R.layout.activity_mygarden;
    }

    @Override
    protected void initViews() {
        initToolbar();

    }

    private void initToolbar() {
        toolbar.setLeftIv(R.mipmap.btn_back_white);
        toolbar.setTitle("我的花园");
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
                showdialog();
            }
        });
    }

    @OnClick({R.id.tv_annu,R.id.planting})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.tv_annu:
                showAnnudialog();
                break;
            case R.id.planting:
                goActivity(ManageActivity.class);
               // showPlantingdialog();
                break;
        }
    }

    private void maggarden() {

    }

    private void showPlantingdialog() {
        mydialog = new AlertDialog.Builder(MygardenActivity.this, R.style.MyDialogStyle).create();
        mydialog.show();
        Window window = mydialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        mydialog.getWindow().setContentView(R.layout.dalog_painting);
        mydialog.findViewById(R.id.ll_leixing).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.findViewById(R.id.ll_1).setVisibility(View.VISIBLE);
                mydialog.findViewById(R.id.ll_2).setVisibility(View.INVISIBLE);
                mydialog.findViewById(R.id.ll_3).setVisibility(View.INVISIBLE);
                mydialog.findViewById(R.id.paint_line1).setVisibility(View.VISIBLE);
                mydialog.findViewById(R.id.paint_line3).setVisibility(View.INVISIBLE);
                mydialog.findViewById(R.id.paint_line2).setVisibility(View.INVISIBLE);
                mydialog.findViewById(R.id.xuanze).setVisibility(View.VISIBLE);
            }
        });
        mydialog.findViewById(R.id.ll_peiyang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.findViewById(R.id.ll_1).setVisibility(View.INVISIBLE);
                mydialog.findViewById(R.id.ll_2).setVisibility(View.VISIBLE);
                mydialog.findViewById(R.id.ll_3).setVisibility(View.INVISIBLE);
                mydialog.findViewById(R.id.paint_line1).setVisibility(View.INVISIBLE);
                mydialog.findViewById(R.id.paint_line3).setVisibility(View.INVISIBLE);
                mydialog.findViewById(R.id.paint_line2).setVisibility(View.VISIBLE);
                mydialog.findViewById(R.id.xuanze).setVisibility(View.VISIBLE);
            }
        });
        mydialog.findViewById(R.id.ll_zhuangban).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.findViewById(R.id.ll_1).setVisibility(View.INVISIBLE);
                mydialog.findViewById(R.id.ll_3).setVisibility(View.VISIBLE);
                mydialog.findViewById(R.id.ll_2).setVisibility(View.INVISIBLE);
                mydialog.findViewById(R.id.paint_line1).setVisibility(View.INVISIBLE);
                mydialog.findViewById(R.id.paint_line3).setVisibility(View.VISIBLE);
                mydialog.findViewById(R.id.paint_line2).setVisibility(View.INVISIBLE);
                mydialog.findViewById(R.id.xuanze).setVisibility(View.VISIBLE);
            }
        });
        mydialog.findViewById(R.id.btn_zhongzhi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.dismiss();
                Toast.makeText(getBaseContext(),"种植成功",Toast.LENGTH_SHORT).show();
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

    private void showAnnudialog() {
        mydialog = new AlertDialog.Builder(MygardenActivity.this, R.style.MyDialogStyle).create();
        mydialog.show();
        Window window = mydialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        mydialog.getWindow().setContentView(R.layout.dalog_announce);
        mydialog.findViewById(R.id.know).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.dismiss();
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

    public void showdialog() {
        mydialog = new AlertDialog.Builder(MygardenActivity.this, R.style.MyDialogStyle).create();
        mydialog.show();
        Window window = mydialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        mydialog.getWindow().setContentView(R.layout.dalog_garden);
        //mydialog.findViewById(R.id.AlertDialog_i_willhelp_ensure).setOnClickListener(this);
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
