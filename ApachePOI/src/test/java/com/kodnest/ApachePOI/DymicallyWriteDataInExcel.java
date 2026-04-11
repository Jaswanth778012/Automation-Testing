package com.kodnest.ApachePOI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DymicallyWriteDataInExcel {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook();
		
		XSSFSheet sheet = wb.createSheet("DynamicData");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the no.of rows");
		int rows = sc.nextInt();
		
		System.out.println("Enter the no.of cells");
		int cells = sc.nextInt();
		
		sc.nextLine();
		
		DataFormatter format = new DataFormatter();
		
		for(int i=0; i<rows; i++) {
			System.out.println("Enter the details in row " + (i));
			XSSFRow row = sheet.createRow(i);
			for(int j=0; j<cells; j++) {
				System.out.println("Enter the details in cell " +(j));
				 XSSFCell cell = row.createCell(j);
				 cell.setCellValue(sc.next());
			}
		}
		
		FileOutputStream fo = new FileOutputStream(System.getProperty("user.dir")+ "//testdata//dynamicdata.xlsx");
		wb.write(fo);
		wb.close();
		fo.close();
	}

}
