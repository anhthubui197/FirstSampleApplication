package com.anhthubui.login;

import android.content.Intent;
import android.os.Bundle;

import com.anhthubui.BR;
import com.anhthubui.R;
import com.anhthubui.base.BaseActivity;
import com.anhthubui.databinding.ActivityLoginBinding;
import com.anhthubui.di.component.ActivityComponent;
import com.anhthubui.view_posts.ViewPostsActivity;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginHandler {

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
        buildComponent.inject(this);
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void openViewPostsActivity() {
        startActivity(new Intent(LoginActivity.this, ViewPostsActivity.class));
        finish();
    }
}
