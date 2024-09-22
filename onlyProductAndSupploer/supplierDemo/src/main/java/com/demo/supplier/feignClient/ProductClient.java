package com.demo.supplier.feignClient;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PRODUCTDEMO")
public interface ProductClient {
	@PutMapping("/product/{productId}/quantity")

	void updateProductQuantity(@PathVariable("productId") Long productId, @RequestBody Map<String, Integer> quantity);

}
