package com.java.vo;

public class TotalProfitsStatitics {
	private int tsnum;
	private int tinnum;
	private double tsprice;
	private double tinprice;
	private double tprofits;
	public int getTsnum() {
		return tsnum;
	}
	public void setTsnum(int tsnum) {
		this.tsnum = tsnum;
	}
	public int getTinnum() {
		return tinnum;
	}
	public void setTinnum(int tinnum) {
		this.tinnum = tinnum;
	}
	public double getTsprice() {
		return tsprice;
	}
	public void setTsprice(double tsprice) {
		this.tsprice = tsprice;
	}
	public double getTinprice() {
		return tinprice;
	}
	public void setTinprice(double tinprice) {
		this.tinprice = tinprice;
	}
	public double getTprofits() {
		return tprofits;
	}
	public void setTprofits(double tprofits) {
		this.tprofits = tprofits;
	}
	@Override
	public String toString() {
		return "TotalProfitsStatitics [tsnum=" + tsnum + ", tinnum=" + tinnum + ", tsprice=" + tsprice + ", tinprice="
				+ tinprice + ", tprofits=" + tprofits + "]";
	}
	public TotalProfitsStatitics() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
