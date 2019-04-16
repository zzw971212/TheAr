package com.zzw.thinkpad.thear.ui.activity.Test.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.zzw.thinkpad.thear.R;
import com.zzw.thinkpad.thear.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Response;

public class Test1Activity extends BaseActivity {

    @BindView(R.id.choose_a)
    ImageView choose_a;
    @BindView(R.id.answer_b)
    ImageView answer_b;
    @BindView(R.id.cuo)
    ImageView cuo;
    @BindView(R.id.dui)
    ImageView dui;
    private int id;
    private String baseUrl = "http://121.43.59.5:8080/";
    private String url = "family/questions/subject?subject=消防安全";
    private int score=0;
    private String rightanswer;
    @Override
    protected int getContentView() {
        return R.layout.activity_test1;
    }

    @Override
    protected void initViews() {
        url_test1();

    }

    private void url_test1() {
      //  RemoteOptionIml remoteOptions = new RemoteOptionIml();
      //  CustomCallback2<RemoteDataResult2<Test1Get>> callback =new CustomCallback2<RemoteDataResult2<Test1Get>>() {
         //   @Override
         //   public void onSuccess(Response<RemoteDataResult2<Test1Get>> response) {

          //      for (int i=0;i<response.body().getData().length;i++){
          //          Test1Get apple = new Test1Get(response.body().getData()[i].getId(),response.body().getData()[i].getQuestion(),response.body().getData()[i].getSubject(),response.body().getData()[i].getAnswer());
          //      }

        //    }

        //    @Override
          //  public void onFail(String message) {

          //  }
      //  };
      //  remoteOptions.gettest1(callback);

    }


    @OnClick({R.id.choose_a,R.id.right,R.id.answer_b})
    public void onClicked(View v){
        switch (v.getId()){
            case R.id.choose_a:
                choose_a.setImageResource(R.mipmap.xuanze);
                score= score+10;
                choose_a.setEnabled(false);
                answer_b.setEnabled(false);
                cuo.setVisibility(View.VISIBLE);
                break;
            case R.id.answer_b:
                answer_b.setImageResource(R.mipmap.xuanze);
                score= score;
                choose_a.setEnabled(false);
                answer_b.setEnabled(false);
                dui.setVisibility(View.VISIBLE);
                break;
            case R.id.right:
                Bundle bundle =new Bundle();
                bundle.putInt("score",score);
                goActivity(Test2Activity.class,bundle);
                break;

        }
    }
}
