package com.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

	public class QuestionInsert {
		
		 static class Question {
		        private String question;
		        private String optionA;
		        private String optionB;
		        private String optionC;
		        private String optionD;
		        private String correctOption;

		        public Question(String question, String optionA, String optionB, String optionC, String optionD, String correctOption) {
		            this.question = question;
		            this.optionA = optionA;
		            this.optionB = optionB;
		            this.optionC = optionC;
		            this.optionD = optionD;
		            this.correctOption = correctOption;
		        }
//comment
		        public String getQuestion() {
		            return question;
		        }

		        public String getOptionA() {
		            return optionA;
		        }

		        public String getOptionB() {
		            return optionB;
		        }

		        public String getOptionC() {
		            return optionC;
		        }

		        public String getOptionD() {
		            return optionD;
		        }

		        public String getCorrectOption() {
		            return correctOption;
		        }

			 public static void main(String[] args) throws SQLException {
			        // connect to the database
				 	try {
				 	Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root");
					
			        ArrayList<Question> questions = new ArrayList<>();
			        questions.add(new Question("Automatic type conversion is possible in which of the possible cases?", 
			        		"Int to long", "Byte to Int", "long to Int", "Short to Int", "A"));
			        questions.add(new Question("How many types of statements in JDBC?", 
			        		"3", "2", "4", "6", "A"));
			 

			        String sql = "INSERT INTO question (question, option_a, option_b, option_c, option_d, correctoption) VALUES (?, ?, ?, ?, ?, ?)";
			        PreparedStatement statement = null;
			        try {
			            for (Question question : questions) {
			                statement = con.prepareStatement(sql);
			                statement.setString(1, question.getQuestion());
			                statement.setString(2, question.getOptionA());
			                statement.setString(3, question.getOptionB());
			                statement.setString(4, question.getOptionC());
			                statement.setString(5, question.getOptionD());
			                statement.setString(6, question.getCorrectOption());
			                int rowsInserted = statement.executeUpdate();
			                if (rowsInserted > 0) {
			                    System.out.println("A new question has been added to the database.");
			                }
			            }
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
				 	
				 	}catch(Exception e) {
				 		e.printStackTrace();
				 	}
			 }
		 }
	}
				 
			   
		


