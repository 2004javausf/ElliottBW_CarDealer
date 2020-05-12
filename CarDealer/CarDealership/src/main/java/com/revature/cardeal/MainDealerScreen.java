package com.revature.cardeal;

import java.util.Scanner;

public class MainDealerScreen implements CarScreen {
	
	String typePerson;

	@Override
	public CarScreen render(Scanner scan) {
		
		System.out.println("Welcome to Elliott's Cars");
		System.out.println("What type of user are you?");
		System.out.println("Please select a corresponding number.");
		System.out.println("1: Customer");
		System.out.println("2: Employee");
		System.out.println("3: Exit Application");
		typePerson= scan.nextLine();
		
		if(typePerson.equals("1")) {
			return new CustScreen().render(scan);
		}
		
		else if(typePerson.equals("2")) {
			return new EmpLogin().render(scan);
		}
		
		else if(typePerson.equals("3")) {
			Driver.isRunning = false;
			return null;
		}
		
		else {
			System.out.println("Invalid Entry");
			return new MainDealerScreen().render(scan);
		}
	}

}
