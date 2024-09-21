package com.suppliers.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Entity
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SupplierId;
	private String SupplierName;
    private Long ProductId;
    private String ProductName;
    private Long ProductQuantity;
    private double ProductPrice;
    public Supplier() {
    	
    }
    
	public Supplier(Long supplierId, String supplierName, Long productId, String productName, Long productQuantity,
			double productPrice) {
		super();
		this.SupplierId = supplierId;
		this.SupplierName = supplierName;
		this.ProductId = productId;
		this.ProductName = productName;
		this.ProductQuantity = productQuantity;
		this.ProductPrice = productPrice;
	}

	public Long getSupplierId() {
		return SupplierId;
	}

	public void setSupplierId(Long supplierId) {
		SupplierId = supplierId;
	}

	public String getSupplierName() {
		return SupplierName;
	}

	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}

	public Long getProductId() {
		return ProductId;
	}

	public void setProductId(Long productId) {
		ProductId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public Long getProductQuantity() {
		return ProductQuantity;
	}

	public void setProductQuantity(Long productQuantity) {
		ProductQuantity = productQuantity;
	}

	public double getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Supplier [SupplierId=" + SupplierId + ", SupplierName=" + SupplierName + ", ProductId=" + ProductId
				+ ", ProductName=" + ProductName + ", ProductQuantity=" + ProductQuantity + ", ProductPrice="
				+ ProductPrice + "]";
	} 
    
	
    
    

}
