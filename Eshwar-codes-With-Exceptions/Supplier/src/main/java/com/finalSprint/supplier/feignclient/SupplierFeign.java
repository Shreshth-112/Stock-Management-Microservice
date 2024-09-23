package com.finalSprint.supplier.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finalSprint.supplier.model.Product;

@FeignClient(value = "feignClient", url = "http://localhost:8087/product")
public interface SupplierFeign {
	
	@RequestMapping(method=RequestMethod.GET, value="/viewproducts")
	public List<Product> showProducts();
	
	@RequestMapping(method=RequestMethod.POST, value="/addproduct")
	public Product addProduct(@RequestBody Product product); 
}

 
