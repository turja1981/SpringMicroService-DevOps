package com.billing.payment.eft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EftApplication {

	public static void main(String[] args) {
		SpringApplication.run(EftApplication.class, args);
	}
}
