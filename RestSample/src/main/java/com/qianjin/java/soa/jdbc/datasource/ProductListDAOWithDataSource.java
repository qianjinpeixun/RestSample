package com.qianjin.java.soa.jdbc.datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianjin.java.soa.model.ProductList;


//@Component 是一个泛化的概念，仅仅表示一个组件 (Bean) ，可以作用在任何层次。
//@Service 通常作用在业务层，但是目前该功能与 @Component 相同。
//@Constroller 通常作用在控制层，但是目前该功能与 @Component 相同。

@Service
public class ProductListDAOWithDataSource {

	// @Autowired注解的意思就是，当Spring发现@Autowired注解时，将自动在代码上下文中找到和其匹配（默认是类型匹配）的Bean，并自动注入到相应的地方去。

	@Autowired
	private DataSource dataSource;

	public ArrayList<ProductList> getListByGroupIdViaJDBC(String groupId) {
		ArrayList<ProductList> list = new ArrayList<ProductList>();

		try {
			Connection connection = dataSource.getConnection();

			Statement stmt = connection.createStatement();
			String sql = "";
			sql = "SELECT name,access_code,show_order,service_type,group_id FROM product_list where visible=1 and group_id='"
					+ groupId + "'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ProductList dataAccessType = new ProductList();
				String name = rs.getString("name");
				String access_code = rs.getString("access_code");
				int show_order = rs.getInt("show_order");
				int type = rs.getInt("service_type");
				String group_id = rs.getString("group_id");
				System.out.println("name=" + name + ",access_code=" + access_code + ",type=" + type);
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
