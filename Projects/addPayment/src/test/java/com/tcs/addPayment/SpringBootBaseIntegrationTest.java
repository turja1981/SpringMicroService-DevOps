package com.tcs.addPayment;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.tcs.addPayment.bean.Payment;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class SpringBootBaseIntegrationTest {

    private static final Logger log = LoggerFactory.getLogger(SpringBootBaseIntegrationTest.class);

    private final String SERVER_URL = "http://localhost:3333";
    private final String PAYMENT_ENDPOINT = "/sendPayment";

    private RestTemplate restTemplate;
    
    private int responseStatus ;
    
    private String responseMsg ;

    public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public int getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(int responseStatus) {
		this.responseStatus = responseStatus;
	}

	@LocalServerPort
    protected int port;

    public SpringBootBaseIntegrationTest() {
    	ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(requestFactory);
    }

    private String thingsEndpoint() {
        return SERVER_URL + PAYMENT_ENDPOINT;
    }

    public Payment savePayment(final Payment payment) {
    	HttpEntity<Payment> request = new HttpEntity<>(payment);
    	
    	ResponseEntity<Payment>  returnPayment=  restTemplate.postForEntity(thingsEndpoint(), request,  Payment.class);
    	this.responseStatus  = returnPayment.getStatusCodeValue();
        return returnPayment.getBody() ;
    }

    Payment getContents() {
        return restTemplate.getForEntity(thingsEndpoint(), Payment.class).getBody();
    }

    void clean() {
        restTemplate.delete(thingsEndpoint());
    }
}