package com.java.controller;

import java.io.IOException;
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

import com.java.service.InventoryService;
import com.java.service.LogService;
import com.java.service.MedicineService;
import com.java.util.ExportExcel;
import com.java.vo.Admin;
import com.java.vo.FormOfMedicine;
import com.java.vo.Inventory;
import com.java.vo.InventoryStatistics;
import com.java.vo.Medicine;
import com.java.vo.Provider;

@Controller
@Scope("prototype")
@RequestMapping("/inventory")
public class InventoryController {
	@Autowired
	private InventoryService is;
	@Autowired
	private MedicineService ms;
	@Autowired
	private LogService logService;

	/**
	 * ��ʾ������Ϣ
	 * 
	 * @param model
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("/inMedMessage")
	public String inMedMessage(Model model, @RequestParam int pageNo, HttpServletRequest req, HttpSession hs) {
		List<Inventory> list = new ArrayList<Inventory>();
		int allpage = 0;
		if (pageNo == 0) {
			pageNo = 1;
		}
		int perpage = 8;
		int strpage = perpage * (pageNo - 1);
		int endpage = perpage * pageNo;
		int last = 0;
		allpage = is.allPage();
		last = (allpage - 1) / perpage + 1;
		list = is.inMed(strpage, endpage);
		System.out.println(list.toString());
		List<Medicine> mlist = new ArrayList<Medicine>();
		List<Provider> plist = new ArrayList<Provider>();
		mlist = is.medicineName();
		plist = is.proName();
		List<FormOfMedicine> flist = new ArrayList<FormOfMedicine>();
		flist = ms.flist();
		model.addAttribute("list", list);
		model.addAttribute("flist", flist);
		model.addAttribute("plist", plist);
		model.addAttribute("mlist", mlist);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("last", last);
		Admin admin = (Admin) req.getSession().getAttribute("admin");
		System.out.println(admin.getUname());
		Admin aa = (Admin) hs.getAttribute("admin");
		logService.insertLog(aa.getUname(), "�鿴������Ϣ");
		return "../jsp/inventoryManager/inventoryMessage.jsp";
	}

	/**
	 * ͼ����ʾ������Ϣ���
	 * 
	 * @param model
	 * @param response
	 * @param nyear
	 * @param s
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/statisticsBymonth")
	public String statisticsBymonth(Model model, HttpSession hs, HttpServletResponse response, @RequestParam int nyear)
			throws IOException {
		List<InventoryStatistics> list = new ArrayList<InventoryStatistics>();
		String year = String.valueOf(nyear);
		list = is.bymonth(year);
		String path = null;
		if (list != null) {
			model.addAttribute("list", list);
			Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "�鿴����ͼ����Ϣ");
			path = "../jsp/inventoryManager/graphicStatistics.jsp";
			return path;
		} else {
			return "404.jsp";
		}
	}

	@RequestMapping("/statisticsBymonthzhuxing")
	@ResponseBody
	public List<InventoryStatistics> statisticsBymonthzhuxing(Model model, HttpSession hs, HttpServletResponse response,
			@RequestParam int nyear) {
		System.out.println("comging" + nyear);
		List<InventoryStatistics> list = new ArrayList<InventoryStatistics>();
		String year = String.valueOf(nyear);
		list = is.bymonth(year);
		System.out.println(list.toString());
		return list;
	}

	@RequestMapping("zhuxing")
	public String zhuxing(HttpSession hs) {
		Admin aa = (Admin) hs.getAttribute("admin");
		logService.insertLog(aa.getUname(), "�鿴����ͼ����Ϣ");
		return "../jsp/inventoryManager/test.jsp";
	}

	/**
	 * ʵ�ֽ�����Ϣ��񵼳�
	 * 
	 * @param resq
	 * @param resp
	 * @return
	 */
	@RequestMapping("/exportExcel")
	public String exportExcel(HttpServletRequest resq, HttpServletResponse resp, HttpSession hs) {
		String title = "������Ϣ����";
		List<Inventory> list = is.listExcelMessage();
		String[] columnName = new String[] { "�������", "�������ݺ�", "ҩƷ���", "ҩƷ����", "����", "��������", "��������", "��������", "��Ӧ��",
				"״̬" };
		List<Object[]> dataList = new ArrayList<Object[]>();
		Object[] objs;
		for (int i = 0; i < list.size(); i++) {
			objs = new Object[columnName.length];
			objs[0] = "INID" + list.get(i).getInid();
			objs[1] = "INDOCNO" + list.get(i).getInDocNo();
			objs[2] = list.get(i).getMed().getMid();
			objs[3] = list.get(i).getMed().getMname();
			objs[4] = list.get(i).getMed().getFmedicine();
			objs[5] = list.get(i).getInNum();
			objs[6] = list.get(i).getInPrice();
			objs[7] = list.get(i).getInTime();
			objs[8] = list.get(i).getPro().getProName();
			objs[9] = list.get(i).getState();
			dataList.add(objs);
		}
		// ʵ����������
		ExportExcel ex = new ExportExcel(title, columnName, dataList, resq, resp);
		try {
			// ����excel
			ex.export();
			Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "����������Ϣ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �������ҩƷ
	 * 
	 * @param inPrice
	 * @param innum
	 * @param inTime
	 * @param proid
	 * @param mid
	 */
	@RequestMapping("/addInventoryMsg")
	public void addInventoryMsg(@RequestParam double inPrice, @RequestParam int innum, @RequestParam String inTime,
			@RequestParam String proname,@RequestParam String mname, HttpServletResponse resp, HttpSession hs) {
		System.out.println("hekfhskgskjf");
		boolean flag = false;
		int mid = is.mid(mname);
		int proid = is.proid(proname);
		System.out.println(inPrice + 2);
		flag = is.addInventoryMsg(inPrice, innum, inTime, proid, mid);
		String msg = null;
		if (flag) {
			Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "���������Ϣ");
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

	@RequestMapping("/inbill")
	public String inbill() {
		return "../jsp/inventoryManager/InventoryBill.jsp";
	}

	@RequestMapping("/exportInventorybillExcel")
	public String exportsellbillExcel(@RequestParam(value="mname") String mname, @RequestParam(value="sellnum") int sellnum,
			@RequestParam(value="sellprice") double sellprice, @RequestParam(value="reprice") double reprice, @RequestParam(value="totalprice") double totalprice,
			@RequestParam(value="uname") String uname, @RequestParam(value="date") String date, HttpServletRequest resq, HttpServletResponse resp,
			HttpSession hs) {
		String title = "ҩƷ���۵�";
		String[] columnName = new String[] { "ҩƷ����", "�˻�����", "��������", "�˻�����", "�����ܶ�", "������", "��������" };
		List<Object[]> dataList = new ArrayList<Object[]>();
		Object[] objs;
		for (int i = 0; i < 1; i++) {
			objs = new Object[columnName.length];
			objs[0] = mname;
			objs[1] = sellnum;
			objs[2] = sellprice;
			objs[3] = reprice;
			objs[4] = totalprice;
			objs[5] = uname;
			objs[6] = date;
			dataList.add(objs);
		}
		// ʵ����������
		ExportExcel ex = new ExportExcel(title, columnName, dataList, resq, resp);
		try {
			// ����excel
			ex.export();
			Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "�������ۿ�����");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("inmedicineMesageLike")
	@ResponseBody
	public List<Inventory> inmedicineMesageLike(HttpSession hs,@RequestParam String mname,@RequestParam String fmedname) {
		List<Inventory> list= new ArrayList<Inventory>();
		System.out.println(fmedname);
		list=is.inmedicineMesageLike(mname, fmedname);
		System.out.println(list.toString());
		Admin aa = (Admin) hs.getAttribute("admin");
		logService.insertLog(aa.getUname(), "ģ����ѯҩƷ������Ϣ");
		return list;	
	}
}
