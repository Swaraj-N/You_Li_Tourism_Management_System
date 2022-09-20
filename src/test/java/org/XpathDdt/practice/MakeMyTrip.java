package org.XpathDdt.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("src/test/resources/DDT.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("MMT");
		String URL = sheet.getRow(0).getCell(0).getStringCellValue();
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		Thread.sleep(2000);
		String fromcity=sheet.getRow(1).getCell(0).getStringCellValue();
		String tocity=sheet.getRow(1).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(fromcity);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='"+fromcity+"']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(tocity);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='"+tocity+"']")).click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();
	}
}
