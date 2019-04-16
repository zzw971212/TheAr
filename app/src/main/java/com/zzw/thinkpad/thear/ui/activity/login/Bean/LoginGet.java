package com.zzw.thinkpad.thear.ui.activity.login.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by asus-pc on 2017/7/16.
 */

public class LoginGet {
    @SerializedName("uniqueId")
    private String uniqueId;//唯一id
    @SerializedName("name")
    private String name;
    @SerializedName("school")
    private String school;//昵称
    @SerializedName("clazz")
    private String clazz;
    @SerializedName("phone")
    private String phone;//

    public LoginGet(String uniqueId, String name, String school, String clazz, String phone) {
        this.uniqueId = uniqueId;
        this.name = name;
        this.school = school;
        this.clazz = clazz;
        this.phone = phone;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    public String getClazz() {
        return clazz;
    }

    public String getPhone() {
        return phone;
    }
}
