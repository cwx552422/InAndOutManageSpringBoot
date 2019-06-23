package com.java.vo;

import java.sql.Date;

public class Rebill {
	private int reid;
	private Sell sell;
	private Admin admin;
	private int renum;
	private Date redate;
	public int getReid() {
		return reid;
	}
	public void setReid(int reid) {
		this.reid = reid;
	}
	public Sell getSell() {
		return sell;
	}
	public void setSell(Sell sell) {
		this.sell = sell;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public int getRenum() {
		return renum;
	}
	public void setRenum(int renum) {
		this.renum = renum;
	}
	public Date getRedate() {
		return redate;
	}
	public void setRedate(Date redate) {
		this.redate = redate;
	}
	@Override
	public String toString() {
		return "Rebill [reid=" + reid + ", sell=" + sell + ", admin=" + admin + ", renum=" + renum + ", redate="
				+ redate + "]";
	}
	public Rebill(int reid, Sell sell, Admin admin, int renum, Date redate) {
		super();
		this.reid = reid;
		this.sell = sell;
		this.admin = admin;
		this.renum = renum;
		this.redate = redate;
	}
	public Rebill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
