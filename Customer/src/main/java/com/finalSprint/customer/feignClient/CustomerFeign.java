package com.finalSprint.customer.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finalSprint.customer.model.Product;

@FeignClient(value="feignClient", url = "http://localhost:8087/product")
public interface CustomerFeign {
	
	@RequestMapping(method=RequestMethod.GET, value="/viewproducts")
	public List<Product> showProducts();

}
