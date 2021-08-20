package com.anhthubui.view_posts;

import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anhthubui.BR;
import com.anhthubui.R;
import com.anhthubui.base.BaseActivity;
import com.anhthubui.databinding.ActivityViewPostsBinding;
import com.anhthubui.di.component.ActivityComponent;
import com.anhthubui.model.GetPostResponse;

import java.util.List;

import javax.inject.Inject;

public class ViewPostsActivity extends BaseActivity<ActivityViewPostsBinding, ViewPostsViewModel> implements ViewPostsHandler
{
    final static String TAG ="Thu ViewPostsActivity";
    @Inject
    PostsAdapter postsAdapter;

    @Override
    public int getBindingVariable() {
        Log.i(TAG,"getBindingVariable");

        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        Log.i(TAG,"getLayoutId");

        return R.layout.activity_view_posts;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mViewModel.setHandler(this);
        Log.i(TAG,"onCreate");
        mViewModel.getPosts("1");
        Log.i(TAG,"after get posts");

    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        Log.i(TAG,"performDependencyInjection");

        buildComponent.inject(this);
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void setUpPosts(List<GetPostResponse> response) {
        Log.i(TAG,"setUpPosts");
        RecyclerView recyclerView = getViewDataBinding().posts;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        postsAdapter.setPostsList(response);
        recyclerView.setAdapter(postsAdapter);
    }
}
