package com.qianjin.java.soa.xml;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

	@XmlAttribute
	private String id;
	@XmlElement
	private String author;
	@XmlElement
	private String title;
	@XmlElement
	private String genre;
	@XmlElement
	private double price;
	@XmlElement
	private String publish_date;
	@XmlElement
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title + ", genre=" + genre + ", price=" + price + ", publish_date=" + publish_date + ", description="
				+ description + "]";
	}

}
