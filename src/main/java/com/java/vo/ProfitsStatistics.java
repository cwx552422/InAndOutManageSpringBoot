package com.java.vo;

public class ProfitsStatistics {
	private int mid;
	private String mname;
	private int snum;
	private int innum;
	private int renum;
	private double sprice;
	private double inprice;
	private double profits;
	private double spp;
	private double inpp;
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
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public int getInnum() {
		return innum;
	}
	public void setInnum(int innum) {
		this.innum = innum;
	}
	public int getRenum() {
		return renum;
	}
	public void setRenum(int renum) {
		this.renum = renum;
	}
	public double getSprice() {
		return sprice;
	}
	public void setSprice(double sprice) {
		this.sprice = sprice;
	}
	public double getInprice() {
		return inprice;
	}
	public void setInprice(double inprice) {
		this.inprice = inprice;
	}
	public double getProfits() {
		return profits;
	}
	public void setProfits(double profits) {
		this.profits = profits;
	}
	public double getSpp() {
		return spp;
	}
	public void setSpp(double spp) {
		this.spp = spp;
	}
	public double getInpp() {
		return inpp;
	}
	public void setInpp(double inpp) {
		this.inpp = inpp;
	}
	@Override
	public String toString() {
		return "ProfitsStatistics [mid=" + mid + ", mname=" + mname + ", snum=" + snum + ", innum=" + innum + ", renum="
				+ renum + ", sprice=" + sprice + ", inprice=" + inprice + ", profits=" + profits + ", spp=" + spp
				+ ", inpp=" + inpp + "]";
	}
	public ProfitsStatistics(int mid, String mname, int snum, int innum, int renum, double sprice, double inprice,
			double profits, double spp, double inpp) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.snum = snum;
		this.innum = innum;
		this.renum = renum;
		this.sprice = sprice;
		this.inprice = inprice;
		this.profits = profits;
		this.spp = spp;
		this.inpp = inpp;
	}
	public ProfitsStatistics() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
