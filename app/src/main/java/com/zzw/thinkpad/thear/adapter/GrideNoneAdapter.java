package com.zzw.thinkpad.thear.adapter;

import android.content.Context;

import com.zzw.thinkpad.thear.ui.activity.roastDetail.Controller.GridINonetemDelegate;
import com.zzw.thinkpad.thear.weight.recycler.MultiItemTypeAdapter;

import java.util.List;



public class GrideNoneAdapter extends MultiItemTypeAdapter<Integer> {
    public GrideNoneAdapter(Context context, List<Integer> datas) {
        super(context, datas);
        addItemViewDelegate(new GridINonetemDelegate());
    }
}
