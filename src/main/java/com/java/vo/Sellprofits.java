package com.java.vo;

public class Sellprofits {
	private int mid;
	private double sellProfits;
	private int sellNum;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public double getSellProfits() {
		return sellProfits;
	}
	public void setSellProfits(double sellProfits) {
		this.sellProfits = sellProfits;
	}
	public int getSellNum() {
		return sellNum;
	}
	public void setSellNum(int sellNum) {
		this.sellNum = sellNum;
	}
	@Override
	public String toString() {
		return "Sellprofits [mid=" + mid + ", sellProfits=" + sellProfits + ", sellNum=" + sellNum + "]";
	}
	public Sellprofits() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sellprofits(int mid, double sellProfits, int sellNum) {
		super();
		this.mid = mid;
		this.sellProfits = sellProfits;
		this.sellNum = sellNum;
	}
	
}
