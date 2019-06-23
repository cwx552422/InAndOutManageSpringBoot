package com.java.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.java.service.LogService;
import com.java.service.MedicineService;
import com.java.service.PurchaseService;
import com.java.util.ExportExcel;
import com.java.vo.Admin;
import com.java.vo.FormOfMedicine;
import com.java.vo.Purchase;

@Controller
@Scope("prototype")
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private PurchaseService ps;
	@Autowired
	private LogService logService;
	@Autowired
	private MedicineService ms;
//	�����Ϣ��ѯ
	@RequestMapping("/purchaseMessage")
	public String purchaseMessage(Model model,HttpSession hs) {
		List<Purchase> list=new ArrayList<Purchase>();		
		list=ps.purchase();	
		System.out.println(list);
		List<FormOfMedicine> flist=null;
		flist=ms.flist();
		if(list!=null) {
			model.addAttribute("list",list);
			model.addAttribute("flist",flist);
			Date date = new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			String sDateSuffix = dateformat.format(date);
			model.addAttribute("crruentTime",sDateSuffix);
			Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "�鿴�����Ϣ");
			return "../jsp/purchaseManager/purchaseMessage.jsp";
			 
		}else {
			return "404.jsp";
		}	
	}
	
	/**
	 * ʵ��ҩƷ�����Ϣ��񵼳�
	 * @param resq
	 * @param resp
	 * @return
	 */
	@RequestMapping("/exportExcel")
	public String exportExcel(HttpServletRequest resq,HttpServletResponse resp,HttpSession hs) {
		String title = "ҩƷ�����Ϣ����";
		List<Purchase> list = ps.purchase();
        String[] columnName = new String[]{"ҩƷ���","ҩƷ����","�������","��������","�̵�����","�̵�����","ҩƷ��Ч����"};
        List<Object[]> dataList = new ArrayList<Object[]>();
        Object[] objs;	
        Date dt = new Date();     
        //����aa��ʾ�����硱�����硱    HH��ʾ24Сʱ��    �������hh��ʾ12Сʱ��     
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");
        String temp_str=sdf.format(dt);
        for (int i = 0; i < list.size(); i++) {
            objs = new Object[columnName.length];
            objs[0] = "MID"+list.get(i).getMid();
            objs[1] = list.get(i).getMname();
            objs[2] = list.get(i).getTinnum();
            objs[3] = list.get(i).getTsnum();
            objs[4] = list.get(i).getCnum();
            objs[5] = temp_str;
            objs[6] = list.get(i).getValiddate();
            dataList.add(objs);
        }
        //ʵ����������
        ExportExcel ex = new ExportExcel(title, columnName, dataList,resq,resp);
        try {
            //����excel
            ex.export();
            Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "������汨����Ϣ");
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
	
	@RequestMapping("/purchaseMessageStatitics")
	@ResponseBody
	public List<Purchase> purchaseMessageStatitics(Model model,HttpSession hs) {
		List<Purchase> list=new ArrayList<Purchase>();		
		list=ps.purchase();	
		System.out.println(list);
		if(list!=null) {
			model.addAttribute("list",list);
			Date date = new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			String sDateSuffix = dateformat.format(date);
			model.addAttribute("crruentTime",sDateSuffix);
			Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "�鿴�����Ϣ");		 
		}
		return list;
	}
	
	
	@RequestMapping("purLikeMed")
	@ResponseBody
	public List<Purchase> purLikeMed(HttpSession hs,@RequestParam(value="mname") String mname) {
		List<Purchase> list= new ArrayList<Purchase>();
		list=ps.purLikeMed(mname);
		System.out.println(list.toString());
		Admin aa = (Admin) hs.getAttribute("admin");
		logService.insertLog(aa.getUname(), "ģ����ѯҩƷ�����Ϣ");
		return list;	
	}
}


