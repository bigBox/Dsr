package com.dj.tool.error;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jodd.io.FileUtil;

public class ToolError2Xlsx {
	public static void main(String[] args) throws Exception {
		String url = "D:\\work_project\\mycore\\doc\\策划\\待解析表格\\服务器错误码_ServerError.xlsx";
		File file = new File(url);
		FileUtil.copyFile(new File("F:\\java-work\\ServerError_template.xlsx"), file);
		try (InputStream is = new FileInputStream(url);
				XSSFWorkbook excel = new XSSFWorkbook(is);
				FileOutputStream out = new FileOutputStream(url)) {
			XSSFSheet sheet = excel.getSheetAt(0);
			int rowIndex = 5;
			for (Field e : ErrorCode.class.getDeclaredFields()) {
				String text;
				ErrorDesc c = e.getAnnotation(ErrorDesc.class);
				if (c != null) {
					int code = e.getInt(null);
					XSSFRow row = sheet.getRow(rowIndex);
					if (row == null) {
						row = sheet.createRow(rowIndex);
					}
					if (row.getCell(0) == null) {
						row.createCell(0);
					}
					row.getCell(0).setCellValue(code + "");
					if (row.getCell(1) == null) {
						row.createCell(1);
					}
					byte[] b1 = c.text().getBytes(StandardCharsets.UTF_8);
					text = new String(b1, StandardCharsets.UTF_8);
					row.getCell(1).setCellValue(text);
					if (row.getCell(2) == null) {
						row.createCell(2);
					}
					row.getCell(2).setCellValue(c.isShow());
					rowIndex++;
					System.out.println(code +" "+c.isShow()+"	->	"+ text);
				}
			}
			excel.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/**
 * JDK是面向开发人员使用的SDK
 * JRE是Java Runtime Enviroment是指Java的运行环境。只要你的电脑安装了JRE，就可以正确的运行Java应用程序。
 * 
 * 
 * 
 * 
 * 
 **/
