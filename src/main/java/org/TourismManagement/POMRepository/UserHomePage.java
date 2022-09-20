package org.TourismManagement.POMRepository;

import org.TourishManagement.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
	String pName="Package ";
	String name="Name: ";
	//Declaration
	String SpecifiedPackage="//h4[.='"+pName+name+"%s']/ancestor::div[@class='rom-btm']/descendant::a";
	@FindBy(xpath = "//a[.=' / Write Us ']") private WebElement writeusMajorTab;
	@FindBy(xpath = "//select[@name='issue']") private WebElement issueDropdown;
	@FindBy(xpath = "//input[@name='description']") private WebElement descriptionTextAreaField;
	@FindBy(xpath = "//button[@name='submit']") private WebElement submitButton;
	@FindBy(xpath = "//a[.='/ Logout']") private WebElement signoutLink;
	@FindBy(xpath = "//a[.='Issue Tickets']") private WebElement issueTicketsButton;
	//@FindBy(xpath = "//h4[.='%s']") private WebElement ViewSpecifiedPackage;
	//h4[.='Package Name: Manali Trip ']/ancestor::div[@class='rom-btm']/descendant::a

	//Initialization
	public UserHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}

	//Business Library
	public void clickOnWriteusMajorTab()
	{
		writeusMajorTab.click();	
	}
	 public void ScrollSpecifiedPackageName(WebDriver driver,WebDriverUtility wdu,String packageName)
	    {
		 WebElement pName = convertpackage(packageName, driver);
		 wdu.waitTillElementIsVisible(driver, 10, pName);
		 wdu.initializeJSE(driver);
	    	wdu.scrollUsingJSE(pName);
	    }

	public void createIssue(WebDriver driver,long timeInSeconds,String issueVisibletext,String issuedescription,int randomNumber,WebDriverUtility wdu)
	{

		wdu.initializeDropDown(issueDropdown);
		wdu.waitTillElementIsVisible(driver, timeInSeconds, issueDropdown);
		issueDropdown.click();
		wdu.selectOptionFromDropDownVisibletext(issueVisibletext);
		descriptionTextAreaField.sendKeys(issuedescription+randomNumber);
		submitButton.click();
	}

	public void userSignout(WebDriverUtility wdu)
	{
		wdu.scrollUsingJSE(signoutLink);
		signoutLink.click();
	}

    public void ViewSpecifiedPackage(String packageName,WebDriver driver)
    {
    	 WebElement pName = convertpackage(packageName, driver);
    	pName.click();
    }
	public void clickOnIssueTickets(WebDriver driver,long timeInSeconds,WebDriverUtility wdu)
	{
		wdu.waitTillElementIsVisible(driver, timeInSeconds, issueTicketsButton);
		issueTicketsButton.click();
	}
	
	public WebElement convertpackage(String replaceData,WebDriver driver)
	{
		String requiredPath = String.format(SpecifiedPackage, replaceData);
		WebElement dynamicElement = driver.findElement(By.xpath(requiredPath));
		return dynamicElement;
	}
}
