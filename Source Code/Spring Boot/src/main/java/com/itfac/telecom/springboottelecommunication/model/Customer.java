package com.itfac.telecom.springboottelecommunication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	@Column(name = "acc_no", length = 10)
	private int accNo;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 12, nullable = false)
	private String nic;

	@Column(name = "contact_no", length = 12, nullable = false)
	private String contactNo;

	@Column(nullable = false)
	private String address;


}
