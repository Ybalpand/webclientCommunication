package com.webapp.springbootrestapiwebclient.service;

import java.util.List;


import com.webapp.springbootrestapiwebclient.entity.Account;

public interface AccountService {

	List<Account> getAllAccountList();
	
	Account getAccountById(Integer accountId);
	
	Account createAccount(Account account);
	
	Account updateAccount(Account account);
	
	void deleteAccount(Integer accountId);

	Boolean updateDeActiveAccount(Integer accountId);

	Boolean updateActiveAccount(Integer accountId);

	
	//webclient communication method
	List<Account> getAccountByCustomerId(Integer customerId);
	
	
	
	
}
