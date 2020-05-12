package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Car;
import com.revature.beans.Offer;
import com.revature.beans.Payment;
import com.revature.dao.EmpDao;
import com.revature.util.ConnFactory;
import com.revature.util.LogThis;

public class EmpDaoImpl implements EmpDao {
public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void login() throws SQLException {
		int num;
		String pass;
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter Employee ID");
		num = sc.nextInt();
		System.out.println("Enter Password");
		pass = sc2.nextLine();
		Connection conn = cf.getConnection();
		Statement stm = conn.createStatement();
		String sql = "SELECT ACCT_NUM, PASS FROM EMP WHERE ACCT_NUM = " + num + " AND PASS = '" + pass + "'";
		ResultSet rs = stm.executeQuery(sql);
		if(rs.next() == false) {
			System.out.println("Incorrect Login Info");
			login();
		}
		else {
			System.out.println("Welcome Employee");
			LogThis.LogIt("info", "Employee " + num + " logged in");
		}
		
	}

	@Override
	public void createEmp(int acct_num, String pass) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call MYEMPPRO(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, acct_num);
		call.setString(2, pass);
		call.execute();
	}

	@Override
	public void createCar(int car_Id, String car_Make, String car_Model, String car_Color, int owner) throws SQLException {

		Connection conn = cf.getConnection();
		String sql = "INSERT INTO CAR VALUES(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, car_Id);
		ps.setString(2, car_Make);
		ps.setString(3, car_Model);
		ps.setString(4, car_Color);
		ps.setInt(5, owner);
		ps.executeUpdate();
	}

	@Override
	public List<Car> getCarList() throws SQLException {
		List<Car> carList = new ArrayList<Car>();
		Connection conn = cf.getConnection();
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM CAR");
		Car c = null;
		while(rs.next()) {
			c = new Car(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5));
			carList.add(c);
		}
		return carList;
	}

	@Override
	public void removeCar() throws SQLException {
		int num;
		Scanner sc1 = new Scanner(System.in);
		System.out.println("What is the id of the car you would like to remove?");
		num = sc1.nextInt();
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM CAR WHERE CAR_ID = " +num;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeUpdate();
		LogThis.LogIt("info", "Employee removed car " +num+ " from the lot");
		
	}

	@Override
	public List<Offer> getOfferList() throws SQLException {
		List<Offer> offList = new ArrayList<Offer>();
		Connection conn = cf.getConnection();
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM OFFER");
		Offer o = null;
		while(rs.next()) {
			o = new Offer(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			offList.add(o);
		}
		return offList;
	}

	@Override
	public void acceptDenyOffer() throws SQLException {
		String choice;
		int num;
		//String offer;
		int acctNum = 0;
		int carNum = 0;
		int offd = 0;
		String need = "Accepted";
		List<Offer> offList = new ArrayList<Offer>();
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Offer o = null;
		System.out.println("What the offer ID number of the offer you wish to view?");
		num = sc.nextInt();
		Connection conn = cf.getConnection();
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM OFFER WHERE OFFER_ID = " + num);
		if (rs.next() == false) {
			System.out.println("Offer ID not found");
			acceptDenyOffer();
		}
		
		else {
			ResultSet rs2 = stm.executeQuery("SELECT * FROM OFFER WHERE OFFER_ID = " + num);
			while(rs2.next()) {
				o = new Offer(rs2.getInt(1), rs2.getInt(2), rs2.getInt(3), rs2.getInt(4), rs2.getString(5));
				offList.add(o);
				acctNum = rs2.getInt(1);
				carNum = rs2.getInt(2);
				offd = rs2.getInt(3);
				System.out.println(offList);
			}
			
			System.out.println("Would you like to accept or deny this offer?");
			System.out.println("Press A to accept and D to deny");
			choice = sc1.nextLine();
				if(choice.equals("a") || choice.equals("A")) {
					String sql = "UPDATE CAR SET CAR_OWNER =" +acctNum+ "WHERE CAR_ID =" + carNum;
					PreparedStatement ps = conn.prepareStatement(sql);
					//ps.setInt(5, acctNum);
					//ps.setInt(1, carNum);
					ps.executeUpdate();
					System.out.println("Car purchased");
					
					String sql4 = "UPDATE OFFER SET OFFER_STATUS ='" +need+ "'WHERE CAR_ID =" + carNum;
					PreparedStatement ps4 = conn.prepareStatement(sql4);
					ps4.executeUpdate();
					
					String sql2 = "DELETE FROM OFFER WHERE ACCT_NUM != " +acctNum + "AND CAR_ID = " + carNum;
					PreparedStatement ps2 = conn.prepareStatement(sql2);
					ps2.executeUpdate();
					
					String sql3 = "INSERT INTO PAYMENT VALUES(?,?,?,?,?)"; 
					PreparedStatement ps3 = conn.prepareStatement(sql3);
					ps3.setInt(1, carNum);
					ps3.setInt(2, acctNum);
					ps3.setInt(3, offd);
					ps3.setInt(4, offd);
					ps3.setInt(5, 12);
					ps3.executeUpdate();
					LogThis.LogIt("info", "Employee approved offer of $" + offd + " for car " + carNum);
				}
				
				else if(choice.equals("d") || choice.equals("D")) {
					String sql = "DELETE FROM OFFER WHERE OFFER_ID = " +num;
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.executeUpdate();
					System.out.println("Offer rejected");
					LogThis.LogIt("info", "Employee denied offer of $" + offd + " for car " + carNum);
				}
				
				else {
					System.out.println("Invalid Input");
					acceptDenyOffer();
				}
		}
	}

	@Override
	public List<Payment> getPayments() throws SQLException {
		List<Payment> payList = new ArrayList<Payment>();
		Connection conn = cf.getConnection();
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM PAYMENT");
		Payment p = null;
		while(rs.next()) {
			p = new Payment(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
			payList.add(p);
		}
		return payList;
	}

}
