package com.zzw.thinkpad.thear.ui.activity.roastDetail.Controller;

import com.bumptech.glide.Glide;
import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseAppManager;
import com.zzw.thinkpad.thear.ui.activity.roastDetail.Module.Newclist;
import com.zzw.thinkpad.thear.weight.recycler.ItemViewDelegate;
import com.zzw.thinkpad.thear.weight.recycler.ViewHolder;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by asus-pc on 2017/7/2.
 */

public class CommentItemDelegate implements ItemViewDelegate<Newclist> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_comment;
    }

    @Override
    public boolean isForViewType(Newclist item, int position) {
        return true;
    }

    @Override
    public void convert(ViewHolder holder, Newclist newclist, final int position) {
        CircleImageView head = (CircleImageView) holder.getView(R.id.head);
        Glide.with(BaseAppManager.getInstance().getForwardActivity()).load(newclist.getUserpicing()).into(head);
        holder.setText(R.id.name,newclist.getUsername());
        holder.setText(R.id.targetname,newclist.getTargetname());
        holder.setText(R.id.context,newclist.getComment());
        holder.setText(R.id.time,newclist.getDtime());
    }


}
