package com.qianjin.java.soa.rest;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qianjin.java.soa.hibernate.ProductListServiceHibernate;
import com.qianjin.java.soa.jdbc.datasource.*;
import com.qianjin.java.soa.jdbc.dbutils.ProductListDAODbUtils;
import com.qianjin.java.soa.jdbc.direct.ProductListDAOViaJDBC;
import com.qianjin.java.soa.jdbc.template.ProductListWithJDBCTemplate;
import com.qianjin.java.soa.model.ProductList;


@RestController
public class ProductListRest {

	@Autowired
	ProductListDAOWithDataSource dataAccessTypesServiceWithDataSource;
	
	@Autowired
	ProductListWithJDBCTemplate dataAccessTypeJDBCTemplateDao;
	
	
	@Autowired
	ProductListServiceHibernate dataAccessTypeHibernateService;
	
	
	@RequestMapping("/jdbc/direct")
	public String getByGroupIDDirectJDBC(
			@RequestParam(value = "group_id", defaultValue = "DPTOPUPS") String groupId) {
		return ProductListDAOViaJDBC.Test();
	}
	
	
	@RequestMapping("/jdbc/dbutils")
	public List<ProductList> getByGroupID(
			@RequestParam(value = "group_id", defaultValue = "DPTOPUPS") String groupId) {

		ProductListDAODbUtils dataAccessTypesService=new ProductListDAODbUtils();
		
		List<ProductList> list = dataAccessTypesService.getListByGroupIdViaJDBC(groupId);
		return list;
	}
	
	
	@RequestMapping("/jdbc/datasource")
	public List<ProductList> getByGroupIDWithDataSource(
			@RequestParam(value = "group_id", defaultValue = "DPTOPUPS") String groupId) {

		
		
		List<ProductList> list = dataAccessTypesServiceWithDataSource.getListByGroupIdViaJDBC(groupId);
		return list;
	}
	
	@RequestMapping("/jdbc/template")
	public List<ProductList> getByGroupIDWithTemplate(
			@RequestParam(value = "group_id", defaultValue = "DPTOPUPS") String groupId) {
		
		List<ProductList> list = dataAccessTypeJDBCTemplateDao.findByGroupId(groupId);
		return list;
	}
	
	
	@RequestMapping("/hibernate/simple")
	public List<ProductList> getByGroupIDWithSimpleHibernate(
			@RequestParam(value = "group_id", defaultValue = "DPTOPUPS") String groupId) {
		
		List<ProductList> list = dataAccessTypeHibernateService.getListByGroupId(groupId);
		return list;
	}
	
	
}
