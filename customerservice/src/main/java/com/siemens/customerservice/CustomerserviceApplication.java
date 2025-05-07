package com.siemens.customerservice;

import com.siemens.customerservice.models.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CustomerserviceApplication {

	public static void main(String[] args) {

        SpringApplication.run(CustomerserviceApplication.class, args);

	}

}
