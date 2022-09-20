package org.TourismManagement.POMRepository;

import org.TourishManagement.GenericUtilities.WelcomePageLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonPage {


	private	String commonPageLink="//a[.='%s']";

	public WebElement anylinkElement(WebDriver driver, String linkName)
	{
	String format = String.format(commonPageLink, linkName);
	WebElement ele = driver.findElement(By.xpath(format));
	return ele;
	}
	
	public void performclick(WebDriver driver, WelcomePageLinks linkTabName)
	{
		anylinkElement(driver, linkTabName.getLinkName()).click();
	}
}
