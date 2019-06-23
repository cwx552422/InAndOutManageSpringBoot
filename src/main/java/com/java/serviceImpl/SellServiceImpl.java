package com.java.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.SellDao;
import com.java.service.SellService;
import com.java.vo.Inprofits;
import com.java.vo.Rebill;
import com.java.vo.Reprofits;
import com.java.vo.Sell;
import com.java.vo.Sellprofits;
@Service
public class SellServiceImpl implements SellService {

	@Autowired
	private SellDao sm;
	@Override
	public List<Sell> sellMed(int strpage, int endpage) {
		// TODO Auto-generated method stub
		return sm.sellMed(strpage, endpage);
	}
	@Override
	public int allPage() {
		// TODO Auto-generated method stub
		return sm.allPage();
	}
	@Override
	public List<Rebill> rebill(int strpage, int endpage) {
		// TODO Auto-generated method stub
		return sm.rebill(strpage, endpage);
	}
	@Override
	public int reallPage() {
		// TODO Auto-generated method stub
		return sm.reallPage();
	}
	@Override
	public List<Inprofits> inprofits() {
		// TODO Auto-generated method stub
		return sm.inprofits();
	}
	@Override
	public List<Sellprofits> sellprofits() {
		// TODO Auto-generated method stub
		return sm.sellprofits();
	}
	@Override
	public List<Reprofits> reprofits() {
		// TODO Auto-generated method stub
		return sm.reprofits();
	}
	@Override
	public List<Sell> sellMedExcel() {
		// TODO Auto-generated method stub
		return sm.sellMedExcel();
	}
	@Override
	public List<Rebill> rebillExcel() {
		// TODO Auto-generated method stub
		return sm.rebillExcel();
	}
	@Override
	public List<Sell> semedicineMesageLike(String mname, String fmedname) {
		// TODO Auto-generated method stub
		return sm.semedicineMesageLike(mname, fmedname);
	}


}
