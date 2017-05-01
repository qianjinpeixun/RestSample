package com.qianjin.java.soa.gson;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;

public class SimpleJson {

	public static void main(String[] args){
		try{
			
			Gson gson=new Gson();
			String xml = FileUtils.readFileToString(new File("C:/git-sourcecode/RestSample/src/main/resources/test-data/friends.json"), "utf-8");
			Friends f=gson.fromJson(xml, Friends.class);
			System.out.println(f.getUsers().get(0));
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
