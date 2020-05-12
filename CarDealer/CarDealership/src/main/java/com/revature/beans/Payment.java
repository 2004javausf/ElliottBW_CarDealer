package com.revature.beans;

public class Payment {
	
	private int car_Id;
	private int acct_num;
	private int org_amt;
	private int amt_left;
	private int pay_left;
	
	public Payment() {
		super();
	}

	public Payment(int car_Id, int acct_num, int org_amt, int amt_left, int pay_left) {
		super();
		this.car_Id = car_Id;
		this.acct_num = acct_num;
		this.org_amt = org_amt;
		this.amt_left = amt_left;
		this.pay_left = pay_left;
	}

	public int getCar_Id() {
		return car_Id;
	}

	public void setCar_Id(int car_Id) {
		this.car_Id = car_Id;
	}

	public int getAcct_num() {
		return acct_num;
	}

	public void setAcct_num(int acct_num) {
		this.acct_num = acct_num;
	}

	public int getOrg_amt() {
		return org_amt;
	}

	public void setOrg_amt(int org_amt) {
		this.org_amt = org_amt;
	}

	public int getAmt_left() {
		return amt_left;
	}

	public void setAmt_left(int amt_left) {
		this.amt_left = amt_left;
	}

	public int getPay_left() {
		return pay_left;
	}

	public void setPay_left(int pay_left) {
		this.pay_left = pay_left;
	}

	@Override
	public String toString() {
		return "Payment [car_Id=" + car_Id + ", acct_num=" + acct_num + ", org_amt=" + org_amt + ", amt_left="
				+ amt_left + ", pay_left=" + pay_left + "]";
	}
}
