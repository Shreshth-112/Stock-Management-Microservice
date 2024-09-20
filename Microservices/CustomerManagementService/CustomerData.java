package com.customer.customer.CustomersData;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerData {
	
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long customerId; 
private String customerName;
private String customerAddress;
private	long phoneNumber;

public CustomerData(long customerId, String customerName, String customerAddress, long phoneNumber) {
	super();
	this.customerId = customerId;
	this.customerName = customerName;
	this.customerAddress = customerAddress;
	this.phoneNumber = phoneNumber;
}
public CustomerData() {

}
public long getCustomerId() {
	return customerId;
}
public void setCustomerId(long customerId) {
	this.customerId = customerId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getCustomerAddress() {
	return customerAddress;
}
public void setCustomerAddress(String customerAddress) {
	this.customerAddress = customerAddress;
}
public long getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(long phoneNumber) {
	this.phoneNumber = phoneNumber;
}



@Override
public String toString() {
	return "CustomerData [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
			+ customerAddress + ", phoneNumber=" + phoneNumber + "]";
}


	
}
