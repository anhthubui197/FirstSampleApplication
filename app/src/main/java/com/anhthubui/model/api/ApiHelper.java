package com.anhthubui.model.api;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.anhthubui.model.GetPostResponse;
import com.anhthubui.model.LoginRequest;
import com.anhthubui.model.LoginResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class ApiHelper implements IApiHelper {

    public static final String ENDPOINT_LOGIN = "https://run.mocky.io/v3/bd65fa35-85c4-4a03-b999-b2c6c0068814";

    public static final String ENDPOINT_GET_POST = " https://jsonplaceholder.typicode.com/posts";

    @Inject
    public ApiHelper() {
    }

    @Override
    public Single<LoginResponse> doLoginApiCall(LoginRequest request) {
        return Rx2AndroidNetworking.post(ENDPOINT_LOGIN)
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);

    }

    @Override
    public Single<List<GetPostResponse>> doGetPostApiCall(String userId) {
        return Rx2AndroidNetworking.get(ENDPOINT_GET_POST)
                .addQueryParameter("userId",userId)
                .build()
                .getObjectListSingle(GetPostResponse.class);
    }

}
