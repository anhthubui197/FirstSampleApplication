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
        //Log.i(TAG,"ViewPostsViewModel");
    }


    public void getPosts(String userId) {
        //Log.i(TAG,"getPosts");
        getCompositeDisposable()
                .add(getApiHelper().doGetPostApiCall(userId)
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(response -> {
                            //Log.i(TAG, "subscribe response");
                            getHandler().setUpPosts(response);
                        }, throwable -> {
                            //Log.i(TAG, "throwable: "+ throwable.getMessage());
                        }));
    }
}
