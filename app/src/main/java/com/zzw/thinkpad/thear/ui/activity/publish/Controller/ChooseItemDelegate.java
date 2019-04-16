package com.zzw.thinkpad.thear.ui.activity.publish.Controller;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseAppManager;
import com.zzw.thinkpad.thear.weight.recycler.ItemViewDelegate;
import com.zzw.thinkpad.thear.weight.recycler.ViewHolder;

/**
 * Created by asus-pc on 2017/7/2.
 */

public class ChooseItemDelegate implements ItemViewDelegate<String> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.choose_item;
    }

    @Override
    public boolean isForViewType(String item, int position) {
        return true;
    }

    @Override
    public void convert(ViewHolder holder, String urls, final int position) {
        ImageView head = (ImageView) holder.getView(R.id.album_image);
        Glide.with(BaseAppManager.getInstance().getForwardActivity()).load(urls).into(head);
        if(urls.equals("000000")){
            Glide.with(BaseAppManager.getInstance().getForwardActivity()).load(R.mipmap.btn_addpic).into(head);
        }

    }


}
