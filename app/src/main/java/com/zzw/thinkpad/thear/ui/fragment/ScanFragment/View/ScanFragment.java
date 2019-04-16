package com.zzw.thinkpad.thear.ui.fragment.ScanFragment.View;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lidong.photopicker.PhotoPickerActivity;
import com.lidong.photopicker.PhotoPreviewActivity;
import com.lidong.photopicker.SelectModel;
import com.lidong.photopicker.intent.PhotoPickerIntent;
import com.lidong.photopicker.intent.PhotoPreviewIntent;
import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.adapter.ChooseAdapter;
import com.zzw.thinkpad.thear.base.BaseFragment;
import com.zzw.thinkpad.thear.easyAR.CameraActivity;
import com.zzw.thinkpad.thear.easyAR.GLView;
import com.zzw.thinkpad.thear.ui.activity.publish.View.PictureActivity;
import com.zzw.thinkpad.thear.ui.activity.scanresult.View.ScanActivity;
import com.zzw.thinkpad.thear.weight.layout.LayoutScan;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.OnClick;
import cn.easyar.Engine;
import cn.easyar.engine.PermissionFragment;

import static android.app.Activity.RESULT_OK;

/**
 * Created by thinkpad on 2018/12/6.
 */

public class ScanFragment extends BaseFragment {
    @BindView(R.id.toolbar)
    NormalToolbar toolbar;
    @BindView(R.id.preview)
    FrameLayout preview;
    @BindView(R.id.scan)
    TextView scan;
    private GLView glView;
    private ArrayList<String> imagePaths = new ArrayList<>();
    private ChooseAdapter adapter;
    private List<String> plist = new ArrayList<>();
    private List<String> qiniu_key=new ArrayList<>();
    private static final int REQUEST_CAMERA_CODE = 1;
    private static final int REQUEST_PREVIEW_CODE = 2;
    private static String key =
            "BUdmA41NeffAcIax50JXzCMgsTpmmjrk8Xh26cUtKwzehNvrWBwt0FLEMqgy2XHROVHpOv4pJHV8kJeE2Vo2f5bsTPQbwRiXqO28YARsO7wmVYE2b4dXzYH0QgTq4B24z5meMk7V2JFYsofLkj1vhDdoWvLtRi4Siam5f9g7WXXnQeNW29fjVggkwj48wY0HeConUvi6";
    @Override
    protected void initViews(final View rootView) {
        initToolbar();


    }



    private void initToolbar() {
        toolbar.setLeftIv(R.mipmap.scan_left);
        toolbar.setTitle("扫一扫");
    }


    @Override
    protected int getContentViewID() {
        return R.layout.fragment_scan;
    }
    @OnClick({R.id.scan})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.scan:
             goActivity(CameraActivity.class
             );
               break;
        }
    }

}
