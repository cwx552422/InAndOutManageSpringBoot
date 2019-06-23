package com.java.vo;

public class Inprofits {
	private int mid;
	private Medicine med;
	private double inprice;
	private int innum;
	public Medicine getMed() {
		return med;
	}
	public void setMed(Medicine med) {
		this.med = med;
	}

	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public double getInprice() {
		return inprice;
	}
	public void setInprice(double inprice) {
		this.inprice = inprice;
	}
	public int getInnum() {
		return innum;
	}
	public void setInnum(int innum) {
		this.innum = innum;
	}
	@Override
	public String toString() {
		return "Inprofits [mid=" + mid + ", mname=" + med + ", inprice=" + inprice + ", innum=" + innum + "]";
	}
	public Inprofits(int mid,Medicine med, double inprice, int innum) {
		super();
		this.mid = mid;
		this.med = med;
		this.inprice = inprice;
		this.innum = innum;
	}
	public Inprofits() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
