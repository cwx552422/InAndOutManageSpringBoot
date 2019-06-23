package com.java.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MedicineDao;
import com.java.service.MedicineService;
import com.java.vo.FormOfMedicine;
import com.java.vo.Medicine;
@Service
public class MedicineServiceImpl implements MedicineService {
	@Autowired
	private MedicineDao mm;
	@Override
	public List<Medicine> allMedicine(int strpage, int endpage) {
		return mm.adminMessage(strpage, endpage);
	}

	@Override
	public int allpage() {
		return mm.allpage();
	}

	@Override
	public List<FormOfMedicine> flist() {
		return mm.flist();
	}

	@Override
	public List<Medicine> medMessageExcel() {
		// TODO Auto-generated method stub
		return mm.medMessageExcel();
	}

	@Override
	public boolean addFormOfMedicine(String fmedicine) {
		// TODO Auto-generated method stub
		return mm.addFormOfMedicine(fmedicine);
	}

	@Override
	public List<Medicine> medicineMesageLike(String mname, String fmedname) {
		// TODO Auto-generated method stub
		return mm.medicineMesageLike(mname, fmedname);
	}

	@Override
	public List<FormOfMedicine> fmedicinebyname(String fmedname) {
		// TODO Auto-generated method stub
		return mm.fmedicinebyname(fmedname);
	}

	@Override
	public boolean delformMed(int fid) {
		// TODO Auto-generated method stub
		return mm.delformMed(fid);
	}

}
