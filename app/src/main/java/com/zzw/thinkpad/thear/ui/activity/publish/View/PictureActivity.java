package com.zzw.thinkpad.thear.ui.activity.publish.View;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidong.photopicker.PhotoPickerActivity;
import com.lidong.photopicker.PhotoPreviewActivity;
import com.lidong.photopicker.SelectModel;
import com.lidong.photopicker.intent.PhotoPickerIntent;
import com.lidong.photopicker.intent.PhotoPreviewIntent;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;
import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.adapter.ChooseAdapter;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.internet.CustomCallBack;
import com.zzw.thinkpad.thear.internet.CustomCallBack1;
import com.zzw.thinkpad.thear.internet.RemoteDataResult;
import com.zzw.thinkpad.thear.internet.RemoteDataResult1;
import com.zzw.thinkpad.thear.internet.RemoteOptionIml;
import com.zzw.thinkpad.thear.ui.activity.publish.Bean.PublishRoastPost;
import com.zzw.thinkpad.thear.weight.ToastUtil;
import com.zzw.thinkpad.thear.weight.recycler.MultiItemTypeAdapter;
import com.zzw.thinkpad.thear.weight.recycler.ViewHolder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Response;

public class PictureActivity extends BaseActivity {
    @BindView(R.id.grid)
    RecyclerView grid;
    @BindView(R.id.right)
    TextView right;
    @BindView(R.id.left)
    ImageView left;
    @BindView(R.id.content)
    EditText content;
    private ArrayList<String> imagePaths = new ArrayList<>();
    private ChooseAdapter adapter;
    private List<String> plist = new ArrayList<>();
    private List<String> qiniu_key=new ArrayList<>();
    private static final int REQUEST_CAMERA_CODE = 1;
    private static final int REQUEST_PREVIEW_CODE = 2;
    private String Qiniu_token ="";
    private boolean flag_qiniu=false;
    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private String baseUrl = "http://139.224.164.183:8008/";
    private String url = "Chat_AddChat.aspx";
    @Override
    protected int getContentView() {
        return R.layout.activity_picture;
    }

    @Override
    protected void initViews() {
        initGrid();
    }
    @OnClick({R.id.right,R.id.left})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.right:
                if (plist.size()>0){
                    if (uploadImageToQiniu(plist,Qiniu_token)){
                        Url_publish();
                    }
                }else {
                    if(content.getText().toString().length()!=0){
                        Url_publish();
                    }else {
                        ToastUtil.showShortToast(PictureActivity.this,"请填写完整!");
                    }
                }
                break;
            case R.id.left:
               finish();
                break;
        }
    }
    /**
     * 七牛上传
     * @param filePaths
     * @param token
     * @return
     */
    public boolean uploadImageToQiniu(final List<String> filePaths, final String token) {
        final UploadManager uploadManager = new UploadManager();
        // 设置图片名字
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<filePaths.size();i++){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                    String key = "icon_" +i+"_"+ sdf.format(new Date())+"Express";
                    uploadManager.put(filePaths.get(i), key, token, new UpCompletionHandler() {
                        @Override
                        public void complete(String key, ResponseInfo info, JSONObject res) {
                            Log.d("error:", info.toString());
                            // info.error中包含了错误信息，可打印调试
                            /////存储图片到服务器("http://opoecp2mn.bkt.clouddn.com/"+key)

                            if(key!=null&&key.length()>0){
                                qiniu_key.add("http://pq1wd0aab.bkt.clouddn.com/"+key);
                                Log.d("-------key",qiniu_key.size()+"");

                                if (qiniu_key.size()==filePaths.size()){
                                    flag_qiniu=true;
                                }else {
                                    flag_qiniu=false;
                                }
                            }else {
                                flag_qiniu=false;
                            }
                        }
                    }, null);
                }
            }
        }).start();

        return flag_qiniu;
    }
    private void initGrid() {
        StaggeredGridLayoutManager layoutManger = new
                StaggeredGridLayoutManager(3, StaggeredGridLayoutManager
                .VERTICAL);
        grid.setLayoutManager(layoutManger);
        //GrideAdapter adapter = new GrideAdapter(this,strings);
        // grid.setAdapter(adapter);
        imagePaths.add("000000");
        adapter =new ChooseAdapter(this,imagePaths);
        grid.setAdapter(adapter);
        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, ViewHolder holder, int position) {
                String imgs = (String) imagePaths.get(position);
                if ("000000".equals(imgs)) {
                    PhotoPickerIntent intent = new PhotoPickerIntent
                            (PictureActivity.this);
                    intent.setSelectModel(SelectModel.MULTI);
                    intent.setShowCarema(true); // 是否显示拍照
                    intent.setMaxTotal(20); // 最多选择照片数量，默认为6
                    intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
                    startActivityForResult(intent, REQUEST_CAMERA_CODE);
                } else {
                    PhotoPreviewIntent intent = new PhotoPreviewIntent
                            (PictureActivity.this);
                    intent.setCurrentItem(position);
                    intent.setPhotoPaths(imagePaths);
                    startActivityForResult(intent, REQUEST_PREVIEW_CODE);
                }
            }

            @Override
            public boolean onItemLongClick(View view, ViewHolder holder, final int position) {
                builder = new AlertDialog.Builder(view.getContext());
                View view1 = LayoutInflater.from(view.getContext()).inflate(R
                        .layout.dialog_takepic, null);
                TextView no = (TextView) view1.findViewById(R.id.no);
                TextView yes = (TextView) view1.findViewById(R.id.yes);
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imagePaths.remove(position);
                        plist.remove(position);
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                builder.setView(view1);
                dialog = builder.create();
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.WRAP_CONTENT);
                return true;
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent
            data) {
        switch (requestCode) {
            case REQUEST_CAMERA_CODE:
                if (resultCode == RESULT_OK) {
                    ArrayList<String> list = data.getStringArrayListExtra
                            (PhotoPickerActivity.EXTRA_RESULT);
                    plist.addAll(list);
                    loadAdpater(list);
                }
                break;
            // 预览
            case REQUEST_PREVIEW_CODE:
                if (resultCode == RESULT_OK) {
                    ArrayList<String> ListExtra = data
                            .getStringArrayListExtra(PhotoPreviewActivity
                                    .EXTRA_RESULT);
                    loadAdpater(ListExtra);
                }
                break;

        }
    }
    private void Url_publish() {
        PublishRoastPost post = new PublishRoastPost(1,content.getText().toString()
                ,0,qiniu_key);
        RemoteOptionIml remoteOptionIml = new RemoteOptionIml();
        remoteOptionIml.publishRoast(post, baseUrl, url, new CustomCallBack1<RemoteDataResult1>() {

            @Override
            public void onSuccess(Response<RemoteDataResult1> response) {
                ToastUtil.showShortToast(getBaseContext(),"发布成功");
                finish();
            }

            @Override
            public void onFail(String message) {

            }
        });

    }




    private void loadAdpater(ArrayList<String> paths) {
        if (imagePaths != null && imagePaths.size() > 0) {
            imagePaths.clear();
        }
        if (paths.contains("000000")) {
            paths.remove("000000");
        }
        paths.add("000000");
        imagePaths.addAll(paths);
        adapter.notifyDataSetChanged();
        try {
            JSONArray obj = new JSONArray(imagePaths);
            Log.e("--", obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
