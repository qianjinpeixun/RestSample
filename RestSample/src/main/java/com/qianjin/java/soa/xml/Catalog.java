package com.qianjin.java.soa.xml;

import java.util.*;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "catalog")
@XmlAccessorType(XmlAccessType.FIELD)
public class Catalog {

	@Override
	public String toString() {
		return "Catalog [books=" + books + "]";
	}

	@XmlElement(name = "book")
	private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}




}
