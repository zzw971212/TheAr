package com.zzw.thinkpad.thear.ui.fragment.StateFragment.Controller;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.loveplusplus.demo.image.ImagePagerActivity;
import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.adapter.GrideAdapter;
import com.zzw.thinkpad.thear.base.BaseAppManager;
import com.zzw.thinkpad.thear.internet.CustomCallBack;
import com.zzw.thinkpad.thear.internet.CustomCallBack1;
import com.zzw.thinkpad.thear.internet.RemoteDataResult;
import com.zzw.thinkpad.thear.internet.RemoteDataResult1;
import com.zzw.thinkpad.thear.internet.RemoteOptionIml;
import com.zzw.thinkpad.thear.ui.fragment.StateFragment.Bean.PicingGet;
import com.zzw.thinkpad.thear.ui.fragment.StateFragment.Bean.ProvePost;
import com.zzw.thinkpad.thear.ui.fragment.StateFragment.Bean.RoastListGet;
import com.zzw.thinkpad.thear.weight.recycler.ItemViewDelegate;
import com.zzw.thinkpad.thear.weight.recycler.MultiItemTypeAdapter;
import com.zzw.thinkpad.thear.weight.recycler.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Response;

/**
 * Created by thinkpad on 2018/12/6.
 */

public class StateItemDelegate implements ItemViewDelegate<RoastListGet> {
    private int like_num;
    private boolean flag;
    private int userid;
    private String baseUrl = "http://139.224.164.183:8008/";
    private String url_add = "Chat_AddApprove.aspx";
    private String url_delete = "Chat_DeleteApprove.aspx";
    List<PicingGet> plist = new ArrayList<>();
    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_roast;
    }

    @Override
    public boolean isForViewType(RoastListGet item, int position) {
        return true;
    }

    @Override
    public void convert(ViewHolder holder, final RoastListGet roastListGet, int position) {

        CircleImageView head = (CircleImageView) holder.getView(R.id.head);
        Glide.with(BaseAppManager.getInstance().getForwardActivity()).load("http://pq1wd0aab.bkt.clouddn.com/Avatar%281%29.png").into(head);
        holder.setText(R.id.name, roastListGet.getName());

        TextView context = (TextView)holder.getView(R.id.context);
        if(roastListGet.getChatcontent()==null||roastListGet.getChatcontent().length()==0){
            context.setVisibility(View.GONE);
        }else {
            holder.setText(R.id.context, roastListGet.getChatcontent());
        }
        holder.setText(R.id.time, roastListGet.getChattime());
        holder.setText(R.id.num_comment, roastListGet.getCom()+"");

        like_num = roastListGet.getApprove();
        final TextView textView = (TextView)holder.getView(R.id.num_like) ;
        final ImageView imageView = (ImageView)holder.getView(R.id.img_like);
        textView.setText(String.valueOf(like_num));
        Log.d("like_num",like_num+"");
        if(roastListGet.getYon()==0){
            flag = false;
            imageView.setImageResource(R.mipmap.img_love);
        }else {
            flag = true;
            imageView.setImageResource(R.mipmap.my_img_praise);
        }

        //S roastActivity =(RoastActivity)BaseAppManager.getInstance().getForwardActivity();
        userid=1;
        holder.setOnClickListener(R.id.ll_like, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Url_Prove(roastListGet.getId(),textView,imageView);
            }
        });

        RecyclerView grid = (RecyclerView)holder.getView(R.id.grid);
        if(roastListGet.getPlist()!=null&&roastListGet.getPlist().size()>0){
            final String[] urls = new String[roastListGet.getPlist().size()];
            for(int i=0;i<roastListGet.getPlist().size();i++){
                urls[i] = roastListGet.getPlist().get(i).getPicing();
            }
            grid.setVisibility(View.VISIBLE);
            ArrayList<String> strings = new ArrayList<>();
            for(int i=0;i<urls.length;i++){
                strings.add(urls[i]);
            }
            // StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

            GrideLayoutManger layoutManger = new GrideLayoutManger(3, StaggeredGridLayoutManager.VERTICAL);
            grid.setLayoutManager(layoutManger);
            GrideAdapter adapter = new GrideAdapter(BaseAppManager.getInstance().getForwardActivity(),strings);
            grid.setAdapter(adapter);

        }else {
            grid.setVisibility(View.GONE);
        }
    }

    public void Url_Prove(int chatid, final TextView textView, final ImageView imageView){
        String url = "";
        if (flag){
            url = url_delete;
        }else {
            url = url_add;
        }
        ProvePost post = new ProvePost(userid, chatid);
        RemoteOptionIml remoteOptionIml = new RemoteOptionIml();
        remoteOptionIml.Prove(post, baseUrl, url, new CustomCallBack1<RemoteDataResult1>() {
            @Override
            public void onSuccess(Response<RemoteDataResult1> response) {
                int resource ;
                if (flag){
                    like_num=like_num-1;
                    resource = R.mipmap.img_love;
                    flag = false;
                }else{
                    like_num=like_num+1;
                    resource = R.mipmap.my_img_praise;
                    flag = true;
                }
                imageView.setImageResource(resource);
                textView.setText(String.valueOf(like_num));
            }

            @Override
            public void onFail(String message) {
                Log.d("------message--",message);
            }
        });

    }



    class GrideLayoutManger extends StaggeredGridLayoutManager {

        private boolean isScrollEnabled = false;


        public GrideLayoutManger(int spanCount, int orientation) {
            super(spanCount, orientation);
        }

        public void setScrollEnabled(boolean flag) {
            this.isScrollEnabled = flag;
        }

        @Override
        public boolean canScrollVertically() {

            return isScrollEnabled && super.canScrollVertically();
        }
    }
    private void imageBrower(int position ,String[] urls){
        Intent intent=new Intent(BaseAppManager.getInstance().getForwardActivity(),ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_URLS,urls);
        intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_INDEX,position);
        BaseAppManager.getInstance().getForwardActivity().startActivity(intent);
    }
}
