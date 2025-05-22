package com.kh.app.student;

public class StudentVo {
	
	private String no;
	private String name;
	private String score;
	private String gender;
	private String enrollDate;
	private String delYn;
	public StudentVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentVo(String no, String name, String score, String gender, String enrollDate, String delYn) {
		super();
		this.no = no;
		this.name = name;
		this.score = score;
		this.gender = gender;
		this.enrollDate = enrollDate;
		this.delYn = delYn;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	@Override
	public String toString() {
		return "StudentVo [no=" + no + ", name=" + name + ", score=" + score + ", gender=" + gender + ", enrollDate="
				+ enrollDate + ", delYn=" + delYn + "]";
	}
	
	

}


//no
//name
//score
//gender
//enrollDate
//delYn