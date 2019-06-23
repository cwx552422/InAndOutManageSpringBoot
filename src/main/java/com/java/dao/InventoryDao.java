package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.java.vo.Inventory;
import com.java.vo.InventoryStatistics;
import com.java.vo.Medicine;
import com.java.vo.Provider;

public interface InventoryDao {
//	@Select("select * from (select a.*,rownum rn from inventory a where rownum<=#{1}) where rn>#{0}")
//	@Results({
//		@Result(property = "med", column = "mid", one = @One(select = "com.java.mapper.MedicineMapper.med")),
//		@Result(property = "pro", column = "proid", one = @One(select = "com.java.mapper.ProviderMapper.pro"))
//	})
	public List<Inventory> inMed(int strpage, int endpage);
	
	@Select("select count(*) from inventory")
	public int allPage();
	
	@Select("SELECT TO_CHAR(T.intime,'MM') tdate,sum(T.inprice*T.innum) tprice,sum(T.innum) tnum " + 
			"FROM inventory T WHERE TO_CHAR(T.intime,'YYYY') = TO_CHAR(to_date(#{year},'YYYY'),'YYYY') " + 
			"GROUP BY TO_CHAR(T.intime,'MM') " + 
			"ORDER BY TO_CHAR(T.intime,'MM') ASC NULLS  LAST")
	public List<InventoryStatistics> bymonth(String year);
	
	@Select("select * from (select a.*,rownum rn from inventory a) ")
	@Results({
		@Result(property = "med", column = "mid", one = @One(select = "com.java.mapper.MedicineMapper.med")),
		@Result(property = "pro", column = "proid", one = @One(select = "com.java.mapper.ProviderMapper.pro"))
	})
	public List<Inventory> listExcelMessage();
	
	@Select("select * from medicine")
	public List<Medicine> medicineName();
	
	@Select("select * from provider")
	public List<Provider> proName();
	
	@Insert("insert into inventory values(inseq.nextval,indocseq.nextval,#{inPrice},#{innum},to_date(#{inTime},'yyyy-mm-dd'),#{proid},#{mid},'����')")
	public boolean addInventoryMsg(@Param(value = "inPrice") double inPrice,@Param(value = "innum") int innum,@Param(value = "inTime") String inTime,@Param(value = "proid") int proid,@Param(value = "mid") int mid);
	@Select("select mid from medicine where mname=#{mname}")
	public int mid(String mname);
	
	@Select("select proid from provider where proname=#{proname}")
	public int proid(String proname);
	
	
	public List<Inventory> inmedicineMesageLike(@Param("mname") String mname,@Param("fmedname") String fmedname);
}
