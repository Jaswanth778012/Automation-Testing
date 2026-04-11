package com.kodnest.ApachePOI;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook();
		
		XSSFSheet sheet = wb.createSheet("TestData1");
		
		XSSFRow row1 = sheet.createRow(0);
		
		row1.createCell(0).setCellValue("Jaswanth");
		row1.createCell(1).setCellValue(21);
		row1.createCell(2).setCellValue(300.50);
		
		
		XSSFRow row2 = sheet.createRow(1);
		
		row2.createCell(0).setCellValue("Jaswanth");
		row2.createCell(1).setCellValue(21);
		row2.createCell(2).setCellValue(300.50);
		
		XSSFRow row3 = sheet.createRow(2);
		
		row3.createCell(0).setCellValue("Jaswanth");
		row3.createCell(1).setCellValue(21);
		row3.createCell(2).setCellValue(300.50);
		
		FileOutputStream fo = new FileOutputStream(System.getProperty("user.dir")+"//testdata//myfile.xlsx");
		
		wb.write(fo);
		wb.close();
		fo.close();
	}

}
