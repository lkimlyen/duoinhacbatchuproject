package com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by yenyen on 9/30/2017.
 */

public class CalligraphyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().setDefaultFontPath(getString(R.string.font_name)).setFontAttrId(R.attr.fontPath).build());
    }
}
