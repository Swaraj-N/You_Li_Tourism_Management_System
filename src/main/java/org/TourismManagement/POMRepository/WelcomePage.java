package org.TourismManagement.POMRepository;

import java.util.List;
import java.util.Map;

import org.TourishManagement.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	private String dynamicXpath="//tbody/tr/td[.='%s']";
	//Declaration
	@FindBy(xpath = "//a[.='Admin Login']") private WebElement AdminLoginLink;
	@FindBy(xpath = "//input[@name='username']") private WebElement adminNameTextField;
	@FindBy(xpath = "//input[@name='password']") private WebElement adminPasswordTextField;
	@FindBy(xpath = "//input[@name='login']") private WebElement loginButton;
	@FindBy(xpath = "//a[.='Sign Up']") private WebElement signupLink;
	@FindBy(xpath = "//input[@name='fname']") private WebElement newUsernameTextfield;
	@FindBy(xpath = "//input[@name='mobilenumber']") private WebElement mobileNumTextfield;
	@FindBy(xpath = "//h3[.='Create your account ']/following-sibling::input[@id='email']") private WebElement emailTextField;
	@FindBy(xpath = "//input[@placeholder='Password']") private WebElement userPassword;
	@FindBy(xpath = "//input[@id='submit']") private WebElement submitButton;
	@FindBy(xpath = "//a[.='/ Sign In']") private WebElement signinLink;
	@FindBy(xpath = "//input[@placeholder='Enter your Email']") private WebElement usernameTextField;
	@FindBy(id = "password") private WebElement userPasswordTextField;
	@FindBy(xpath = "//input[@name='signin']") private WebElement userSingInButton;
	//Initialization
	public WelcomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Business Library
	public void AdminLoginAction(String adminUserName, String adminPassword)
	{
		AdminLoginLink.click();
		adminNameTextField.sendKeys(adminUserName);
		adminPasswordTextField.sendKeys(adminPassword);
		loginButton.click();
	}
	public void signUp()
	{
		signupLink.click();
	}

	public void createUser(int randomNumber,List<Map<String, String>> map)
	{
		newUsernameTextfield.sendKeys(randomNumber+map.get(0).get("UserName"));
		mobileNumTextfield.sendKeys(map.get(0).get("MobileNumber")+randomNumber);
		emailTextField.sendKeys(randomNumber+map.get(0).get("Email"));
		userPassword.sendKeys(map.get(0).get("Password")+randomNumber);
		submitButton.click();
	}

	public void userSignInAction(String userName,String userPassword,WebDriverUtility wdu,WebDriver driver)
	{
		signinLink.click();
		wdu.waitTillElementIsVisible(driver, 10, usernameTextField);
		usernameTextField.sendKeys(userName);
		userPasswordTextField.sendKeys(userPassword);
		userSingInButton.click();	
	}
	/**
	 * This method is used to Convert Dynamic String to WebElement
	 * @param dynamicXpath
	 * @param replaceData
	 * @param driver
	 * @return
	 */
	public WebElement convertStringToWebelement(String replaceData,WebDriver driver)
	{
		String requiredPath = String.format(dynamicXpath, replaceData);
		WebElement dynamicElement = driver.findElement(By.xpath(requiredPath));
		return dynamicElement;
	}
	/**
	 * This method is used to fetch Text from a Dynamic Element
	 * @param dynamicXpath
	 * @param replaceData
	 * @return
	 */
	public String getTextfromDynamicElement(String replaceData,WebDriver driver)
	{
		String requiredPath = String.format(dynamicXpath,replaceData);
		String dynamicElementtext = driver.findElement(By.xpath(requiredPath)).getText();	
		return dynamicElementtext;
	}


}
