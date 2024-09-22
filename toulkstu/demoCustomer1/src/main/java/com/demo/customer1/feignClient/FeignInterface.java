package com.demo.customer1.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.customer1.model.Product;

@FeignClient(value="feignClient", url = "http://localhost:8087/product")
public interface FeignInterface {
	
	@RequestMapping(method=RequestMethod.GET, value="/viewproducts")
	public List<Product> showProducts();
}
