package com.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentRegistration {
  
	
     
     public static void insertstudentdata(String firstname,String lastname,String username,String Password,
    		String city, String mailid,String mobile) throws SQLException{
            try {
            	Connection connection = ConnectionTest.getConnectionDetails();
            	PreparedStatement ps=connection.prepareStatement("insert into studentregistration( firstname,lastname,username,Password,city, Mailid, mobile )values(?,?,?,?,?,?,?)");
            	
            	ps.setString(1,firstname);
            	ps.setString(2,lastname);
            	ps.setString(3,username);
            	ps.setString(4,Password);
            	ps.setString(5,city);
            	ps.setString(6,mailid);
            	ps.setString(7,mobile);
            	int i =ps.executeUpdate();
            	System.out.println("Record inserted successfully"+i);
            	
            	}catch (Exception e) {
            		e.printStackTrace();
            	}finally {
             	}
     }
     
	public static void main(String[] args) throws NullPointerException ,SQLException{
		
	 Scanner scanner = new Scanner(System.in);
		   for (int i=0;i<7;i++) {
			
			System.out.println("Enter firstname>>");
			
			String firstname= scanner.next();
			
			System.out.println("Enter lastname>>");
			String lastname= scanner.next();		
			
		System.out.println("Enter usename>>");
		String username = scanner.next();		
		
		System.out.println("Enter password>>");
		String password= scanner.next();		
		
		System.out.println("Enter city>>");
		String city= scanner.next();		
		
		System.out.println("Enter mailid>>");
		String mailid= scanner.next();		
		
		System.out.println("Enter mobile>>");
		String mobile= scanner.next();	
		
		insertstudentdata(firstname,lastname,username, password,city,mailid,mobile);
	
		}
	}
	}
