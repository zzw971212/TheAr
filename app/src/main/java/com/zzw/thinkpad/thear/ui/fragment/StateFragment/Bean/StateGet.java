package com.zzw.thinkpad.thear.ui.fragment.StateFragment.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by thinkpad on 2018/12/6.
 */

public class StateGet {
    @SerializedName("name")
    private String name;//吐槽人名字
    @SerializedName("picing")
    private int picing;//吐槽人头像
    @SerializedName("content")
    private String content;
    @SerializedName("time")
    private String time;
    @SerializedName("approve")
    private int approve;//赞数
    @SerializedName("com")
    private int com;//评论
    @SerializedName("yon")
    private int yon;//转发数
    @SerializedName("see")
    private int see;//浏览数
    @SerializedName("plist")
    private List<PicingGet> plist;//图片

    public StateGet(String name, int picing, String content, String time, int approve, int com, int yon, int see, List<PicingGet> plist) {
        this.name = name;
        this.picing = picing;
        this.content = content;
        this.time = time;
        this.approve = approve;
        this.com = com;
        this.yon = yon;
        this.see = see;
        this.plist = plist;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicing(int picing) {
        this.picing = picing;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setApprove(int approve) {
        this.approve = approve;
    }

    public void setCom(int com) {
        this.com = com;
    }

    public void setYon(int yon) {
        this.yon = yon;
    }

    public void setSee(int see) {
        this.see = see;
    }

    public void setPlist(List<PicingGet> plist) {
        this.plist = plist;
    }

    public String getName() {
        return name;
    }

    public int getPicing() {
        return picing;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public int getApprove() {
        return approve;
    }

    public int getCom() {
        return com;
    }

    public int getYon() {
        return yon;
    }

    public int getSee() {
        return see;
    }

    public List<PicingGet> getPlist() {
        return plist;
    }
}
