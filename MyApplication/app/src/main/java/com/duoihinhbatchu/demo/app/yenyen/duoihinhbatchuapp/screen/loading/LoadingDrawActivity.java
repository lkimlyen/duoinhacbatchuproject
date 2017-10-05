package com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.screen.loading;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.R;

public class LoadingDrawActivity extends Activity {
    public static void startActivity(Context context) {
        Intent intent = new Intent(context, LoadingDrawActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_draw);
    }
}
