package com.anhthubui.di.component;

import com.anhthubui.di.module.ActivityModule;
import com.anhthubui.login.LoginActivity;
import com.anhthubui.view_posts.ViewPostsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(LoginActivity activity);

    void inject(ViewPostsActivity activity);
}
