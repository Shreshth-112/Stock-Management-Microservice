package com.suppliers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SuppliersApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuppliersApplication.class, args);
	}

}
