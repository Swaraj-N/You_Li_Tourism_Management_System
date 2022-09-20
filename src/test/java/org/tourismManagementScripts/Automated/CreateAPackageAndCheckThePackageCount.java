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

public class CreateAPackageAndCheckThePackageCount {
public static void main(String[] args) {
	ExcelUtilities Eu=new ExcelUtilities();
	PropertyUtilities Pu=new PropertyUtilities();
	WebDriverUtility wdu=new WebDriverUtility();
	GenerateRandomNumberUtility Grnu=new GenerateRandomNumberUtility();
	int RandomNumber = Grnu.setRandomNumber(1000);
	JavaOperationUtilities jou=new JavaOperationUtilities();
	String Browser = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "Browser");
	String Url = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "URL");
	String time = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "TimeUnit");
	String AUser = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "AdminUser");
	String APass = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "AdminPassword");
	long longtime = (long)jou.convertStringIntoAnyDatatype(time, DataTypes.LONG);
	WebDriver driver = wdu.commonOperation(Browser, Url, longtime);
	driver.findElement(By.xpath("//a[.='Admin Login']")).click();
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(AUser);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(APass);
	driver.findElement(By.xpath("//input[@name='login']")).click();
	//Continue with Create Package
}
}
