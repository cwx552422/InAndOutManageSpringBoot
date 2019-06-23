package com.java.vo;

public class InventoryStatistics {
	private String tdate;
	private float tprice;
	private int tnum;
	public String getTdate() {
		return tdate;
	}
	public void setTdate(String tdate) {
		this.tdate = tdate;
	}
	public float getTprice() {
		return tprice;
	}
	public void setTprice(float tprice) {
		this.tprice = tprice;
	}
	public int getTnum() {
		return tnum;
	}
	public void setTnum(int tnum) {
		this.tnum = tnum;
	}
	@Override
	public String toString() {
		return "InventoryStatistics [tdate=" + tdate + ", tprice=" + tprice + ", tnum=" + tnum + "]";
	}
	public InventoryStatistics(String tdate, float tprice, int tnum) {
		super();
		this.tdate = tdate;
		this.tprice = tprice;
		this.tnum = tnum;
	}
	public InventoryStatistics() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
