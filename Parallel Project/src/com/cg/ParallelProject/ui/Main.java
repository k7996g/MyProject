package com.cg.ParallelProject.ui;

import java.util.Scanner;

import com.cg.ParallelProject.exception.AccountDoesNotExistException;
import com.cg.ParallelProject.exception.InsufficientBalanceAfterWithdrawException;
import com.cg.ParallelProject.service.AccountService;
import com.cg.ParallelProject.service.AccountServiceImpl;

public class Main {
	 static AccountService a = new AccountServiceImpl();
	public static void main(String[] args) {
		showMenu();
	}

	public static void showMenu() {
		
		
		while (true) {
			System.out.println("Enter 1 for create account");
			System.out.println("Enter 2 for deposit");
			System.out.println("Enter 3 for withdraw");
			System.out.println("Enter 4 for FundTransfer");
			System.out.println("Enter 5 for showBalance");
			System.out.println("Enter 6 for exit");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: accountCreate();
			        break;
			case 2:
				depositAmount();
				break;
			case 3:
				withDrawAmount();
				break;
			case 4:
				transferAmount();
				break;
			case 5:
				showAmount();
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("Wrong choice");
			}
		}
	}
	public static void accountCreate()
	{Scanner scanner=new Scanner(System.in);
	System.out.println("Enter account no");
	int accNo=scanner.nextInt();
	System.out.println("Enter amount");
	int amount=scanner.nextInt();
	a.createAccount(accNo, amount);
	}

	public static  void depositAmount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the amount you want to deposit");
		int amount = scanner.nextInt();
		System.out.println("Enter your account");
		int account = scanner.nextInt();
		
		try {
			a.deposit(account, amount);
		} catch (AccountDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void withDrawAmount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the amount you want to withdraw");
		int amount = scanner.nextInt();
		System.out.println("Enter your account");
		int account = scanner.nextInt();
		
		try {
			a.withDraw(account, amount);
		} catch (InsufficientBalanceAfterWithdrawException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void transferAmount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your account no");
		int account1 = scanner.nextInt();
		System.out.println("Enter second party account no");
		int account2 = scanner.nextInt();
		System.out.println("Enter the amount which you want to transfer");
		int amount = scanner.nextInt();
		
		try {
			try {
				a.fundTransfer(account1, account2, amount);
			} catch (AccountDoesNotExistException e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid account so fund transfer can not happen");
			}
		} catch (InsufficientBalanceAfterWithdrawException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void showAmount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your account no");
		int account = scanner.nextInt();
		
		a.showBalance(account);
	}
}
