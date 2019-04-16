package com.zzw.thinkpad.thear.ui.activity.roastDetail.Module;

import com.google.gson.annotations.SerializedName;
import com.zzw.thinkpad.thear.ui.fragment.StateFragment.Bean.PicingGet;

import java.util.List;



public class RoastDetailGet {
    @SerializedName("name")
    private String name;
    @SerializedName("picing")
    private String picing;
    @SerializedName("userid")
    private int userid;///吐槽着id
    @SerializedName("chatcontent")
    private String chatcontent;
    @SerializedName("Plist")
    private List<PicingGet> Plist;
    @SerializedName("chatclist")
    private List<ChatList> chatclist;

    public RoastDetailGet(String name, String picing, int userid, String
            chatcontent, List<PicingGet> plist, List<ChatList> chatclist) {
        this.name = name;
        this.picing = picing;
        this.userid = userid;
        this.chatcontent = chatcontent;
        Plist = plist;
        this.chatclist = chatclist;
    }

    public String getName() {
        return name;
    }

    public String getPicing() {
        return picing;
    }

    public int getUserid() {
        return userid;
    }

    public String getChatcontent() {
        return chatcontent;
    }

    public List<PicingGet> getPlist() {
        return Plist;
    }

    public List<ChatList> getChatclist() {
        return chatclist;
    }
}
