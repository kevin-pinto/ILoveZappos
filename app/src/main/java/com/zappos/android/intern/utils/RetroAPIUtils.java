package com.zappos.android.intern.utils;

import com.zappos.android.intern.api.SearchAPIService;
import com.zappos.android.intern.framework.RetroAPIClient;

/**
 * Created by Kevin on 10-02-2017.
 */
public class RetroAPIUtils {
	//https://api.zappos.com/Search?term=nike&key=b743e26728e16b81da139182bb2094357c31d331
	private static final String TAG = RetroAPIUtils.class.getSimpleName();
	public static final String BASE_URL = "https://api.zappos.com/";
	public static final String AND = "&";
	public static final String EQUALS = "=";
	public static final String SEARCH = "Search?";
	public static final String KEY = "key";
	public static final String KEY_VALUE = "b743e26728e16b81da139182bb2094357c31d331";
	public static final String DUMMY_KEY_VALUE = KEY + EQUALS + KEY_VALUE;

	/**
	 * Retrives key for the given session.
	 * 
	 * @return returns dummy key for the session.
	 */
	public static final String getAPIKey() {
		return KEY.concat(EQUALS).concat(KEY_VALUE);
	}

	/**
	 * Fetches the interface to query the search.
	 * 
	 * @return SearchAPIService
	 */
	public static SearchAPIService getSearchAPI() {
		return RetroAPIClient.getClient().create(SearchAPIService.class);
	}
}
