package com.tcs.addPayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AddPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddPaymentApplication.class, args);
	}
}
