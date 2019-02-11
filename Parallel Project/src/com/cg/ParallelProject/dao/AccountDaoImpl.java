package com.cg.ParallelProject.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.ParallelProject.bean.Account;
import com.cg.ParallelProject.exception.AccountDoesNotExistException;
import com.cg.ParallelProject.exception.InsufficientBalanceAfterWithdrawException;

public class AccountDaoImpl implements AccountDao {
	static HashMap<Integer, Account> hm = new HashMap<>();
	int i = 0;
	int countDeposit = 0, countWithdraw = 0, countFundTransfer = 0, x = 0, y = 0, z = 0, a = 0, b = 0,c=0,d=0;

	public AccountDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Account Create(int accNo, int amount) {

		int f = 0;
		for (Map.Entry<Integer, Account> m : hm.entrySet()) {
			if (((Account) m.getValue()).getAccNo() == accNo) {
				System.out.println("Account no already exists");
				f = 1;
				break;
			}
		}
		if (f == 0) {
			Account account = new Account(accNo, amount);
			hm.put(i++, account);
			return account;
		}
		return null;
	}

	@Override
	public Account deposit(int accNo, int amount) throws AccountDoesNotExistException {

		for (Map.Entry<Integer, Account> m : hm.entrySet()) {
			if (((Account) m.getValue()).getAccNo() == accNo) {
				((Account) m.getValue()).setAmount(((Account) m.getValue()).getAmount() + amount);
				if (c == d) {
					countDeposit++;
					printTransaction(amount);
				} else {
					d = c;
				}
				return (Account) m.getValue();
			}
		}
		throw new AccountDoesNotExistException();

	}

	@Override
	public Account withDraw(int accNo, int amount) throws InsufficientBalanceAfterWithdrawException {

		for (Map.Entry<Integer, Account> m : hm.entrySet()) {
			if (((Account) m.getValue()).getAccNo() == accNo) {
				if ((((Account) m.getValue()).getAmount() - amount) > 500) {
					((Account) m.getValue()).setAmount(((Account) m.getValue()).getAmount() - amount);
					if (a == b) {
						countWithdraw++;
						printTransaction(amount);
					} else {
						b = a;
					}
					return (Account) m.getValue();

				} else
					throw new InsufficientBalanceAfterWithdrawException();

			}
		}
		return null;
	}

	@Override
	public void FundTransfer(int accNo1, int accNo2, int amount)
			throws InsufficientBalanceAfterWithdrawException, AccountDoesNotExistException {
		a++;
                c++;
		deposit(accNo2, amount);
		withDraw(accNo1, amount);
		System.out.println("Your balance is " + showBalance(accNo1));
		countFundTransfer++;
		printFundTransferTransaction(accNo2, amount);
	}

	@Override
	public Account showBalance(int accNo) {

		for (Map.Entry<Integer, Account> m : hm.entrySet()) {
			if (((Account) m.getValue()).getAccNo() == accNo) {
				return (Account) m.getValue();
			}
		}
		return null;
	}

	public void printTransaction(int amount) {
		if (countDeposit != x) {
			x = countDeposit;
			System.out.println("you deposit amount :" + amount);
		} else if (countWithdraw != y) {
			y = countWithdraw;
			System.out.println("you withdraw amount :" + amount);
		}
	}

	public void printFundTransferTransaction(int account, int amount) {
		if (countFundTransfer != z) {
			z = countFundTransfer;
			System.out.println("you transfer amount " + amount + " in account no " + account);
		}
	}
}
