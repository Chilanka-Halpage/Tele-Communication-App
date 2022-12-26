package com.itfac.telecom.springboottelecommunication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itfac.telecom.springboottelecommunication.dao.PaymentDetailsRepository;
import com.itfac.telecom.springboottelecommunication.model.PaymentDetails;
import com.itfac.telecom.springboottelecommunication.service.PaymentDetailsService;

@Service
public class PaymentDetailsServiceImpl implements PaymentDetailsService {

	@Autowired
	PaymentDetailsRepository paymentDetailsRepository;

	@Override
	public void addPayment(PaymentDetails payment) {
		// Save the new payment in the DB
		PaymentDetails pay = paymentDetailsRepository.save(payment);

		// Throw an error unless saving process succeeded
		if (pay == null)
			throw new RuntimeException("Error occured while saving the new payment");

	}

	@Override
	public PaymentDetails getPayment(long paymentRef) {
		// Checking the payment record is available for the given ref No.If not, throw
		// an error
		return paymentDetailsRepository.findById(paymentRef)
				.orElseThrow(() -> new RuntimeException("Payment record not found for ref No: " + paymentRef));
	}

	@Override
	public List<PaymentDetails> getAllPayments(int accNo) {
		// Retrieving all the payment records for the given account
		return paymentDetailsRepository.findByCustomerAccNo(accNo);
	}

}
