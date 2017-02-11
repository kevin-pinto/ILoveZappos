package com.zappos.android.intern.helpers;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.zappos.android.intern.R;
import com.zappos.android.intern.activities.ProductDetailActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

/**
 * Created by Kevin on 11-10-2016.
 */
/**
 * This class is used to download image into bitmap from the product url.
 */
public class FetchImageAsyncTask extends AsyncTask<Object, Void, Bitmap> {
	private Activity activity;

	public FetchImageAsyncTask(Activity activity) {
		this.activity = activity;
	}

	@Override
	protected Bitmap doInBackground(Object... params) {
		Bitmap bitmap = null;
		try {
			URL url = new URL((String) params[0]);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.connect();
			InputStream input = connection.getInputStream();
			bitmap = BitmapFactory.decodeStream(input);
		} catch (Exception ex) {
			bitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.img_unavailable);
		}
		return bitmap;
	}

	/**
	 * Redirects to perform
	 * 
	 * @param success
	 */
	@Override
	protected void onPostExecute(Bitmap success) {
		((ProductDetailActivity) activity).onImageLoadComplete(success);
	}
}
