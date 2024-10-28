package com.finalSprint.dispatch.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finalSprint.dispatch.model.Product;

@FeignClient(value="feignClient", url = "http://localhost:8087/product")
public interface DispatchFeign {
	
	@RequestMapping(method=RequestMethod.POST, value="/subproduct")
	public ResponseEntity<Product> subtractProduct(@RequestBody Product product);
	

}
