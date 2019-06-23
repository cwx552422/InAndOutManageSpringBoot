package com.java.vo;

public class Admin {
	private int uid;
	private String uname;
	private String upd;
	private String tel;
	private String role;	
	private String img;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpd() {
		return upd;
	}
	public void setUpd(String upd) {
		this.upd = upd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Admin [uid=" + uid + ", uname=" + uname + ", upd=" + upd + ", tel=" + tel + ", role=" + role + ", img="
				+ img + "]";
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int uid, String uname, String upd, String tel, String role, String img) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upd = upd;
		this.tel = tel;
		this.role = role;
		this.img = img;
	}
}