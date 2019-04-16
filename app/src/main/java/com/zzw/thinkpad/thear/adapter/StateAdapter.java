package com.zzw.thinkpad.thear.adapter;

import android.content.Context;

import com.zzw.thinkpad.thear.ui.fragment.StateFragment.Bean.RoastListGet;
import com.zzw.thinkpad.thear.ui.fragment.StateFragment.Bean.StateGet;
import com.zzw.thinkpad.thear.ui.fragment.StateFragment.Controller.StateItemDelegate;
import com.zzw.thinkpad.thear.weight.recycler.MultiItemTypeAdapter;

import java.util.List;

/**
 * Created by thinkpad on 2018/12/6.
 */

public class StateAdapter extends MultiItemTypeAdapter<RoastListGet>{
    public StateAdapter(Context context, List<RoastListGet> datas) {
        super(context, datas);
        addItemViewDelegate(new StateItemDelegate());
    }
}
