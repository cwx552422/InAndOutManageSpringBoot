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
	      * 显示的导出表的标题
	      */
	     private String title;
	 
	     /**
	      * 导出表的列名
	      */
	     private String[] columnName;
	 
	     /**
	      * 需要导出的数据集合
	      */
	     private List<Object[]> dataList = new ArrayList<Object[]>();
	 
	     /**
	      * 输出流对象
	      */
	     private HttpServletResponse response;
	 
	 
	     /**
	      *
	      * @param title
	      * @param columnName
	      * @param dataList
	      * @param request
	      * @param response
	      * @description 构造方法，传入要导出的数据
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
	      * @description 导出数据到excel
	      */
	     @SuppressWarnings("deprecation")
		public void export() throws Exception {
	 
	         try {
	             HSSFWorkbook workbook = new HSSFWorkbook();                        // 创建工作簿对象
	             HSSFSheet sheet = workbook.createSheet(title);                     // 创建工作表
	 
	             // 产生表格标题行
	             HSSFRow rowm = sheet.createRow(0);
	             HSSFCell cellTiltle = rowm.createCell(0);
	 
	             //设置标题和单元格样式
	             HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook);  //获取列头样式对象
	             HSSFCellStyle style = this.getStyle(workbook);                    //单元格样式对象
	 
	             //合并单元格
	             sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, (columnName.length - 1)));
	             cellTiltle.setCellStyle(columnTopStyle);
	             cellTiltle.setCellValue(title);
	 
	             // 定义所需列数
	             int columnNum = columnName.length;
	             HSSFRow rowRowName = sheet.createRow(2);                 // 在索引2的位置创建行(最顶端的行开始的第二行)
	 
	 
	             // 将列头设置到sheet的单元格中
	             for (int n = 0; n < columnNum; n++) {
	                 HSSFCell cellRowName = rowRowName.createCell(n);                  //创建列头对应个数的单元格
	                 cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING);                //设置列头单元格的数据类型
	                 HSSFRichTextString text = new HSSFRichTextString(columnName[n]);
	                 cellRowName.setCellValue(text);                                    //设置列头单元格的值
	                 cellRowName.setCellStyle(columnTopStyle);                          //设置列头单元格样式
	             }
	 
	             //将查询出的数据设置到sheet对应的单元格中
	             for (int i = 0; i < dataList.size(); i++) {
	                 Object[] obj = dataList.get(i);//遍历每个对象
	                 HSSFRow row = sheet.createRow(i + 3);//创建所需的行数
	                 for (int j = 0; j < obj.length; j++) {
	                     HSSFCell cell = null;   //设置单元格的数据类型
	                     //第一列为数字类型并设置单元格的值
//	                     if (j == 0) {
//	                         cell = row.createCell(j, HSSFCell.CELL_TYPE_NUMERIC);
//	                         cell.setCellValue(i + 1);
//	                     } else {
	                         //其他列为字符串类型并设置单元格的值
	                         cell = row.createCell(j, HSSFCell.CELL_TYPE_STRING);
	                         if (!"".equals(obj[j]) && obj[j] != null) {
	                             cell.setCellValue(obj[j].toString());
	                         }
//	                     }
	                     cell.setCellStyle(style);                                    //设置单元格样式
	                 }
	             }
	 
	 
	             //让列宽随着导出的列长自动适应
	             for (int colNum = 0; colNum < columnNum; colNum++) {
	                 int columnWidth = sheet.getColumnWidth(colNum) / 256;
	                 for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
	                     HSSFRow currentRow;
	                     //当前行未被使用过
	                     if (sheet.getRow(rowNum) == null) {
	                         currentRow = sheet.createRow(rowNum);
	                     } else {
	                         currentRow = sheet.getRow(rowNum);
	                     }
	                     if (currentRow.getCell(colNum) != null) {
	                         //取得当前的单元格
	                         HSSFCell currentCell = currentRow.getCell(colNum);
	                         //如果当前单元格类型为字符串
	                         if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
	                        	 if(currentCell.getRichStringCellValue()==null) {
	                            	 currentCell.setCellValue("null");
	                             }
	                        	 int length = currentCell.getStringCellValue().getBytes().length;
	                            
	                             if (columnWidth < length) {
	                                 //将单元格里面值大小作为列宽度
	                                 columnWidth = length;
	                             }
	                         }
	                     }
	                 }
	                 //再根据不同列单独做下处理
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
	    * @description 标题行的单元格样式
	    */
	   @SuppressWarnings("deprecation")
	public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {
	
	       // 设置字体
	       HSSFFont font = workbook.createFont();
	       //设置字体大小
	       font.setFontHeightInPoints((short) 11);
	       //字体加粗
	       font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	       //设置字体名字
	       font.setFontName("Courier New");
	       //设置样式;
	       HSSFCellStyle style = workbook.createCellStyle();
	       style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
	       //设置底边框;
	       style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	       //设置底边框颜色;
	       style.setBottomBorderColor(HSSFColor.BLACK.index);
	       //设置左边框;
	       style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	       //设置左边框颜色;
	       style.setLeftBorderColor(HSSFColor.BLACK.index);
	       //设置右边框;
	       style.setBorderRight(HSSFCellStyle.BORDER_THIN);
	       //设置右边框颜色;
	       style.setRightBorderColor(HSSFColor.BLACK.index);
	       //设置顶边框;
	       style.setBorderTop(HSSFCellStyle.BORDER_THIN);
	       //设置顶边框颜色;
	       style.setTopBorderColor(HSSFColor.BLACK.index);
	       //在样式用应用设置的字体;
	       style.setFont(font);
	       //设置自动换行;
	       style.setWrapText(false);
	       //设置水平对齐的样式为居中对齐;
	       style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	       //设置垂直对齐的样式为居中对齐;
	       style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	       return style;
	   }
	
	   /**
	    * @param
	    * @return
	    * @description 列数据信息单元格样式
	    */
	   @SuppressWarnings("deprecation")
	public HSSFCellStyle getStyle(HSSFWorkbook workbook) {
	       // 设置字体
	       HSSFFont font = workbook.createFont();
	       //设置字体大小
	       //font.setFontHeightInPoints((short)10);
	       //字体加粗
	       //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	       //设置字体名字
	       font.setFontName("Courier New");
	       //设置样式;
	       HSSFCellStyle style = workbook.createCellStyle();
	       //设置底边框;
	       style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	       //设置底边框颜色;
	       style.setBottomBorderColor(HSSFColor.BLACK.index);
	       //设置左边框;
	       style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	       //设置左边框颜色;
	       style.setLeftBorderColor(HSSFColor.BLACK.index);
	       //设置右边框;
	       style.setBorderRight(HSSFCellStyle.BORDER_THIN);
	       //设置右边框颜色;
	       style.setRightBorderColor(HSSFColor.BLACK.index);
	       //设置顶边框;
	       style.setBorderTop(HSSFCellStyle.BORDER_THIN);
	       //设置顶边框颜色;
	       style.setTopBorderColor(HSSFColor.BLACK.index);
	       //在样式用应用设置的字体;
	       style.setFont(font);
	       //设置自动换行;
	       style.setWrapText(false);
	       //设置水平对齐的样式为居中对齐;
	       style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	       //设置垂直对齐的样式为居中对齐;
	       style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	       return style;
	   }
}
