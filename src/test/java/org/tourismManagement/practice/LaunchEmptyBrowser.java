package org.tourismManagement.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchEmptyBrowser 
{
	public static void main(String[] args) {
		WebDriver driver=null;
		String browser = "Firefox";
			if(browser.equalsIgnoreCase(browser))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase(browser))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else
			{
				WebDriverManager.iedriver().setup();
				driver=new InternetExplorerDriver();
			}
//		String browser="Chrome";
//		switch (browser)
//		{
//		case "Firefox" :
//			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
//			break;
//
//		case "Chrome" :
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//			break;
//
//		case "ie" :
//			WebDriverManager.iedriver().setup();
//			driver=new InternetExplorerDriver();
//			break;
//			
//			default :
//				System.out.println("Please Enter Valid Browser Key");
//				break;
//		}


	}

}

