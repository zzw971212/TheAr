package com.zzw.thinkpad.thear.ui.activity.home.View;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.adapter.HomeViewPagerAdapter;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.ui.fragment.MyFragment.View.MyFragment;
import com.zzw.thinkpad.thear.ui.fragment.ScanFragment.View.ScanFragment;
import com.zzw.thinkpad.thear.ui.fragment.StateFragment.View.StateFragment;
import com.zzw.thinkpad.thear.weight.layout.BottomBar;
import com.zzw.thinkpad.thear.weight.layout.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.viewpager)
    NoScrollViewPager viewPager;
    @BindView(R.id.bottom_bar)
    BottomBar bottomBar;
    List<Fragment> fragments = new ArrayList<>();
    private Fragment statefragment;
    private Fragment sanfragment;
    private Fragment myfragment;
    private Bundle bundle;
    String uniqueId;
    String phone;
    @Override
    protected int getContentView() {
        return R.layout.activity_home;
    }

    @Override
    protected void initViews() {
        //getNum();
        initfragment();
    }

    private void getNum() {
        bundle=getIntent().getExtras();
        uniqueId=bundle.getString("uniqueId");
        phone=bundle.getString("phone");
    }

    private void initfragment() {
        statefragment = new StateFragment();
        sanfragment = new ScanFragment();
        myfragment =new MyFragment();
        fragments.add(statefragment);
        fragments.add(sanfragment);
        fragments.add(myfragment);
        viewPager.setOffscreenPageLimit(4);
        HomeViewPagerAdapter homeViewPagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(homeViewPagerAdapter);
        bottomBar.setLeftClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomBar.showLeftLine();
                viewPager.setCurrentItem(0);
            }
        });
        bottomBar.setCentreClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomBar.showTitleLine();
                viewPager.setCurrentItem(1);
            }
        });
        bottomBar.setRightClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomBar.showRightLine();
                viewPager.setCurrentItem(2);
            }
        });

    }

}
