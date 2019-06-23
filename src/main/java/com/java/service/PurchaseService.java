package com.java.service;

import java.util.List;

import com.java.vo.Purchase;

public interface PurchaseService {
	public List<Purchase> purchase();

	public List<Purchase> purLikeMed(String mname);
}
