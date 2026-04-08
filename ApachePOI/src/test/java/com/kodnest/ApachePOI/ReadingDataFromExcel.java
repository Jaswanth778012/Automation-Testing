package com.kodnest.ApachePOI;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class ReadingDataFromExcel {
	public static void main(String[] args) throws IOException  {
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "//testdata//Data.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fs);
	}
}
