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
@Table(name = "package_activation")
public class PackageActivation {
	
	@GeneratedValue
	@Id
	@Column(name = "ref_no")
	private long refNo;
	
	@Column(name = "package_name", nullable = false)
	private String packageName;
	
	private String description;
	
	private double charge;

	private double tax;
	
	@Column(name = "is_active", nullable = false)
	private boolean active;
	
	@Column(name = "activated_on", nullable = false)
	private Date activatedOn;
	
	@Column(name = "deactivated_on")
	private Date deactivatedOn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "acc_no", nullable = false, foreignKey = @ForeignKey(name = "package_activation_fk"))
	@Getter(onMethod_ = @JsonIgnore)
	@Setter(onMethod_ = @JsonProperty)
	private Customer customer;
	

}
