package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.java.vo.Purchase;

public interface PurchaseDao {
	
//	���ͳ��
	@Select("select mm.mid,mm.mname,mm.VALIDDATE,mm.prodate,sum(ids.innum) \"tinnum\",sum(s.snum) \"tsnum\",sum(ids.innum-s.snum) \"cnum\" from medicine mm,inventory ids,sell s where mm.mid=ids.mid and mm.mid=s.mid group by mm.mid,mm.mname,mm.VALIDDATE,mm.prodate order by mm.mid")
	public List<Purchase> purchase();
	@Select("select mm.mid,mm.mname,mm.VALIDDATE,mm.prodate,sum(ids.innum) \"tinnum\",sum(s.snum) \"tsnum\",sum(ids.innum-s.snum) \"cnum\" from medicine mm,inventory ids,sell s where mm.mid=ids.mid and mm.mid=s.mid and mm.mname like concat(concat('%',#{mname}),'%') group by mm.mid,mm.mname,mm.VALIDDATE,mm.prodate order by mm.mid")
	public List<Purchase> purLikeMed(@Param(value = "mname") String mname);
}
