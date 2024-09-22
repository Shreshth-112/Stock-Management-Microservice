package com.demo.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductDemoApplication.class, args);
	}

}
