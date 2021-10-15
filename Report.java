package report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utility.CustomisedUtility;
import vender.sign_up;

public class Report {
	
	public static void list_of_venders() {
          Connection con=CustomisedUtility.getConnected();
          PreparedStatement prp;
          ResultSet rs;
    String QRY="select * from vendor_details	";
          try {
        	  prp=con.prepareStatement(QRY);
        	  
        	  rs=prp.executeQuery();
        	  while(rs.next()) {
        		  System.out.println("v_id=="+rs.getInt("v_id")+"   v_name=="+rs.getString("v_name"));       	  }
        	
       }catch(Exception e) {
    	   e.printStackTrace();
       }
   }
	
	
public  static	void tolat_item_cost(){
	Connection con=CustomisedUtility.getConnected();
	PreparedStatement prp;
	ResultSet rs;
	
	String QRY="select unit_cost.unit_cost, quantity.qty from unit_cost join quantity on unit_cost.item_id=quantity.item_id";
	try {
		prp=con.prepareStatement(QRY);
		rs=prp.executeQuery();
		while(rs.next()) {
			System.out.println("qyt=="+rs.getInt("qty")+"  unit_cost=="+rs.getInt("unit_cost")+"  Total_cost=="+(rs.getInt("unit_cost")*+rs.getInt("qty")));
		}
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
  
public static void item_desc() {
	Connection con=CustomisedUtility.getConnected();
	PreparedStatement prp;
	ResultSet rs;
	
	String a="select itam_details.item_name,quantity.qty,unit_cost.unit_cost from itam_details,"
			+ " quantity,unit_cost where itam_details.item_id=quantity.item_id AND itam_details.item_id=unit_cost.item_id";
	//String b=" select unit_cost.v_id,unit_cost.unit_cost, quantity.qty, quantity.v_id from unit_cost join quantity on unit_cost.v_id=quantity.v_id ";
	//String QRY="a.v_id, "'
	try {
		prp=con.prepareStatement(a
				);
		rs=prp.executeQuery();
		while(rs.next()) {
			System.out.println("item_name=="+rs.getString("item_name")+"      qyt=="+rs.getInt("qty")+"    unit_cost=="+rs.getInt("unit_cost"));
		//	System.out.println("v_id=="+rs.getInt("v_id")+"    unit_cost=="+rs.getInt("unit_cost")+"   qyt=="+rs.getInt("qty"));
		}
			}catch(Exception e) {
		e.printStackTrace();	
		}
	
	
	
}
	
	
	
	
	
	
	
	
	
}