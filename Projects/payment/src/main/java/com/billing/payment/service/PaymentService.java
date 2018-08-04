package com.billing.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.billing.payment.bean.Payment;
import com.billing.payment.dao.BillingInfoDao;

@CrossOrigin
@RestController
public class PaymentService {
	
	@Autowired
	private BillingInfoDao paymentDao =  new BillingInfoDao();


	@GetMapping("/payments/{policyNo}")
	public Payment getPayment(@PathVariable String policyNo) {
		System.out.println("-------id--"+policyNo);
		return paymentDao.findBillingInfoByPolicyNo(policyNo) ;
	}
	
}
