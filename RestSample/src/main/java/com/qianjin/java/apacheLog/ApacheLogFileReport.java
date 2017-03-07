package com.qianjin.java.apacheLog;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class ApacheLogFileReport {

	private static int getCount(String url, ArrayList list) {


		int ret = 0;
		for (int i = 0; i < list.size(); i++) {
			ApacheLogFile apacheLogFile = (ApacheLogFile) list.get(i);
			// System.out.println(apacheLogFile);
			if (StringUtils.isBlank(apacheLogFile.getUrl()))
				continue;
			if (url.toLowerCase().equals(apacheLogFile.getUrl().toLowerCase()))
				ret++;
		}
		return ret;
	}

	public static void main(String[] args) {
		try {
			List list = FileUtils
					.readLines(new File("C:/git-sourcecode/RestSample/src/main/resources/test-data/access_log"));
			ArrayList apacheLoglist = new ArrayList();
			for (int i = 0; i < list.size(); i++) {
				String line = (String) list.get(i);
				String url = StringUtils.substringBetween(line, "GET ", " HTTP");
				// System.out.println(url);
				ApacheLogFile apacheLogFile = new ApacheLogFile();
				apacheLogFile.setUrl(url);
				apacheLoglist.add(apacheLogFile);
			}

			int[] countNumberOfEachUrl = new int[apacheLoglist.size()];
			for (int i = 0; i < apacheLoglist.size(); i++) {
				ApacheLogFile apacheLogFile = (ApacheLogFile) apacheLoglist.get(i);
				String url = apacheLogFile.getUrl();
				if (StringUtils.isBlank(url))
					countNumberOfEachUrl[i] = 0;
				else
					countNumberOfEachUrl[i] = getCount(url, apacheLoglist);
			}

			System.out.println(Arrays.toString(countNumberOfEachUrl));

			int bigestNumber = 0;
			int index = 0;
			for (int i = 0; i < list.size(); i++) {
				if (countNumberOfEachUrl[i] > bigestNumber) {
					bigestNumber = countNumberOfEachUrl[i];
					index = i;
				}

			}
			ApacheLogFile apacheLogFile = (ApacheLogFile) apacheLoglist.get(index);
			System.out.println("Bigest number of url is:" + apacheLogFile.getUrl() + ", count=" + bigestNumber);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
