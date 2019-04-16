package com.zzw.thinkpad.thear.internet;


import com.zzw.thinkpad.thear.ui.activity.login.Bean.LoginGet;
import com.zzw.thinkpad.thear.ui.activity.roastDetail.Module.CommentGet;
import com.zzw.thinkpad.thear.ui.activity.roastDetail.Module.RoastDetailGet;
import com.zzw.thinkpad.thear.ui.fragment.StateFragment.Bean.All;
import com.zzw.thinkpad.thear.ui.fragment.StateFragment.Bean.RoastListGet;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;


public interface RemoteApi {
    @FormUrlEncoded
    @POST("user/login")
    Call<RemoteDataResult<LoginGet>>login(@Field("phone") String phone, @Field("password") String password);
    @FormUrlEncoded
    @POST("user/register/phone")
    Call<RemoteDataResult>register(@Field("phone") String phone, @Field("username") String username, @Field("password") String password  );
    @FormUrlEncoded
    @POST("user/register/phone")
    Call<RemoteDataResult>register1(@Field("phone") String phone, @Field("school") String school, @Field("clazz") String clazz , @Field("mark") String mark  );

    @FormUrlEncoded
    @GET("dynamic/index")
    Call<RemoteDataResult<All>>state( );
    @FormUrlEncoded
    @POST
    Call<RemoteDataResult1> Prove(@Url String url, @Field("")
            JSONObject jsonObject);
    @FormUrlEncoded
    @POST
    Call<RemoteDataResult1<List<RoastListGet>>> roastList(@Url String url, @Field("")
            JSONObject jsonObject);
    @FormUrlEncoded
    @POST
    Call<RemoteDataResult1> publishRoast(@Url String url, @Field("")
            JSONObject jsonObject);
    @FormUrlEncoded
    @POST
    Call<RemoteDataResult1<RoastDetailGet>> roastDetail(@Url String url, @Field("")
            JSONObject jsonObject);
    @FormUrlEncoded
    @POST
    Call<RemoteDataResult1> reply(@Url String url, @Field("")
            JSONObject jsonObject);
    @FormUrlEncoded
    @POST
    Call<RemoteDataResult1> commentReply(@Url String url, @Field("")
            JSONObject jsonObject);
    @FormUrlEncoded
    @POST
    Call<RemoteDataResult1<CommentGet>> commentDetail(@Url String url, @Field("")
            JSONObject jsonObject);
}
