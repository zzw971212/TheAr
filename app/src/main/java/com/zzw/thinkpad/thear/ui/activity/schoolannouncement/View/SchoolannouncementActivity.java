package com.zzw.thinkpad.thear.ui.activity.schoolannouncement.View;
import android.view.View;
import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;
import com.zzw.thinkpad.thear.weight.layout.NormalToolbar;
import butterknife.BindView;
public class SchoolannouncementActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    NormalToolbar toolbar;
    @Override
    protected int getContentView() {
        return R.layout.activity_schoolannouncement;
    }

    @Override
    protected void initViews() {
        toolbar.setLeftIv(R.mipmap.btn_back_white);
        toolbar.setTitle("校园公告");
        toolbar.setRightIv(R.mipmap.my_img_point);
        toolbar.setRightClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showdialog();
            }
        });
        toolbar.setLeftClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
