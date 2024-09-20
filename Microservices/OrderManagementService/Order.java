package com.stockManagement.order.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	private long customerId;
	private long productId;
	private int productQuantity;
	private double totalCost;
	
	public Order() {}
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public Order(long orderId, long customerId, long productId, int productQuantity, double totalCost) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.productId = productId;
		this.productQuantity = productQuantity;
		this.totalCost = totalCost;
	}

	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", productId=" + productId
				+ ", productQuantity=" + productQuantity + ", totalCost=" + totalCost + "]";
	}
	
	
}
