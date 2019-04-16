package com.zzw.thinkpad.thear.base.bases;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by ZWY on 2017/3/21.
 */

public abstract class BaseRVViewHolder<M> extends RecyclerView.ViewHolder {
    private View mView;
    private Context mContext;

    public BaseRVViewHolder(Context context, View itemView) {
        super(itemView);
        mView = itemView;
        mContext = context;
        initView(itemView);
    }

    public View getView() {
        return mView;
    }

    public abstract void initView(View view);

    public abstract void setData(M data);

    protected Context getContext() {
        return mContext;
    }
}
