package com.qianjin.java.math.csci3421.assignment3;

import org.apache.tomcat.util.codec.binary.Base64;

public class BaseTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String user_name = "qianjincanada@gmail.com";
		String user_password = "1977Qwert";
		
		String base_user_name="";
		String base_password="";
		
		base_user_name=Base64.encodeBase64String(user_name.getBytes());
		base_password=Base64.encodeBase64String(user_password.getBytes());
		
		System.out.println(base_user_name);
		
		System.out.println(base_password);
		
	}

}
