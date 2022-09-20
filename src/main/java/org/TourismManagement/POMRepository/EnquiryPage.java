package org.TourismManagement.POMRepository;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnquiryPage {
	@FindBy(id = "fname") private WebElement fullNameTextfield;
	@FindBy(id = "email") private WebElement emailTextField;
	@FindBy(id = "mobileno") private WebElement mobileNumTextfield;
	@FindBy(id = "subject") private WebElement subjectTextField;
	@FindBy(id = "description") private WebElement descriptionTextAreaField;
	@FindBy(name = "submit1") private WebElement submitButton;

	public EnquiryPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public void fillEnquiryDetails(List<Map<String, String>> map,int random)
	{
		fullNameTextfield.sendKeys(map.get(0).get("Full_Name")+random);
		emailTextField.sendKeys(random+map.get(0).get("Email"));
		mobileNumTextfield.sendKeys(map.get(0).get("Mobile_Num")+random);
		subjectTextField.sendKeys(map.get(0).get("Subject"));
		descriptionTextAreaField.sendKeys(map.get(0).get("Description"));
		submitButton.click();
	}
	
	
}
