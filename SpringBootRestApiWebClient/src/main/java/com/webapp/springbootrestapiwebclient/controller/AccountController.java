package com.webapp.springbootrestapiwebclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.springbootrestapiwebclient.entity.Account;
import com.webapp.springbootrestapiwebclient.entity.Customer;
import com.webapp.springbootrestapiwebclient.exception.AccountNotFoundException;
import com.webapp.springbootrestapiwebclient.response.AccountResponse;
import com.webapp.springbootrestapiwebclient.response.CustomerResponse;
import com.webapp.springbootrestapiwebclient.service.AccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/springbootrestapiwebclient/account")
@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/getCustomerInfo")
	@ResponseStatus(HttpStatus.OK)
	public Customer getCustomerByInfo(@RequestParam (name = "customerId", required = false)  Integer customerId ){
		List<Account> accounts = accountService.getAccountByCustomerId(customerId);
		Customer customerInfo = WebClientController.getCustomerByInfo(customerId);
		customerInfo.setAccount(accounts);		
		return customerInfo;
	}
	
	
	
	
	// 1 get All Account List
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Account> getAllAccount() {
		return accountService.getAllAccountList();
	}

	// 2 Get Account by Id
	@GetMapping("/{accountId}")
	public ResponseEntity<Account> getAccountById(@PathVariable("accountId") Integer accountId) {
		Account acc = accountService.getAccountById(accountId);
		if (accountId <= 0) {
			return new ResponseEntity<Account>(acc, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Account>(acc, HttpStatus.OK);
	}

	// 3 create account
	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account newAccountcreated = accountService.createAccount(account);
		if (newAccountcreated == null)
			return new ResponseEntity<Account>(newAccountcreated, HttpStatus.IM_USED);
		else
			return new ResponseEntity<Account>(newAccountcreated, HttpStatus.CREATED);
	}

	// 4 update account
	@PutMapping
	public Account updateAccount(@RequestBody Account account) {
		return accountService.updateAccount(account);
	}

	// 5 delete account
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public @ResponseBody void deleteAccount(@RequestParam(name = "accountId", required = false) Integer accountId) {
		accountService.deleteAccount(accountId);
	}

	// 6 update deactive Account
	@GetMapping(value = "/deactiveAccount")
	public Boolean updateDeActiveAccount(@RequestParam(name = "accountId", required = false) Integer accountId) {
		return accountService.updateDeActiveAccount(accountId);
	}

	// 6 update Active Account
	@GetMapping(value = "/activeAccount")
	public Boolean updateActiveAccount(@RequestParam(name = "accountId", required = false) Integer accountId) {
		 return accountService.updateActiveAccount(accountId);
	}

}
