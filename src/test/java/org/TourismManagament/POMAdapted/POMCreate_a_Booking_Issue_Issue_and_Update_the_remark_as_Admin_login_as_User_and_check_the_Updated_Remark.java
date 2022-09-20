package org.TourismManagament.POMAdapted;

import org.TourishManagement.GenericUtilities.DataTypes;
import org.TourishManagement.GenericUtilities.ExcelUtilities;
import org.TourishManagement.GenericUtilities.GenerateRandomNumberUtility;
import org.TourishManagement.GenericUtilities.IConstantPath;
import org.TourishManagement.GenericUtilities.JavaOperationUtilities;
import org.TourishManagement.GenericUtilities.PropertyUtilities;
import org.TourishManagement.GenericUtilities.WebDriverUtility;
import org.TourismManagement.POMRepository.AdminFunctionalitiesPage;
import org.TourismManagement.POMRepository.AdminRemarkUpdateWindowPage;
import org.TourismManagement.POMRepository.UserHomePage;
import org.TourismManagement.POMRepository.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POMCreate_a_Booking_Issue_Issue_and_Update_the_remark_as_Admin_login_as_User_and_check_the_Updated_Remark {
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
		String UUser = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "UUserName");
		String UPassword = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "UPassword");
		String issue = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "bookingissue");
		String issuedesc = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "issuedesc");
		String remark = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "remark");
		long longtime = (long)jou.convertStringIntoAnyDatatype(time, DataTypes.LONG);
		WebDriver driver = wdu.commonOperation(Browser, Url, longtime);
		String validation = remark+RandomNumber;
		wdu.initializeJSE(driver);	
		wdu.waitImplicityInSeconds(driver, longtime);
		WelcomePage wp=new WelcomePage(driver);
		wp.userSignInAction(UUser, UPassword, wdu, driver);
		UserHomePage uhp=new UserHomePage(driver);
		uhp.clickOnWriteusMajorTab();
		uhp.createIssue(driver, longtime, issue, issuedesc, RandomNumber, wdu);
		uhp.userSignout(wdu);
		wp.AdminLoginAction(AUser, APass);
		AdminFunctionalitiesPage afp=new AdminFunctionalitiesPage(driver);
		afp.manageIssueAction(wdu,driver);
		wdu.switchToWindow(driver, "updateissue");
		AdminRemarkUpdateWindowPage aruw=new AdminRemarkUpdateWindowPage(driver);
		String updateRemark = aruw.updateRemark(remark, RandomNumber);
		wdu.closeTheTab(driver);
		wdu.switchToWindow(driver, "manage");
		afp.adminLogoutAction(wdu,driver);
		afp.backtohome();
		wp.userSignInAction(UUser, UPassword, wdu, driver);
		uhp.clickOnIssueTickets(driver, longtime, wdu);
		WebElement dynamicelement = wp.convertStringToWebelement(validation, driver);
		wdu.scrollUsingJSE(dynamicelement);
		String textfromDynamicElement = wp.getTextfromDynamicElement(validation, driver);
		uhp.userSignout(wdu);
		if(updateRemark.equalsIgnoreCase(textfromDynamicElement))
		{
			Eu.setValuesToExcel(IConstantPath.EXCEL_PATH, "TestCase", 3, 3, "Pass");
			System.out.println("TEST CASE IS PASS");
		}
		else
		{
			Eu.setValuesToExcel(IConstantPath.EXCEL_PATH, "TestCase", 3, 3, "Fail");
			System.out.println("TEST CASE IS FAIL");
		}
				wdu.closeTheBrowser(driver);
	}
}
