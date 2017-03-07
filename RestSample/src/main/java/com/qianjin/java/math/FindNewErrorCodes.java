package com.qianjin.java.math;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;

import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindNewErrorCodes {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private final String base_path = "C:/work/deployment/logs/prod/error_msg/";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindNewErrorCodes ff = new FindNewErrorCodes();
		HashMap map=ff.getAllErrorCodes();
		HashSet set=ff.getAllNewErrorCodes();
		Iterator ver=set.iterator();
		while(ver.hasNext()){
			String code=(String)ver.next();
			String msg=(String)map.get(code);
			System.out.println(code);
			System.out.println(msg);
			System.out.println();
			
			
		}
	}

	
	private HashSet getAllNewErrorCodes(){
		HashSet set=new HashSet();
		;
		
		File file = new File(base_path);
		File[] files = file.listFiles();
		try {

			for (File ff : files) {
				FileInputStream input = new FileInputStream(ff);
				InputStreamReader xover;
				if (ff.getName().contains(".gz")) {
					GZIPInputStream gzis;

					gzis = new GZIPInputStream(input);
					xover = new InputStreamReader(gzis);

				} else {
					input = new FileInputStream(ff);
					xover = new InputStreamReader(input);
				}
				LineIterator line = new LineIterator(xover);
				while (line.hasNext()) {
					String ss = (String) line.next();
					if(ss.contains("Code not found with mindError:")){
						String code=StringUtils.substringBetween(ss, "Code not found with mindError:", " ,");
						set.add(code.trim());
					}
					
				}
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}
	
	private HashMap getAllErrorCodes() {
		HashMap map = new HashMap();
		
		File file = new File(base_path);
		File[] files = file.listFiles();

		try {

			for (File ff : files) {
				FileInputStream input = new FileInputStream(ff);
				InputStreamReader xover;
				if (ff.getName().contains(".gz")) {
					GZIPInputStream gzis;

					gzis = new GZIPInputStream(input);
					xover = new InputStreamReader(gzis);

				} else {
					input = new FileInputStream(ff);
					xover = new InputStreamReader(input);
				}
				LineIterator line = new LineIterator(xover);
				HashSet set = new HashSet();
				while (line.hasNext()) {
					String ss = (String) line.next();
					if (ss.contains("MINDResponse Error Message is:")) {
						String msg = StringUtils.substringBetween(ss, "MINDResponse Error Message is:",
								",MINDErrorCode is:");
						String code = StringUtils.substringBetween(ss, ",MINDErrorCode is:", ",defaultLang is");
						if(code==null){
							//logger.info(ss);
						}
						if(code!=null)
						map.put(code.trim(), msg);
						// System.out.println(ss);
						
					}
				}
				

			}
			Iterator ver = map.entrySet().iterator();
			while (ver.hasNext()) {
				Entry entry=(Entry)ver.next();
				String key=(String)entry.getKey();
				String value=(String)entry.getValue();
				//logger.info("key="+key+",value="+value);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("map.size=" + map.size());
		return map;
	}

	

}
