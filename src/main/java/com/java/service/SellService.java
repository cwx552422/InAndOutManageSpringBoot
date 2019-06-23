package com.java.service;

import java.util.List;

import com.java.vo.Inprofits;
import com.java.vo.Rebill;
import com.java.vo.Reprofits;
import com.java.vo.Sell;
import com.java.vo.Sellprofits;

public interface SellService {
	// ҩƷ������Ϣ��ѯ
	public List<Sell> sellMed(int strpage, int endpage);

	public int allPage();

	// �����˵���ѯ
	public List<Rebill> rebill(int strpage, int endpage);

	public int reallPage();

	// �������
	public List<Inprofits> inprofits();

	public List<Sellprofits> sellprofits();

	public List<Reprofits> reprofits();

	public List<Sell> sellMedExcel();

	public List<Rebill> rebillExcel();

	public List<Sell> semedicineMesageLike(String mname, String fmedname);

}
