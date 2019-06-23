package com.java.vo;

import java.sql.Date;

public class Sell {
  private int sid;
  private Medicine med;
  private Customer cust;
  private int sdocno;
  private int snum;
  private double spprice;
  private Date sdate;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public Medicine getMed() {
	return med;
}
public void setMed(Medicine med) {
	this.med = med;
}
public Customer getCust() {
	return cust;
}
public void setCust(Customer cust) {
	this.cust = cust;
}
public int getSdocno() {
	return sdocno;
}
public void setSdocno(int sdocno) {
	this.sdocno = sdocno;
}
public int getSnum() {
	return snum;
}
public void setSnum(int snum) {
	this.snum = snum;
}
public double getSpprice() {
	return spprice;
}
public void setSpprice(double spprice) {
	this.spprice = spprice;
}
public Date getSdate() {
	return sdate;
}
public void setSdate(Date sdate) {
	this.sdate = sdate;
}
@Override
public String toString() {
	return "Sell [sid=" + sid + ", med=" + med + ", cust=" + cust + ", sdocno=" + sdocno + ", snum=" + snum
			+ ", spprice=" + spprice + ", sdate=" + sdate + "]";
}
public Sell() {
	super();
	// TODO Auto-generated constructor stub
}
public Sell(int sid, Medicine med, Customer cust, int sdocno, int snum, double spprice, Date sdate) {
	super();
	this.sid = sid;
	this.med = med;
	this.cust = cust;
	this.sdocno = sdocno;
	this.snum = snum;
	this.spprice = spprice;
	this.sdate = sdate;
}
  
  
}
