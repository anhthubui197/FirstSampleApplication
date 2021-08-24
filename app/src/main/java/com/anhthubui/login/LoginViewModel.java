package com.anhthubui.login;

import android.util.Log;

import com.anhthubui.base.BaseViewModel;
import com.anhthubui.model.LoginRequest;
import com.anhthubui.model.api.IApiHelper;
import com.anhthubui.ultils.ISchedulerProvider;

public class LoginViewModel extends BaseViewModel<LoginHandler>
{

    private static final String TAG = "Thu LoginViewModel";

    public LoginViewModel(ISchedulerProvider mSchedulerProvider, IApiHelper apiHelper) {
        super(mSchedulerProvider, apiHelper);
    }

    public void login(String username, String password) {
        getCompositeDisposable()
                .add(getApiHelper().doLoginApiCall(new LoginRequest(username, password))
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(response -> {
                            getHandler().openViewPostsActivity(response);
                            //Log.i(TAG, "subscribe response: "+ response.getUserName());
                        }, throwable -> {
                            //Log.i(TAG, "subscribe throwable: "+ throwable.getMessage());
                            getHandler().handleError(throwable);
                        }));
    }
}
