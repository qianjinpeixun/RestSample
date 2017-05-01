package com.qianjin.java.soa.xml;

import java.io.File;
import java.io.*;

import javax.xml.bind.*;
import javax.xml.transform.stream.*;

import org.apache.commons.io.FileUtils;


public class SimpleJAXB {

	public static void main(String[] args) {
		try {
			JAXBContext jcon = JAXBContext.newInstance(Catalog.class);
			Unmarshaller unmarshaller = jcon.createUnmarshaller();
			String xml = FileUtils.readFileToString(new File("C:/git-sourcecode/RestSample/src/main/resources/test-data/books.xml"), "utf-8");
			StreamSource stream = new StreamSource(new StringReader(xml));
			Catalog catalog = (Catalog)unmarshaller.unmarshal(stream);
			System.out.println(catalog.getBooks());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
