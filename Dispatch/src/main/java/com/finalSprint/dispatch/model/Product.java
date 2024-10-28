package com.finalSprint.dispatch.model;


public class Product {

	private Long productId;
	private String productName;
	private Double productPrice;
	private Long quantity;
	
	public Product() {	
	}
	
	public Product(long productId, String productName, double productPrice, long quantity) {
		super();
		this.productId=productId;
		this.productName=productName;
		this.productPrice=productPrice;
		this.quantity=quantity;
	}
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productNmae) {
		this.productName = productNmae;
	}
	
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice + ", quantity=" + quantity + "]";
	}
}
