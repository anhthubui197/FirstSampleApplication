package com.anhthubui.base;

import android.util.Log;

import androidx.lifecycle.ViewModel;
import com.anhthubui.model.api.IApiHelper;
import com.anhthubui.ultils.ISchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel<N> extends ViewModel {

    private static String TAG ="Thu BaseViewModel";
    private final ISchedulerProvider mSchedulerProvider;

    private final IApiHelper apiHelper;

    private CompositeDisposable mCompositeDisposable;

    private N handler;

    protected BaseViewModel(ISchedulerProvider mSchedulerProvider, IApiHelper apiHelper) {
        Log.i(TAG,"BaseViewModel");

        this.mSchedulerProvider = mSchedulerProvider;
        this.apiHelper = apiHelper;
        this.mCompositeDisposable = new CompositeDisposable();

    }

    @Override
    protected void onCleared() {
        Log.i(TAG,"onCleared");

        mCompositeDisposable.dispose();
        super.onCleared();
    }

    public ISchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public IApiHelper getApiHelper() {
        return apiHelper;
    }

    public N getHandler() {
        return handler;
    }

    public void setHandler(N handler) {
        this.handler = handler;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }
}
