package com.tcs.showPayment;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.tcs.showPayment.bean.Payment;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class SpringBootBaseIntegrationTest {

    private static final Logger log = LoggerFactory.getLogger(SpringBootBaseIntegrationTest.class);

    private final String SERVER_URL = "http://localhost:3334";
    private final String PAYMENT_ENDPOINT = "/payments";

    private RestTemplate restTemplate;



    public SpringBootBaseIntegrationTest() {
    	ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(requestFactory);
    }

    private String thingsEndpoint() {
        return SERVER_URL + PAYMENT_ENDPOINT;
    }

    public Payment savePayment(final Payment payment) {
    	HttpEntity<Payment> request = new HttpEntity<>(payment);
        Payment returnPayment  =  restTemplate.postForObject(thingsEndpoint(), request,  Payment.class);
        return returnPayment ;
    }

    List<Payment> getAllPayments() {
    	ResponseEntity<Payment[]> response = restTemplate.getForEntity(thingsEndpoint(), Payment[].class);
        return Arrays.asList(response.getBody()); 
    }
    void clean() {
        restTemplate.delete(thingsEndpoint());
    }
}