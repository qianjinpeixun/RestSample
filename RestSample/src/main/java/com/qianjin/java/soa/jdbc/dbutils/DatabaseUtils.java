package com.qianjin.java.soa.jdbc.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {

	public static Connection getConn() {

		Connection connection = null;

		try {
			Class.forName("org.h2.Driver");
			System.out.println("MySQL JDBC Driver Registered!");
			connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
		return connection;
	}
}
