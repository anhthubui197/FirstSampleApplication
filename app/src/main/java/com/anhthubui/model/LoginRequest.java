package com.anhthubui.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class LoginRequest {

    @Expose
    @SerializedName("username")
    private String username;

    @Expose
    @SerializedName("password")
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getusername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
