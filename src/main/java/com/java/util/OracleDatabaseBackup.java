package com.java.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class OracleDatabaseBackup {
//	public static void main(String[] args) {
		// ���ݿ������Ҫʹ�ô�д
//		backUpDataBaseOracle("cl", "cl1234", "ORCL", "D:/oralce");
//		 resumeDataBaseOracle("cl", "cl1234", "ORCL", "D:/oralce");
//	}

	/**
	 * ����ָ���û����ݿ�
	 * 
	 * @param userName
	 *            �û���
	 * @param password
	 *            ����
	 * @param databseName
	 *            ���ݿ�����
	 * @param address
	 *            �����ַ d:/oracle/backup
	 */
	public static boolean backUpDataBaseOracle(String userName, String password, String databseName, String address) {
		// ƴ��dos����������ݿⱸ��
		StringBuffer exp = new StringBuffer("exp ");
		exp.append(userName);
		exp.append("/");
		exp.append(password);
		exp.append("@");
		exp.append(databseName);
		exp.append(" file=");
		/*
		 * �õ��洢��ַ�����һ���ַ�������С�\����ֱ��ƴװ��ַ�����û��\�ͼ���/Ȼ��ƴװ���ݿ�����
		 */
		String maxIndex = address.substring(address.length() - 1);
		if ("/".equals(maxIndex) || "\\".equals(maxIndex)) {
			exp.append(address);
		} else {
			address = address + "\\";
			exp.append(address);
		}
		File file = new File(address);
		// ����ļ���������ô�����´�����������Ŀ¼
		if (!file.exists()) {
			file.mkdirs();
		}
		exp.append(databseName);
		exp.append(".dmp");
		System.out.println("��ʼ����");
		try {
			System.out.println(exp.toString());
			Process p = Runtime.getRuntime().exec(exp.toString());
			InputStreamReader isr = new InputStreamReader(p.getErrorStream());
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				if (line.indexOf("����") != -1) {
					break;
				}

			}
			p.destroy();
			p.waitFor();
			System.out.println("���ݳɹ���");
			return true;
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
			return false;

		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
	}

	// ��ԭָ����
	public static boolean resumeDataBaseOracle(String userName, String password, String dataBaseName, String address,String table[]) {
		// ƴ��DOS����������ݿ⻹ԭ
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
		// �ж��ļ��Ƿ���ڣ����ڲŽ��лָ��������ھͲ��ָ�
		if (file.exists()) {
			System.out.println("��ʼ�ָ�...");
			try {
				System.out.println(imp.toString());
				Process p = Runtime.getRuntime().exec(imp.toString());
				InputStreamReader isr = new InputStreamReader(p.getErrorStream());
				BufferedReader br = new BufferedReader(isr);
				String line = null;
				while ((line = br.readLine()) != null) {
					if (line.indexOf("����") != -1) {
						break;
					}
				}
				p.destroy();
				System.out.println("�ָ��ɹ���");
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