package org.XpathDdt.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchStatusofAllBooking {
	static WebDriver driver;
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("src/test/resources/DDT.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
Sheet sheet = wb.getSheet("Pro");
DataFormatter df=new DataFormatter();
String url = df.formatCellValue(sheet.getRow(0).getCell(0));
String ColName="Package Name";
String ColData="Kerala";
WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get(url);
driver.findElement(By.xpath("//a[.='/ Sign In']")).click();
driver.findElement(By.xpath("//input[@id='email' and @placeholder='Enter your Email']")).sendKeys("shalivan@gmail.com");
driver.findElement(By.xpath("//input[@id='password']")).sendKeys("shalivan");
driver.findElement(By.xpath("//input[@value='SIGNIN']")).click();
driver.findElement(By.xpath("//a[.='My Tour History']")).click();
List<WebElement> text = driver.findElements(By.xpath("//h3[.='My Tour History']/following::tbody/tr/th[.='"+ColName+"']/parent::tr/following-sibling::tr/following::td[contains(.,'"+ColData+"')]/parent::tr"));
for (WebElement abc : text) {
	System.out.println(abc.getText());
}
}
}
