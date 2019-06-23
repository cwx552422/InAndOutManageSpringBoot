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

import com.java.service.LogService;
import com.java.service.MedicineService;
import com.java.service.SellService;
import com.java.util.ExportExcel;
import com.java.vo.Admin;
import com.java.vo.FormOfMedicine;
import com.java.vo.Inprofits;
import com.java.vo.ProfitsStatistics;
import com.java.vo.Rebill;
import com.java.vo.Reprofits;
import com.java.vo.Sell;
import com.java.vo.Sellprofits;

@Controller
@Scope("prototype")
@RequestMapping("/sell")
public class SellController {

	@Autowired
	private SellService ss;
	@Autowired
	private LogService logService;
	@Autowired
	private MedicineService ms;
//	������Ϣ��ѯ
	@RequestMapping("/sellMessage")
	public String sellMedMessage(Model model,@RequestParam int pageNo,HttpSession hs) {
		List<Sell> list=new ArrayList<Sell>();
		int allpage=0;
		if(pageNo==0) {
			pageNo=1;
		}
		int perpage=8;
		int strpage=perpage*(pageNo-1);
		int endpage=perpage*pageNo;
		int last=0;
		allpage=ss.allPage();
		last=(allpage-1)/perpage+1;
		list=ss.sellMed(strpage, endpage);
		List<FormOfMedicine> flist=new ArrayList<FormOfMedicine>();
		flist=ms.flist();
		if(list!=null) {
			model.addAttribute("list",list);
			model.addAttribute("flist",flist);
			model.addAttribute("pageNo",pageNo);
			model.addAttribute("last",last);
			System.out.println(list);
			Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "�鿴������Ϣ");
			return "../jsp/sellManager/sellMessage.jsp";
			 
		}else {
			return "404.jsp";
		}	
	}
//	�����˵���ѯ
	@RequestMapping("/reebillMessage")
	public String rebillMessage(Model model,@RequestParam int pageNo,HttpSession hs) {
		List<Rebill> list=new ArrayList<Rebill>();
		int allpage=0;
		if(pageNo==0) {
			pageNo=1;
		}
		int perpage=8;
		int strpage=perpage*(pageNo-1);
		int endpage=perpage*pageNo;
		int last=0;
		allpage=ss.reallPage();
		last=(allpage-1)/perpage+1;
		list=ss.rebill(strpage, endpage);
		List<FormOfMedicine> flist=new ArrayList<FormOfMedicine>();
		flist=ms.flist();
		if(list!=null) {
			model.addAttribute("list",list);
			model.addAttribute("flist",flist);
			model.addAttribute("pageNo",pageNo);
			model.addAttribute("last",last);
			System.out.println(list);
			Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "�鿴�˻���Ϣ");
			return "../jsp/sellManager/rebillMessage.jsp";
			 
		}else {
			return "404.jsp";
		}	
	}
	
//�������
	@RequestMapping("/profitsStatistics")
	public String profits(Model model,HttpSession hs) {
		List<Inprofits> inlist=new ArrayList<Inprofits>();
		List<Sellprofits> selist=new ArrayList<Sellprofits>();
		List<Reprofits> relist=new ArrayList<Reprofits>();
		List<ProfitsStatistics> prolist=new ArrayList<ProfitsStatistics>();
		inlist=ss.inprofits();
		selist=ss.sellprofits();
		relist=ss.reprofits();	
		ProfitsStatistics pro=null;
		int mid=0;						
		String mname=null;			
		int innum=0;			
		double sprice=0;
		double inprice=0;
		double inpp=0;
		double spp=0;
		int renum=0;
		int snum=0;
		double profits=0;
		int remid=0;
		int semid=0;
		for(int j=0;j<relist.size();j++) {
			for(int i=0;i<selist.size();i++) {
				for(int k=0;k<inlist.size();k++) {
					 mid=inlist.get(k).getMed().getMid();						
					 mname=inlist.get(k).getMed().getMname();			
					 innum=inlist.get(k).getInnum();			
					 sprice=selist.get(i).getSellProfits();
					 inprice=inlist.get(k).getInprice();
					 inpp=inprice/innum;
					 remid=relist.get(j).getMid();
					 semid=selist.get(i).getMid();
					if(mid==semid&&semid==remid&&mid==remid) {
						pro=new ProfitsStatistics();
						renum=relist.get(j).getRenum();	
						snum=selist.get(i).getSellNum();
						spp=sprice/snum;
						profits=(snum-renum)*(spp-inpp);
						pro.setMid(mid);
						pro.setMname(mname);
						pro.setSnum(snum);
						pro.setInnum(innum);
						pro.setRenum(renum);				
						pro.setSprice(sprice);
						pro.setInprice(inprice);
						pro.setProfits(profits);
						pro.setInpp(inpp);
						pro.setSpp(spp);
						prolist.add(pro);
						break;
					}else if(mid==semid&&semid!=remid) {						
						pro=new ProfitsStatistics();
						renum=0;
						snum=selist.get(i).getSellNum();
						spp=sprice/snum;	
						profits=(snum-renum)*(spp-inpp);
						pro.setMid(mid);
						pro.setMname(mname);
						pro.setSnum(snum);
						pro.setInnum(innum);
						pro.setRenum(renum);				
						pro.setSprice(sprice);
						pro.setInprice(inprice);
						pro.setProfits(profits);
						pro.setInpp(inpp);
						pro.setSpp(spp);
						prolist.add(pro);
					}else{
						renum=0;
						snum=0;
					}					
				}				
			}
			
		}	     
			 model.addAttribute("list",prolist);
			 System.out.println("fdgsgrrrrrrr"+prolist.size());
			 Admin aa = (Admin) hs.getAttribute("admin");
			 logService.insertLog(aa.getUname(), "�鿴������Ϣ");
			 return "../jsp/sellManager/profitStatistics.jsp";			
	}
	
	
	/**
	 * ʵ��ҩƷ������Ϣ��񵼳�
	 * @param resq
	 * @param resp
	 * @return
	 */
	@RequestMapping("/exportSellExcel")
	public String exportSellExcel(HttpServletRequest resq,HttpServletResponse resp,HttpSession hs) {
		String title = "ҩƷ������Ϣ����";
		List<Sell> list = ss.sellMedExcel();
        String[] columnName = new String[]{"���۱��","���۵��ݺ�","ҩƷ���","ҩƷ����","��������","���۵���","��������","�ͻ�"};
        List<Object[]> dataList = new ArrayList<Object[]>();
        Object[] objs;	
        for (int i = 0; i < list.size(); i++) {
            objs = new Object[columnName.length];
            objs[0] = "S"+list.get(i).getSid();
            objs[1] = "MCS"+list.get(i).getSdocno();
            objs[2] = "MID"+list.get(i).getMed().getMid();
            objs[3] = list.get(i).getMed().getMname();
            objs[4] = list.get(i).getSnum();
            objs[5] = list.get(i).getSpprice();
            objs[6] = list.get(i).getSdate();
            objs[7] = list.get(i).getCust().getCname();
            dataList.add(objs);
        }
        //ʵ����������
        ExportExcel ex = new ExportExcel(title, columnName, dataList,resq,resp);
        try {
            //����excel
            ex.export();
            Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "����������Ϣ����");
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
	
	@RequestMapping("/exportRebillExcel")
	public String exportRebillExcel(HttpServletRequest resq,HttpServletResponse resp,HttpSession hs) {
		String title = "ҩƷ�˻���Ϣ����";
		List<Rebill> list = ss.rebillExcel();
        String[] columnName = new String[]{"�˻����","���۵��ݺ�","ҩƷ����","ҩƷ����","�˻�����","�˻�����","�˻��ͻ�","������"};
        List<Object[]> dataList = new ArrayList<Object[]>();
        Object[] objs;		
        for (int i = 0; i < list.size(); i++) {
            objs = new Object[columnName.length];
            objs[0] = "RE"+list.get(i).getReid();
            objs[1] = "MCS"+list.get(i).getSell().getSdocno();
            objs[2] = list.get(i).getSell().getMed().getMname();
            objs[3] = list.get(i).getSell().getMed().getFmedicine().getFmedicine();
            objs[4] = list.get(i).getRenum();
            objs[5] = list.get(i).getRedate() ;
            objs[6] = list.get(i).getSell().getCust().getCname();
            objs[7] = list.get(i).getAdmin().getUname();
            dataList.add(objs);
        }
        //ʵ����������
        ExportExcel ex = new ExportExcel(title, columnName, dataList,resq,resp);
        try {
            //����excel
            ex.export();
            Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "�����˻���Ϣ����");
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
	
	
	@RequestMapping("semedicineMesageLike")
	@ResponseBody
	public List<Sell> semedicineMesageLike(HttpSession hs,@RequestParam String mname,@RequestParam String fmedname) {
		List<Sell> list= new ArrayList<Sell>();
		System.out.println(fmedname);
		list=ss.semedicineMesageLike(mname, fmedname);
		System.out.println(list.toString());
		Admin aa = (Admin) hs.getAttribute("admin");
		logService.insertLog(aa.getUname(), "ģ����ѯҩƷ������Ϣ");
		return list;	
	}
	
	@RequestMapping("/exportprofitExcel")
	public String exportprofitExcel(HttpServletRequest resq,HttpServletResponse resp,HttpSession hs) {
		String title = "ҩƷ������Ϣ����";
		List<Inprofits> inlist=new ArrayList<Inprofits>();
		List<Sellprofits> selist=new ArrayList<Sellprofits>();
		List<Reprofits> relist=new ArrayList<Reprofits>();
		List<ProfitsStatistics> prolist=new ArrayList<ProfitsStatistics>();
		inlist=ss.inprofits();
		selist=ss.sellprofits();
		relist=ss.reprofits();	
		ProfitsStatistics pro=null;
		System.out.println(inlist+"/n"+inlist.size());
		System.out.println(selist);
		System.out.println(relist);
		int mid=0;						
		String mname=null;			
		int innum=0;			
		double sprice=0;
		double inprice=0;
		double inpp=0;
		double spp=0;
		int renum=0;
		int snum=0;
		double profits=0;
		int remid=0;
		int semid=0;
		for(int j=0;j<relist.size();j++) {
			for(int i=0;i<selist.size();i++) {
				for(int k=0;k<inlist.size();k++) {
					 mid=inlist.get(k).getMed().getMid();						
					 mname=inlist.get(k).getMed().getMname();			
					 innum=inlist.get(k).getInnum();			
					 sprice=selist.get(i).getSellProfits();
					 inprice=inlist.get(k).getInprice();
					 inpp=inprice/innum;
					 remid=relist.get(j).getMid();
					 semid=selist.get(i).getMid();
					if(mid==semid&&semid==remid&&mid==remid) {
						pro=new ProfitsStatistics();
						renum=relist.get(j).getRenum();	
						snum=selist.get(i).getSellNum();
						spp=sprice/snum;
						profits=(snum-renum)*(spp-inpp);
						pro.setMid(mid);
						pro.setMname(mname);
						pro.setSnum(snum);
						pro.setInnum(innum);
						pro.setRenum(renum);				
						pro.setSprice(sprice);
						pro.setInprice(inprice);
						pro.setProfits(profits);
						pro.setInpp(inpp);
						pro.setSpp(spp);
						prolist.add(pro);
						break;
					}else if(mid==semid&&semid!=remid) {						
						pro=new ProfitsStatistics();
						renum=0;
						snum=selist.get(i).getSellNum();
						spp=sprice/snum;	
						profits=(snum-renum)*(spp-inpp);
						pro.setMid(mid);
						pro.setMname(mname);
						pro.setSnum(snum);
						pro.setInnum(innum);
						pro.setRenum(renum);				
						pro.setSprice(sprice);
						pro.setInprice(inprice);
						pro.setProfits(profits);
						pro.setInpp(inpp);
						pro.setSpp(spp);
						prolist.add(pro);
					}else{
						renum=0;
						snum=0;
					}					
				}				
			}
			
		}	     
        String[] columnName = new String[]{"ҩƷ���","ҩƷ����","��������","�˻�����","��������","���۵���","�������","���۽��","����"};
        List<Object[]> dataList = new ArrayList<Object[]>();
        Object[] objs;	
        for (int i = 0; i < prolist.size(); i++) {
            objs = new Object[columnName.length];
            objs[0] = "MID"+prolist.get(i).getMid()+1;
            objs[1] = prolist.get(i).getMname();
            objs[2] = prolist.get(i).getSnum();
            objs[3] = prolist.get(i).getRenum();
            objs[4] = prolist.get(i).getInpp() ;
            objs[5] = prolist.get(i).getSpp();
            objs[6] = prolist.get(i).getInprice();
            objs[7] = prolist.get(i).getSprice();
            objs[8] = prolist.get(i).getProfits();
            dataList.add(objs);
        }
        //ʵ����������
        ExportExcel ex = new ExportExcel(title, columnName, dataList,resq,resp);
        try {
            //����excel
            ex.export();
            Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "�����������󱨱�");
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
	
	@RequestMapping("/sellbill")
	public String sellbill() {
		return "../jsp/sellManager/sellBill.jsp";
	}
	
	@RequestMapping("/exportsellbillExcel")
	public String exportsellbillExcel(@RequestParam(value="mname") String mname,@RequestParam(value="sellnum") int sellnum,@RequestParam(value="sellprice") double sellprice,
			@RequestParam(value="totalprice") double totalprice,@RequestParam(value="uname") String uname ,@RequestParam(value="date") String date,
			HttpServletRequest resq,HttpServletResponse resp,HttpSession hs) {
		String title = "ҩƷ���ۿ���";
        String[] columnName = new String[]{"ҩƷ����","��������","���۵���","�����ܶ�","������","��������"};
        List<Object[]> dataList = new ArrayList<Object[]>();
        Object[] objs;		
        for (int i = 0; i < 1; i++) {
            objs = new Object[columnName.length];
            objs[0] = mname;
            objs[1] = sellnum;
            objs[2] = sellprice;
            objs[3] = totalprice;
            objs[4] = uname;
            objs[5] = date ;   
            dataList.add(objs);
        }
        //ʵ����������
        ExportExcel ex = new ExportExcel(title, columnName, dataList,resq,resp);
        try {
            //����excel
            ex.export();
            Admin aa = (Admin) hs.getAttribute("admin");
			logService.insertLog(aa.getUname(), "�������ۿ�����");
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
	
	
	@RequestMapping("/profitsStatisticsdisplay")
	@ResponseBody
	public List<ProfitsStatistics> profitsStatisticsdisplay(Model model,HttpSession hs) {
		List<Inprofits> inlist=new ArrayList<Inprofits>();
		List<Sellprofits> selist=new ArrayList<Sellprofits>();
		List<Reprofits> relist=new ArrayList<Reprofits>();
		List<ProfitsStatistics> prolist=new ArrayList<ProfitsStatistics>();
		inlist=ss.inprofits();
		selist=ss.sellprofits();
		relist=ss.reprofits();	
		ProfitsStatistics pro=null;
		int mid=0;						
		String mname=null;			
		int innum=0;			
		double sprice=0;
		double inprice=0;
		double inpp=0;
		double spp=0;
		int renum=0;
		int snum=0;
		double profits=0;
		int remid=0;
		int semid=0;
		for(int j=0;j<relist.size();j++) {
			for(int i=0;i<selist.size();i++) {
				for(int k=0;k<inlist.size();k++) {
					 mid=inlist.get(k).getMed().getMid();						
					 mname=inlist.get(k).getMed().getMname();			
					 innum=inlist.get(k).getInnum();			
					 sprice=selist.get(i).getSellProfits();
					 inprice=inlist.get(k).getInprice();
					 inpp=inprice/innum;
					 remid=relist.get(j).getMid();
					 semid=selist.get(i).getMid();
					if(mid==semid&&semid==remid&&mid==remid) {
						pro=new ProfitsStatistics();
						renum=relist.get(j).getRenum();	
						snum=selist.get(i).getSellNum();
						spp=sprice/snum;
						profits=(snum-renum)*(spp-inpp);
						pro.setMid(mid);
						pro.setMname(mname);
						pro.setSnum(snum);
						pro.setInnum(innum);
						pro.setRenum(renum);				
						pro.setSprice(sprice);
						pro.setInprice(inprice);
						pro.setProfits(profits);
						pro.setInpp(inpp);
						pro.setSpp(spp);
						prolist.add(pro);
						break;
					}else if(mid==semid&&semid!=remid) {						
						pro=new ProfitsStatistics();
						renum=0;
						snum=selist.get(i).getSellNum();
						spp=sprice/snum;	
						profits=(snum-renum)*(spp-inpp);
						pro.setMid(mid);
						pro.setMname(mname);
						pro.setSnum(snum);
						pro.setInnum(innum);
						pro.setRenum(renum);				
						pro.setSprice(sprice);
						pro.setInprice(inprice);
						pro.setProfits(profits);
						pro.setInpp(inpp);
						pro.setSpp(spp);
						prolist.add(pro);
					}else{
						renum=0;
						snum=0;
					}					
				}				
			}
			
		}	     
			 model.addAttribute("list",prolist);
			 System.out.println("fdgsgrrrrrrr"+prolist.size());
			 Admin aa = (Admin) hs.getAttribute("admin");
			 logService.insertLog(aa.getUname(), "�鿴����ͼ����Ϣ");
			 return prolist;			
	}
}


