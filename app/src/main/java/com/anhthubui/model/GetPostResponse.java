package com.anhthubui.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class GetPostResponse {

    @Expose
    @SerializedName("userId")
    private String userId;

    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("body")
    private String body;

    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
