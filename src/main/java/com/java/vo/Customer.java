package com.java.vo;

public class Customer {
	private int cid;
	private String cname;
	private String csite;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCsite() {
		return csite;
	}
	public void setCsite(String csite) {
		this.csite = csite;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cid;
		result = prime * result + ((cname == null) ? 0 : cname.hashCode());
		result = prime * result + ((csite == null) ? 0 : csite.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (cid != other.cid)
			return false;
		if (cname != other.cname)
			return false;
		if (csite == null) {
			if (other.csite != null)
				return false;
		} else if (!csite.equals(other.csite))
			return false;
		return true;
	}
	public Customer(int cid, String cname, String csite) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.csite = csite;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
