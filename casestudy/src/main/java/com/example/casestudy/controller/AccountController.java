package com.example.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.casestudy.model.Account;
import com.example.casestudy.service.AccountService;

@RestController
@RequestMapping("/casestudy")
public class AccountController {
	@Autowired
	AccountService accountService;
	
	@GetMapping("/account")
	private List<Account> getAllAccounts(){
		return accountService.getAllAccounts();
	}
	
	@GetMapping("/account/{id}")
	private Account getAccountById(@PathVariable("id") int id){
		return accountService.getAccountById(id);
	}
	
	@DeleteMapping("/account/{id}")
	private void deleteAccountById(@PathVariable("id") int id) {
		 accountService.delete(id);
	}
	
	@PostMapping("/account")
	private ResponseEntity<Integer> saveAccount(@RequestBody Account account){
		accountService.saveOrUpdate(account);
		return new ResponseEntity<Integer>(account.getId(),HttpStatus.OK);
		
	}
	
}
