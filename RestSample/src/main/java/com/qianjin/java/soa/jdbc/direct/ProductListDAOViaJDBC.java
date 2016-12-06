package com.qianjin.java.soa.jdbc.direct;

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;


public class ProductListDAOViaJDBC {
	
	

	public static String Test() {
		String ret="";
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return null;
		}

		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");

			try {
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(
						"SELECT name,access_code,show_order,SERVICE_type,group_id FROM PRODUCT_LIST where visible=1");

				
				while (rs.next()) {
					String name = rs.getString("name");
					String access_code = rs.getString("access_code");
					int type = rs.getInt("SERVICE_type");
					ret=ret+"name="+name+",access_code="+access_code+",type="+type;
					System.out.println(
							"name=" + name + ",access_code=" + access_code + ",type=" + type);
				}

				rs.close();
				stmt.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Failed to make connection!");
		}
		return ret;

	}

}
