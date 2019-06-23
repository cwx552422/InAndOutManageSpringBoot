package com.java.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.java.service.LogService;
import com.java.service.MedicineService;
import com.java.util.ExportExcel;
import com.java.vo.Admin;
import com.java.vo.FormOfMedicine;
import com.java.vo.Medicine;

@Controller
@Scope("prototype")
@RequestMapping("medicine")
@SessionAttributes
public class MedicineController {
	@Autowired
	private MedicineService ms;
	
	@Autowired
	private LogService logService;
	@RequestMapping("allMedicine")
	public String allMedicine(Model model,@RequestParam int pageNo,HttpSession hs) {
		List<Medicine> list=null;
		int allpage=0;
		if(pageNo==0) {
			pageNo=1;
		}
		int perpage=8;
		int strpage=perpage*(pageNo-1);
		int endpage=perpage*pageNo;
		int last=0;
		allpage=ms.allpage();
		last=(allpage-1)/perpage+1;
		list=ms.allMedicine(strpage, endpage);	
		List<FormOfMedicine> flist=null;
		flist=ms.flist();
		if(list!=null) {
			model.addAttribute("list",list);
			model.addAttribute("flist",flist);
			model.addAttribute("pageNo",pageNo);
			model.addAttribute("last",last);
			Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "�鿴ҩƷ��Ϣ");
			return "../jsp/medicineMessageManager/allMedicine.jsp";
		}else {
			return "404.jsp";
		}	
	}
	
	@RequestMapping("/formOfMedicine")
	public String formOfMedicine(Model model,HttpSession hs) {
		List<FormOfMedicine> list=new ArrayList<FormOfMedicine>();
		list=ms.flist();
		if(list!=null) {
			model.addAttribute("list",list);
			Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "�鿴ҩƷ������Ϣ");
			return "../jsp/medicineMessageManager/formOfMedicine.jsp";
		}else {
			return "404.jsp";
		}
	}
	
	/**
	 * ʵ��ҩƷ��Ϣ��񵼳�
	 * @param resq
	 * @param resp
	 * @return
	 */
	@RequestMapping("/exportExcel")
	public String exportExcel(HttpServletRequest resq,HttpServletResponse resp,HttpSession hs) {
		String title = "ҩƷ��Ϣ����";
		List<Medicine> list = ms.medMessageExcel();
        String[] columnName = new String[]{"ҩƷ���","ҩƷ����","����","��λ","������","��������","��Ч��","ҩƷ����"};
        List<Object[]> dataList = new ArrayList<Object[]>();
        Object[] objs;
        for (int i = 0; i < list.size(); i++) {
            objs = new Object[columnName.length];
            objs[0] = "MID"+list.get(i).getMid();
            objs[1] = list.get(i).getMname();
            objs[2] = list.get(i).getFmedicine().getFmedicine();
            objs[3] = list.get(i).getUnits();
            objs[4] = list.get(i).getManufacture();
            objs[5] = list.get(i).getProDate();
            objs[6] = list.get(i).getValidDate();
            objs[7] = list.get(i).getDescription();
            dataList.add(objs);
        }
        //ʵ����������
        ExportExcel ex = new ExportExcel(title, columnName, dataList,resq,resp);
        try {
            //����excel
            ex.export();
            Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "����ҩƷ��Ϣ");
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;		
	}
	
	/**
	 * ���ҩƷ����
	 * @param fmedicine
	 * @return
	 */
	@RequestMapping("addFormOfMedicine")
	public void addFormOfMedicine(@RequestParam String fmedicine,HttpServletResponse resp,HttpSession hs) {
	System.out.println("hekfhskgskjf");
		boolean flag = false;
		flag = ms.addFormOfMedicine(fmedicine);	
		String msg = null;
		if(flag) {
			Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "���ҩƷ��Ϣ");
			msg = "ok";			
		}
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		try {
			out = resp.getWriter();
			// ��д��ȥ��ʱ���json����ת����String����
			out.println(msg);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("medicineMesageLike")
	@ResponseBody
	public List<Medicine> medicineMesageLike(Model model,HttpSession hs,@RequestParam String mname,@RequestParam String fmedname) {
		List<Medicine> list=null;
		list=ms.medicineMesageLike(mname, fmedname);
		System.out.println(list.toString());
		Admin aa = (Admin) hs.getAttribute("admin");
		logService.insertLog(aa.getUname(), "ģ����ѯҩƷ��Ϣ");
		return list;	
	}
	
	
	@RequestMapping("formofmedicineMesageLike")
	@ResponseBody
	public List<FormOfMedicine> formofmedicineMesageLike(HttpSession hs,@RequestParam String fmedname) {
		List<FormOfMedicine> list= new ArrayList<FormOfMedicine>();
		System.out.println(fmedname);
		list=ms.fmedicinebyname(fmedname);
		System.out.println(list.toString());
		Admin aa = (Admin) hs.getAttribute("admin");
		logService.insertLog(aa.getUname(), "ģ����ѯҩƷ������Ϣ");
		return list;	
	}
	
	
	@RequestMapping("delformMed")
	public void delformMed(@RequestParam int fid,HttpServletResponse resp,HttpSession hs) {
	System.out.println("hsfdgerqeeeeeeeeeee");
		boolean flag = false;
		flag = ms.delformMed(fid);	
		String msg = null;
		if(ms.medMessageExcel().size()>0) {
			if(flag) {
				Admin aa = (Admin) hs.getAttribute("admin");
				logService.insertLog(aa.getUname(), "ɾ��ҩƷ������Ϣ");
				msg = "ok";			
			}
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			try {
				out = resp.getWriter();
				// ��д��ȥ��ʱ���json����ת����String����
				out.println(msg);
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
