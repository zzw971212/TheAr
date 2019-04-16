package com.zzw.thinkpad.thear.internet;

import android.util.Log;

import com.zzw.thinkpad.thear.ui.activity.login.Bean.LoginGet;
import com.zzw.thinkpad.thear.ui.activity.publish.Bean.PublishRoastPost;
import com.zzw.thinkpad.thear.ui.activity.roastDetail.Module.CommentGet;
import com.zzw.thinkpad.thear.ui.activity.roastDetail.Module.DetailPost;
import com.zzw.thinkpad.thear.ui.activity.roastDetail.Module.ReplyPost;
import com.zzw.thinkpad.thear.ui.activity.roastDetail.Module.RoastDetailGet;
import com.zzw.thinkpad.thear.ui.fragment.StateFragment.Bean.All;
import com.zzw.thinkpad.thear.ui.fragment.StateFragment.Bean.ProvePost;
import com.zzw.thinkpad.thear.ui.fragment.StateFragment.Bean.RoastListGet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;


/**
 * Created by asus-pc on 2017/4/9.
 */
public class RemoteOptionIml {
    private HttpHelper httpHelper=new HttpHelper();
    private  String baseUrl ="http://114.116.55.220:8080/ar_safe/";
    public void login(String phone, String password,CustomCallBack<RemoteDataResult<LoginGet>> callback){
        JSONObject jsonObject=new JSONObject();
        Map<String , String>map = new HashMap<>();
      //  map.put("phone",phone);
        map.put("password",password);
        Log.d("---",jsonObject.toString());
        RemoteApi remoteApi = httpHelper.getService(RemoteApi.class,baseUrl);
        Call<RemoteDataResult<LoginGet>> remoteDataResultCall = remoteApi.login(phone,password);
        remoteDataResultCall.enqueue(callback);

    }
    public void register(String phone,  String username,String password,CustomCallBack<RemoteDataResult> callback){
        JSONObject jsonObject=new JSONObject();
        Map<String , String>map = new HashMap<>();
        //  map.put("phone",phone);
        map.put("password",password);
        Log.d("---",jsonObject.toString());
        RemoteApi remoteApi = httpHelper.getService(RemoteApi.class,baseUrl);
        Call<RemoteDataResult> remoteDataResultCall = remoteApi.register(phone,username,password);
        remoteDataResultCall.enqueue(callback);

    }
    public void register1(String phone,  String school,String clazz,String mark,CustomCallBack<RemoteDataResult> callback){
        JSONObject jsonObject=new JSONObject();

        Log.d("---",jsonObject.toString());
        RemoteApi remoteApi = httpHelper.getService(RemoteApi.class,baseUrl);
        Call<RemoteDataResult> remoteDataResultCall = remoteApi.register1(phone,school,clazz,mark);
        remoteDataResultCall.enqueue(callback);

    }
    public void publishRoast(PublishRoastPost post, String baseUrl,
                             String url, CustomCallBack1<RemoteDataResult1> callback){
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("userid",post.getUserid());
            jsonObject.put("chatcontent",post.getChatcontent());
            jsonObject.put("approve",post.getApprove());

            JSONArray jsonArray = new JSONArray();
            for(int i=0;i<post.getPlist().size();i++){
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("picing",post.getPlist().get(i));
                jsonArray.put(i,jsonObject1);
            }
            jsonObject.put("plist",jsonArray);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("---",jsonObject.toString());
        RemoteApi remoteApi = httpHelper.getService(RemoteApi.class,baseUrl);
        Call<RemoteDataResult1> remoteDataResultCall = remoteApi.publishRoast(url,jsonObject);
        remoteDataResultCall.enqueue(callback);

    }
    public void state(CustomCallBack<RemoteDataResult<All>> callback){
        JSONObject jsonObject=new JSONObject();

        Log.d("---",jsonObject.toString());
        RemoteApi remoteApi = httpHelper.getService(RemoteApi.class,baseUrl);
        Call<RemoteDataResult<All>> remoteDataResultCall = remoteApi.state();
        remoteDataResultCall.enqueue(callback);
    }
    public void Prove(ProvePost post, String baseUrl,
                      String url, CustomCallBack1<RemoteDataResult1> callback){
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("userid",post.getUserid());
            jsonObject.put("chatid",post.getChatid());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("---",jsonObject.toString());
        RemoteApi remoteApi = httpHelper.getService(RemoteApi.class,baseUrl);
        Call<RemoteDataResult1> remoteDataResultCall = remoteApi.Prove(url,jsonObject);
        remoteDataResultCall.enqueue(callback);

    }
    public void roastList(int post, String baseUrl,
                          String url, CustomCallBack1<RemoteDataResult1<List<RoastListGet>>> callback){
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("id",post);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("---",jsonObject.toString());
        RemoteApi remoteApi = httpHelper.getService(RemoteApi.class,baseUrl);
        Call<RemoteDataResult1<List<RoastListGet>>> remoteDataResultCall = remoteApi.roastList(url,jsonObject);
        remoteDataResultCall.enqueue(callback);

    }
    public void roastDetail(DetailPost post, String baseUrl,
                            String url, CustomCallBack1<RemoteDataResult1<RoastDetailGet>> callback){
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("id",post.getChatId());
            jsonObject.put("userid",post.getUserId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("---",jsonObject.toString());
        RemoteApi remoteApi = httpHelper.getService(RemoteApi.class,baseUrl);
        Call<RemoteDataResult1<RoastDetailGet>> remoteDataResultCall = remoteApi.roastDetail(url,jsonObject);
        remoteDataResultCall.enqueue(callback);
    }
    public void reply(ReplyPost post, String baseUrl,
                      String url, CustomCallBack1<RemoteDataResult1> callback){
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("chatid",post.getChatid());
            jsonObject.put("userid",post.getUserid());
            jsonObject.put("comment",post.getComment());
            jsonObject.put("dtime",post.getDtime());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("---",jsonObject.toString());
        RemoteApi remoteApi = httpHelper.getService(RemoteApi.class,baseUrl);
        Call<RemoteDataResult1> remoteDataResultCall = remoteApi.reply(url,jsonObject);
        remoteDataResultCall.enqueue(callback);

    }
    public void commentReply(ReplyPost post, String baseUrl,
                             String url, CustomCallBack1<RemoteDataResult1> callback){
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("chatcommentid",post.getChatid());
            jsonObject.put("userid",post.getUserid());
            jsonObject.put("targetid",post.getTargetid());
            jsonObject.put("comment",post.getComment());
            jsonObject.put("dtime",post.getDtime());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("---",jsonObject.toString());
        RemoteApi remoteApi = httpHelper.getService(RemoteApi.class,baseUrl);
        Call<RemoteDataResult1> remoteDataResultCall = remoteApi.commentReply(url,jsonObject);
        remoteDataResultCall.enqueue(callback);
    }
    public void commentDetail(DetailPost post, String baseUrl,
                              String url, CustomCallBack1<RemoteDataResult1<CommentGet>> callback){
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("id",post.getChatId());
            jsonObject.put("userid",post.getUserId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("---",jsonObject.toString());
        RemoteApi remoteApi = httpHelper.getService(RemoteApi.class,baseUrl);
        Call<RemoteDataResult1<CommentGet>> remoteDataResultCall = remoteApi.commentDetail(url,jsonObject);
        remoteDataResultCall.enqueue(callback);

    }
}






