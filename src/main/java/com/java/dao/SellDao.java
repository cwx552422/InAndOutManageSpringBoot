package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.java.vo.Inprofits;
import com.java.vo.Medicine;
import com.java.vo.Rebill;
import com.java.vo.Reprofits;
import com.java.vo.Sell;
import com.java.vo.Sellprofits;

public interface SellDao {
//	ҩƷ������Ϣ��ѯ
	/*@Select("select * from (select a.*,rownum rn from sell a where rownum<=#{1}) where rn>#{0}")
	@Results({
		@Result(property = "med", column = "mid", one = @One(select = "com.java.mapper.MedicineMapper.med")),
		@Result(property = "cust", column = "cid", one = @One(select = "com.java.mapper.CustomerMapper.cust"))
	})*/
	public List<Sell> sellMed(int strpage, int endpage);
	public List<Sell> semedicineMesageLike(@Param("mname") String mname,@Param("fmedname") String fmedname);
	@Select("select count(*) from sell")
	public int allPage();
	
	@Select("select * from sell where sid=#{sid}")
	public Sell sell();
	
	
//	�����˵���ѯ
//	@Select("select * from (select a.*,rownum rn from rebill a where rownum<=#{1}) where rn>#{0}")
//	@Results({
//		@Result(property = "sell", column = "sid", one = @One(select = "com.java.mapper.SellMapper.sell")),
//		@Result(property = "admin", column = "uid", one = @One(select = "com.java.mapper.AdminMapper.admin"))
//	})
	public List<Rebill> rebill(int strpage, int endpage);
	
	@Select("select count(*) from rebill")
	public int reallPage();
	
//	����ͳ��
	@Select("select * from(\r\n" + 
			"select mid,sum(innum*inprice) \"inprice\",sum(innum) \"innum\" from inventory  group by mid order by mid) ")
	@Results({
		@Result(property = "med", column = "mid", one = @One(select = "com.java.mapper.SellMapper.mlist")),
	})
	public List<Inprofits> inprofits();
	@Select("select mid,sum(snum*spprice) \"sellProfits\",sum(snum) \"sellNum\" from sell group by mid order by mid")
	public List<Sellprofits> sellprofits();
	@Select("select s.mid,sum(re.renum) \"renum\",sum(re.renum*s.spprice) \"reprofits\" from rebill re,sell s where s.sid=re.sid group by s.mid order by s.mid")
	public List<Reprofits> reprofits();
	@Select("select * from medicine where mid=#{mid}")
	public List<Medicine> mlist();
	
	@Select("select * from (select a.*,rownum rn from sell a )")
	@Results({
		@Result(property = "med", column = "mid", one = @One(select = "com.java.mapper.MedicineMapper.med")),
		@Result(property = "cust", column = "cid", one = @One(select = "com.java.mapper.CustomerMapper.cust"))
	})
	public List<Sell> sellMedExcel();
	
//	@Select("select * from (select a.*,rownum rn from rebill a )")
//	@Results({
//		@Result(property = "sell", column = "sid", one = @One(select = "com.java.mapper.SellMapper.sell")),
//		@Result(property = "admin", column = "uid", one = @One(select = "com.java.mapper.AdminMapper.admin"))
//	})
	public List<Rebill> rebillExcel();
	
	public List<Sell> quryLiekListSell(@Param("mname") String mname,@Param("fmedname") String fmedname);
}
