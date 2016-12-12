package com.qianjin.java.soa.algorithm.distinct;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;

import org.apache.commons.io.LineIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class FindNewErrors {

	@Autowired
    private ResourceLoader resourceLoader;
	
	
	
	public String test(){
		String ret="";
		Resource resource=resourceLoader.getResource("classpath:test-data/server_errors.log.gz");
		try {
			GZIPInputStream gzis = new GZIPInputStream(resource.getInputStream());
			InputStreamReader xover = new InputStreamReader(gzis);
			LineIterator line = new LineIterator(xover);
			HashSet set=new HashSet();
			while (line.hasNext()) {
				String ss = (String) line.next();
				if(ss.contains(" ERROR ") && !ss.contains("Not found in localDatabase,service_code=")){
					//System.out.println(ss);
					set.add(ss);
				}
			}
			Iterator ver=set.iterator();
			while(ver.hasNext()){
				String ss=(String)ver.next();
				System.out.println(ss);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fileName=resource.getFilename();
		
		System.out.println(fileName);
		ret=fileName;
		return ret;
	}

}
