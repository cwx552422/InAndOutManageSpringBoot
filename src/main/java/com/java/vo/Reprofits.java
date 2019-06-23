package com.java.vo;

public class Reprofits {
	private int mid;
	private int renum;
	private double reprofits;
	
	public Reprofits() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reprofits(int mid, int renum, double reprofits) {
		super();
		this.mid = mid;
		this.renum = renum;
		this.reprofits = reprofits;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getRenum() {
		return renum;
	}

	public void setRenum(int renum) {
		this.renum = renum;
	}

	public double getReprofits() {
		return reprofits;
	}

	public void setReprofits(double reprofits) {
		this.reprofits = reprofits;
	}

	@Override
	public String toString() {
		return "Reprofits [mid=" + mid + ", renum=" + renum + ", reprofits=" + reprofits + "]";
	}
	
}
