package com.billing.payment.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.billing.payment.card.bean.Payment;
import com.billing.payment.card.dao.CardPaymentDao;

@CrossOrigin
@RestController
public class CardPaymentService {

	@Autowired
	private CardPaymentDao cardDao = new CardPaymentDao();

	@PostMapping(path = "/setup")
	public Payment insertPayment(@RequestBody Payment payment) {
		String msg ;

		System.out.println(payment.getCardHolderName());
		System.out.println(payment.getCardNo());
		System.out.println(payment.getCardZip());
		System.out.println(payment.getPolicyNumber());
		
		cardDao.update(payment);
		
		payment.setStatus("Card details were Successfully Updated");
		return payment;
	}

}
