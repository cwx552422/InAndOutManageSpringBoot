package com.java.dao;

import org.apache.ibatis.annotations.Select;

import com.java.vo.Customer;

public interface CustomerDao {
	@Select("select * from Customer where cid=#{cid}")
	public Customer cust();
}
