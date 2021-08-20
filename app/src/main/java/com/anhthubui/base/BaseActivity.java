package com.anhthubui.base;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.anhthubui.di.component.ActivityComponent;
import com.anhthubui.di.component.DaggerActivityComponent;
import com.anhthubui.di.module.ActivityModule;

import javax.inject.Inject;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity
{
    final static String TAG ="Thu BaseActivity";

    private T mViewDataBinding;

    @Inject
    protected V mViewModel;

    public abstract int getBindingVariable();

    public abstract
    @LayoutRes
    int getLayoutId();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(TAG,"onCreate");
        performDependencyInjection(getBuildComponent());
        super.onCreate(savedInstanceState);
        performDataBinding();
    }

    public T getViewDataBinding() {
        return mViewDataBinding;
    }


    private ActivityComponent getBuildComponent() {
        Log.i(TAG,"getBuildComponent");

        return DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .build();
    }

    public abstract void performDependencyInjection(ActivityComponent buildComponent);


    private void performDataBinding() {
        Log.i(TAG,"performDataBinding");

        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        //mViewDataBinding.executePendingBindings();
    }
}

