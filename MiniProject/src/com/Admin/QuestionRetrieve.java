package com.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class QuestionRetrieve {

	    public static void main(String[] args) {
	        // connect to the database
	        String url = "jdbc:mysql://localhost:3306/miniproject";
	        String username = "root";
	        String password = "root";
	        Connection connection = null;
	        try {
	            connection = DriverManager.getConnection(url, username, password);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return;
	        }

	        // retrieve a question with options from the database
	        String sql = "SELECT question, option_a, option_b, option_c, option_d FROM question WHERE question_number = ?";
	        PreparedStatement statement = null;
	        ResultSet resultSet = null;
	        try {
	            statement = connection.prepareStatement(sql);
	            statement.setInt(1, 2); // set the question ID to retrieve
	            resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                String question = resultSet.getString("question");
	                String optionA = resultSet.getString("option_a");
	                String optionB = resultSet.getString("option_b");
	                String optionC = resultSet.getString("option_c");
	                String optionD = resultSet.getString("option_d");

	                System.out.println(question);
	                System.out.println("A. " + optionA);
	                System.out.println("B. " + optionB);
	                System.out.println("C. " + optionC);
	                System.out.println("D. " + optionD);
	                
	                System.out.println("enter the answer");
	                Scanner sc = new Scanner(System.in);
	                String s= sc.next();
	                
	                //String sql1 = "select correctoption from question where question_number = (1) and (s)";
	                if(s=="A")
	                	System.out.println("correct");
	             
	            } else {
	                System.out.println("Question not found.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        // close the database connection
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


