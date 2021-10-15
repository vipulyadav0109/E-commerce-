package DemoMain;

import java.sql.SQLException;
import java.util.Scanner;

import report.Report;
import update.UpdateMobile;
import vender.sign_up;

public class Admin_model {

	public static void  admin_model() throws SQLException {
		Scanner sc= new Scanner (System.in);
	System.out.println("Admin Moduled   1.Vender signUp  2.Reports  3.Update ");

	System.out.println("Enter your choice");

			int num=sc.nextInt();
			switch(num) {

			case 1 :
				sign_up.vendor_signUp();
				break;
			case 2:				
				System.out.println("1.list_of_venders");
				System.out.println("2.tolat_item_cost");
				System.out.println("3.item_desc");
				System.out.println("Enter your choice");
				int num2=sc.nextInt();
		
				switch(num2) {
				
				case 1:
					Report.list_of_venders();
	            break;
				case 2:
					Report.tolat_item_cost();
				break;
				
				case 3:
					Report.item_desc();
				}
				break;
			case 3:
				UpdateMobile.update_mobile();		
				}
			System.exit(num);
			
}
}