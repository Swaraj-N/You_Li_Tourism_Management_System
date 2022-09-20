package org.TourismManagement.POMRepository;

import java.util.List;
import java.util.Map;

import org.TourishManagement.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePackagePage {

		@FindBy(name = "packagename")
		private WebElement PackageNameTextfield;
		@FindBy(name = "packagetype")
		private WebElement PackageTypeTextfield;
		@FindBy(name = "packagelocation")
		private WebElement PackageLocationTextfield;
		@FindBy(name = "packageprice")
		private WebElement PackagePriceTextfield;
		@FindBy(name = "packagefeatures")
		private WebElement PackageFeaturesTextfield;
		@FindBy(name = "packagedetails")
		private WebElement PackageDetailsTextfield;
		@FindBy(xpath = "//input[@type='file']")
		private WebElement ImageFIleBrowser;
		@FindBy(xpath = "//button[.='Create']")
		private WebElement CreatePackageButton;
		@FindBy(xpath = "//button[.='Reset']")
		private WebElement ResetButton;
		@FindBy(xpath = "//div[@class='succWrap']")
		private WebElement SuccessText;

		public CreatePackagePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		public void CreatPackagedetails(List<Map<String, String>> map,int random, WebDriverUtility wdu) {
			PackageNameTextfield.sendKeys(map.get(0).get("Package_Name")+random);
			PackageTypeTextfield.sendKeys(map.get(0).get("Package_Type"));
			PackageLocationTextfield.sendKeys(map.get(0).get("Package_Location"));
			PackagePriceTextfield.sendKeys(map.get(0).get("Package_Price")+random);
			PackageFeaturesTextfield.sendKeys(map.get(0).get("Package_Features"));
			wdu.scrollUsingJSE(CreatePackageButton);	
			PackageDetailsTextfield.sendKeys(map.get(0).get("Package_Details"));
			ImageFIleBrowser.sendKeys(map.get(0).get("Image"));

		}

		public void ScrollTillCreateButton(WebDriver driver, WebDriverUtility wdu) {
			wdu.initializeJSE(driver);
			wdu.scrollUsingJSE(CreatePackageButton);
			
		}
		public void CreateButton()
		{
			CreatePackageButton.click();
		}

		public void ResetButton() {
			ResetButton.click();
		}

		public String fetchText()
		{
			return SuccessText.getText();
			
		}

}
