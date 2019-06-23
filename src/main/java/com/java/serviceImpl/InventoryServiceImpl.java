package com.java.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.InventoryDao;
import com.java.service.InventoryService;
import com.java.vo.Inventory;
import com.java.vo.InventoryStatistics;
import com.java.vo.Medicine;
import com.java.vo.Provider;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryDao im;

	@Override
	public List<Inventory> inMed(int strpage, int endpage) {
		// TODO Auto-generated method stub
		return im.inMed(strpage, endpage);
	}

	@Override
	public int allPage() {
		// TODO Auto-generated method stub
		return im.allPage();
	}

	@Override
	public List<InventoryStatistics> bymonth(String year) {
		return im.bymonth(year);
	}

	/*
	 * @Override public Inventory ins(int inid) {
	 * 
	 * return im.ins(inid); }
	 */
	@Override
	public List<Inventory> listExcelMessage() {
		// TODO Auto-generated method stub
		return im.listExcelMessage();
	}

	@Override
	public List<Medicine> medicineName() {
		// TODO Auto-generated method stub
		return im.medicineName();
	}

	@Override
	public List<Provider> proName() {
		// TODO Auto-generated method stub
		return im.proName();
	}

	@Override
	public boolean addInventoryMsg(double inPrice, int innum, String inTime, int proid, int mid) {
		// TODO Auto-generated method stub
		return im.addInventoryMsg(inPrice, innum, inTime, proid, mid);
	}

	@Override
	public int mid(String mname) {
		// TODO Auto-generated method stub
		return im.mid(mname);
	}

	@Override
	public int proid(String proname) {
		// TODO Auto-generated method stub
		return im.proid(proname);
	}

	@Override
	public List<Inventory> inmedicineMesageLike(String mname, String fmedname) {
		// TODO Auto-generated method stub
		return im.inmedicineMesageLike(mname, fmedname);
	}

}
