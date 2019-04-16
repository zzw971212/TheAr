package com.zzw.thinkpad.thear.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by thinkpad on 2018/12/6.
 */

public class HomeViewPagerAdapter extends FragmentStatePagerAdapter{
    private List<Fragment>mlist;
    public HomeViewPagerAdapter(FragmentManager fm,List<Fragment>list) {
        super(fm);
        mlist=list;
    }

    @Override
    public Fragment getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }
}
