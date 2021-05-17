package com.hsm.healthservicemanagement.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class Policy {

	@Id
	@NotNull
	private int policyId;
	
	@NotNull
	@Size(min=3, max=25)
	private String policyName;
	private LocalDate createDate;
	private LocalDate endDate;
	private Integer maximumAmount;

	@OneToOne(mappedBy="policy", cascade = CascadeType.ALL)
	private Patient patient;
	
	@JsonBackReference
	public Patient getpatient() {
		return patient;
	}
	
	// constructor
	public Policy() {
		super();

	}

	public Policy(int policyId, String policyName, LocalDate createDate, LocalDate endDate, Integer maximumAmount) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.createDate = createDate;
		this.endDate = endDate;
		this.maximumAmount = maximumAmount;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Integer getMaximumAmount() {
		return maximumAmount;
	}

	public void setMaximumAmount(Integer maximumAmount) {
		this.maximumAmount = maximumAmount;
	}

	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyName=" + policyName + ", createDate=" + createDate
				+ ", endDate=" + endDate + ", maximumAmount=" + maximumAmount + "]";
	}

}
