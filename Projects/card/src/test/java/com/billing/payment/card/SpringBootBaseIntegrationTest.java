package com.billing.payment.card;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.billing.payment.card.bean.Payment;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class SpringBootBaseIntegrationTest {

    private static final Logger log = LoggerFactory.getLogger(SpringBootBaseIntegrationTest.class);

    private final String SERVER_URL = "http://localhost:3337";
    private final String CARD_ENDPOINT = "/setup";
    private final String ROUTING_ENDPOINT = "/routing";
    
    private final String PAYMENT_SERVER_URL = "http://payment:3334/payments/";
  

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



    public Payment saveCardSetUp(final Payment payment) {
    	HttpEntity<Payment> request = new HttpEntity<>(payment);
    	
    	ResponseEntity<Payment>  returnPayment=  restTemplate.postForEntity(SERVER_URL + CARD_ENDPOINT, request,  Payment.class);
    	this.responseStatus  = returnPayment.getStatusCodeValue();
        return returnPayment.getBody() ;
    }

    public String getBankName(final String routingNo ) {
        return restTemplate.getForEntity(SERVER_URL + ROUTING_ENDPOINT+"/"+routingNo , String.class).getBody();
    }
    
    public Payment findBillingDetails(final String policyNo ) {
    	System.out.println(policyNo);
        return restTemplate.getForEntity(PAYMENT_SERVER_URL +policyNo , Payment.class).getBody();
    }    


}