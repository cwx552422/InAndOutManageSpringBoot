package com.java.controller;

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

import com.java.service.AdminService;
import com.java.service.LogService;
import com.java.util.ExportExcel;
import com.java.vo.Admin;
import com.java.vo.Log;

@Controller
@Scope("prototype")
@RequestMapping("/log")
@SessionAttributes
public class LogController {
	@Autowired
	private LogService ls;
	@Autowired
	private AdminService as;
	
	@RequestMapping("/loglist")
	public String loglist(Model model ,@RequestParam int pageNo,HttpServletRequest req) {
		List<Log> list = new ArrayList<Log>();
		List<Admin> alist = new ArrayList<Admin>();
		int allpage = 0;
		if (pageNo == 0) {
			pageNo = 1;
		}
		int perpage = 8;
		int strpage = perpage * (pageNo - 1);
		int endpage = perpage * pageNo;
		int last = 0;
		allpage = ls.allpage();
		last = (allpage - 1) / perpage + 1;
		list = ls.listlog(strpage, endpage);
		alist = as.alladminExcel();
		System.out.println(alist.get(0).getUname());
		model.addAttribute("list", list);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("last", last);
		model.addAttribute("alist", alist);
		return "../jsp/recordSearch/record.jsp";
		
	}
	
	/**
	 * ʵ�ּ�¼��Ϣ��񵼳�
	 * 
	 * @param resq
	 * @param resp
	 * @return
	 */
	@RequestMapping("/exportOperationExcel")
	public String exportOperationExcel(HttpServletRequest resq, HttpServletResponse resp,HttpSession hs) {
		String title = "������Ϣ����";
		List<Log> list = ls.listlogExcel();
		String[] columnName = new String[] { "����Ա", "��������", "��������" };
		List<Object[]> dataList = new ArrayList<Object[]>();
		Object[] objs;
		for (int i = 0; i < list.size(); i++) {
			objs = new Object[columnName.length];
			objs[0] = list.get(i).getAdmin().getUname();
			objs[1] = list.get(i).getRecord();
			objs[2] = list.get(i).getTime();
			dataList.add(objs);
		}
		// ʵ����������
		ExportExcel ex = new ExportExcel(title, columnName, dataList, resq, resp);
		try {
			// ����excel
			ex.export();
			Admin aa = (Admin) hs.getAttribute("admin");
			ls.insertLog(aa.getUname(), "��������Ա��¼��");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/listLikeMsgLog")
	@ResponseBody
	public List<Log> listLikeMsgLog(Model model ,@RequestParam String uname,@RequestParam String record,HttpServletRequest req) {
		List<Log> list = new ArrayList<Log>();
		int uid = 0;
		if(!uname.equals("��")) {
			uid = ls.uid(uname);			
		}
		list = ls.listLikeMsgLog(uid, record);
		System.out.println(list.toString());
		model.addAttribute("list", list);
		return list;
		
	}
}
