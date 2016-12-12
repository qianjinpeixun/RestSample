package com.qianjin.java.soa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qianjin.java.soa.algorithm.distinct.FindNewErrors;
import com.qianjin.java.soa.jdbc.dbutils.ProductListDAODbUtils;
import com.qianjin.java.soa.ldap.LdapAccess;
import com.qianjin.java.soa.model.ProductList;

@RestController
public class LdapRest {

	@Autowired
	LdapAccess ldapAccess;
	
	@RequestMapping("/ldap/getUser")
	public String findUser() {

		return ldapAccess.getUserName();
	}
	
}
