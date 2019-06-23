package com.java.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.LogDao;
import com.java.service.LogService;
import com.java.vo.Log;
@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDao lm;
	@Override
	public List<Log> listlog(int strpage, int endpage) {
		// TODO Auto-generated method stub
		return lm.listlog(strpage, endpage);
	}
	@Override
	public boolean insertLog(String uname,String record) {
		int operatorid = (int)((Math.random()*9+1)*10000);
		Date dateDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(operatorid);
		System.out.println(dateDate);
		String time = formatter.format(dateDate);
		System.out.println(time);
		boolean flag = false;
		int uid = lm.uid(uname);
		flag = lm.insertLog(uid, operatorid, record, time);
		if(flag) {
			System.out.println("����ɹ�");
		}else {
			System.out.println("����ʧ��");
		}
		return flag;
	}
	@Override
	public int allpage() {
		// TODO Auto-generated method stub
		return lm.allpage();
	}
	@Override
	public List<Log> listlogExcel() {
		// TODO Auto-generated method stub
		return lm.listlogExcel();
	}
	@Override
	public List<Log> listLikeMsgLog(int uid, String record) {
		// TODO Auto-generated method stub
		return lm.listLikeMsgLog(uid, record);
	}
	@Override
	public int uid(String uname) {
		// TODO Auto-generated method stub
		return lm.uid(uname);
	}

}
