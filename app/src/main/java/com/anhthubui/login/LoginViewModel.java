package com.anhthubui.login;

import com.anhthubui.base.BaseViewModel;
import com.anhthubui.model.LoginRequest;
import com.anhthubui.model.api.IApiHelper;
import com.anhthubui.ultils.ISchedulerProvider;

public class LoginViewModel extends BaseViewModel<LoginHandler>
{

    public LoginViewModel(ISchedulerProvider mSchedulerProvider, IApiHelper apiHelper) {
        super(mSchedulerProvider, apiHelper);
    }

    public void login(String username, String password) {
        getCompositeDisposable()
                .add(getApiHelper().doLoginApiCall(new LoginRequest(username, password))
                    //.doOnSuccess(
                      //      loginResponse -> Log.i("Thu", loginResponse.getFirstName() + " "+ loginResponse.getLastName()))
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(response -> {
                         //   Log.i("Thu", "response: "+ response.getUserName());
                            getHandler().openViewPostsActivity();
                        }, throwable -> {
                          //  Log.i("Thu", "throwable: "+ throwable.getMessage());
                            getHandler().handleError(throwable);
                        }));
    }
}
