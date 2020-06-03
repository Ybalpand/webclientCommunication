package com.webapp.springbootrestapiwebclient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.springbootrestapiwebclient.entity.Transaction;
import com.webapp.springbootrestapiwebclient.exception.TransactionNotFoundException;
import com.webapp.springbootrestapiwebclient.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;

	
	// getting all Transaction record by using the method findaAll() of transacionRepository
	@Override
	public List<Transaction> getAllTransactionList() {
		return transactionRepository.findAll();
	}

	// getting a specific record by using the method findById() of transacionRepository
	@Override
	public Transaction getTransactionById(Integer transactionId) {
		return transactionRepository.findById(transactionId)
				.orElseThrow(() -> new TransactionNotFoundException("Transaction Is Not found : " +transactionId ));
	}

	// saving a specific record by using the method save() of transacionRepository
	@Override
	public Transaction createTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	// updating a record
	@Override
	public Transaction updateTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	// deleting a specific record by using the method deleteById() of transactionRepository
	@Override
	public void deleteTransaction(Integer transactionId) {
		transactionRepository.deleteById(transactionId);
	}

}
