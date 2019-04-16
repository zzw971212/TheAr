package com.zzw.thinkpad.thear.adapter;

import android.content.Context;

import com.zzw.thinkpad.thear.ui.fragment.StateFragment.Bean.PicingGet;
import com.zzw.thinkpad.thear.ui.fragment.StateFragment.Controller.GridItemDelegate;
import com.zzw.thinkpad.thear.weight.recycler.MultiItemTypeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thinkpad on 2018/12/6.
 */

public class GrideAdapter extends MultiItemTypeAdapter<String>{
    public GrideAdapter(Context context, ArrayList<String> datas) {
        super(context, datas);
        addItemViewDelegate(new GridItemDelegate());
    }
}
