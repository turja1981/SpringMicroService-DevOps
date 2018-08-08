package com.billing.payment.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.billing.payment.card.bean.Payment;
import com.billing.payment.card.dao.CardPaymentDao;


@CrossOrigin
@RestController
public class CardPaymentService {
	
	@Autowired
	private CardPaymentDao paymentDao =  new CardPaymentDao();

	@PostMapping(path = "/setup")
	public Payment   insertPayment(@RequestBody Payment payment) {
		String msg ;

		System.out.println(payment.getCardHolderName());
		System.out.println(payment.getCardNo());
		System.out.println(payment.getCardZip());
		System.out.println(payment.getPolicyNumber());
		
		int row  =  paymentDao.update(payment);
		if (row > 0)
			msg = "Successfully updated " + row +" row ";
		else
			msg = "Payment Amount must be greater than Zero";
		return payment;
	}
}
