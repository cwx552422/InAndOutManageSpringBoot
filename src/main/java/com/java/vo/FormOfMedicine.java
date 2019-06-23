package com.java.vo;

public class FormOfMedicine {
	private int fid;
	private String fmedicine;
	private Medicine med;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFmedicine() {
		return fmedicine;
	}
	public void setFmedicine(String fmedicine) {
		this.fmedicine = fmedicine;
	}
	public Medicine getMed() {
		return med;
	}
	public void setMed(Medicine med) {
		this.med = med;
	}
	@Override
	public String toString() {
		return "FormOfMedicine [fid=" + fid + ", fmedicine=" + fmedicine + ", med=" + med + "]";
	}
	public FormOfMedicine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FormOfMedicine(int fid, String fmedicine, Medicine med) {
		super();
		this.fid = fid;
		this.fmedicine = fmedicine;
		this.med = med;
	}
	
	
}

