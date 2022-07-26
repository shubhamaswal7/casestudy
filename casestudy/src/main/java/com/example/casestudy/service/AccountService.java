package com.example.casestudy.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.casestudy.model.Account;
import com.example.casestudy.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Cacheable("accounts")
	public List<Account> getAllAccounts() {
		System.out.println("Get all accounts called");
		List<Account> accountList = new ArrayList<Account>();
		accountRepository.findAll().forEach(account -> accountList.add(account));
		return accountList;
	}

	public AccountService(AccountRepository accountRepository) {

		super();
		this.accountRepository = accountRepository;
	}

	public Account getAccountById(int id) {

		return accountRepository.findById(id).get();
	}

	@CacheEvict(value = "accounts", allEntries = true)
	public Account saveOrUpdate(Account account) {

		return accountRepository.save(account);
	}

	@CacheEvict(value = "accounts", allEntries = true)
	public void delete(Integer id) {

		accountRepository.deleteById(id);
	}
}
