package com.java.service;

import java.util.List;

import com.java.vo.Log;

public interface LogService {
	public List<Log> listlog(int strpage, int endpage);

	public boolean insertLog(String uname, String record);

	public int allpage();

	public List<Log> listlogExcel();

	public List<Log> listLikeMsgLog(int uid, String record);

	public int uid(String uname);
}
