package org.tourismManagementScripts.Automated;

import org.TourishManagement.GenericUtilities.DataTypes;
import org.TourishManagement.GenericUtilities.ExcelUtilities;
import org.TourishManagement.GenericUtilities.GenerateRandomNumberUtility;
import org.TourishManagement.GenericUtilities.IConstantPath;
import org.TourishManagement.GenericUtilities.JavaOperationUtilities;
import org.TourishManagement.GenericUtilities.PropertyUtilities;
import org.TourishManagement.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RaiseIssueAsUserUpdateAsAdminReviewAsUser {
	public static void main(String[] args) {
		ExcelUtilities Eu=new ExcelUtilities();
		PropertyUtilities Pu=new PropertyUtilities();
		WebDriverUtility wdu=new WebDriverUtility();
		GenerateRandomNumberUtility Grnu=new GenerateRandomNumberUtility();
		int RandomNumber = Grnu.setRandomNumber(1000);
		JavaOperationUtilities jou=new JavaOperationUtilities();
		String UName = Eu.getValuesFromExcel(IConstantPath.EXCEL_PATH, "UserData", 0, 0);
		String UMNum = Eu.getValuesFromExcel(IConstantPath.EXCEL_PATH, "UserData", 0, 1);
		String UEmail = Eu.getValuesFromExcel(IConstantPath.EXCEL_PATH, "UserData", 0, 2);
		String UPass = Eu.getValuesFromExcel(IConstantPath.EXCEL_PATH, "UserData", 0, 3);
		String Browser = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "Browser");
		String Url = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "URL");
		String time = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "TimeUnit");
		String AUser = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "AdminUser");
		String APass = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "AdminPassword");
		String UUser = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "UUserName");
		String UPassword = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "UPassword");
		String issue = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "cancellationissue");
		String issuedesc = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "issuedesc");
		String remark = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "remark");
		long longtime = (long)jou.convertStringIntoAnyDatatype(time, DataTypes.LONG);
		WebDriver driver = wdu.commonOperation(Browser, Url, longtime);
		wdu.initializeJSE(driver);	
		wdu.waitImplicityInSeconds(driver, longtime);
		driver.findElement(By.linkText("/ Sign In")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(UUser);
		driver.findElement(By.id("password")).sendKeys(UPassword);
		driver.findElement(By.xpath("//input[@name='signin']")).click();
		driver.findElement(By.xpath("//a[.=' / Write Us ']")).click();
		WebElement ele = driver.findElement(By.xpath("//select[@name='issue']"));
		wdu.initializeDropDown(ele);
		wdu.waitTillElementIsVisible(driver, longtime, ele);
		driver.findElement(By.xpath("//select[@name='issue']")).click();
		wdu.selectOptionFromDropDownVisibletext(issue);
		String validation = remark+RandomNumber;
		driver.findElement(By.xpath("//input[@name='description']")).sendKeys(issuedesc+RandomNumber);
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		driver.findElement(By.xpath("//a[.='/ Logout']")).click();
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(AUser);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(APass);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		driver.findElement(By.xpath("//span[.='Manage Issues']")).click();
		WebElement scrollElement = driver.findElement(By.xpath("(//a[.='View '])[last()]"));
		wdu.scrollUsingJSE(scrollElement);
		scrollElement.click();
		wdu.switchToWindow(driver, "updateissue");
		driver.findElement(By.name("remark")).sendKeys(remark+RandomNumber);
		driver.findElement(By.name("submit2")).click();
		wdu.closeTheTab(driver);
		wdu.switchToWindow(driver, "manage");
		WebElement Scrolltowelcome = driver.findElement(By.xpath("//p[text()='Welcome']"));
		wdu.scrollUsingJSE(Scrolltowelcome);
		Scrolltowelcome.click();
		driver.findElement(By.xpath("//a[.=' Logout']")).click();
		driver.findElement(By.xpath("//a[.='Back to home']")).click();
		driver.findElement(By.linkText("/ Sign In")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(UUser);
		driver.findElement(By.id("password")).sendKeys(UPassword);
		driver.findElement(By.xpath("//input[@name='signin']")).click();
		driver.findElement(By.xpath("//a[.='Issue Tickets']")).click();
		WebElement tablelast = driver.findElement(By.xpath("(//table/descendant::td/ancestor::tr)[last()]"));
		String text = driver.findElement(By.xpath("//tbody/tr/td[.='"+validation+"']")).getText();
		wdu.scrollUsingJSE(tablelast);
		WebElement scrolllogout=driver.findElement(By.xpath("//li[@class='sigi']"));
		wdu.scrollUsingJSE(scrolllogout);
		scrolllogout.click();
		System.out.println(text);
		if(text.equalsIgnoreCase(validation))
		{
			Eu.setValuesToExcel(IConstantPath.EXCEL_PATH, "TestCase", 2, 3, "Pass");
			System.out.println("TEST CASE IS PASS");
		}
		else
		{
			Eu.setValuesToExcel(IConstantPath.EXCEL_PATH, "TestCase", 2, 3, "Fail");
			System.out.println("TEST CASE IS FAIL");
		}
		wdu.closeTheBrowser(driver);
	}
}
