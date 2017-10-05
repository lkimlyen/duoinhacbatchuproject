package com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.screen.login;

import com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.app.base.BasePresenter;
import com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.app.base.BaseView;
import com.facebook.AccessToken;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by yenyen on 10/4/2017.
 */

public interface LoginContract {
    interface View extends BaseView<LoginContract.Presenter> {
        void showError();

        void dangNhapThanhCong();

        void dangNhapThatBai();

        void goToMenuScreen(FirebaseUser user);
    }

    interface Presenter extends BasePresenter {
        void handleFacebookAccessToken(AccessToken token);
        void checkUserLogin();
    }

}
