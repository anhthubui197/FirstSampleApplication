package com.anhthubui;

import com.anhthubui.login.LoginHandler;
import com.anhthubui.login.LoginViewModel;
import com.anhthubui.model.LoginRequest;
import com.anhthubui.model.LoginResponse;
import com.anhthubui.model.api.IApiHelper;
import com.anhthubui.ultils.TestSchedulerProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Single;
import io.reactivex.schedulers.TestScheduler;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginViewModelTest {

    @Mock
    LoginHandler mLoginCallback;
    @Mock
    IApiHelper mMockApiHelper;

    private LoginViewModel mLoginViewModel;
    private TestScheduler mTestScheduler;

    @BeforeClass
    public static void onlyOnce() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        mTestScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
        mLoginViewModel = new LoginViewModel(testSchedulerProvider, mMockApiHelper);
        mLoginViewModel.setNavigator(mLoginCallback);
    }

    @After
    public void tearDown() throws Exception {
        mTestScheduler = null;
        mLoginViewModel = null;
        mLoginCallback = null;
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void correctInput_login_shouldOpenViewPostsActivity() throws Exception {
        String username = "Tester";
        String password = "P@ssw0rd";

        LoginResponse loginResponse = new LoginResponse();

        when(mMockApiHelper.doLoginApiCall(any(LoginRequest.class)))
                .thenReturn(Single.just(loginResponse));


        mLoginViewModel.login(username, password);
        mTestScheduler.triggerActions();

        verify(mLoginCallback).openViewPostsActivity();
    }
}
