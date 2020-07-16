package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FbData extends Base {
	public static void main(String[] args) throws IOException {
	lb();
	url("https://www.facebook.com/");
	WebElement email = driver.findElement(By.id("email"));
	fill(email, getData(0, 0));
	WebElement pw = driver.findElement(By.id("pass"));
    fill(pw, getData(0, 1));
	}

}
