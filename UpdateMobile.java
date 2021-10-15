package update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import utility.CustomisedUtility;

public class UpdateMobile {
   public static void update_mobile() throws SQLException {
	   Scanner sc= new Scanner(System.in);
	   System.out.println("Enter mobile number-->");
	   int mobile_no=sc.nextInt();
	   
	   System.out.println("Enter valid V_name-->");
	   String v_name=sc.next();   
	   
	   Connection con=CustomisedUtility.getConnected();
	   PreparedStatement prp;
	   
	 String QRY="update  vendor_details set mobile_no=? where v_name=?";
	   
	 try {
		 con.setAutoCommit(false);
		 prp=con.prepareStatement(QRY);
		 prp.setInt(1, mobile_no);
		 prp.setString(2, v_name);
		 prp.executeUpdate();
		 
		 con.commit();
			 System.out.println("Mobile Number Updated....");
		 con.commit();
	 }catch(Exception e) {
		 e.printStackTrace();
		 con.rollback();
	 }
	   
   }
}
