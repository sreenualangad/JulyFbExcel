package org.base;



	import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
	public class Base {
	public static WebDriver driver;
	//public static Select s;
	public static WebDriver lb() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\eclipse-workspace\\SkyAirJava\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	public static void url(String url) {
		driver.get(url);
	}

	public static void fill(WebElement e, String value) {
	e.sendKeys(value);
	}

	public static void click(WebElement e) {
		e.click();

	}
	public static void select(WebElement s, String value) {
	Select s1= new Select(s);
	s1.selectByValue(value);
	}

	public void moveToElement(WebElement e ) {
	Actions acc =new Actions(driver);
	acc.moveToElement(e).perform();
	}

	public void Screenshot() throws IOException {


		TakesScreenshot tk = (TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Lenovo\\eclipse-workspace\\Addactin\\screenshots\\name.jpeg");
		FileUtils.copyFile(src,dest);
	}
public static String getData(int ro, int col) throws IOException {
		
		File f = new File("C:\\Users\\Lenovo\\eclipse-workspace\\ExcelTest\\excel\\hij.xlsx");
		FileInputStream fin=new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet("sreeni");
		Row r = s.getRow(ro);
		Cell c = r.getCell(col);
		String value=" ";
		int cc=c.getCellType();
		if(cc==1) {
			value = c.getStringCellValue();
		}
else if (cc==0){
	 if(DateUtil.isCellDateFormatted(c)) {
		 Date d = c.getDateCellValue();
		 SimpleDateFormat sd=new SimpleDateFormat("dd-mm-yyyy");
		 value = sd.format(d);
	}
	 else {
		 double nc = c.getNumericCellValue();
	 long l=(long)nc;
	 value=String.valueOf(l);
	 }
}
	return value;
	}}
	

