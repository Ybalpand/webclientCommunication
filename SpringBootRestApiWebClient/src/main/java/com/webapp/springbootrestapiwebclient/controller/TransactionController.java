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

import com.webapp.springbootrestapiwebclient.entity.Transaction;
import com.webapp.springbootrestapiwebclient.service.TransactionService;

@RequestMapping("/springbootrestapiwebclient/transaction")
@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	public TransactionService getTransactionService() {
		return transactionService;
	}

	// 1 get All Transaction List
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Transaction> getAllTransaction() {
		return transactionService.getAllTransactionList();
	}

	// 2 Get Transaction by Id
	@GetMapping("/{transactionId}")
	public ResponseEntity<Transaction> getTranactionById(@PathVariable("transactionId") Integer transactionId) {
		Transaction transaction = transactionService.getTransactionById(transactionId);
		if (transactionId <= 0) {
			return new ResponseEntity<Transaction>(transaction, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}

	// 3 create account
	@PostMapping
	public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
		Transaction newTransactionCreated = transactionService.createTransaction(transaction);
		if (newTransactionCreated == null)
			return new ResponseEntity<Transaction>(newTransactionCreated, HttpStatus.IM_USED);
		else
			return new ResponseEntity<Transaction>(newTransactionCreated, HttpStatus.CREATED);
	}

	// 4 update account
	@PutMapping
	public Transaction updateTransaction(@RequestBody Transaction transaction) {
		return transactionService.updateTransaction(transaction);
	}

	// 5 delete account
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public @ResponseBody void deleteTransaction(@RequestParam(name = "transactionId", required = false) Integer transactionId) {
		transactionService.deleteTransaction(transactionId);
	}

}
