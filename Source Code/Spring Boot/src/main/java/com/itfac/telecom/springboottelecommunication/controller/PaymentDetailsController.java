package com.itfac.telecom.springboottelecommunication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itfac.telecom.springboottelecommunication.model.PaymentDetails;
import com.itfac.telecom.springboottelecommunication.service.PaymentDetailsService;

@RestController
public class PaymentDetailsController {
	@Autowired
	private PaymentDetailsService paymentDetailsService;

	@PostMapping("api/payments")
	public ResponseEntity<String> addPayment(@RequestBody PaymentDetails payment) {
		paymentDetailsService.addPayment(payment);
		return ResponseEntity.status(HttpStatus.OK).body("Successfully Saved");
	}

	@GetMapping("api/payments/{accNo}/all")
	public ResponseEntity<List<PaymentDetails>> getAllPayments(@PathVariable int accNo) {
		List<PaymentDetails> payments = paymentDetailsService.getAllPayments(accNo);
		return ResponseEntity.status(HttpStatus.OK).body(payments);
	}

}
