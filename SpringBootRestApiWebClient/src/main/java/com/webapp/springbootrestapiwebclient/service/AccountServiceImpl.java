package com.webapp.springbootrestapiwebclient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.springbootrestapiwebclient.entity.Account;
import com.webapp.springbootrestapiwebclient.exception.AccountNotFoundException;
import com.webapp.springbootrestapiwebclient.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	/* Webclient through Communiction Methods call */
	
	@Override
	public List<Account> getAccountByCustomerId(Integer customerId) {
		return accountRepository.getAccountByCustomerId(customerId);
	}
	
	
	/* account information CRUD operation */
	
	@Override
	// getting all accounts record by using the method findaAll() of accountRepository
	public List<Account> getAllAccountList() {
		return accountRepository.findAll();
	}

	@Override
	// getting a specific record by using the method findById() of accountRepository
	public Account getAccountById(Integer accountId) {
		return accountRepository.findById(accountId)
				.orElseThrow(() -> new AccountNotFoundException("Account is not found :: " + accountId));
	}

	@Override
	// saving a specific record by using the method save() of accountRepository
	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	// updating a record
	public Account updateAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	// deleting a specific record by using the method deleteById() of accountRepository
	public void deleteAccount(Integer accountId) {
		accountRepository.deleteById(accountId);
	}

	// update deactive Account
	@Override
	public Boolean updateDeActiveAccount(Integer accountId) { // throws AccountAlreadyExistException{
		accountRepository.findById(accountId)
				.orElseThrow(() -> new AccountNotFoundException("can not deactivated account :: " + accountId));
		accountRepository.deActivateAccount(accountId);
		return true;
	}

	// updating a account by de active
	@Override
	public Boolean updateActiveAccount(Integer accountId) {
		accountRepository.findById(accountId)
				.orElseThrow(() -> new AccountNotFoundException("can not activated account :: " + accountId));
		accountRepository.activateAccount(accountId);
		return true;
	}


}
