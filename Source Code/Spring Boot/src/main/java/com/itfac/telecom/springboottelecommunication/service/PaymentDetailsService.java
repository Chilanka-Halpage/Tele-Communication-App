package com.itfac.telecom.springboottelecommunication.service;

import java.util.List;

import com.itfac.telecom.springboottelecommunication.model.PaymentDetails;

public interface PaymentDetailsService {
	void addPayment(PaymentDetails payment);

	PaymentDetails getPayment(long paymentRef);

	List<PaymentDetails> getAllPayments(int accNo);

}
