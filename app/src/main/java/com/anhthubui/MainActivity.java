package com.anhthubui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.anhthubui.databinding.ActivityLoginBinding;
import com.anhthubui.login.LoginActivity;
import com.anhthubui.login.LoginViewModel;
import com.anhthubui.model.LoginRequest;
import com.anhthubui.model.LoginResponse;
import com.anhthubui.model.api.ApiHelper;
import com.anhthubui.view_posts.ViewPostsViewModel;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);

        //ActivityLoginBinding binding = ActivityLoginBinding.inflate(getLayoutInflater());
        startActivity(new Intent(this, LoginActivity.class));
//        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
//
//        final LoginViewModel mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
//
//        binding.setViewModel(mViewModel);
//
//        final ViewPostsViewModel viewPostsViewModel = new ViewModelProvider(this).get(ViewPostsViewModel.class);

        //viewPostsViewModel.getPosts("1");
    }
}