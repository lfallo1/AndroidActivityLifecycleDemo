package com.training.lfallon.activitylifecycle1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public abstract class BaseActivity extends AppCompatActivity {

    private String tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tag = getClass().getSimpleName();
        Log.e(tag, "--- OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(tag, "--- onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(tag, "--- onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(tag, "--- onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(tag, "--- onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(tag, "--- onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(tag, "--- OnCreate");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(tag, "--- onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(tag, "--- onRestoreInstanceState");
    }
}
