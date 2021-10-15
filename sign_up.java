package vender;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import utility.CustomisedUtility;

public class sign_up {
     
	public static void vendor_signUp() throws SQLException{

    	 System.out.println("Enter Vender_Details--->");
    	 Scanner sc= new Scanner(System.in);

    	 System.out.println("Enter v_id");
    	 int v_id=sc.nextInt();
    	
    	  System.out.println("Enter v_name");
    	  String v_name=sc.next();
    	  
    	   System.out.println("Enter item_details");
    	   System.out.println(" item_id");
    	   int item_id=sc.nextInt();
    	   
    	   System.out.println("ENTER item_name");
    	   String item_name=sc.next();	   
    	    
    	  System.out.println("Unit_cost-->");
          int unit_cost=sc.nextInt();
          
    	  System.out.println("enter qty");
    	  int qty=sc.nextInt();
    	  
    	  System.out.println("ADDRESS ADD_ID");
    	   int add_id=sc.nextInt();
    	   
  	     System.out.println("ADDRESS--------CITY");
  	     String city=sc.next();
  	     
  	     System.out.println("ADDRESS--------STATE");
  	     String state=sc.next();
  	     
  	     System.out.println("ADDRESS------COUNTRY");
  	     String country=sc.next();
    	   
  		         Address adr=new Address(add_id, city, state, country);
    	
    	System.out.println("Enter pin No");
    	int pin =sc.nextInt();
    	
 Connection con=CustomisedUtility.getConnected();
 PreparedStatement prp;
 String QRY1="insert into vender_address values(?,?,?,?)";
String QRY2="insert into vendor_details values(?,?,?,?)";
String QRY3="insert into itam_details values(?,?,?)";
String QRY4="insert into quantity values (?,?)";
String QRY5="insert into unit_cost values(?,?)";
 	try {
 		 //String QRY1="insert into vender_address values (add_id="+add_id+",city="+city+",state="+state+",country="+country+")";
 		con.setAutoCommit(false);

		prp=con.prepareStatement(QRY1);
		prp.setInt(1, add_id);
		prp.setString(2, city);
		prp.setString(3, state);
		prp.setString(4, country);
		prp.addBatch();
		prp.executeBatch();
 	
 	
 //String QRY2="insert into vendor_details values(v_id="+v_id+",v_name="+v_name+",v_add_id="+add_id+",pin="+pin+")";
    		prp=con.prepareStatement(QRY2);
    		prp.setInt(1, v_id); 
    		prp.setString(2, v_name);
    		prp.setInt(3, add_id);
    		prp.setInt(4, pin);
    		prp.addBatch();
            prp.executeBatch();
  //String QRY3="insert into itam_details values   (item_id="+item_id+",v_id="+v_id+",item_name="+item_name+")"  ;

            prp=con.prepareStatement(QRY3);
    		prp.setInt(1, item_id);
    		prp.setInt(2, v_id);
    		prp.setString(3, item_name);
    		prp.addBatch();
    		prp.executeBatch();
    		
    		
// String QRY4="insert into quantity values      (item_id="+item_id+",v_id="+v_id+",qty="+tty+")";
    		prp=con.prepareStatement(QRY4);	
    		prp.setInt(1, item_id);
    		prp.setInt(2, qty);
       		prp.addBatch();
    		prp.executeBatch();
    		
    		// String QRY5="insert into unit_cost values     (item_id="+item_id+",v_id="+v_id+",unit_cost="+unit_cost+")";
		prp=con.prepareStatement(QRY5);
		prp.setInt(1, item_id);
		prp.setInt(2, unit_cost);

 		prp.addBatch();
    	prp.executeBatch();	
    	
 		con.commit();
    				System.out.println("Record inserted....");
    	
 			}catch(Exception e) {
 				e.printStackTrace();
 			con.rollback();
 				System.out.println("ROLLBACK");
 			
    	}
	

 
    	  
      }
}
