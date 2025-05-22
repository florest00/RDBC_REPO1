package com.kh.app.book;

public class BookVo {
	
	private String no;
	private String title;
	private String author;
	private String price;
	private String publishedDate;
	private String delYn;
	public BookVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookVo(String no, String title, String author, String price, String publishedDate, String delYn) {
		super();
		this.no = no;
		this.title = title;
		this.author = author;
		this.price = price;
		this.publishedDate = publishedDate;
		this.delYn = delYn;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", author=" + author + ", price=" + price + ", publishedDate="
				+ publishedDate + ", delYn=" + delYn + "]";
	}
	
	

}
