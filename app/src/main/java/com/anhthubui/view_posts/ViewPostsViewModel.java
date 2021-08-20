package com.anhthubui.view_posts;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.anhthubui.base.BaseViewModel;
import com.anhthubui.model.LoginRequest;
import com.anhthubui.model.api.ApiHelper;
import com.anhthubui.model.api.IApiHelper;
import com.anhthubui.ultils.ISchedulerProvider;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ViewPostsViewModel extends BaseViewModel<ViewPostsHandler> {

    final static String TAG ="Thu ViewPostsViewModel";

    public ViewPostsViewModel(ISchedulerProvider mSchedulerProvider, IApiHelper apiHelper) {
        super(mSchedulerProvider, apiHelper);
        Log.i(TAG,"ViewPostsViewModel");
    }


    public void getPosts(String userId) {
        Log.i(TAG,"getPosts");
        getCompositeDisposable()
                .add(getApiHelper().doGetPostApiCall(userId)
                        .doOnSuccess(postResponseList -> Log.i(TAG, postResponseList.get(0).getBody()))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(response -> {
                            getHandler().setUpPosts(response);
                            Log.i(TAG, "response: "+ response.get(1).getTitle());
                        }, throwable -> {
                            Log.i(TAG, "throwable: "+ throwable.getMessage());
                        }));
    }
}
