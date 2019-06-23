package com.java.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.PurchaseDao;
import com.java.service.PurchaseService;
import com.java.vo.Purchase;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	private PurchaseDao pm;
	@Override
	public List<Purchase> purchase() {
		// TODO Auto-generated method stub
		return pm.purchase();
	}
	@Override
	public List<Purchase> purLikeMed(String mname) {
		// TODO Auto-generated method stub
		return pm.purLikeMed(mname);
	}

}
