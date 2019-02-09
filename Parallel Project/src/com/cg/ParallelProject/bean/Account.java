package com.cg.ParallelProject.bean;

public class Account {
	private int accNo;
	private int amount;

	public Account(int accNo, int amount) {
		super();
		this.accNo = accNo;
		this.amount = amount;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accNo;
		result = prime * result + amount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accNo != other.accNo)
			return false;
		if (amount != other.amount)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", amount=" + amount + "]";
	}

}
