package com.zappos.android.intern.activities;

import com.zappos.android.intern.R;
import com.zappos.android.intern.framework.BaseActivity;
import com.zappos.android.intern.utils.Constants;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Kevin on 09-02-2017. Activity to perform search taking input from
 * user and navigating to product details page.
 */
public class SearchActivity extends BaseActivity {
	private EditText etSearch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void init() {
		Log.d("SEARCH_ACTIVITY", "init() called");
		setContentView(R.layout.activity_search);
		etSearch = (EditText) findViewById(R.id.etSearch);
		findViewById(R.id.ivSearch).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				validateSearch();
			}
		});
		etSearch.setImeActionLabel("Search", KeyEvent.KEYCODE_ENTER);
		etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				boolean handled = false;
				if (actionId == EditorInfo.IME_ACTION_SEND) {
					validateSearch();
					handled = true;
				}
				return handled;
			}
		});
	}

	/**
	 * Performs validations on text searched.
	 */
	private void validateSearch() {
		if (isInternetConnectivityAvailable()) {
			String searchBoxtext = etSearch.getText().toString();
			if (searchBoxtext.trim().isEmpty()) {
				Toast.makeText(this, "Please let us know what you're looking for today.", Toast.LENGTH_SHORT).show();
			} else if (searchBoxtext.trim().length() < 3) {
				Toast.makeText(this, "Please enter at least 3 characters before you proceed.", Toast.LENGTH_SHORT).show();
			} else {
				showProductDetailsPage();
			}
		} else {
			Toast.makeText(this, "Please check for internet connection on your device!", Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * Returns if internet connectivity is available on device or not.
	 * 
	 * @return boolean
	 */
	private boolean isInternetConnectivityAvailable() {
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		return (activeNetworkInfo != null) && activeNetworkInfo.isConnected();
	}

	/**
	 * Navigates to product detail page with the searchParam as an extra.
	 */
	private void showProductDetailsPage() {
		Intent intent = new Intent(SearchActivity.this, ProductDetailActivity.class);
		intent.putExtra(Constants.SEARCH_QUERY_EXTRA, etSearch.getText().toString().trim());
		startActivity(intent);
	}
}
