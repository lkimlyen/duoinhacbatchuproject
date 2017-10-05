package com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.app;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Created by yenyen on 10/5/2017.
 */
@RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class CoreApplication extends MultiDexApplication implements Application.ActivityLifecycleCallbacks{
    private String TAG = CoreApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        initializeFirebase();
        initializeFacebook();
    }
    private void initializeFirebase() {
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Core FCM Token: " + token);
    }

    private void initializeFacebook() {
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
