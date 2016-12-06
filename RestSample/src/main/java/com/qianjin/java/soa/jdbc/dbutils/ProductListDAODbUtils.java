package com.qianjin.java.soa.jdbc.dbutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.qianjin.java.soa.model.ProductList;

public class ProductListDAODbUtils {
	
	public ArrayList<ProductList> getListByGroupIdViaJDBC(String groupId){
		ArrayList<ProductList> list=new ArrayList<ProductList>();
		Connection connection = DatabaseUtils.getConn();
		try {
			
			Statement stmt = connection.createStatement();
			String sql="";
			sql="SELECT name,access_code,show_order,service_type,group_id FROM product_list where visible=1 and group_id='"+groupId+"'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ProductList dataAccessType =new ProductList();
				String name = rs.getString("name");
				String access_code = rs.getString("access_code");
				int show_order = rs.getInt("show_order");
				int type = rs.getInt("service_type");
				String group_id = rs.getString("group_id");
				System.out.println(
						"name=" + name + ",access_code=" + access_code + ",type=" + type);
				dataAccessType.setName(name);
				dataAccessType.setAccess_code(access_code);
				dataAccessType.setShow_order(show_order);
				dataAccessType.setService_type(type);
				dataAccessType.setGroup_id(group_id);
				list.add(dataAccessType);
			}

			rs.close();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

}
