package com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.screen.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.R;
import com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.app.base.BaseActivity;

/**
 * Created by yenyen on 10/5/2017.
 */

public class MenuActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
    public static void start(Activity activity) {
        Intent intent = new Intent(activity, MenuActivity.class);
        activity.startActivity(intent);
    }

}
