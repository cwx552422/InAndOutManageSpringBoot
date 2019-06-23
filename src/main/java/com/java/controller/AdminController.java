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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.java.service.AdminService;
import com.java.service.LogService;
import com.java.util.ExportExcel;
import com.java.util.OracleDatabaseBackup;
import com.java.vo.Admin;

/**
 * ����Աģ����Ʋ�
 * 
 * @author chenli
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/admin")
@SessionAttributes
public class AdminController {
	@Autowired
	private AdminService as;
	@Autowired
	private LogService logService;

	/**
	 * 项目启动
	 */
	@RequestMapping("projectStart")
	public String projectStart() {
		return "../login.jsp";
	}
	
	/**
	 * ��¼����
	 * 
	 * @param a
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("/login")
	@ResponseBody()
	public void adminLogin(@ModelAttribute Admin a, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Admin admin = null;
		admin = as.adminLogin(a);
		String msg = null;
		if (admin != null) {
			req.getSession().setAttribute("admin", admin);
			System.out.print("�ɹ�");
			logService.insertLog(a.getUname(), "��¼ϵͳ");
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

	@RequestMapping("loginmid")
	public String loginmid() {
		return "../index.jsp";
	}

	/**
	 * ��ʾ����Ա��Ϣ
	 * 
	 * @param model
	 * @param pageNo
	 * @param req
	 * @return
	 */
	@RequestMapping("adminMessage")
	public String adminMessage(Model model, @RequestParam int pageNo, HttpServletRequest req) {
		List<Admin> list = null;
		int allpage = 0;
		if (pageNo == 0) {
			pageNo = 1;
		}
		int perpage = 8;
		int strpage = perpage * (pageNo - 1);
		int endpage = perpage * pageNo;
		int last = 0;
		allpage = as.allpage();
		last = (allpage - 1) / perpage + 1;
		list = as.adminMessage(strpage, endpage);
		if (list != null) {
			model.addAttribute("list", list);
			model.addAttribute("pageNo", pageNo);
			model.addAttribute("last", last);
			Admin a = (Admin) req.getSession().getAttribute("admin");
			logService.insertLog(a.getUname(), "�鿴����Ա��Ϣ");
			return "../jsp/systemManager/userManager.jsp";
		} else {
			return "404.jsp";
		}
	}

	@RequestMapping("/ModifyadminMessagetest")
	public void modifyadminMessage(Model model, @ModelAttribute Admin a, HttpSession hs, HttpServletRequest req,
			HttpServletResponse resp) {
		Admin sessionadmin = (Admin) hs.getAttribute("admin");
		a.setUid(sessionadmin.getUid());
		a.setUpd(sessionadmin.getUpd());
		a.setRole(sessionadmin.getRole());
		if (a.getImg() == null || a.getImg() == "") {
			a.setImg(sessionadmin.getImg());
		}
		boolean flag = as.modifyadminMessage(a);
		String msg = null;
		System.out.println("jinru0000000000000000000");
		System.out.println(a.getImg() + "------" + a.getTel() + "sgw20-----" + a.getUname());
		System.out.println(a);
		if (flag) {
			msg = "�޸ĳɹ�";
			System.out.println(msg);
			Admin aa = (Admin) req.getSession().getAttribute("admin");
			logService.insertLog(aa.getUname(), "�޸Ĺ���Ա��Ϣ");
			hs.invalidate();
			req.getSession().setAttribute("admin", a);
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

	// �޸��û�����
	@RequestMapping("/modifypwd")
	public void modifypwd(Model model, @RequestParam String jspnewupd, HttpServletRequest req, HttpSession hs,
			HttpServletResponse resp) {
		Admin sessionadmin = (Admin) hs.getAttribute("admin");
		int uid = sessionadmin.getUid();
		boolean flag = as.modifypwd(jspnewupd, uid);
		String msg = null;
		if (flag) {
			msg = "ok";
			System.out.println(msg);
			Admin aa = (Admin) req.getSession().getAttribute("admin");
			logService.insertLog(aa.getUname(), "�޸ĸ��˵�¼����");
			hs.invalidate();
			Admin a = as.admin11(uid);
			req.getSession().setAttribute("admin", a);
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

	@RequestMapping("exitmid")
	public String exitmid(HttpSession hs) {
		Admin aa = (Admin) hs.getAttribute("admin");
		hs.invalidate();
		if (null != aa) {
			logService.insertLog(aa.getUname(), "�˳���¼");
		}

		return "../login.jsp";

	}

	@RequestMapping("indexmid")
	public String indexmid() {
		return "../index.jsp";

	}

	@RequestMapping("addAdmin")
	public void addAdmin(Model model, HttpSession hs, @ModelAttribute Admin a, HttpServletResponse resp, HttpServletRequest req) throws IllegalStateException, IOException {
		boolean flag = false;
		flag = as.addAdmin(a);
		String msg = null;
		if (flag) {
			Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "���ӹ���Ա");
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

	@RequestMapping("delAdmin")
	public void delAdmin(@RequestParam int uid, HttpServletResponse resp, HttpSession hs) {
		System.out.println("400000000------" + uid);
		boolean flag = false;
		flag = as.delAdmin(uid);
		String msg = null;
		if (flag) {
			Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "ɾ������Ա");
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

	@RequestMapping(value = "/ModifyadminMessage", method = RequestMethod.POST)
	public void ModifyadminMessage(@ModelAttribute Admin a, HttpSession hs, HttpServletResponse resp) {
		System.out.println("400000000------" + a);
		Admin aa = (Admin) hs.getAttribute("admin");
		a.setUid(aa.getUid());
		boolean flag = false;
		flag = as.modifyadminMessage(a);
		String msg = null;
		if (flag) {
			logService.insertLog(aa.getUname(), "�޸ĸ�����Ϣ");
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

	/**
	 * ʵ�ֽ�����Ϣ��񵼳�
	 * 
	 * @param resq
	 * @param resp
	 * @return
	 */
	@RequestMapping("/exportExcel")
	public String exportExcel(HttpServletRequest resq, HttpServletResponse resp, HttpSession hs) {
		String title = "����Ա��Ϣ����";
		List<Admin> list = as.alladminExcel();
		String[] columnName = new String[] { "���", "����", "��ɫ", "��ϵ��ʽ" };
		List<Object[]> dataList = new ArrayList<Object[]>();
		Object[] objs;
		for (int i = 0; i < list.size(); i++) {
			objs = new Object[columnName.length];
			objs[0] = list.get(i).getUid();
			objs[1] = list.get(i).getUname();
			objs[2] = list.get(i).getRole();
			objs[3] = list.get(i).getTel();
			dataList.add(objs);
		}
		// ʵ����������
		ExportExcel ex = new ExportExcel(title, columnName, dataList, resq, resp);
		try {
			// ����excel
			ex.export();
			Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "��������Ա��");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/backData")
	public void backData(HttpServletResponse resp, HttpSession hs) {
		String msg = null;
		if (OracleDatabaseBackup.backUpDataBaseOracle("cl", "cl1234", "ORCL", "D:/oralce")) {
			Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "��������");
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

	@RequestMapping("/resumeData")
	public void resumeData(HttpServletResponse resp, HttpSession hs) {
		String msg = null;
		String table[] = { "customer", "purchase", "sell", "inventory", "rebill" };
		if (OracleDatabaseBackup.resumeDataBaseOracle("cl", "cl1234", "ORCL", "D:/oralce", table)) {
			Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "�ָ�����");
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

	@RequestMapping("/deleteAllData")
	public void deleteAllData(HttpServletResponse resp) {
		String msg = null;
		boolean flag = as.deleteCustomer();
		boolean flag1 = as.deletePurchase();
		boolean flag2 = as.deleteSell();
		boolean flag3 = as.deleteInventory();
		boolean flag4 = as.deleteRebill();
		if (flag && flag1 && flag2 && flag3 && flag4) {
			msg = "ok";
		} else {
			msg = "";
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
