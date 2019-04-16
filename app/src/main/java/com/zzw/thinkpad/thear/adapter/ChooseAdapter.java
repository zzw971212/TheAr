package com.zzw.thinkpad.thear.adapter;

import android.content.Context;


import com.zzw.thinkpad.thear.ui.activity.publish.Controller.ChooseItemDelegate;
import com.zzw.thinkpad.thear.weight.recycler.MultiItemTypeAdapter;

import java.util.List;

/**
 * Created by asus-pc on 2017/7/6.
 */

public class ChooseAdapter extends MultiItemTypeAdapter<String> {
    public ChooseAdapter(Context context, List<String> datas) {
        super(context, datas);if(datas.size()==10){
            datas.remove(datas.size()-1);
        }
        addItemViewDelegate(new ChooseItemDelegate());
    }
}
