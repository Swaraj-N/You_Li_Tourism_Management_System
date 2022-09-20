package org.XpathDdt.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchFromExcelandGetGoldMedalDetails {

	public static String Fetch() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/DDT.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("USER");
		DataFormatter df=new DataFormatter();
		String key=null;
		String value=null;
		Scanner sc=new Scanner(System.in);
		key=sc.next();
		switch (key)
		{
		case "1":
			value = df.formatCellValue(sheet.getRow(0).getCell(1));
			break;
		case "2":
			value = df.formatCellValue(sheet.getRow(1).getCell(1));
			break;
		case "3":
			value = df.formatCellValue(sheet.getRow(2).getCell(1));
			break;
		case "4":
			value = df.formatCellValue(sheet.getRow(3).getCell(1));
			break;
		default:System.out.println("Please Enter Valid Key");
		break;
		}
		return value;
	}

	static WebDriver driver;
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		String name = FetchFromExcelandGetGoldMedalDetails.Fetch();	
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String gold = null;
		driver.get("https://olympics.com/");
		WebElement medal = driver.findElement(By.xpath("//span[text()='"+name+"']/ancestor::li//span[@class='result-medal result-medal--gold']"));
		gold = medal.getText();
		Thread.sleep(2000);
		System.out.println(name+" has "+gold+" medals.");	
	}
}
