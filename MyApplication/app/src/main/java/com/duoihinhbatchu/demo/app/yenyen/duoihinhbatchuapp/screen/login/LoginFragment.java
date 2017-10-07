package com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.screen.login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.R;
import com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.app.base.BaseFragment;
import com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.screen.menu.MenuActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by yenyen on 10/5/2017.
 */

public class LoginFragment extends BaseFragment implements LoginContract.View {

    private LoginContract.Presenter mPresenter;
    private ProgressDialog mProgressDialog;
    private CallbackManager mCallbackManager;

    @BindView(R.id.login_button)
    LoginButton loginButton;

    public LoginFragment() {
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);

        loginButton.setReadPermissions("email", "public_profile");
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                mPresenter.handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCallbackManager = CallbackManager.Factory.create();
        mPresenter.checkUserLogin();
    }

    @Override
    public void onStart() {
        LoginManager.getInstance().logOut();
        super.onStart();
        mPresenter.checkUserLogin();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void showProgressBar() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getContext());
            mProgressDialog.setIndeterminate(true);
        }
        mProgressDialog.show();
    }

    @Override
    public void hideProgressBar() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showError() {

    }

    @Override
    public void dangNhapThanhCong() {
        Toast.makeText(getContext(), getString(R.string.dang_nhap_thanh_cong), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dangNhapThatBai() {

        Toast.makeText(getContext(), getString(R.string.dang_nhap_that_bai), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goToMenuScreen(FirebaseUser user) {
        if (user != null) {
            Activity activity = getActivity();
            if (activity != null) {
                MenuActivity.start(activity);
                activity.finish();
            }
        }
    }
}
