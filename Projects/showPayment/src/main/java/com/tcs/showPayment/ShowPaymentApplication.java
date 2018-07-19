package com.tcs.showPayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ShowPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowPaymentApplication.class, args);
	}
}
