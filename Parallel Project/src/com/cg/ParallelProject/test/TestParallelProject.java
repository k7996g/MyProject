package com.cg.ParallelProject.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.cg.ParallelProject.bean.Account;
import com.cg.ParallelProject.dao.AccountDao;
import com.cg.ParallelProject.dao.AccountDaoImpl;
import com.cg.ParallelProject.exception.AccountDoesNotExistException;
import com.cg.ParallelProject.exception.InsufficientBalanceAfterWithdrawException;


class TestParallelProject {
	
	

	@Before
	public void runEachTimeBeforeTest() {
		System.out.println("Testing..............................");
	}

	@Test
	void test1Deposit() {
		Account account = new Account(1000, 6000);
		AccountDao a = new AccountDaoImpl();
		a.Create(1000, 5000);
		try {
			assertEquals(account, a.deposit(1000, 1000));
		} catch (AccountDoesNotExistException e) {
			// TODO Auto-generated catch block
			
		}
	}

	@Test
	void test2Deposit() {
		
		Account account = new Account(1001, 2000);
		AccountDao a = new AccountDaoImpl();
		a.Create(1001, 1000);
		try {
			assertEquals(account, a.deposit(1001, 1000));
		} catch (AccountDoesNotExistException e) {
			// TODO Auto-generated catch block
			
		}
	}

	@Test
	void test3Deposit() {
		
		Account account = new Account(1002, 6000);
		AccountDao a = new AccountDaoImpl();
		a.Create(1002, 800);
		try {
			assertEquals(account, a.deposit(1002, 5200));
		} catch (AccountDoesNotExistException e) {
			// TODO Auto-generated catch block
			System.out.println("Account does not exist");
		}
	}

	@Test
	void test4Deposit() {
		Account account = new Account(1003, 40000);
		AccountDao a = new AccountDaoImpl();
		a.Create(1003, 500);
		try {
			assertEquals(account, a.deposit(1003, 39500));
		} catch (AccountDoesNotExistException e) {
			// TODO Auto-generated catch block
		
		}
	}

	@Test
	void test1WithDraw() throws InsufficientBalanceAfterWithdrawException {
		Account account = new Account(1005, 5000);
		AccountDao a = new AccountDaoImpl();
		a.Create(1005, 10000);
		a.withDraw(1005,5000);
	}

	@Test
	void test2WithDraw() throws InsufficientBalanceAfterWithdrawException {
		AccountDao a = new AccountDaoImpl();
		a.Create(1000, 5000);
		Account account = new Account(1000, 400);
	
		a.withDraw(1000, 4600);
	}

	@Test
	void testShowBalance() {
		AccountDao a = new AccountDaoImpl();
		a.Create(1000, 5000);
		Account account = new Account(1000, 5000);
		a.showBalance(1000);
	}
}
