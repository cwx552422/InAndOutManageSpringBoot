package com.java.dao;

import org.apache.ibatis.annotations.Select;

import com.java.vo.Provider;

public interface ProviderDao {
	@Select("select * from provider where proid=#{proid}")
	public Provider pro();
}
