package com.zappos.android.intern.modal;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import android.databinding.BaseObservable;

/**
 * Created by Kevin on 10-02-2017.
 */
public class Product extends BaseObservable implements Serializable {
	/**
	 * Indicates the unique id of the product.
	 */
	@SerializedName("productId")
	@Expose
	private String productId;
	/**
	 * Indicates the name of the product.
	 */
	@SerializedName("productName")
	@Expose
	private String productName;
	/**
	 * Indicates the brand name of the product.
	 */
	@SerializedName("brandName")
	@Expose
	private String brandName;
	/**
	 * Indicates the current price of the product.
	 */
	@SerializedName("price")
	@Expose
	private String price;
	/**
	 * Indicates the original of the product.
	 */
	@SerializedName("originalPrice")
	@Expose
	private String originalPrice;
	/**
	 * Indicates the discount offered on the product.
	 */
	@SerializedName("percentOff")
	@Expose
	private String percentOff;
	/**
	 * Indicates the unique style id of the product.
	 */
	@SerializedName("styleId")
	@Expose
	private String styleId;
	/**
	 * Indicates the unique color id of the product.
	 */
	@SerializedName("colorId")
	@Expose
	private String colorId;
	/**
	 * Indicates the link to the thumbnail image of the product.
	 */
	@SerializedName("thumbnailImageUrl")
	@Expose
	private String thumbnailURL;
	/**
	 * Indicates the link to the product on the zappos page.
	 */
	@SerializedName("productUrl")
	@Expose
	private String productURL;

	public Product() {
	}

	public Product(String productId, String productName, String brandName, String price, String originalPrice, String percentOff) {
		this.productId = productId;
		this.productName = productName;
		this.brandName = brandName;
		this.price = price;
		this.originalPrice = originalPrice;
		this.percentOff = percentOff;
	}

	/**
	 * Fetches the brand name of the product.
	 *
	 * @return brandName
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * Sets the brand name of the product.
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * Fetches the unique color id of the product.
	 *
	 * @return colorId
	 */
	public String getColorId() {
		return colorId;
	}

	/**
	 * Sets the unique color id of the product.
	 */
	public void setColorId(String colorId) {
		this.colorId = colorId;
	}

	/**
	 * Fetches the original of the product.
	 *
	 * @return originalPrice
	 */
	public String getOriginalPrice() {
		return originalPrice;
	}

	/**
	 * Sets the original of the product.
	 */
	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}

	/**
	 * Fetches the discount offered on the product.
	 *
	 * @return percentOff
	 */
	public String getPercentOff() {
		return percentOff;
	}

	/**
	 * Sets the discount offered on the product.
	 */
	public void setPercentOff(String percentOff) {
		this.percentOff = percentOff;
	}

	/**
	 * Fetches the current price of the product.
	 *
	 * @return price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * Sets the current price of the product.
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * Fetches the unique id of the product.
	 *
	 * @return productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * Sets the unique id of the product.
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * Fetches the name of the product.
	 *
	 * @return productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the name of the product.
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Fetches the link to the product on the zappos page.
	 *
	 * @return productURL
	 */
	public String getProductURL() {
		return productURL;
	}

	/**
	 * Sets the link to the product on the zappos page.
	 */
	public void setProductURL(String productURL) {
		this.productURL = productURL;
	}

	/**
	 * Fetches the unique style id of the product.
	 *
	 * @return styleId
	 */
	public String getStyleId() {
		return styleId;
	}

	/**
	 * Sets the unique style id of the product.
	 */
	public void setStyleId(String styleId) {
		this.styleId = styleId;
	}

	/**
	 * Fetches the link to the thumbnail image of the product.
	 *
	 * @return thumbnailURL
	 */
	public String getThumbnailURL() {
		return thumbnailURL;
	}

	/**
	 * Sets the link to the thumbnail image of the product.
	 */
	public void setThumbnailURL(String thumbnailURL) {
		this.thumbnailURL = thumbnailURL;
	}

	@Override
	public String toString() {
		return "Product{" + "brandName='" + brandName + '\'' + ", productId=" + productId + ", productName='" + productName + '\'' + ", price=" + price + ", originalPrice=" + originalPrice
				+ ", percentOff=" + percentOff + ", styleId=" + styleId + ", colorId=" + colorId + ", thumbnailURL='" + thumbnailURL + '\'' + ", productURL='" + productURL + '\'' + '}';
	}
}
