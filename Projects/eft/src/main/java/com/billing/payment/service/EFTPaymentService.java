package com.billing.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.billing.payment.bean.Payment;
import com.billing.payment.dao.EFTPaymentDao;

@CrossOrigin
@RestController
public class EFTPaymentService {
	
	@Autowired
	private EFTPaymentDao paymentDao =  new EFTPaymentDao();

	@PostMapping("/eft")
	public String   insertPayment(@RequestBody Payment payment) {
		String msg ;

		int row  =  paymentDao.update(payment);
		if (row > 0)
			msg = "Successfully updated " + row +" row ";
		else
			msg = "Payment Amount must be greater than Zero";
		return msg;
	}
}
