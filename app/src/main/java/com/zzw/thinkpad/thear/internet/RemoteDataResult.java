package com.zzw.thinkpad.thear.internet;

import com.google.gson.annotations.SerializedName;

/**
 * Created by XRY on 2016/10/4.
 */

public class RemoteDataResult<T> {
    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private T data;
    @SerializedName("status")
    private int status;

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResultMessage() {
        return msg;
    }

    public void setResultMessage(String resultMessage) {
        this.msg = resultMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
