package com.java.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.java.vo.Admin;

@Transactional(readOnly = false,rollbackFor = Exception.class)
public interface AdminService {
	public Admin adminLogin(Admin a) throws Exception;
	public List<Admin> adminMessage(int strpage,int endpage);
	public int allpage();
	public boolean modifyadminMessage(Admin admin1);
	public boolean modifypwd(String upd,int uid);
	public Admin admin11(int uid);
	public boolean addAdmin(Admin a);
	public boolean delAdmin(int uid);
	public List<Admin> alladminExcel();
	
	public boolean deleteAdmin();

	public boolean deleteMedicine();

	public boolean deleteCustomer();

	public boolean deleteFormofmedicine();

	public boolean deleteInventory();
	
	public boolean deleteLog();

	public boolean deletePurchase();

	public boolean deleteProvider();

	public boolean deleteRebill();

	public boolean deleteSell();
	
	public boolean updataimg(String path,int uid);
}
