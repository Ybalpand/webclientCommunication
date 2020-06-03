package com.webapp.springbootrestapiwebclient.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountResponse {

	@JsonProperty("accountId")
	private Integer accountId;

	@JsonProperty("accountName")
	private String accountName;

	@JsonProperty("balance")
	private Double balance;

	@JsonProperty("accountOpenDate")
	private Date accountOpenDate;

	@JsonProperty("customerId")
	private int customerId;

	@JsonProperty("isActive")
	private Integer isActive;

	public AccountResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountResponse(Integer accountId, String accountName, Double balance, Date accountOpenDate, int customerId,
			Integer isActive) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.balance = balance;
		this.accountOpenDate = accountOpenDate;
		this.customerId = customerId;
		this.isActive = isActive;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Date getAccountOpenDate() {
		return accountOpenDate;
	}

	public void setAccountOpenDate(Date accountOpenDate) {
		this.accountOpenDate = accountOpenDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "AccountResponse [accountId=" + accountId + ", accountName=" + accountName + ", balance=" + balance
				+ ", accountOpenDate=" + accountOpenDate + ", customerId=" + customerId + ", isActive=" + isActive
				+ "]";
	}

}
