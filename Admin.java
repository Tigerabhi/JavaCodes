package com.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Admin {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		// TODO Auto-generated method stub
		String FirstName=" ";
		String LastName = " ";
		int Score;
		int Student_id;
		
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root");
		
		String sql = "select FirstName,LastName ,Score from miniproject.admin order by Score";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			 
            FirstName = rs.getString("FirstName");
            LastName = rs.getString("LastName");
            System.out.println("FirstName "+ FirstName +" LastName " + LastName);
        }
		
		System.out.println(" ");
		
		System.out.println("Enter Student ID");
		Scanner sc = new Scanner(System.in);
		Student_id = sc.nextInt();
		
		String sql1 = "Select Score from miniproject.admin where Student_id ="+Student_id;
		Statement ps1 = con.createStatement();
		
		ResultSet rs1 = ps1.executeQuery(sql1);
			
		if(rs1.next()) {
			Score =rs1.getInt("Score");
			System.out.println("StudentID "+ Student_id +" Score "+ Score);
        }
		
		
	}
		catch(Exception e) {
			System.out.println(e);
		}

}
}
