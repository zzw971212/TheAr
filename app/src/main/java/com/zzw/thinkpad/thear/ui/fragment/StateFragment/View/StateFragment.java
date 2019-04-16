package com.zzw.thinkpad.thear.ui.fragment.StateFragment.View;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.adapter.StateAdapter;
import com.zzw.thinkpad.thear.base.BaseFragment;
import com.zzw.thinkpad.thear.internet.CustomCallBack;
import com.zzw.thinkpad.thear.internet.CustomCallBack1;
import com.zzw.thinkpad.thear.internet.RemoteDataResult;
import com.zzw.thinkpad.thear.internet.RemoteDataResult1;
import com.zzw.thinkpad.thear.internet.RemoteOptionIml;
import com.zzw.thinkpad.thear.ui.activity.publish.View.PictureActivity;
import com.zzw.thinkpad.thear.ui.activity.roastDetail.View.RoastDetailActivity;
import com.zzw.thinkpad.thear.ui.activity.signin.View.SigninActivity;
import com.zzw.thinkpad.thear.ui.fragment.StateFragment.Bean.PicingGet;
import com.zzw.thinkpad.thear.ui.fragment.StateFragment.Bean.RoastListGet;
import com.zzw.thinkpad.thear.ui.fragment.StateFragment.Bean.StateGet;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;
import com.zzw.thinkpad.thear.weight.recycler.MultiItemTypeAdapter;
import com.zzw.thinkpad.thear.weight.recycler.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Response;

/**
 * Created by thinkpad on 2018/12/6.
 */

public class StateFragment extends BaseFragment {
    @BindView(R.id.toolbar)
    NormalToolbar toolbar;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refreshlayout;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    StateAdapter stateAdapter;
    List<StateGet> stateGets = new ArrayList<>();
    List<PicingGet> plist= new ArrayList<>();//图片
    private AlertDialog mydialog = null;
    private Bundle bundle;

    private List<RoastListGet> roastListGets =new ArrayList<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    private String baseUrl = "http://139.224.164.183:8008/";
    private String url = "Chat_ReturnChatList.aspx";
    private String url_retrun = "Chat_ReturnReply.aspx";
    @Override
    protected void initViews(View rootView) {
       // toolbar.setLeftIv(Integer.parseInt(null));
        toolbar.setTitle("动态");
        toolbar.setRightIv(R.mipmap.btn_add);
        toolbar.setLeftIv(R.mipmap.bg_state_top);
        toolbar.setRightClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goActivity(PictureActivity.class);
            }

        });
        initRefresh();
        Url_roastlist();

    }

    private void Url_roastlist() {
        RemoteOptionIml remoteOptionIml = new RemoteOptionIml();
        remoteOptionIml.roastList(1, baseUrl, url, new CustomCallBack1<RemoteDataResult1<List<RoastListGet>>>() {

            @Override
            public void onSuccess(Response<RemoteDataResult1<List<RoastListGet>>>
                                          response) {
                roastListGets.clear();
                roastListGets = response.body().getData();
                initRecycler();
            }

            @Override
            public void onFail(String message) {
                Log.d("------message--",message);
            }
        });
    }
    private void initRecycler() {
        NoScrollLinearLayoutManager linearLayoutManager = new
                NoScrollLinearLayoutManager(getContext());
        linearLayoutManager.setScrollEnabled(false);
        recycler.setLayoutManager(linearLayoutManager);
        stateAdapter = new StateAdapter(getContext(), roastListGets);
        recycler.setAdapter(stateAdapter);
        stateAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, ViewHolder holder, int
                    position) {
                bundle = new Bundle();
                bundle.putString("object","");
                bundle.putString("name","");
                bundle.putInt("userid",1);
                bundle.putInt("chatid",roastListGets.get(position).getId());
               goActivity(RoastDetailActivity.class,bundle);
            }

            @Override
            public boolean onItemLongClick(View view, ViewHolder holder, int position) {
                return false;
            }
        });
    }
    private void showdalog() {
        mydialog = new AlertDialog.Builder(getContext(), R.style.MyDialogStyle).create();
        mydialog.show();
        Window window = mydialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        mydialog.getWindow().setContentView(R.layout.dalog_addstate);
        mydialog.findViewById(R.id.img_delet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.dismiss();
            }
        });
        mydialog.findViewById(R.id.word).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               goActivity(PictureActivity.class);
            }
        });
        mydialog.findViewById(R.id.picture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.dismiss();
            }
        });
        mydialog.findViewById(R.id.signin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goActivity(SigninActivity.class);
            }
        });
        mydialog.findViewById(R.id.img_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.dismiss();
            }
        });
        mydialog.getWindow().setGravity(Gravity.CENTER_VERTICAL);
        WindowManager m = getActivity().getWindowManager();
        Display d = m.getDefaultDisplay();  //为获取屏幕宽、高
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER_VERTICAL);//获取对话框当前的参数值
        lp.height = (int) (d.getHeight());   //高度设置为屏幕的0.6
        lp.width = (int) (d.getWidth());  //宽度设置为屏幕
        mydialog.getWindow().setAttributes(lp);     //设置生效
    }

    private void initRefresh() {
        refreshlayout.setColorSchemeResources(R.color.colorAccent);
        refreshlayout.setSize(SwipeRefreshLayout.DEFAULT);
        refreshlayout.setProgressViewEndTarget(true, 100);
        refreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Url_roastlist();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    refreshlayout.setRefreshing(false);
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }

    @Override
    protected int getContentViewID() {
        return R.layout.fragment_state;
    }

    class NoScrollLinearLayoutManager extends LinearLayoutManager {
        private boolean isScrollEnabled = false;

        public NoScrollLinearLayoutManager(Context context) {
            super(context);
        }

        public void setScrollEnabled(boolean flag) {
            this.isScrollEnabled = flag;
        }

        @Override
        public boolean canScrollVertically() {
            //Similarly you can customize "canScrollHorizontally()" for
            // managing horizontal scroll
            return isScrollEnabled && super.canScrollVertically();
        }
    }
}
