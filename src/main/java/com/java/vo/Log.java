package com.java.vo;

import java.util.Date;


public class Log {
	private int lid;
	private Admin admin;
	private int operatorid;
	private String record;
	private Date time;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public int getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(int operatorid) {
		this.operatorid = operatorid;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Log [lid=" + lid + ", admin=" + admin + ", operatorid=" + operatorid + ", record=" + record + ", time="
				+ time + "]";
	}

	public Log(int lid, Admin admin, int operatorid, String record, Date time) {
		super();
		this.lid = lid;
		this.admin = admin;
		this.operatorid = operatorid;
		this.record = record;
		this.time = time;
	}

	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}

}
