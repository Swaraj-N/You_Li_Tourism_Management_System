package org.TourismManagement.POMRepository;

import org.TourishManagement.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminFunctionalitiesPage {
	//declaration
	String dynamicFullName="//th[.='Name']/ancestor::table/tbody/tr/td/span[.='%s']";
	@FindBy(xpath = "//h3[.='User']/following-sibling::h4") private WebElement userCount;
	@FindBy(xpath = "//h3[.='Toatal packages']/following-sibling::h4") private WebElement packageCount;
	@FindBy(xpath = "//p[text()='Welcome']") private WebElement welcomeDropdown;
	@FindBy(xpath = "//a[.=' Logout']") private WebElement logoutLink;
	@FindBy(xpath = "//span[.='Manage Issues']") private WebElement manageIssueButton;
	@FindBy(xpath = "(//a[.='View '])[last()]") private WebElement lastViewButton;
	@FindBy(xpath = "//a[.='Back to home']") private WebElement backToHomeLink;
	@FindBy(xpath = "//i[@aria-hidden='true' and@class='fa fa-list-ul']")private WebElement Tourpackagebutton;
	@FindBy(xpath = "//a[.='Create']")private WebElement adminCreatebutton;
	@FindBy(xpath = "//span[.='Manage Booking']") private WebElement ManageBookingTab;
	@FindBy(xpath = "//a[@class='sidebar-icon']") private WebElement CloseSidebarTab;
	@FindBy(xpath = "//span[.='Dashboard']" ) private WebElement DashboardButton;
	@FindBy(xpath = "//span[.='Manage Enquiries']") private WebElement ManageEnquiriesButton;
	@FindBy(xpath = "//span[.='Kothi']/following::a[.='Pending']") private WebElement pendingLink;
	//Initialization
	public AdminFunctionalitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Business Library
	public String userNumber()
	{
		return userCount.getText();	
	}
	public String packageNumber()
	{
		return packageCount.getText();	
	}
	public void adminLogoutAction(WebDriverUtility wdu,WebDriver driver)
	{
		wdu.initializeActions(driver);
		wdu.scrollUsingJSE(welcomeDropdown);
		welcomeDropdown.click();
		logoutLink.click();
	}
	public void manageIssueAction(WebDriverUtility wdu,WebDriver driver)
	{
		manageIssueButton.click();
		wdu.initializeJSE(driver);
		wdu.scrollUsingJSE(lastViewButton);
		lastViewButton.click();

	}
	public void backtohome()
	{
		backToHomeLink.click();
	}
	public void Tourpackagebutton() {
		Tourpackagebutton.click();
	}

	public void CreateOptionbutton(WebDriverUtility wdu) {
		wdu.scrollUsingJSE(adminCreatebutton);
		adminCreatebutton.click();
	}

	public void ManageBookingTab()
	{
		ManageBookingTab.click();
	}
	public void CloseSidebarTab()
	{
		CloseSidebarTab.click();
	}
	public void DashBoardButton()
	{
		DashboardButton.click();
	}
	public void clickonManageEnquiriesButton()
	{
		ManageEnquiriesButton.click();
	}
	public void readTheEnquiry(WebDriverUtility wdu,WebDriver driver)
	{
		wdu.initializeJSE(driver);
		wdu.scrollUsingJSE(pendingLink);
		pendingLink.click();
	}

	public String getFullnameofEnquirer(String replaceData,WebDriver driver,WebDriverUtility wdu)
	{
		String requiredPath = String.format(dynamicFullName,replaceData);
		wdu.initializeJSE(driver);
		WebElement dynamicElement = driver.findElement(By.xpath(requiredPath));	
		wdu.scrollUsingJSE(dynamicElement);
		String text = dynamicElement.getText();
		return text;
	}
}
