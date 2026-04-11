package com.kodnest.ApachePOI.sirQuestionOnPOI;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SirsQuestion {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook();
		
		XSSFSheet sheet = wb.createSheet("Sheet1");
		
		XSSFRow row3 = sheet.createRow(3);
		row3.createCell(2).setCellValue(300.50);
		
		FileOutputStream fo = new FileOutputStream(System.getProperty("user.dir") + "//testdata//sirquestion.xlsx");
		wb.write(fo);
		wb.close();
		fo.close();
	}

}
