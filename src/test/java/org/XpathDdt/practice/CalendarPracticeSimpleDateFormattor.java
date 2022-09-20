package org.XpathDdt.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPracticeSimpleDateFormattor {
	static WebDriver driver;
	public static void main(String[] args) throws ParseException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
		String ReqMonth="August 2022";
		String ReqDate="29";
		driver.get("http://testleaf.herokuapp.com/pages/Calendar.html");
		driver.findElement(By.id("datepicker")).click();
		SimpleDateFormat sdf=new SimpleDateFormat("MMMM yyyy");
		Date req = sdf.parse(ReqMonth);
		while(true)
		{
			String ele = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			Date cur = sdf.parse(ele);
			if(ele.equalsIgnoreCase(ReqMonth))
			{
				break;
			}
			else if(req.after(cur))
			{
				driver.findElement(By.xpath("//a[.='Next']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//a[.='Prev']")).click();
			}
		}
		driver.findElement(By.xpath("//a[.='"+ReqDate+"']")).click();


	}
}
