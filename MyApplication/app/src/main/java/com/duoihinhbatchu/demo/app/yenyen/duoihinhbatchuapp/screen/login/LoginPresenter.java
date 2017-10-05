package com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.screen.login;

import android.support.annotation.NonNull;
import android.util.Log;

import com.facebook.AccessToken;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by yenyen on 10/4/2017.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private final String TAG = LoginPresenter.class.getName();
    private FirebaseAuth mAuth;
    LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        Log.d(TAG, TAG + ".start() called");
    }

    @Override
    public void stop() {
        Log.d(TAG, TAG + ".start() called");
    }

    @Override
    public void handleFacebookAccessToken(AccessToken token) {
        view.showProgressBar();
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            view.dangNhapThanhCong();
                            view.goToMenuScreen(user);

                        } else {

                            view.dangNhapThatBai();
                            view.goToMenuScreen(null);

                        }
                        view.showProgressBar();
                    }

                });
    }

    @Override
    public void checkUserLogin() {
        FirebaseUser user = mAuth.getCurrentUser();
        view.goToMenuScreen(user);
    }
}
