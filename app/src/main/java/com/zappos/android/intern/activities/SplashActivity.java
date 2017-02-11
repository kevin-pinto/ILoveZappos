package com.zappos.android.intern.activities;

import com.zappos.android.intern.BuildConfig;
import com.zappos.android.intern.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Kevin on 10-02-2017.<br/>
 * <br/>
 * Displays branding, and background services such as sync loading and local
 * database reading should be done over here.
 */
public class SplashActivity extends AppCompatActivity {
	private int count = 0;
	private int SPLASH_TIME_OUT = 3000;
	private int SPLASH_INTERVAL = 500;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		int versionCode = BuildConfig.VERSION_CODE;
		String versionName = BuildConfig.VERSION_NAME;
		((TextView) findViewById(R.id.tvVersion)).setText("Version: " + versionName);
		performAnimation();
	}

	/**
	 * Displays branding image and perform loading animation. Once done,
	 * redirects to next activity.
	 */
	private void performAnimation() {
		final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
		progressBar.setProgress(0);
		progressBar.setMax(5);
		CountDownTimer timer = new CountDownTimer(SPLASH_TIME_OUT, SPLASH_INTERVAL) {
			@Override
			public void onTick(long millisUntilFinished) {
				count++;
				progressBar.setProgress(count);
			}

			@Override
			public void onFinish() {
				startNextActivity();
			}
		};
		timer.start();
	}

	/**
	 * Redirects to next activity.
	 */
	private void startNextActivity() {
		Intent intent = new Intent(this, SearchActivity.class);
		startActivity(intent);
		finish();
	}
}
