package com.qianjin.java.apacheLog;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class SimpleLog {

	public static void main(String[] args) {
		SimpleLog log=new SimpleLog();
		log.readFile();
	}

	public void readFile(){
		try{
			
			String fileName=	"C:/git-sourcecode/RestSample/src/main/resources/test-data/access_log";
			File file=new File(fileName);
			ArrayList list=(ArrayList)FileUtils.readLines(file, "utf-8");
			for(int i=0;i<list.size();i++){
				if(i==1) break;
				String line=(String)list.get(i);
				System.out.println(line);
				
				String newLine="";
				String ip="";
				String time="";
				String url="";
				String code="";
				
				ip=line.substring(0, line.indexOf(" - - "));
				System.out.println("ip="+ip);
				newLine=line.substring(line.indexOf("["));
				System.out.println("newLine="+newLine);
				time=newLine.substring(1, newLine.indexOf("]"));
				System.out.println("time="+time);
				
				
				url=StringUtils.substringBetween(line, "\"","\"");
				System.out.println("url="+url);
				
				
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
