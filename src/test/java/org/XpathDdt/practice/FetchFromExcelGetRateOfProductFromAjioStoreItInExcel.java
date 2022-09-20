package org.XpathDdt.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchFromExcelGetRateOfProductFromAjioStoreItInExcel {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException, EncryptedDocumentException, IOException {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ajio.com/");
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ESCAPE);
		rb.keyRelease(KeyEvent.VK_ESCAPE);
		driver.findElement(By.xpath("//a[@title='KIDS']")).click();
		driver.findElement(By.xpath("//a[@href='/s/0-to-2-years-3767-54091']")).click();
		Thread.sleep(2000);
		WebElement Productname = driver.findElement(By.xpath("//a[@href='/toonyport-graphic-shorts--t-shirt-set/p/464040969_red']/descendant::div[@class='nameCls']"));
		Thread.sleep(1000);
		String Pname = Productname.getText();
		WebElement Productprice = driver.findElement(By.xpath("//a[@href='/toonyport-graphic-shorts--t-shirt-set/p/464040969_red']/descendant::div/span[@class='price  ']"));
		Thread.sleep(2000);
		String Pprice = Productprice.getText();
		Thread.sleep(2000);
		System.out.println(Pname);
		System.out.println(Pprice);
		driver.quit();
		FetchFromExcelGetRateOfProductFromAjioStoreItInExcel.Fetch(Pname, Pprice);
	}
	public static void Fetch(String Pn,String Pp) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/DDT.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		try {
		Sheet sheet = wb.getSheet("ADMIN");		
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue(Pn);
		row.createCell(1).setCellValue(Pp);
		FileOutputStream fos=new FileOutputStream("./src/test/resources/DDT.xlsx");
		wb.write(fos); }
		finally
		{
			System.out.println("Data Updated to excel Successfully");
			wb.close();}
	}
}