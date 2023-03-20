package com.User;
import java.sql.*;
import java.util.Scanner;
public class StudentLogin {
	
	public static void main(String args[]) {

     
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter your username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Enter your password: ");
        String inputPassword = scanner.nextLine();

       
        String dbUrl = "jdbc:mysql://localhost:3306/quizapplication";
        String dbUser = "root";
        String dbPassword = "123";

        
        String sqlQuery = "SELECT username, password FROM studentregistration WHERE username = ? AND password = ?";

        try {
            
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

           
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, inputUsername);
            stmt.setString(2, inputPassword);

       
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful. Welcome, " + inputUsername + "!");
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        scanner.close();

    }

}




