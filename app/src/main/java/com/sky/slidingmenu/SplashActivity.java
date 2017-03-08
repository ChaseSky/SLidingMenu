package com.sky.slidingmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Sky on 2017/3/6.
 */

public class SplashActivity extends Activity implements Runnable {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.splash);
        Thread thread = new Thread(this);
        Log.i("1", "2");
        thread.start();
    }


    @Override
    public void run() {
        intent = new Intent(SplashActivity.this, LoginActivity.class);
        try {
            Thread.sleep(1200);
            Log.i("3", "4");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.finish();
        startActivity(intent);

    }
}
