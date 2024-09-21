package com.suppliers.feign;

import java.util.List;
import com.products.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-ervice", url = "http://localhost:8080/product")
public interface ProductFeignClient {
	
	@GetMapping("/{pid}")
    Product getProductById(@PathVariable("pid") long pid);

    @GetMapping("/name/{name}")
    Product getProductByName(@PathVariable("name") String name);

    @GetMapping("/price/{price}")
    List<Product> getProductByPrice(@PathVariable("price") double price);

    @GetMapping("/productbelow/{price}")
    List<Product> getProductLessThan(@PathVariable("price") double price);
}