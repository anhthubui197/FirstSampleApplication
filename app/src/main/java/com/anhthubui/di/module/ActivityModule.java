package com.anhthubui.di.module;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;

import com.anhthubui.ViewModelFactory;
import com.anhthubui.base.BaseActivity;
import com.anhthubui.login.LoginViewModel;
import com.anhthubui.model.api.ApiHelper;
import com.anhthubui.model.api.IApiHelper;
import com.anhthubui.ultils.ISchedulerProvider;
import com.anhthubui.ultils.SchedulerProvider;
import com.anhthubui.view_posts.ViewPostsViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private BaseActivity<?, ?> activity;

    public ActivityModule(BaseActivity<?, ?> activity) {
        this.activity = activity;
    }

    @Provides
    LoginViewModel provideLoginViewModel(ISchedulerProvider mSchedulerProvider, IApiHelper apiHelper) {
        Supplier<LoginViewModel> supplier = () -> new LoginViewModel(mSchedulerProvider,apiHelper );
        ViewModelFactory<LoginViewModel> factory = new ViewModelFactory<>(LoginViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(LoginViewModel.class);
    }

    @Provides
    ViewPostsViewModel provideViewPostsViewModel(ISchedulerProvider mSchedulerProvider, IApiHelper apiHelper) {
        Supplier<ViewPostsViewModel> supplier = () -> new ViewPostsViewModel(mSchedulerProvider,apiHelper );
        ViewModelFactory<ViewPostsViewModel> factory = new ViewModelFactory<>(ViewPostsViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(ViewPostsViewModel.class);
    }

    @Provides
    ISchedulerProvider provideSchedulerProvider(){
        return new SchedulerProvider();
    }

    @Provides
    @Singleton
    IApiHelper provideIApiHelper(ApiHelper apiHelper){
        return apiHelper;
    }
}
