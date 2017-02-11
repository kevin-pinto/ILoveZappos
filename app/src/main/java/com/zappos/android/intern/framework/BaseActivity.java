package com.zappos.android.intern.framework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Kevin on 09-02-2017. Base implementation of Activity. Must be
 * implemented by all activities
 * except @{@link com.zappos.android.intern.activities.SplashActivity}. Perform
 * animation and toolbar configuration here.
 */
public class BaseActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
	}

	/**
	 * Initialization of all views first time.
	 */
	protected void init() {
		Log.d("BASE_ACTIVITY", "init() called");
	}
}
