package com.zappos.android.intern.framework;

import com.zappos.android.intern.utils.RetroAPIUtils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kevin on 10-02-2017. Singleton implementation of @{@link Retrofit}
 * client to interface HTTP calls.
 */
public class RetroAPIClient {
	private static Retrofit retrofit = null;

	public static Retrofit getClient() {
		if (retrofit == null) {
			synchronized (RetroAPIClient.class) {
				if (retrofit == null) {
					retrofit = new Retrofit.Builder().baseUrl(RetroAPIUtils.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
				}
			}
		}
		return retrofit;
	}
}
