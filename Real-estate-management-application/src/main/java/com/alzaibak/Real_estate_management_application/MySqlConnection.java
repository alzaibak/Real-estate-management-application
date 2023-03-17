package com.alzaibak.Real_estate_management_application;

import java.sql.*;

public class MySqlConnection {
	public Connection cn = null;
	public static Connection DBConnection() {
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/logement_mangement?serverTimezone=UTC","root","");
			System.out.println("connection done");
			return cn;
		}catch(ClassNotFoundException  | SQLException e) {
			System.out.println("connection faild");
			e.printStackTrace();
			return null;
			}
		
	}

}
