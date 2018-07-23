package com.tcs.addPayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.addPayment.bean.Payment;
import com.tcs.addPayment.dao.AddPaymentDao;

@CrossOrigin
@RestController
public class InsertPaymentRestController {
	
	@Autowired
	private AddPaymentDao paymentDao =  new AddPaymentDao();

	@PostMapping("/sendPayment")
	public Payment insertPayment(@RequestBody Payment payment) {
		
		System.out.println(payment.getFirstName());
		
		System.out.println(payment.getLastName());

		if (payment.getAmount() > 0)
			paymentDao.create(payment) ;
		else
			payment.setStatus("Payment Amount must be greater than Zero");
		return payment;
	}
}
