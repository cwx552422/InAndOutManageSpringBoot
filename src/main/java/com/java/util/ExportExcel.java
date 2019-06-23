package com.java.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExportExcel {
	/**
	      * ��ʾ�ĵ�����ı���
	      */
	     private String title;
	 
	     /**
	      * �����������
	      */
	     private String[] columnName;
	 
	     /**
	      * ��Ҫ���������ݼ���
	      */
	     private List<Object[]> dataList = new ArrayList<Object[]>();
	 
	     /**
	      * ���������
	      */
	     private HttpServletResponse response;
	 
	 
	     /**
	      *
	      * @param title
	      * @param columnName
	      * @param dataList
	      * @param request
	      * @param response
	      * @description ���췽��������Ҫ����������
	      */
	     public ExportExcel(String title, String[] columnName, List<Object[]> dataList,HttpServletRequest request,HttpServletResponse response) {
	         this.dataList = dataList;
	         this.columnName = columnName;
	         this.title = title;
	         this.response= response;
	     }
	 
	 
	     /**
	      * @param
	      * @return
	      * @description �������ݵ�excel
	      */
	     @SuppressWarnings("deprecation")
		public void export() throws Exception {
	 
	         try {
	             HSSFWorkbook workbook = new HSSFWorkbook();                        // ��������������
	             HSSFSheet sheet = workbook.createSheet(title);                     // ����������
	 
	             // ������������
	             HSSFRow rowm = sheet.createRow(0);
	             HSSFCell cellTiltle = rowm.createCell(0);
	 
	             //���ñ���͵�Ԫ����ʽ
	             HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook);  //��ȡ��ͷ��ʽ����
	             HSSFCellStyle style = this.getStyle(workbook);                    //��Ԫ����ʽ����
	 
	             //�ϲ���Ԫ��
	             sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, (columnName.length - 1)));
	             cellTiltle.setCellStyle(columnTopStyle);
	             cellTiltle.setCellValue(title);
	 
	             // ������������
	             int columnNum = columnName.length;
	             HSSFRow rowRowName = sheet.createRow(2);                 // ������2��λ�ô�����(��˵��п�ʼ�ĵڶ���)
	 
	 
	             // ����ͷ���õ�sheet�ĵ�Ԫ����
	             for (int n = 0; n < columnNum; n++) {
	                 HSSFCell cellRowName = rowRowName.createCell(n);                  //������ͷ��Ӧ�����ĵ�Ԫ��
	                 cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING);                //������ͷ��Ԫ�����������
	                 HSSFRichTextString text = new HSSFRichTextString(columnName[n]);
	                 cellRowName.setCellValue(text);                                    //������ͷ��Ԫ���ֵ
	                 cellRowName.setCellStyle(columnTopStyle);                          //������ͷ��Ԫ����ʽ
	             }
	 
	             //����ѯ�����������õ�sheet��Ӧ�ĵ�Ԫ����
	             for (int i = 0; i < dataList.size(); i++) {
	                 Object[] obj = dataList.get(i);//����ÿ������
	                 HSSFRow row = sheet.createRow(i + 3);//�������������
	                 for (int j = 0; j < obj.length; j++) {
	                     HSSFCell cell = null;   //���õ�Ԫ�����������
	                     //��һ��Ϊ�������Ͳ����õ�Ԫ���ֵ
//	                     if (j == 0) {
//	                         cell = row.createCell(j, HSSFCell.CELL_TYPE_NUMERIC);
//	                         cell.setCellValue(i + 1);
//	                     } else {
	                         //������Ϊ�ַ������Ͳ����õ�Ԫ���ֵ
	                         cell = row.createCell(j, HSSFCell.CELL_TYPE_STRING);
	                         if (!"".equals(obj[j]) && obj[j] != null) {
	                             cell.setCellValue(obj[j].toString());
	                         }
//	                     }
	                     cell.setCellStyle(style);                                    //���õ�Ԫ����ʽ
	                 }
	             }
	 
	 
	             //���п����ŵ������г��Զ���Ӧ
	             for (int colNum = 0; colNum < columnNum; colNum++) {
	                 int columnWidth = sheet.getColumnWidth(colNum) / 256;
	                 for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
	                     HSSFRow currentRow;
	                     //��ǰ��δ��ʹ�ù�
	                     if (sheet.getRow(rowNum) == null) {
	                         currentRow = sheet.createRow(rowNum);
	                     } else {
	                         currentRow = sheet.getRow(rowNum);
	                     }
	                     if (currentRow.getCell(colNum) != null) {
	                         //ȡ�õ�ǰ�ĵ�Ԫ��
	                         HSSFCell currentCell = currentRow.getCell(colNum);
	                         //�����ǰ��Ԫ������Ϊ�ַ���
	                         if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
	                        	 if(currentCell.getRichStringCellValue()==null) {
	                            	 currentCell.setCellValue("null");
	                             }
	                        	 int length = currentCell.getStringCellValue().getBytes().length;
	                            
	                             if (columnWidth < length) {
	                                 //����Ԫ������ֵ��С��Ϊ�п��
	                                 columnWidth = length;
	                             }
	                         }
	                     }
	                 }
	                 //�ٸ��ݲ�ͬ�е������´���
	                 if (colNum == 0) {
	                     sheet.setColumnWidth(colNum, (columnWidth - 2) * 256);
	                 } else {
	                     sheet.setColumnWidth(colNum, (columnWidth + 4) * 256);
	                 }
	             }
	 
	             if (workbook != null) {
	                 try {
	                     String fileName = "Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";
	                     String headStr = "attachment; filename=\"" + fileName + "\"";
	                     response.setContentType("APPLICATION/OCTET-STREAM");
	                     response.setHeader("Content-Disposition", headStr);
	                   OutputStream out1 = response.getOutputStream();
	                   workbook.write(out1);
	               } catch (IOException e) {
	                   e.printStackTrace();
	               }
	           }
	
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	   }
	
	
	   /**
	    * @param
	    * @return
	    * @author chenli
	    * @description �����еĵ�Ԫ����ʽ
	    */
	   @SuppressWarnings("deprecation")
	public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {
	
	       // ��������
	       HSSFFont font = workbook.createFont();
	       //���������С
	       font.setFontHeightInPoints((short) 11);
	       //����Ӵ�
	       font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	       //������������
	       font.setFontName("Courier New");
	       //������ʽ;
	       HSSFCellStyle style = workbook.createCellStyle();
	       style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
	       //���õױ߿�;
	       style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	       //���õױ߿���ɫ;
	       style.setBottomBorderColor(HSSFColor.BLACK.index);
	       //������߿�;
	       style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	       //������߿���ɫ;
	       style.setLeftBorderColor(HSSFColor.BLACK.index);
	       //�����ұ߿�;
	       style.setBorderRight(HSSFCellStyle.BORDER_THIN);
	       //�����ұ߿���ɫ;
	       style.setRightBorderColor(HSSFColor.BLACK.index);
	       //���ö��߿�;
	       style.setBorderTop(HSSFCellStyle.BORDER_THIN);
	       //���ö��߿���ɫ;
	       style.setTopBorderColor(HSSFColor.BLACK.index);
	       //����ʽ��Ӧ�����õ�����;
	       style.setFont(font);
	       //�����Զ�����;
	       style.setWrapText(false);
	       //����ˮƽ�������ʽΪ���ж���;
	       style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	       //���ô�ֱ�������ʽΪ���ж���;
	       style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	       return style;
	   }
	
	   /**
	    * @param
	    * @return
	    * @description ��������Ϣ��Ԫ����ʽ
	    */
	   @SuppressWarnings("deprecation")
	public HSSFCellStyle getStyle(HSSFWorkbook workbook) {
	       // ��������
	       HSSFFont font = workbook.createFont();
	       //���������С
	       //font.setFontHeightInPoints((short)10);
	       //����Ӵ�
	       //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	       //������������
	       font.setFontName("Courier New");
	       //������ʽ;
	       HSSFCellStyle style = workbook.createCellStyle();
	       //���õױ߿�;
	       style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	       //���õױ߿���ɫ;
	       style.setBottomBorderColor(HSSFColor.BLACK.index);
	       //������߿�;
	       style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	       //������߿���ɫ;
	       style.setLeftBorderColor(HSSFColor.BLACK.index);
	       //�����ұ߿�;
	       style.setBorderRight(HSSFCellStyle.BORDER_THIN);
	       //�����ұ߿���ɫ;
	       style.setRightBorderColor(HSSFColor.BLACK.index);
	       //���ö��߿�;
	       style.setBorderTop(HSSFCellStyle.BORDER_THIN);
	       //���ö��߿���ɫ;
	       style.setTopBorderColor(HSSFColor.BLACK.index);
	       //����ʽ��Ӧ�����õ�����;
	       style.setFont(font);
	       //�����Զ�����;
	       style.setWrapText(false);
	       //����ˮƽ�������ʽΪ���ж���;
	       style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	       //���ô�ֱ�������ʽΪ���ж���;
	       style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	       return style;
	   }
}
