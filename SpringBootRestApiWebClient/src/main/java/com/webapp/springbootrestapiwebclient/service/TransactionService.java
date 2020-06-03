package com.webapp.springbootrestapiwebclient.service;

import java.util.List;

import com.webapp.springbootrestapiwebclient.entity.Transaction;


public interface TransactionService {

	List<Transaction> getAllTransactionList();
	
	Transaction getTransactionById(Integer transactionId);
	
	Transaction createTransaction(Transaction transaction);
	
	Transaction updateTransaction(Transaction transaction);
	
	void deleteTransaction(Integer transactionId);
}
