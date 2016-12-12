package com.qianjin.java.soa.ldap;

import org.springframework.stereotype.Service;

@Service
public class LdapAccess {

	public String getUserName(){
		String ret="";
		ret=System.getProperty("user.name");
		return ret;
	}
}
