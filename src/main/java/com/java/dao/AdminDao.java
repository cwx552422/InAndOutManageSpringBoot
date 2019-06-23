package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.java.vo.Admin;

public interface AdminDao {
	@Select("select * from admin where uname=#{uname} and upd=#{upd}")
	public Admin adminLogin(Admin a) throws Exception;
	@Select("select * from (select a.*,rownum rn from admin a where rownum<=#{1} order by a.\"uid\" ) where rn>#{0}")
	public List<Admin> adminMessage(int strpage,int endpage);
	@Select("select count(*) from admin")
	public int allpage();
	@Select("select * from admin where \"uid\"=#{uid}")//���ϲ�ѯ
	public Admin admin();
	@Select("select * from admin where \"uid\"=#{uid} ")//����ģ����ѯ
	public Admin adminlike();
	@Update("update admin set uname=#{uname},tel=#{tel} where \"uid\"=#{uid}")
	public boolean modifyadminMessage(Admin admin1);
	@Update("update admin set upd=#{0} where \"uid\"=#{1}")
	public boolean modifypwd(String upd,int uid);
	@Select("select * from admin where \"uid\"=#{uid}")
	public Admin admin11(int uid);
	@Insert("insert into admin values(adminseq.nextval,#{uname},#{upd},#{tel},#{role},'/InAndOutManage/static/img/admin/201291893228996.jpg')")
	public boolean addAdmin(Admin admin);
	@Delete("delete from admin where \"uid\"=#{uid} ")
	public boolean delAdmin(int uid);
	@Select("select * from admin")
	public List<Admin> alladminExcel();
	@Delete("drop table admin")
	public boolean deleteAdmin();
	@Delete("drop table medicine")
	public boolean deleteMedicine();
	@Delete("drop table customer")
	public boolean deleteCustomer();
	@Delete("drop table formofmedicine")
	public boolean deleteFormofmedicine();
	@Delete("drop table inventory")
	public boolean deleteInventory();
	@Delete("drop table log")
	public boolean deleteLog();
	@Delete("drop table Purchase")
	public boolean deletePurchase();
	@Delete("drop table Provider")
	public boolean deleteProvider();
	@Delete("drop table Rebill")
	public boolean deleteRebill();
	@Delete("drop table Sell")
	public boolean deleteSell();
	@Update("update admin set img=#{img} where \"uid\"=#{uid}")
	public boolean updataimg(@Param(value = "img") String img,@Param(value = "uid") int uid);
}
