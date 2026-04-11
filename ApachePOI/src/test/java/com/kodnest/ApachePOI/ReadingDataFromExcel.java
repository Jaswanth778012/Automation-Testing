package com.kodnest.ApachePOI;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadingDataFromExcel {
	public static void main(String[] args) throws IOException  {
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "//testdata//Data.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		
		XSSFSheet xs = wb.getSheet("Sheet1");
		
		int totalRows = xs.getLastRowNum();
		
		int totalCells = xs.getRow(1).getLastCellNum();
		
		System.out.println("Total No.of rows: " + totalRows);
		System.out.println("Total No.of cells: " + totalCells);
		
		DataFormatter format = new DataFormatter();
		
		for(int i=0;i<=totalRows; i++) {
			
			XSSFRow currentRow = xs.getRow(i);
			for(int j=0; j<totalCells; j++) {
				XSSFCell currentCell = currentRow.getCell(j);
				
				String value = format.formatCellValue(currentCell);
				
				System.out.print(value + " ");
			}
			
			System.out.println();
		}
		
		wb.close();
		fs.close();
	}
}
