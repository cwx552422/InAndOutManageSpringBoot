package com.java.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.service.AdminService;
import com.java.vo.Admin;

@Controller
public class UpdatePhonoController {

	@Autowired
	private AdminService as;

	@RequestMapping("/admin/uplode/photo")
	@ResponseBody
	public Map<String, Object> updatePhoto(@RequestParam String paths,HttpSession hs,HttpServletRequest request, HttpServletResponse response,
			@RequestParam("myFile") MultipartFile myFile) {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			// ����ļ���׺����
			System.out.println(myFile.getOriginalFilename());
			System.out.println(paths);
			DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			// ͼƬ����
			String name = df.format(new Date());

			Random r = new Random();
			for (int i = 0; i < 3; i++) {
				name += r.nextInt(10);
			}
			//
			String ext = FilenameUtils.getExtension(myFile.getOriginalFilename());
			// ����ͼƬ Fileλ�� ��ȫ·���� /upload/fileName.jpg
//			String url = request.getSession().getServletContext().getRealPath("/") + "WEB-INF\\resources\\img"+ File.separator +"admin";
		       
//			String url = request.getSession().getServletContext().getRealPath("/static/img/upload/phono/");
			String url = "C:/Users/Administrator/Desktop/InAndOutManage2/src/main/webapp/WEB-INF/resources/img/admin";
			// ���·��
			String path = File.separator  + name + "." + ext;
			File file = new File(url);
			if (!file.exists()) {
				file.mkdirs();
			}
			myFile.transferTo(new File(url + path));
			Admin admin = (Admin) request.getSession().getAttribute("admin");
			as.updataimg(paths+File.separator+"static/img/admin"+path, admin.getUid());
			System.out.println("aaaaaaaaaa"+url+path);
			json.put("success", "/static/img/upload/phono" + path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;

	}
}