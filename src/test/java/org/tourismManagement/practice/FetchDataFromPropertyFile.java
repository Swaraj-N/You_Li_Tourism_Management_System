package org.tourismManagement.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDataFromPropertyFile 
{
	static WebDriver driver=null;
	public static void main(String[] args) throws IOException {
		//Step1 : Convert Physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");	
		//Step2 : Create Object for Properties
		Properties property = new Properties();
		//Step3 : Load all the Keys
		property.load(fis);
		//Step4 : Fetch the Data
		String URL = property.getProperty("url").trim();
		String USN = property.getProperty("UserName").trim();
		String PWD = property.getProperty("Password").trim();
		System.out.println(URL);
		System.out.println(USN);
		System.out.println(PWD);
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.xpath("//a[.='/ Sign In']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(USN);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@name='signin']")).click();
	}

}
