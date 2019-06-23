package com.java.vo;

import java.sql.Date;

public class Purchase {
	private int mid;
	private String mname;
	private String validdate;
	private int tinnum;
	private int tsnum;
	private int cnum;
	private int cdate;
	private Date prodate;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getValiddate() {
		return validdate;
	}
	public void setValiddate(String validdate) {
		this.validdate = validdate;
	}
	public int getTinnum() {
		return tinnum;
	}
	public void setTinnum(int tinnum) {
		this.tinnum = tinnum;
	}
	public int getTsnum() {
		return tsnum;
	}
	public void setTsnum(int tsnum) {
		this.tsnum = tsnum;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public int getCdate() {
		return cdate;
	}
	public void setCdate(int cdate) {
		this.cdate = cdate;
	}
	public Date getProdate() {
		return prodate;
	}
	public void setProdate(Date prodate) {
		this.prodate = prodate;
	}
	@Override
	public String toString() {
		return "Purchase [mid=" + mid + ", mname=" + mname + ", validdate=" + validdate + ", tinnum=" + tinnum
				+ ", tsnum=" + tsnum + ", cnum=" + cnum + ", cdate=" + cdate + ", prodate=" + prodate + "]";
	}
	public Purchase(int mid, String mname, String validdate, int tinnum, int tsnum, int cnum, int cdate, Date prodate) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.validdate = validdate;
		this.tinnum = tinnum;
		this.tsnum = tsnum;
		this.cnum = cnum;
		this.cdate = cdate;
		this.prodate = prodate;
	}
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
