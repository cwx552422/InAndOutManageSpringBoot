package com.java.vo;

import java.sql.Date;

public class Medicine {
	private int mid;
	private String mname;
	private String units;
	private String manufacture;
	private Date proDate;
	private String validDate;
	private FormOfMedicine fmedicine;
	private String description;
	private int fid;
	@Override
	public String toString() {
		return "Medicine [mid=" + mid + ", mname=" + mname + ", units=" + units + ", manufacture=" + manufacture
				+ ", proDate=" + proDate + ", validDate=" + validDate + ", fmedicine=" + fmedicine + ", description="
				+ description + ", fid=" + fid + "]";
	}
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
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public Date getProDate() {
		return proDate;
	}
	public void setProDate(Date proDate) {
		this.proDate = proDate;
	}
	public String getValidDate() {
		return validDate;
	}
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	public FormOfMedicine getFmedicine() {
		return fmedicine;
	}
	public void setFmedicine(FormOfMedicine fmedicine) {
		this.fmedicine = fmedicine;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public Medicine(int mid, String mname, String units, String manufacture, Date proDate, String validDate,
			FormOfMedicine fmedicine, String description, int fid) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.units = units;
		this.manufacture = manufacture;
		this.proDate = proDate;
		this.validDate = validDate;
		this.fmedicine = fmedicine;
		this.description = description;
		this.fid = fid;
	}
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
	