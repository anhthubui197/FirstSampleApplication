package com.anhthubui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.anhthubui.BR;
import com.anhthubui.R;
import com.anhthubui.base.BaseActivity;
import com.anhthubui.databinding.ActivityLoginBinding;
import com.anhthubui.di.component.ActivityComponent;
import com.anhthubui.model.LoginResponse;
import com.anhthubui.view_posts.ViewPostsActivity;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginHandler {

    final static String TAG ="Thu LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setHandler(this);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        //Log.i(TAG,"performDependencyInjection");
        buildComponent.inject(this);
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void openViewPostsActivity(LoginResponse response) {
        Intent intent = new Intent(LoginActivity.this, ViewPostsActivity.class);
        intent.putExtra("loginResponse",response);
        startActivity(intent);
        finish();
    }
}
