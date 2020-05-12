package com.revature.cardeal;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.daoimpl.CustDaoImpl;
import com.revature.extramethods.MathTime;
import com.revature.util.LogThis;

public class CustScreen implements CarScreen{
	CustDaoImpl cdi = new CustDaoImpl();
	String choice;
	private static final MathTime mt = new MathTime();
	int randNum = (int) (Math.random() * 999) + 1;
	int randNum2 = (int) (Math.random() * 999) + 1;
	int total = mt.Addition(randNum, randNum2);

	@Override
	public CarScreen render(Scanner scan) {
		System.out.println("Welcome Customer what would you like to do?");
		System.out.println("Please select option from the menu.");
		System.out.println("1: Create new account");
		System.out.println("2: Login");
		choice = scan.nextLine();
		
		if(choice.equals("1")) {
			String pass;
			String lname;
			String fname;
			System.out.println("We are glad you are joining");
			System.out.println("What is your first name?");
			fname = scan.nextLine();
			System.out.println("What is your last name?");
			lname = scan.nextLine();
			System.out.println("What would you like your password to be?");
			pass = scan.nextLine();
			
			try {
				cdi.createCust(total, pass, fname, lname);
				System.out.println("The new account number is: " + total);
				LogThis.LogIt("info", "Customer " + total + " created.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		else if (choice.equals("2")) {
			return new CustLogin().render(scan);
		}
		
		else {
			System.out.println("Invalid Entry");
			return new CustScreen().render(scan);
		}
		
		System.out.println("Thanks for signing up!");
		return new MainDealerScreen().render(scan);
	}

}
