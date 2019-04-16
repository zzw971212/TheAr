package com.zzw.thinkpad.thear.ui.activity.login.Bean;

/**
 * Created by thinkpad on 2018/9/26.
 */

public class LoginPost {
    private  Long phone;
    private  String password;

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginPost(Long phone, String password) {
        this.phone = phone;
        this.password = password;
    }
}
