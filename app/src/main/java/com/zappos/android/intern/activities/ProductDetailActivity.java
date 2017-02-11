package com.zappos.android.intern.activities;

import java.util.Random;

import com.zappos.android.intern.R;
import com.zappos.android.intern.databinding.ActivityProductDetailBinding;
import com.zappos.android.intern.framework.BaseActivity;
import com.zappos.android.intern.helpers.FetchImageAsyncTask;
import com.zappos.android.intern.modal.Product;
import com.zappos.android.intern.modal.retro.ProductList;
import com.zappos.android.intern.utils.Constants;
import com.zappos.android.intern.utils.RetroAPIUtils;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kevin on 10-02-2017. Displays details of single product. Using
 * Retrofit to make http calls. Implements a callback mechanism that initimates
 * the application of the success or failure of the network call.
 */
public class ProductDetailActivity extends BaseActivity implements Callback<ProductList> {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabCheckout);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Added to cart.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
			}
		});
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	protected void init() {
		Log.d("PRODUCT_DETAIL_ACTIVITY", "init() called");
		setContentView(R.layout.activity_product_detail);
		String mSearch = getIntent().getStringExtra(Constants.SEARCH_QUERY_EXTRA);
		Call<ProductList> call = RetroAPIUtils.getSearchAPI().getProducts(mSearch);
		call.enqueue(this);
	}

	/**
	 * Failure implementation of onSuccess for the REST call.
	 *
	 * @param call
	 * @param t
	 */
	@Override
	public void onFailure(Call<ProductList> call, Throwable t) {
		Log.e("PRODUCT_ERROR", t.getMessage());
		Toast.makeText(this, "An error has occured. Please try again later", Toast.LENGTH_LONG).show();
	}

	/**
	 * Sucessful implemetation of onSuccess for the REST call. Selects a random
	 * product to be displayed based on the total count of items fetched from
	 * the service.
	 *
	 * @param call
	 * @param response
	 */
	@Override
	public void onResponse(Call<ProductList> call, Response<ProductList> response) {
		int size = response.body().items.size();
		if (size == 0) {
			findViewById(R.id.scroll).setVisibility(View.GONE);
			findViewById(R.id.tvNoItems).setVisibility(View.VISIBLE);
		} else {
			findViewById(R.id.tvNoItems).setVisibility(View.GONE);
			findViewById(R.id.scroll).setVisibility(View.VISIBLE);
		}
		int prodToDisplay = new Random().nextInt(size - 0 + 1) + 0;
		Product product = response.body().items.get(prodToDisplay);
		Log.d("PRODUCT", product.toString());
		ActivityProductDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail);
		binding.setProduct(product);
		//		setPager(product.getThumbnailURL());
		new FetchImageAsyncTask(this).execute(product.getThumbnailURL()); //TODO: Delete this and use pager. Expensive on UI thread.
	}

	/*
	 * Setting product image.TODO:Delete this.**
	 * @param thumbnailUrl
	 */
	public void onImageLoadComplete(Bitmap bitmap) {
		((ImageView) findViewById(R.id.ivProductImage)).setImageBitmap(bitmap);
	}
}
