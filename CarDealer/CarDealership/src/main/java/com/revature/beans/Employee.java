package com.revature.beans;

public class Employee {
	
	private int acct_num;
	private String password;
	
	public Employee() {
		super();
	}

	public Employee(int acct_num, String password) {
		super();
		this.acct_num = acct_num;
		this.password = password;
	}

	public int getAcct_num() {
		return acct_num;
	}

	public void setAcct_num(int acct_num) {
		this.acct_num = acct_num;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [acct_num=" + acct_num + ", password=" + password + "]";
	}
	
}
