package com.kh.app.jellies;

public class JelliesVo {
	
	private String no;
	private String flavor;
	private String price;
	private String mfg;
	private String delYn;
	public JelliesVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JelliesVo(String no, String flavor, String price, String mfg, String delYn) {
		super();
		this.no = no;
		this.flavor = flavor;
		this.price = price;
		this.mfg = mfg;
		this.delYn = delYn;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMfg() {
		return mfg;
	}
	public void setMfg(String mfg) {
		this.mfg = mfg;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	@Override
	public String toString() {
		return "JelliesVo [no=" + no + ", flavor=" + flavor + ", price=" + price + ", mfg=" + mfg + ", delYn=" + delYn
				+ "]";
	}
	
	

}
