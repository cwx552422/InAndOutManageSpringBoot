package com.java.service;

import java.util.List;

import com.java.vo.Inventory;
import com.java.vo.InventoryStatistics;
import com.java.vo.Medicine;
import com.java.vo.Provider;

public interface InventoryService {
	/**
	 * ��ҳ��ʾ������Ϣ
	 * 
	 * @param strpage
	 * @param endpage
	 * @return
	 */
	public List<Inventory> inMed(int strpage, int endpage);

	/**
	 * ͳ���ܹ�ҳ��
	 * 
	 * @return
	 */
	public int allPage();

	/**
	 * ͨ���·ݲ�ѯ������Ϣ
	 * 
	 * @param year
	 * @return
	 */
	public List<InventoryStatistics> bymonth(String year);
	/* public Inventory ins(int inid); */

	/**
	 * ��ѯ���н�����Ϣ
	 * 
	 * @return
	 */
	public List<Inventory> listExcelMessage();

	/**
	 * ��ѯ����ҩƷ����
	 * 
	 * @return
	 */
	public List<Medicine> medicineName();

	/**
	 * ��ѯ���й�Ӧ��
	 * 
	 * @return
	 */
	public List<Provider> proName();

	/**
	 * �������ҩƷ
	 * 
	 * @param inPrice
	 * @param innum
	 * @param inTime
	 * @param proid
	 * @param mid
	 * @return
	 */
	public boolean addInventoryMsg(double inPrice, int innum, String inTime, int proid, int mid);

	public int mid(String mname);

	public int proid(String proname);

	public List<Inventory> inmedicineMesageLike(String mname, String fmedname);

}
