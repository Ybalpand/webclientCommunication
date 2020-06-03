package com.webapp.springbootrestapiwebclient.response;

import java.util.Date;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerResponse {

	@JsonProperty("customerId")
	private int customerId;

	@JsonProperty("customerName")
	private String customerName;

	@JsonProperty("dateOfBirth")
	private Date dateOfBirth;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("document")
	private List<DocumentResponse> document;

	@JsonProperty("account")
	private List<AccountResponse> account;

	public CustomerResponse() {
		super();
	}

	public CustomerResponse(int customerId, String customerName, Date dateOfBirth, String gender,
			List<DocumentResponse> document, List<AccountResponse> account) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.document = document;
		this.account = account;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<DocumentResponse> getDocument() {
		return document;
	}

	public void setDocument(List<DocumentResponse> document) {
		this.document = document;
	}

	public List<AccountResponse> getAccount() {
		return account;
	}

	public void setAccount(List<AccountResponse> accounts) {
		this.account = accounts;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", document=" + document + ", account=" + account + "]";
	}

}
