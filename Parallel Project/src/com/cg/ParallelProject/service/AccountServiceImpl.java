package com.cg.ParallelProject.service;

import com.cg.ParallelProject.bean.Account;
import com.cg.ParallelProject.dao.AccountDao;
import com.cg.ParallelProject.dao.AccountDaoImpl;
import com.cg.ParallelProject.exception.AccountDoesNotExistException;
import com.cg.ParallelProject.exception.InsufficientBalanceAfterWithdrawException;

public class AccountServiceImpl implements AccountService {
	AccountDao a = new AccountDaoImpl();
	Account account;
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.ParallelProject.service.AccountService#deposit(int, int)
	 */
	@Override
	public void createAccount(int accNo,int amount)
	{System.out.println(a.Create(accNo, amount));
	
	}
	@Override
	public void deposit(int accNo, int amount) throws AccountDoesNotExistException {
		
		 account = a.deposit(accNo, amount);
		System.out.println(account);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.ParallelProject.service.AccountService#withDraw(int, int)
	 */
	@Override
	public void withDraw(int accNo, int amount) throws InsufficientBalanceAfterWithdrawException {
		
		 account = a.withDraw(accNo, amount);
		System.out.println(account);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.ParallelProject.service.AccountService#fundTransfer(int, int,
	 * int)
	 */
	@Override
	public void fundTransfer(int accNo1, int accNo2, int amount) throws InsufficientBalanceAfterWithdrawException, AccountDoesNotExistException {
		
		a.FundTransfer(accNo1, accNo2, amount);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.ParallelProject.service.AccountService#showBalance(int)
	 */
	@Override
	public void showBalance(int accNo) {
		 account = a.showBalance(accNo);
		System.out.println(account);
	}
}
