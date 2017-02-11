package com.zappos.android.intern.modal.retro;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zappos.android.intern.modal.Product;

/**
 * Created by Kevin on 10-02-2017.
 */
public class ProductList {
	@SerializedName("results")
	@Expose
	public List<Product> items;
}
