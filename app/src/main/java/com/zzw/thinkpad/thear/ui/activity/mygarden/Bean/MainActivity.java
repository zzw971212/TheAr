package com.zzw.thinkpad.thear.ui.activity.mygarden.Bean;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 仿支付宝
 */

public class MainActivity extends BaseActivity {
    private WaterView mWaterView;
    private List<Water> mWaters = new ArrayList<>();

    {
        for (int i = 0; i <10; i++) {
            mWaters.add(new Water("item" + i,(int) (i + Math.random() * 4)));
        }
    }


    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        mWaterView = findViewById(R.id.wv_water);
        mWaterView.setWaters(mWaters);
    }

    public void onRest(View view) {
        mWaterView.setWaters(mWaters);
    }
}
