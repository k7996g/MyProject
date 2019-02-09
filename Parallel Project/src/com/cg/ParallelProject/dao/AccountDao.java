package com.cg.ParallelProject.dao;

import com.cg.ParallelProject.bean.Account;
import com.cg.ParallelProject.exception.AccountDoesNotExistException;
import com.cg.ParallelProject.exception.InsufficientBalanceAfterWithdrawException;

public interface AccountDao {

	Account deposit(int accNo, int amount) throws AccountDoesNotExistException;

	Account withDraw(int accNo, int amount) throws InsufficientBalanceAfterWithdrawException;

	void FundTransfer(int accNo1, int accNo2, int amount) throws InsufficientBalanceAfterWithdrawException, AccountDoesNotExistException;

	Account showBalance(int accNo);

	Account Create(int accNo, int amount);

}