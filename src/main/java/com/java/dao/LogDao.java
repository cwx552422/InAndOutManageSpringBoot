package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.java.vo.Log;

public interface LogDao {
	@Insert("insert into log values(logseq.nextval,#{uid},#{operatorid},#{record},to_date(#{time},'yyyy-mm-dd'))")
	public boolean insertLog(@Param(value = "uid") int uid,
			@Param(value = "operatorid") int operatorid,
			@Param(value = "record") String record,
			@Param(value = "time")String time);
	
	@Select("select * from (select a.*,rownum rn from log a where rownum<=#{1}) where rn>#{0}")
	@Results({
		@Result(property = "admin", column = "uid", one = @One(select = "com.java.mapper.AdminMapper.admin"))
	})
	public List<Log> listlog(int strpage, int endpage);
	
	@Select("select \"uid\" from admin where uname=#{uname}")
	public int uid(String uname);
	
	@Select("select count(*) from log")
	public int allpage();
	
	@Select("select * from log")
	@Results({
		@Result(property = "admin", column = "uid", one = @One(select = "com.java.mapper.AdminMapper.admin"))
	})
	public List<Log> listlogExcel();
	@Select("select * from log where  record like concat(concat('%',#{record}),'%') or \"uid\"= #{uid} ")
	@Results({
		@Result(property = "admin", column = "uid", one = @One(select = "com.java.mapper.AdminMapper.adminlike"))
	})
	public List<Log> listLikeMsgLog(@Param("uid") int uid,@Param("record") String record);
	
	
}
