package com.kh.app.book;

public class BookVo {
	private String no;
	private String title;
	private String author;
	private String price;
	private String published_date;
	private String del_yn;
	
	public BookVo() {
		super();
	}

	public BookVo(String no, String title, String author, String price, String published_date, String del_yn) {
		super();
		this.no = no;
		this.title = title;
		this.author = author;
		this.price = price;
		this.published_date = published_date;
		this.del_yn = del_yn;
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

	public String getPublished_date() {
		return published_date;
	}

	public void setPublished_date(String published_date) {
		this.published_date = published_date;
	}

	public String getDel_yn() {
		return del_yn;
	}

	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}

	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", author=" + author + ", price=" + price + ", published_date="
				+ published_date + ", del_yn=" + del_yn + "]";
	}
	
	
}


