package com.zzw.thinkpad.thear.base.bases;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ZWY on 2017/3/21.
 */

public abstract class BaseRVAdapter<M> extends RecyclerView.Adapter<BaseRVViewHolder> {
    private Context mContext;
    private List<M> mData;
    private LayoutInflater mLayoutInflater;
    protected int mLayoutResId;
    protected MyOnItemClickListener mOnItemClickListener;

    public interface MyOnItemClickListener {
        void onItemClick(View view, int position);

        boolean onItemLongClick(View view, int position);
    }

    protected boolean isEnable(int viewType) {
        return true;
    }

    public void setmOnItemClickListener(MyOnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
    protected void setListener(final BaseRVViewHolder holder, int viewType) {
        if (!isEnable(viewType)) return;
        if (mOnItemClickListener != null) {
            holder.getView().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = holder.getAdapterPosition();
                    mOnItemClickListener.onItemLongClick(v, position);
                    return false;
                }
            });
            holder.getView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
                    mOnItemClickListener.onItemClick(v, position);
                }
            });

        }
    }

    public BaseRVAdapter(Context context, List<M> data) {
        mContext = context;
        mData = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public M getItem(int position) {
        if (position >= 0 && position < mData.size()) {
            return mData.get(position);
        }
        return null;
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view=mLayoutInflater.inflate(getLayoutId(viewType),null);
        View view = mLayoutInflater.inflate(viewType, parent,false);
        BaseRVViewHolder holder = getHolder(mContext, view);
        setListener(holder, viewType);
        return holder;
    }

    @Override
    public int getItemViewType(int position) {
        mLayoutResId = setLayoutId(position);
        return setLayoutId(position);
    }

    @Override
    public void onBindViewHolder(BaseRVViewHolder holder, int position) {
        M item = mData.get(position);
        holder.setData(item);
    }


    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public abstract int setLayoutId(int position);

    public List<M> getData() {
        return mData;
    }

    public abstract BaseRVViewHolder getHolder(Context context, View view);

    /**
     * 替换某一个元素
     */
    public void replaceBean(int position, M item) {
        if (item != null) {
            this.mData.remove(position);
            this.mData.add(position, item);
            notifyItemChanged(position, item);
        }
    }

    /**
     * 添加数据列表到列表头部
     */
    public void addListAtStart(List<M> list) {
        if (list != null && !list.isEmpty()) {
            this.mData.addAll(0, list);
            notifyDataSetChanged();
        }
    }

    /**
     * 添加数据列表到列表尾部
     */
    public void addListAtEnd(List<M> list) {
        if (list != null && !list.isEmpty()) {
            this.mData.addAll(list);
            notifyItemRangeInserted(mData.size() - 1, list.size());
        }

    }


    /**
     * 添加数据列表到列表尾部
     */
    public void addListAtEndAndNotify(List<M> list) {
        if (list != null && !list.isEmpty()) {
            this.mData.addAll(list);
            notifyDataSetChanged();
        }
    }


    /**
     * 添加单个元素到列表头
     */
    public void addListBeanAtStart(M item) {
        if (item != null) {
            mData.add(0, item);
            notifyItemInserted(0);
        }

    }

    /**
     * 添加单个元素到列表尾
     */
    public void addListBeanAtEnd(M item) {
        if (item != null) {
            mData.add(item);
            notifyItemInserted(mData.size() - 1);
        }

    }

    /**
     * 替换RecyclerView数据
     */
    public void replaceList(List<M> list) {
        if (list != null) {
            this.mData = list;
        } else {
            mData.clear();
        }

        notifyDataSetChanged();
    }

    /**
     * 替换RecyclerView中的某一个数据
     */
    public void replaceItem(M item, int position) {
        if (position >= 0 && position <= mData.size() && item != null) {
            this.mData.set(position, item);
            notifyItemChanged(position);
        }
    }

    /**
     * 删除RecyclerView所有数据
     */
    public void removeAll() {
        if (mData != null) {
            notifyItemRangeRemoved(0, mData.size());
            this.mData.clear();
        }
    }

    /**
     * 删除RecyclerView指定位置的数据
     */
    public void remove(M item) {
        if (mData != null) {
            this.mData.remove(item);
            notifyDataSetChanged();
        }
    }

    /**
     * 删除RecyclerView指定位置的数据
     */
    public void remove(int position) {
        if (position >= 0 && position <= mData.size() && mData != null) {
            this.mData.remove(position);
            notifyItemRemoved(position);
        }
    }


}
