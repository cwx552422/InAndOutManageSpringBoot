package com.java.vo;

import java.sql.Date;

public class Inventory {
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int inid;
	private int inDocNo;
	private float inPrice;
	private int inNum;
	private Date inTime;
	private String state;
	private Medicine med;
	private Provider pro;
	public int getInid() {
		return inid;
	}
	public void setInid(int inid) {
		this.inid = inid;
	}
	public int getInDocNo() {
		return inDocNo;
	}
	public void setInDocNo(int inDocNo) {
		this.inDocNo = inDocNo;
	}
	public float getInPrice() {
		return inPrice;
	}
	public void setInPrice(float inPrice) {
		this.inPrice = inPrice;
	}
	public int getInNum() {
		return inNum;
	}
	public void setInNum(int inNum) {
		this.inNum = inNum;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public Medicine getMed() {
		return med;
	}
	public void setMed(Medicine med) {
		this.med = med;
	}
	public Provider getPro() {
		return pro;
	}
	public void setPro(Provider pro) {
		this.pro = pro;
	}
	@Override
	public String toString() {
		return "Inventory [inid=" + inid + ", inDocNo=" + inDocNo + ", inPrice=" + inPrice + ", inNum=" + inNum
				+ ", inTime=" + inTime + ", state=" + state + ", med=" + med
				+ ", pro=" + pro + "]";
	}
	public Inventory(int inid, int inDocNo, float inPrice, int inNum, Date inTime, String state, int mid, int proid,
			Medicine med, Provider pro) {
		super();
		this.inid = inid;
		this.inDocNo = inDocNo;
		this.inPrice = inPrice;
		this.inNum = inNum;
		this.inTime = inTime;
		this.state = state;
		
		this.med = med;
		this.pro = pro;
	}
	
	
}
