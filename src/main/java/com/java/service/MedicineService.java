package com.java.service;

import java.util.List;

import com.java.vo.FormOfMedicine;
import com.java.vo.Medicine;

public interface MedicineService {
	public List<Medicine> allMedicine(int strpage, int endpage);

	public int allpage();

	public List<FormOfMedicine> flist();

	public List<Medicine> medMessageExcel();

	public boolean addFormOfMedicine(String fmedicine);

	public List<Medicine> medicineMesageLike(String mname, String fmedname);

	public List<FormOfMedicine> fmedicinebyname(String fmedname);

	public boolean delformMed(int fid);
}
