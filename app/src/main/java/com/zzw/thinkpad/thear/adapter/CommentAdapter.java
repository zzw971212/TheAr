package com.zzw.thinkpad.thear.adapter;

import android.content.Context;

import com.zzw.thinkpad.thear.ui.activity.roastDetail.Controller.CommentItemDelegate;
import com.zzw.thinkpad.thear.ui.activity.roastDetail.Module.Newclist;
import com.zzw.thinkpad.thear.weight.recycler.MultiItemTypeAdapter;

import java.util.List;


public class CommentAdapter extends MultiItemTypeAdapter<Newclist> {
    public CommentAdapter(Context context, List<Newclist> datas) {
        super(context, datas);
        addItemViewDelegate(new CommentItemDelegate());
    }
}
