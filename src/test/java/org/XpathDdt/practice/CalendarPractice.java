package org.XpathDdt.practice;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPractice {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		String ReqDate="15";
		String ReqMonth="August";
		String ReqYear="2023";
		driver.get("http://testleaf.herokuapp.com/pages/Calendar.html");
		driver.findElement(By.id("datepicker")).click();
		String date = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		String[] str = date.split(" ");
		String ActMonth = str[0];
		String ActYear = str[1];
		int RMonInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(ReqMonth).get(ChronoField.MONTH_OF_YEAR);
		int MonInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(ActMonth).get(ChronoField.MONTH_OF_YEAR);
		int YearInNum = Integer.parseInt(ActYear);
		int RYearInNum = Integer.parseInt(ReqYear);
		while(RMonInNum<MonInNum || RYearInNum<YearInNum)
		{
			driver.findElement(By.xpath("//a[.='Prev']")).click();
			date = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			str = date.split(" ");
			ActMonth = str[0];
			ActYear = str[1];
			RMonInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(ReqMonth).get(ChronoField.MONTH_OF_YEAR);
			MonInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(ActMonth).get(ChronoField.MONTH_OF_YEAR);
			YearInNum = Integer.parseInt(ActYear);
			RYearInNum = Integer.parseInt(ReqYear);
		}
		while(!(RMonInNum>MonInNum || RYearInNum>YearInNum))
		{
			driver.findElement(By.xpath("//a[.='Next']")).click();
			date = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			str = date.split(" ");
			ActMonth = str[0];
			ActYear = str[1];
			RMonInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(ReqMonth).get(ChronoField.MONTH_OF_YEAR);
			MonInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(ActMonth).get(ChronoField.MONTH_OF_YEAR);
			YearInNum = Integer.parseInt(ActYear);
			RYearInNum = Integer.parseInt(ReqYear);
		}
	driver.findElement(By.xpath("//a[.='"+ReqDate+"']")).click();
	}
}
