package com.itfac.telecom.springboottelecommunication.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "payment_details")
public class PaymentDetails {

	@GeneratedValue()
	@Id
	@Column(name = "ref_no")
	private long refNo;

	private double amount;

	@Column(name = "pay_mode", length = 50, nullable = false)
	private String payMode;

	private String description;

	@Column(name = "paid_on", nullable = false)
	private Date paidOn;

	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "acc_no", nullable = false, foreignKey = @ForeignKey(name = "payment_details_fk"))
	@Getter(onMethod_ = @JsonIgnore)
	@Setter(onMethod_ = @JsonProperty)
	private Customer customer;
}
