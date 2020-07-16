package org.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DataDriven extends Base{
public static void main(String[] args) throws IOException {
	
	File f = new File("C:\\Users\\Lenovo\\eclipse-workspace\\ExcelTest\\excel\\hij.xlsx");
	FileInputStream fin=new FileInputStream(f);
	Workbook w = new XSSFWorkbook(fin);
	Sheet s = w.getSheet("sreeni");
	
	//int pr = s.getPhysicalNumberOfRows();
	//for(int i=0; i<s.getPhysicalNumberOfRows();i++) {
	//	Row r = s.getRow(i);
		//for(int j=0; j<r.getPhysicalNumberOfCells();j++) {
		//	Cell c=r.getCell(j);
		
		Row r = s.getRow(1);
		Cell c = r.getCell(1);
			int ct = c.getCellType();
	
	
	if(ct==1) {
		String sd = c.getStringCellValue();
		System.out.println(sd);
		}
	else if(ct==0) {
		if(DateUtil.isCellDateFormatted(c)) {
			Date d= c.getDateCellValue();
			SimpleDateFormat sim =new SimpleDateFormat("dd-mm-yyyy");
			String fm = sim.format(d);
			System.out.println(fm);
		}
		
		
		else {
			double nc = c.getNumericCellValue();
	long l=(long)nc;
	System.out.println(l);
	
	
		}}
	
		
	

}}
 