package com.qianjin.java.soa.jdbc.template;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.qianjin.java.soa.model.ProductList;

@Repository
public class ProductListWithJDBCTemplate {

	private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    
    public List<ProductList> findByGroupId(String groupId) {
    	
    	String sql = "SELECT name,access_code,show_order,service_type,group_id FROM product_list where visible=1 and group_id='"
				+ groupId + "'";
        return this.jdbcTemplate.query(sql, new DataAccessTypeMapper());
    }

    private static final class DataAccessTypeMapper implements RowMapper<ProductList> {

        public ProductList mapRow(ResultSet rs, int rowNum) throws SQLException {
        	ProductList dataAccessType = new ProductList();
        	
        	String name = rs.getString("name");
			String access_code = rs.getString("access_code");
			int show_order = rs.getInt("show_order");
			int type = rs.getInt("service_type");
			String group_id = rs.getString("group_id");
			
			dataAccessType.setName(name);
			dataAccessType.setAccess_code(access_code);
			dataAccessType.setShow_order(show_order);
			dataAccessType.setService_type(type);
			dataAccessType.setGroup_id(group_id);
			
            return dataAccessType;
        }
    }
    
}
