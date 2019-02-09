package com.cg.ParallelProject.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.ParallelProject.bean.Account;
import com.cg.ParallelProject.exception.AccountDoesNotExistException;
import com.cg.ParallelProject.exception.InsufficientBalanceAfterWithdrawException;


public class AccountDaoImpl implements AccountDao {
static HashMap<Integer, Account> hm = new HashMap<>();
       int i=0;


	@Override
	public Account Create(int accNo,int amount) {
		
		int f=0;
		for(Map.Entry m:hm.entrySet())
		{if(((Account) m.getValue()).getAccNo()==accNo)
		{System.out.println("Account no already exists");
		f=1;break;}
		}
		if(f==0)
		{Account account =new Account(accNo, amount);
			hm.put(++i,  account);
			return account;
		}
return null;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.ParallelProject.dao.AccountDao#deposit(int, int)
	 */
	@Override
	public Account deposit(int accNo, int amount) throws AccountDoesNotExistException {
		
		for (Map.Entry m : hm.entrySet()) {
			if (((Account) m.getValue()).getAccNo() == accNo) {
				((Account) m.getValue()).setAmount(((Account) m.getValue()).getAmount() + amount);
				return (Account) m.getValue();
			}
		}
		throw new AccountDoesNotExistException();
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.ParallelProject.dao.AccountDao#withDraw(int, int)
	 */
	@Override
	public Account withDraw(int accNo, int amount) throws InsufficientBalanceAfterWithdrawException {
		
		
		for (Map.Entry m : hm.entrySet()) {
			if (((Account) m.getValue()).getAccNo() == accNo) {
				if ((((Account) m.getValue()).getAmount() - amount) > 500)
					((Account) m.getValue()).setAmount(((Account) m.getValue()).getAmount() - amount);
				else
					throw new InsufficientBalanceAfterWithdrawException();

				return (Account) m.getValue();
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.ParallelProject.dao.AccountDao#FundTransfer(int, int, int)
	 */
	@Override
	public void FundTransfer(int accNo1, int accNo2, int amount) throws InsufficientBalanceAfterWithdrawException, AccountDoesNotExistException {
		withDraw(accNo1, amount);
		deposit(accNo2, amount);
		System.out.println("Your balance is "+showBalance(accNo1));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.ParallelProject.dao.AccountDao#showBalance(int, int)
	 */
	@Override
	public Account showBalance(int accNo) {
		
		
		for (Map.Entry m : hm.entrySet()) {
			if (((Account) m.getValue()).getAccNo() == accNo) {
				return (Account) m.getValue();
			}
		}
		return null;
	}
}
