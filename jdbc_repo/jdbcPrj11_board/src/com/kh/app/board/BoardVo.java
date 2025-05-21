package com.kh.app.board;

public class BoardVo {

	private String no;
	private String title;
	private String content;
	private String insertDate;
	private String delYn;
	
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BoardVo(String no, String title, String content, String insertDate, String delYn) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.insertDate = insertDate;
		this.delYn = delYn;
	}
	
	//getter&setter
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	
	//toString
	@Override
	public String toString() {
		return "no : " + no + " | title : " + title + " | content : " + content + " | insertDate : " + insertDate
				+ " | delYn=" + delYn + "\n";
	}
	
}

//ctrl + shift + y
