package com.anhthubui.view_posts;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.anhthubui.databinding.PostListItemBinding;
import com.anhthubui.model.GetPostResponse;
import com.anhthubui.R;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    final static String TAG ="Thu PostsAdapter";

    private List<GetPostResponse> posts;

    @Inject
    public PostsAdapter() {
        Log.i(TAG,"PostsAdapter");
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.i(TAG,"onCreateViewHolder");

        PostListItemBinding postListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.post_list_item, viewGroup, false);
        return new PostViewHolder(postListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder PostViewHolder, int i) {
        Log.i(TAG,"onBindViewHolder");

        GetPostResponse currentPost = posts.get(i);
        PostViewHolder.postListItemBinding.setPost(currentPost);
        PostViewHolder.postListItemBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if (posts != null) {
            return posts.size();
        } else {
            return 0;
        }
    }

    public void setPostsList(List<GetPostResponse> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder {

        private PostListItemBinding postListItemBinding;

        public PostViewHolder(@NonNull PostListItemBinding employeetListItemBinding) {
            super(employeetListItemBinding.getRoot());

            this.postListItemBinding = employeetListItemBinding;
        }

        public PostListItemBinding getPostListItemBinding() {
            return postListItemBinding;
        }
    }
}