package com.zzw.thinkpad.thear.ui.fragment.StateFragment.Controller;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseAppManager;
import com.zzw.thinkpad.thear.ui.fragment.StateFragment.Bean.PicingGet;
import com.zzw.thinkpad.thear.weight.recycler.ItemViewDelegate;
import com.zzw.thinkpad.thear.weight.recycler.ViewHolder;

/**
 * Created by thinkpad on 2018/12/11.
 */

public class GridItemDelegate implements  ItemViewDelegate<String> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.gridview_item;
    }

    @Override
    public boolean isForViewType(String item, int position) {
        return true;
    }


    @Override
    public void convert(ViewHolder holder, String urls, int position) {
        ImageView head = (ImageView) holder.getView(R.id.album_image);
        Glide.with(BaseAppManager.getInstance().getForwardActivity()).load(urls).into(head);

    }



}
