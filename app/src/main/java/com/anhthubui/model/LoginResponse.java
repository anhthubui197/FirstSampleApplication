package com.anhthubui.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class LoginResponse {

    @Expose
    @SerializedName("userId")
    private String userId;

    @Expose
    @SerializedName("userName")
    private String userName;

    @Expose
    @SerializedName("firstName")
    private String firstName;

    @Expose
    @SerializedName("lastName")
    private String lastName;

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
