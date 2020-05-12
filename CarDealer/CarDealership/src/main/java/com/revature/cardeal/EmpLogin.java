package com.revature.cardeal;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.daoimpl.EmpDaoImpl;

public class EmpLogin implements CarScreen{
	
	EmpDaoImpl edi = new EmpDaoImpl();

	@Override
	public CarScreen render(Scanner scan) {
		
		try {
			edi.login();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new EmpMain().render(scan);
	}

}
