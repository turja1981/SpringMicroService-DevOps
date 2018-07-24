package com.tcs.showPayment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.showPayment.bean.Payment;
import com.tcs.showPayment.dao.GetPaymentDao;

@CrossOrigin
@RestController
public class GetPaymentRestController {
	
	@Autowired
	private GetPaymentDao paymentDao =  new GetPaymentDao();

	@GetMapping("/payments")
	public List<Payment> getAllPayments() {
		return paymentDao.findAll() ;
	}
	
	@GetMapping("/payments/{id}")
	public Payment getPayment(@PathVariable int id) {
		System.out.println("-------id--"+id);
		return paymentDao.findPaymentById(id) ;
	}
	
}
