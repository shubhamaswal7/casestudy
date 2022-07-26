package com.example.casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.casestudy.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	
}
