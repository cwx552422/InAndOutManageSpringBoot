package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.java.vo.FormOfMedicine;
import com.java.vo.Medicine;

public interface MedicineDao {
	// ��ҳ��ʾ����ҩƷ�������
	@Select("select * from (select a.*,rownum rn from medicine a where rownum<=#{1}) where rn>#{0}")
	@Results({
			@Result(property = "fmedicine", column = "fid", one = @One(select = "com.java.mapper.MedicineMapper.fmedicine")) })
	public List<Medicine> adminMessage(int strpage, int endpage);

	// ͳ���ܹ��ж���ҩ
	@Select("select count(*) from medicine")
	public int allpage();



	// ����ҩ�ļ���
	@Select("select * from formOfMedicine")
	public List<FormOfMedicine> flist();

	@Select("select * from medicine where mid=#{mid}")
	public Medicine med();

	// ��������ʹ����ʾ����ҩƷ�������
	@Select("select * from (select a.*,rownum rn from medicine a )")
	@Results({
			@Result(property = "fmedicine", column = "fid", one = @One(select = "com.java.mapper.MedicineMapper.fmedicine")) })
	public List<Medicine> medMessageExcel();
	
	//ʵ�ֶ�����ģ����ѯ
//	@Select("SELECT * from medicine m WHERE m.mname LIKE concat('%',#{mname},'%')")
//	@Results({
//		@Result(property = "fmedicine", column = "fid", one = @One(select = "com.java.mapper.MedicineMapper.fmedicine")) })
	public List<Medicine> medicineMesageLike(@Param("mname") String mname,@Param("fmedname") String fmedname);
	
	// ���ϲ�ѯ����id����ҩ�ļ���
	@Select("select * from formOfMedicine where fid=#{fid}")
	public FormOfMedicine fmedicine(int fid);
	
	//����ҩƷ����
	@Insert("insert into formOfMedicine values(formOfMedicineseq.nextval,#{fmedicine})")
	public boolean addFormOfMedicine(String fmedicine);
	
	// ����name����ҩ�ļ���
		@Select("select * from formOfMedicine where fmedicine like concat(concat('%',#{fmedicine}),'%')")
		public List<FormOfMedicine> fmedicinebyname(@Param(value = "fmedicine") String fmedicine);
		
		@Delete("@Delete from formOfMedicine where fid=#{fid}")
		public boolean delformMed(int fid);
}
