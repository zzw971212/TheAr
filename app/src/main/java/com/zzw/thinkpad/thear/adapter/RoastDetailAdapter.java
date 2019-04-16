package com.zzw.thinkpad.thear.adapter;

import android.content.Context;


import com.zzw.thinkpad.thear.ui.activity.roastDetail.Controller.RoastDetailItemDelegate;
import com.zzw.thinkpad.thear.ui.activity.roastDetail.Module.ChatList;
import com.zzw.thinkpad.thear.weight.recycler.MultiItemTypeAdapter;

import java.util.List;



public class RoastDetailAdapter extends MultiItemTypeAdapter<ChatList> {
    public RoastDetailAdapter(Context context, List<ChatList> datas) {
        super(context, datas);
        addItemViewDelegate(new RoastDetailItemDelegate());
    }
}
