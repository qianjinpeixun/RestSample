package com.qianjin.java.soa.rest;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qianjin.java.soa.hibernate.direct.ProductListServiceHibernate;
import com.qianjin.java.soa.hibernate.jpa.ProductListServiceHibernateJPA;
import com.qianjin.java.soa.hibernate.jpa2.ProductListServiceHibernateJPA2;
import com.qianjin.java.soa.hibernate.springdata.PorductListRepository;
import com.qianjin.java.soa.jdbc.datasource.*;
import com.qianjin.java.soa.jdbc.dbutils.ProductListDAODbUtils;
import com.qianjin.java.soa.jdbc.direct.ProductListDAOViaJDBC;
import com.qianjin.java.soa.jdbc.template.ProductListWithJDBCTemplate;
import com.qianjin.java.soa.model.ProductList;
import com.qianjin.java.soa.model.ProductListPOJO;


@RestController
public class ProductListRest {

	@Autowired
	ProductListDAOWithDataSource dataAccessTypesServiceWithDataSource;
	
	@Autowired
	ProductListWithJDBCTemplate dataAccessTypeJDBCTemplateDao;
	
	
	@Autowired
	ProductListServiceHibernate dataAccessTypeHibernateService;
	
	@Autowired
	ProductListServiceHibernateJPA productListServiceHibernateJPA;
	
	@Autowired
	ProductListServiceHibernateJPA2 productListServiceHibernateJPA2;
	
	@Autowired
	PorductListRepository porductListRepository;
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
	
	
	@RequestMapping("/hibernate/jpa")
	public List<ProductList> getByGroupIDWithSimpleHibernateJPA(
			@RequestParam(value = "group_id", defaultValue = "DPTOPUPS") String groupId) {
		
		List<ProductList> list = productListServiceHibernateJPA.getListByGroupIdViaJPA(groupId);
		return list;
	}
	
	@RequestMapping("/hibernate/jpa2")
	public List<ProductList> getByGroupIDWithSimpleHibernateJPA2(
			@RequestParam(value = "group_id", defaultValue = "DPTOPUPS") String groupId) {
		
		List<ProductList> list = productListServiceHibernateJPA2.getListByGroupIdViaJPA(groupId);
		return list;
	}
	
	@RequestMapping("/hibernate/springdata")
	public List<ProductListPOJO> getByGroupIDWithSimpleHibernateSrpingData(
			@RequestParam(value = "group_id", defaultValue = "DPTOPUPS") String groupId) {
		
		List<ProductListPOJO> list = porductListRepository.findByGroupId(groupId);
				
		return list;
	}
	
	
}
