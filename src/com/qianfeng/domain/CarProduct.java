package com.qianfeng.domain;

public class CarProduct {
	/*`pid` varchar(255) DEFAULT NULL,
	  `pimage` varchar(255) DEFAULT NULL,
	  `pname` varchar(255) DEFAULT NULL,
	  `shop_price` double DEFAULT NULL*/
	private String pid;
	private String pimage;
	private String pname;
	private double shop_price;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getShop_price() {
		return shop_price;
	}
	public void setShop_price(double shop_price) {
		this.shop_price = shop_price;
	}
	public CarProduct() {
		super();
	}
	
}
