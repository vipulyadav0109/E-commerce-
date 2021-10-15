package DemoMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import utility.CustomisedUtility;

public class User {

	public static void user_model() throws SQLException {
	
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter item to purchase---->");
		String item_name=sc.next();
		System.out.println("how many product you want--->");
		int qty1=sc.nextInt();
		Connection con=CustomisedUtility.getConnected();
		PreparedStatement prp;
		
		String QRY1= " select item_name from itam_details ";
	//	String QRY2="alter table quantity set qty=qty-"+qty1;
		try {
			prp=con.prepareStatement(QRY1);
		//	prp=con.prepareStatement(QRY2);
			ResultSet rs=prp.executeQuery();
			
			if (rs.next())
			{
				if(item_name.equals(rs.getString("item_name"))) {
					con.setAutoCommit(false);
					String QRY="update  quantity set qty=qty-"+qty1+" where item_name="+item_name;
					prp=con.prepareStatement(QRY);
					prp.executeUpdate();
				}
			}
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
			con.rollback();
		}
		
	}
}
