package com.StockMarket.dispatch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dispatcher")
public class Dispatcher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long dispatcherId;
	private String productName;
	private String customerAddress;
	private Long billAmount;
	
	//no Argument constructor
	public Dispatcher() {}
	
	public Long getDispatcherId() {
		return dispatcherId;
	}
	public void setDispatcherId(Long dispatcherId) {
		this.dispatcherId = dispatcherId;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}
	
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public Long getBillAmount() {
		return billAmount;
	}
	
	public void setBillAmount(Long billAmount) {
		this.billAmount = billAmount;
	}
	
	@Override
	public String toString() {
		return "Dispatcher [dispatcherId=" + dispatcherId + ", productName="+ productName + ", customerAddress=" 
	          + customerAddress + ", billAmount=" + billAmount + "]";
	}
	
	//All argument constructor
	public Dispatcher(Long dispatcherId,  Long orderId, String customerAddress, Long billAmount) {
		super();
		this.dispatcherId = dispatcherId;
		this.productName = productName;
		this.customerAddress = customerAddress;
		this.billAmount = billAmount;
	}


}