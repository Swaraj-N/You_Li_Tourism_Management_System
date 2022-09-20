package org.tourismManagement.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingDataFormattor {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fis=new FileInputStream("./src/test/resources/DDT.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		try {
			DataFormatter df=new DataFormatter();
			Sheet sheet = wb.getSheet("USER");
			Cell data = sheet.getRow(3).getCell(2);
			Cell data2 = sheet.getRow(3).getCell(1);
			String value1 = df.formatCellValue(data);
			String value2 = df.formatCellValue(data2);
			//OR use this
			String USN = df.formatCellValue(sheet.getRow(3).getCell(2));
			String PWD = df.formatCellValue(sheet.getRow(4).getCell(2));
			String URL = df.formatCellValue(sheet.getRow(2).getCell(2));
			System.out.println(value2+"="+value1);
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Valid Browser Name"+"\n"+"1.1 for firefox"+"\n"+"2.2 for chrome"+"\n"+"3.3 for IE");
			String browser = sc.nextLine();
			WebDriver driver=null;
			switch(browser)
			{
			case "1":
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				break;
			case "2" :
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
			case "3":
				WebDriverManager.iedriver().setup();
				driver=new InternetExplorerDriver();
				break;
			default:
				System.out.println("PLEASE ENTER VALID BROWSER KEY");
				break;
			}
			driver.get(URL);
			driver.findElement(By.xpath("//a[.='/ Sign In']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(USN);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(PWD);
			driver.findElement(By.xpath("//input[@name='signin']")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("/ Logout")).click();
		}
		finally {
			wb.close();
		}
		

	}
}
