package com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.screen.login;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.R;
import com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.app.base.BaseActivity;


public class LoginActivity extends BaseActivity {

    LoginFragment loginFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);


    }
    private void initFragment() {
        loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        if (loginFragment == null) {
            loginFragment = LoginFragment.newInstance();
            addFragmentToBackStack(loginFragment, R.id.fragmentContainer);
        }
    }
    private void addFragmentToBackStack(LoginFragment fragment, int frameId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(frameId, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
