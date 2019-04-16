//================================================================================================================================
//
//  Copyright (c) 2015-2017 VisionStar Information Technology (Shanghai) Co., Ltd. All Rights
// Reserved.
//  EasyAR is the registered trademark or trademark of VisionStar Information Technology
// (Shanghai) Co., Ltd in China
//  and other countries for the augmented reality technology developed by VisionStar Information
// Technology (Shanghai) Co., Ltd.
//
//================================================================================================================================

package com.zzw.thinkpad.thear.easyAR;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.bases.BaseActivity;
import com.zzw.thinkpad.thear.ui.activity.game.View.FireExtinguisherActivity;
import com.zzw.thinkpad.thear.ui.activity.game.View.alarmActivity;
import com.zzw.thinkpad.thear.ui.activity.scanresult.View.ScanActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import butterknife.BindView;
import cn.easyar.Engine;


public class CameraActivity extends BaseActivity {
    /*
    * Steps to create the key for this sample:
    *  1. login www.easyar.com
    *  2. create app with
    *      Name: HelloARObjectTracking
    *      Package Name: cn.easyar.samples.helloarobjecttracking
    *  3. find the created item in the list and show key
    *  4. set key string bellow
    */
    private static String key =
            "lDjMBlp0u3UY2nwH7mYTK2ZOJ1q4V6z9OlFZ47XH2uI5X7m9YffFIM15FeYCej0RrxRCoN6E8rHXm5qzHOCR2VWZRos0H0JWVjremt08eWhGTbInVWo5A9lHeveWA5YJWqzwblgyNPdNHwICCQJP3TqPXkzm61jR9PmBmzMjHkYFaAn32CkRHXVDJ1kaGu39loYPCjPP";
    @BindView(R.id.object_frame)
    FrameLayout mObjectFrame;

    private GLView glView;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_camera;
    }

    @Override
    protected void initUI() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager
                .LayoutParams.FLAG_KEEP_SCREEN_ON);

        if (!Engine.initialize(this, key)) {
            Log.e("HelloAR", "Initialization Failed.");
        }
        glView = new GLView(this);
        glView.setEventListener(new GLView.EventListener() {
            @Override
            public void successEvent(String targetName) {
                if (targetName.equals("mhq1") || targetName.equals("mhq2") || targetName.equals("mhq3") ||targetName.equals("1") || targetName.equals("2")||targetName.equals("3")||targetName.equals("4")||targetName.equals("5")||targetName.equals("6")||targetName.equals("7")
                        ||targetName.equals("8") ||targetName.equals("9")||targetName.equals("10")||targetName.equals("11")||targetName.equals("12")||targetName.equals("13")){
                    glView.cancelListener();
                    openActivityAndCloseThis(alarmActivity.class);
                } else if (targetName.equals("m1")||targetName.equals("m2")||targetName.equals("m3")||targetName.equals("m4")||targetName.equals("m5")||targetName.equals("m6")||targetName.equals("m7")||targetName.equals("m8")||targetName.equals("m9")||targetName.equals("m10")
                        ||targetName.equals("m11")||targetName.equals("m12")||targetName.equals("m13")||targetName.equals("m14")
                        ) {
                    glView.cancelListener();
                    String scan_name2="灭火器";
                    Bundle bundle =new Bundle();
                    bundle.putString("scan_name2",scan_name2);
                    openActivityAndCloseThis(FireExtinguisherActivity.class,bundle);

                } else if (targetName.equals("miehuoqi1") || targetName.equals("miehuoqi2")||targetName.equals("miehuoqi3")||targetName.equals("miehuoqi4")||targetName.equals("miehuoqi5")||targetName.equals("miehuoqi6")||targetName.equals("miehuoqi7")
                        ||targetName.equals("miehuoqi8") ||targetName.equals("miehuoqi9")||targetName.equals("miehuoqi10")||targetName.equals("miehuoqi11")||targetName.equals("miehuoqi12")) {
                    glView.resumeListener();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            openActivityAndCloseThis(ScanActivity.class);
                            mObjectFrame.setVisibility(View.VISIBLE);

                        }
                    });

                }
            }

            @Override
            public void failEvent() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mObjectFrame.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
        requestCameraPermission(new PermissionCallback() {
            @Override
            public void onSuccess() {
                ((ViewGroup) findViewById(R.id.preview)).addView(glView, new ViewGroup
                        .LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams
                        .MATCH_PARENT));
            }

            @Override
            public void onFailure() {
            }
        });
    }

    @Override
    protected void initData() {
    }

    Bitmap shoot;
    File fname;
    private void savePic() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);
        String storageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_REMOVED.equals(storageState)) {
            Toast.makeText(getApplicationContext(), "SD卡不存在", Toast.LENGTH_SHORT).show();
        }
        File fileDir=new File("/sdcard/FireSecurity/");
        if(!fileDir.exists()){
            fileDir.mkdir();
        }
        fname = new File(fileDir +"/IMG"+ sdf.format(new Date()) + ".png");

        View view = findViewById(R.id.object_frame);

        view.setDrawingCacheEnabled(true);

        view.buildDrawingCache();

        final Bitmap bitmap2 = view.getDrawingCache();



    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_camera);

    }

    private interface PermissionCallback {
        void onSuccess();

        void onFailure();
    }

    private HashMap<Integer, PermissionCallback> permissionCallbacks = new HashMap<Integer,
            PermissionCallback>();
    private int permissionRequestCodeSerial = 0;

    @TargetApi(23)
    private void requestCameraPermission(PermissionCallback callback) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager
                    .PERMISSION_GRANTED) {
                int requestCode = permissionRequestCodeSerial;
                permissionRequestCodeSerial += 1;
                permissionCallbacks.put(requestCode, callback);
                requestPermissions(new String[]{Manifest.permission.CAMERA}, requestCode);
            } else {
                callback.onSuccess();
            }
        } else {
            callback.onSuccess();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (permissionCallbacks.containsKey(requestCode)) {
            PermissionCallback callback = permissionCallbacks.get(requestCode);
            permissionCallbacks.remove(requestCode);
            boolean executed = false;
            for (int result : grantResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    executed = true;
                    callback.onFailure();
                }
            }
            if (!executed) {
                callback.onSuccess();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onResume() {
        Log.v("aa", "camera_resume");
        super.onResume();
        if (glView != null) {
            glView.onResume();
        }
//
    }

    @Override
    protected void onPause() {
        if (glView != null) {
            glView.onPause();
        }
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item)
//    {
//        int id = item.getItemId();
//
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
