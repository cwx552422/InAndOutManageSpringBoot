package com.java.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class OracleDatabaseBackup {
//	public static void main(String[] args) {
		// 数据库的名称要使用大写
//		backUpDataBaseOracle("cl", "cl1234", "ORCL", "D:/oralce");
//		 resumeDataBaseOracle("cl", "cl1234", "ORCL", "D:/oralce");
//	}

	/**
	 * 备份指定用户数据库
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @param databseName
	 *            数据库名称
	 * @param address
	 *            保存地址 d:/oracle/backup
	 */
	public static boolean backUpDataBaseOracle(String userName, String password, String databseName, String address) {
		// 拼接dos命令进行数据库备份
		StringBuffer exp = new StringBuffer("exp ");
		exp.append(userName);
		exp.append("/");
		exp.append(password);
		exp.append("@");
		exp.append(databseName);
		exp.append(" file=");
		/*
		 * 得到存储地址的最后一个字符，如果有“\”就直接拼装地址，如果没有\就加上/然后拼装数据库名称
		 */
		String maxIndex = address.substring(address.length() - 1);
		if ("/".equals(maxIndex) || "\\".equals(maxIndex)) {
			exp.append(address);
		} else {
			address = address + "\\";
			exp.append(address);
		}
		File file = new File(address);
		// 如果文件不存在那么就重新创建，包括父目录
		if (!file.exists()) {
			file.mkdirs();
		}
		exp.append(databseName);
		exp.append(".dmp");
		System.out.println("开始备份");
		try {
			System.out.println(exp.toString());
			Process p = Runtime.getRuntime().exec(exp.toString());
			InputStreamReader isr = new InputStreamReader(p.getErrorStream());
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				if (line.indexOf("错误") != -1) {
					break;
				}

			}
			p.destroy();
			p.waitFor();
			System.out.println("备份成功！");
			return true;
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
			return false;

		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
	}

	// 还原指定表
	public static boolean resumeDataBaseOracle(String userName, String password, String dataBaseName, String address,String table[]) {
		// 拼接DOS命令进行数据库还原
		StringBuffer imp = new StringBuffer("imp ");
		imp.append(userName);
		imp.append("/");
		imp.append(password);
		imp.append("@");
		imp.append(dataBaseName);
		imp.append(" file=");

		String maxIndex = address.substring(address.length() - 1);
		if ("/".equals(maxIndex) || "||".equals(maxIndex)) {
			imp.append(address);
		} else {
			address = address + "\\";
			imp.append(address);
		}
		imp.append(dataBaseName);
		imp.append(".dmp");
		imp.append(" tables=(");
		for(int i=0;i<table.length;i++) {
			if(i==0) {
				imp.append(table[i]);
			}else {
				imp.append(","+table[i]);
			}		
		}	
		imp.append(")");
		File file = new File(address + dataBaseName + ".dmp");
		// 判断文件是否存在，存在才进行恢复，不存在就不恢复
		if (file.exists()) {
			System.out.println("开始恢复...");
			try {
				System.out.println(imp.toString());
				Process p = Runtime.getRuntime().exec(imp.toString());
				InputStreamReader isr = new InputStreamReader(p.getErrorStream());
				BufferedReader br = new BufferedReader(isr);
				String line = null;
				while ((line = br.readLine()) != null) {
					if (line.indexOf("错误") != -1) {
						break;
					}
				}
				p.destroy();
				System.out.println("恢复成功！");
				p.waitFor();
				return true;
			} catch (IOException e) {
				System.out.println(e.getMessage());
				return false;
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				return false;
			}
		}else {
			return false;
		}
	}

}