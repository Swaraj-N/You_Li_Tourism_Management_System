package org.TourishManagement.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebUtilDummy {

	public WebDriver launchTheBrowser(String browser)
	{
		WebDriver driver=null;
		switch (browser)
		{
		case "Firefox" :
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;

		case "Chrome" :
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;

		case "IE" :
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			
		default :
			System.out.println("Please Enter Valid Browser Key");
			break;
		}
		return driver;
	}
}