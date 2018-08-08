package com.billing.payment.eft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.billing.payment.eft.bean.Payment;
import com.billing.payment.eft.dao.EFTPaymentDao;

@CrossOrigin
@RestController
public class EFTPaymentService {
	
	@Autowired
	private EFTPaymentDao paymentDao =  new EFTPaymentDao();

	@PostMapping(path = "/setup")
	public Payment  insertPayment(@RequestBody Payment payment) {
		String msg = "Test" ;

		System.out.println(payment.getPolicyNumber());
		System.out.println(payment.getBankAccountNo());
		System.out.println(payment.getBankHolderName());
		System.out.println(payment.getAccountType());
		int row  =  paymentDao.update(payment);
		if (row > 0)
			msg = "Successfully updated " + row +" row ";
		else
			msg = "Payment Amount must be greater than Zero";
		return payment;
	}

}
