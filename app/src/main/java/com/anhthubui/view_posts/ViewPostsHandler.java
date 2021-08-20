package com.anhthubui.view_posts;

import com.anhthubui.model.GetPostResponse;

import java.util.List;

public interface ViewPostsHandler {
    void handleError(Throwable throwable);
    void setUpPosts(List<GetPostResponse> response);
}
