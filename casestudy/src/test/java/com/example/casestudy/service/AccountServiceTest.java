package com.example.casestudy.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import com.example.casestudy.model.Account;
import com.example.casestudy.repository.AccountRepository;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {
	
	@Mock
	private AccountRepository accountRepository;

	
	@InjectMocks
	private AccountService accountService;

	
	@BeforeEach
	void setUp() {
		this.accountService = new AccountService(this.accountRepository);
	}
	
	@Test
	void getAllAccounts() {
		 Account account1 = new Account();
			Integer accountId1 = 1;
		        account1.setId(accountId1);
		        account1.setName("Account name");
		        account1.setAccountNumber("13424");
		        account1.setAddress("Mumbai");
		         
	        Account account2 = new Account();
			Integer accountId2 = 1;
		        account1.setId(accountId2);
		        account1.setName("Account name2");
		        account1.setAccountNumber("1846513");
		        account1.setAddress("Delhi");
		     
		        List<Account> accountList = new ArrayList<Account>();
		        accountList.add(account1);
		        accountList.add(account2);
		        
		        Mockito.when(accountRepository.findAll()).thenReturn(accountList);
		        assertThat(accountService.getAllAccounts()).isEqualTo(accountList);
	}
	
	@Test
	void getAccountById() {
		 Account account = new Account();
		Integer accountId = 1;
	        account.setId(accountId);
	        account.setName("Account name");
	        account.setAccountNumber("13424");
	        account.setAddress("Mumbai");
	        
//	        Mockito.when(accountRepository.findById(accountId).get()).thenReturn(account);
//	        assertThat(accountService.getAccountById(accountId)).isEqualTo(account);
	}
	
	@Test
	void saveOrUpdate() {
		Account account = new Account();
		int accountId = 1;
        account.setId(accountId);
        account.setName("Account name");
        account.setAccountNumber("13424");
        account.setAddress("Mumbai");
        
        Mockito.when(accountRepository.save(account)).thenReturn(account);
        assertThat(accountService.saveOrUpdate(account)).isEqualTo(account);
	}
	
//	@Test
//	void delete(int id) {
//		Account account = new Account();
//		int accountId = 1;
//        account.setId(accountId);
//        account.setName("Account name");
//        account.setAccountNumber("13424");
//        account.setAddress("Mumbai");
//	        
//	        Mockito.when(accountRepository.findById(accountId).get()).thenReturn(account);
//	        Mockito.when(accountRepository.existsById(account.getId())).thenReturn(false);
//	        assertThat(accountRepository.existsById(account.getId()));
//	      assertFalse(accountRepository.existsById(account.getId()));
	        
//		accountService.delete(id);
//		verify(accountRepository).deleteById(id);
//	}
	
}
