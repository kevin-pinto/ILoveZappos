package com.zappos.android.intern.api;

import com.zappos.android.intern.modal.retro.ProductList;
import com.zappos.android.intern.utils.RetroAPIUtils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Kevin on 10-02-2017. Interface to expose the endpoint to perform
 * search operation.
 */
public interface SearchAPIService {
	@GET(RetroAPIUtils.SEARCH + RetroAPIUtils.DUMMY_KEY_VALUE)
	public Call<ProductList> getProducts(@Query("term") String search);
}
