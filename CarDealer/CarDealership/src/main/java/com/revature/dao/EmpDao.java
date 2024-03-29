package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Car;
import com.revature.beans.Offer;
import com.revature.beans.Payment;

public interface EmpDao {
	
	public void login() throws SQLException;
	
	public void createEmp(int acct_num, String pass) throws SQLException;
	
	public void createCar(int car_Id, String car_Make, String car_Model, String car_Color, int owner) throws SQLException;

	public List <Car> getCarList() throws SQLException;
	
	public void removeCar() throws SQLException;
	
	public List<Offer> getOfferList() throws SQLException;
	
	public void acceptDenyOffer() throws SQLException;
	
	public List<Payment>getPayments()throws SQLException;
}
