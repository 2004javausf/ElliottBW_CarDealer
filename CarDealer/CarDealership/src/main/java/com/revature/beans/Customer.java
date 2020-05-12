package com.revature.beans;

public class Customer {
	
	private int acct_num;
	private String password;
	private String fName;
	private String lName;
	
	public Customer() {
		super();
	}

	public Customer(int acct_num, String password, String fName, String lName) {
		super();
		this.acct_num = acct_num;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
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

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	@Override
	public String toString() {
		return "Customer [acct_num=" + acct_num + ", password=" + password + ", fName=" + fName + ", lName=" + lName
				+ "]";
	}
}
