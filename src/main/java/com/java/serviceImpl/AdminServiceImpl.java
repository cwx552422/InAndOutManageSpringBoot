package com.java.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.AdminDao;
import com.java.service.AdminService;
import com.java.vo.Admin;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao admin;
	@Override
	public Admin adminLogin(Admin a) throws Exception {
		return admin.adminLogin(a);
	}
	@Override
	public List<Admin> adminMessage(int strpage,int endpage) {
		
		return admin.adminMessage(strpage, endpage);
	}
	@Override
	public int allpage() {
		
		return admin.allpage();
	}
	@Override
	public boolean modifyadminMessage(Admin admin1) {
		// TODO Auto-generated method stub
		return admin.modifyadminMessage(admin1);
	}
	@Override
	public boolean modifypwd(String upd, int uid) {
		// TODO Auto-generated method stub
		return admin.modifypwd(upd, uid);
	}
	@Override
	public Admin admin11(int uid) {
		// TODO Auto-generated method stub
		return admin.admin11(uid);
	}
	@Override
	public boolean addAdmin(Admin a) {
		// TODO Auto-generated method stub
		return admin.addAdmin(a);
	}
	@Override
	public boolean delAdmin(int uid) {
		// TODO Auto-generated method stub
		return admin.delAdmin(uid);
	}
	@Override
	public List<Admin> alladminExcel() {
		// TODO Auto-generated method stub
		return admin.alladminExcel();
	}
	@Override
	public boolean deleteAdmin() {
		// TODO Auto-generated method stub
		return admin.deleteAdmin();
	}
	@Override
	public boolean deleteMedicine() {
		// TODO Auto-generated method stub
		return admin.deleteMedicine();
	}
	@Override
	public boolean deleteCustomer() {
		// TODO Auto-generated method stub
		return admin.deleteCustomer();
	}
	@Override
	public boolean deleteFormofmedicine() {
		// TODO Auto-generated method stub
		return admin.deleteFormofmedicine();
	}
	@Override
	public boolean deleteInventory() {
		// TODO Auto-generated method stub
		return admin.deleteInventory();
	}
	@Override
	public boolean deleteLog() {
		// TODO Auto-generated method stub
		return admin.deleteLog();
	}
	@Override
	public boolean deletePurchase() {
		// TODO Auto-generated method stub
		return admin.deletePurchase();
	}
	@Override
	public boolean deleteProvider() {
		// TODO Auto-generated method stub
		return admin.deleteProvider();
	}
	@Override
	public boolean deleteRebill() {
		// TODO Auto-generated method stub
		return admin.deleteRebill();
	}
	@Override
	public boolean deleteSell() {
		// TODO Auto-generated method stub
		return admin.deleteSell();
	}
	@Override
	public boolean updataimg(String path, int uid) {
		// TODO Auto-generated method stub
		return admin.updataimg(path, uid);
	}

}
