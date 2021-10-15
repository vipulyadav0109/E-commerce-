package DemoMain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import report.Report;
import utility.CustomisedUtility;
import vender.sign_up;

public class DemoMain {

	public static void main(String [] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("1.Admin model");
		System.out.println("2.User model");
		System.out.println("Enter your choice");
		int num=sc.nextInt();
		switch(num) {
		case 1:
			System.out.println("Enter user name---->");
			String name=sc.next();
			System.out.println("Enter password");
			String password=sc.next();
		
			if(name.equals("system") && password.equals("system")) 
				
			Admin_model.admin_model();
			
			else 
				{System.out.println("Invalid user name & password");

				throw new Exception();}
			break;
		case 2:
			System.out.println("user_model");
			User.user_model();
		
		}
     }
 }
	

