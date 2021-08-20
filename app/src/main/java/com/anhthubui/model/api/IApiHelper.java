package com.anhthubui.model.api;

import com.anhthubui.model.GetPostResponse;
import com.anhthubui.model.LoginRequest;
import com.anhthubui.model.LoginResponse;

import java.util.List;

import io.reactivex.Single;

public interface IApiHelper {
    Single<LoginResponse> doLoginApiCall(LoginRequest request);
    Single<List<GetPostResponse>> doGetPostApiCall(String userId);

}
