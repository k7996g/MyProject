package com.cg.ParallelProject.service;

import com.cg.ParallelProject.exception.AccountDoesNotExistException;
import com.cg.ParallelProject.exception.InsufficientBalanceAfterWithdrawException;

public interface AccountService {

	void deposit(int accNo, int amount) throws AccountDoesNotExistException;

	void withDraw(int accNo, int amount) throws InsufficientBalanceAfterWithdrawException;

	void fundTransfer(int accNo1, int accNo2, int amount) throws InsufficientBalanceAfterWithdrawException, AccountDoesNotExistException;

	void showBalance(int accNo);

	void createAccount(int accNo, int amount);

}