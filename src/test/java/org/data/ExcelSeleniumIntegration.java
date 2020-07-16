package org.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExcelSeleniumIntegration extends Base {
	public static void main(String[] args) throws IOException {
		
		lb();
		url("https://www.facebook.com/");
		WebElement name = driver.findElement(By.id("email"));
fill(name, getData(0,0));
	
	}
}