package com.revature.cardeal;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.daoimpl.CustDaoImpl;
import com.revature.daoimpl.EmpDaoImpl;
import com.revature.extramethods.MathTime;
import com.revature.util.LogThis;

public class CustLogin implements CarScreen {
	public static int uNum;
	private static final MathTime mt = new MathTime();
	CustDaoImpl cdi = new CustDaoImpl();
	EmpDaoImpl edi = new EmpDaoImpl();
	String choice;
	String pend = "Pending";
	int randNum = (int) (Math.random() * 999) + 1;
	int randNum2 = (int) (Math.random() * 999) + 1;
	int total = mt.Addition(randNum, randNum2);
	@Override
	public CarScreen render(Scanner scan) {
		
		try {
			cdi.login();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("What would you like to do?");
		System.out.println("Please select option from the list");
		System.out.println("1: View cars on the lot");
		System.out.println("2: Make offer on a car");
		System.out.println("3: View the cars you own");
		System.out.println("4: View remaining balance/payments");
		System.out.println("5: Make a payment");
		System.out.println("6: Return to main menu");
		choice = scan.nextLine();
		
		if(choice.equals("1")) {
			String wait;
			try {
				System.out.println(edi.getCarList());
				System.out.println("Press any key to continue");
				LogThis.LogIt("info", "Customer " + uNum + " looked at car lot");
				wait = scan.nextLine();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		else if(choice.equals("2")) {
			int car;
			int amt;
			Scanner sc1 = new Scanner(System.in);
			System.out.println("What is the ID of the car you wish to make an offer on?");
			car = sc1.nextInt();
			System.out.println("What is the amount you wish to offer?");
			amt = sc1.nextInt();
			try {
				cdi.makeOffer(uNum, car, amt, total, pend);
				System.out.println("Thank you! An employee will either accept or deny your offer.");
				LogThis.LogIt("info", "Customer " + uNum + " made an offer of $" + amt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		else if(choice.equals("3")) {
			String wait;
			try {
				System.out.println(cdi.getCarOwned());
				System.out.println("Press any key to continue");
				LogThis.LogIt("info", "Customer " + uNum + " looked at owned cars");
				wait = scan.nextLine();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(choice.equals("4")) {
			String wait;
			try {
				cdi.getBalance();
				System.out.println("Press any key to continue");
				LogThis.LogIt("info", "Customer " + uNum + " checked their balances");
				wait = scan.nextLine();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		else if(choice.equals("5")) {
			String wait;
			try {
				cdi.makePayment();
				System.out.println("Press any key to continue");
				wait = scan.nextLine();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		else if(choice.equals("6")) {
			return new MainDealerScreen().render(scan);
		}
		
		else {
			System.out.println("Invalid Entry");
			return new CustLogin().render(scan);
		}
		return new CustLogin().render(scan);
	}

}
