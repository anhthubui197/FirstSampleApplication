package com.anhthubui;

import com.anhthubui.login.LoginViewModel;
import com.anhthubui.model.GetPostResponse;
import com.anhthubui.model.LoginRequest;
import com.anhthubui.model.LoginResponse;
import com.anhthubui.model.api.IApiHelper;
import com.anhthubui.ultils.TestSchedulerProvider;
import com.anhthubui.view_posts.ViewPostsHandler;
import com.anhthubui.view_posts.ViewPostsViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.Single;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ViewPostsViewModelTest {
    @Mock
    IApiHelper mMockApiHelper;
    @Mock
    ViewPostsHandler viewPostsHandler;

    private ViewPostsViewModel viewPostsViewModel;
    private TestScheduler mTestScheduler;

    @Before
    public void setUp() throws Exception {
        mTestScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
        viewPostsViewModel = new ViewPostsViewModel(testSchedulerProvider, mMockApiHelper);
        viewPostsViewModel.setHandler(viewPostsHandler);
    }

    @After
    public void tearDown() throws Exception {
        mTestScheduler = null;
        viewPostsViewModel = null;
        viewPostsHandler = null;
    }


    @Test
    public void correctInput_getPosts_shouldSetUpPosts() throws Exception {
        String userId = "1";

        List<GetPostResponse> getPostResponses = new ArrayList<>();

        when(mMockApiHelper.doGetPostApiCall(anyString()))
                .thenReturn(Single.just(getPostResponses));


        viewPostsViewModel.getPosts(userId);
        mTestScheduler.triggerActions();

        verify(viewPostsHandler).setUpPosts(any(List.class));
    }
}
