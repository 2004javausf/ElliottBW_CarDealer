package com.revature.cardeal;

import java.util.Scanner;

public class Driver {

	static boolean isRunning = true;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		CarScreen presentScreen = new MainDealerScreen();
		
		while(isRunning) {
			presentScreen = presentScreen.render(scan);
		}

	}

}
