package com.java.vo;

public class Provider {
	private int proid;
	private String proName;
	private String proSite;
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProSite() {
		return proSite;
	}
	public void setProSite(String proSite) {
		this.proSite = proSite;
	}
	@Override
	public String toString() {
		return "Provider [proid=" + proid + ", proName=" + proName + ", proSite=" + proSite + "]";
	}
	public Provider(int proid, String proName, String proSite) {
		super();
		this.proid = proid;
		this.proName = proName;
		this.proSite = proSite;
	}
	public Provider() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
