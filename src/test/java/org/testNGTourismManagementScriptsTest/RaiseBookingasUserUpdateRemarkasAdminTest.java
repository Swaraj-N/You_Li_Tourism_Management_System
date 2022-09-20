package org.testNGTourismManagementScriptsTest;

import org.TourishManagement.GenericUtilities.BaseClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RaiseBookingasUserUpdateRemarkasAdminTest extends BaseClass {
	@Test
	public void SecondScriptTest()
	{
		String validation = remark+RandomNumber;
		wp.userSignInAction(UUser, UPassword, wdu, driver);
		uhp.clickOnWriteusMajorTab();
		uhp.createIssue(driver, longtime, issue, issuedesc, RandomNumber,wdu);
		uhp.userSignout(wdu);
		wp.AdminLoginAction(AUser, APass);
		afp.manageIssueAction(wdu,driver);
		wdu.switchToWindow(driver, "updateissue");
		String updateRemark = aruw.updateRemark(remark, RandomNumber);
		wdu.closeTheTab(driver);
		wdu.switchToWindow(driver, "manage");
		afp.adminLogoutAction(wdu,driver);
		afp.backtohome();
		wp.userSignInAction(UUser, UPassword, wdu, driver);
		uhp.clickOnIssueTickets(driver, longtime,wdu);
		WebElement dynamicelement = wp.convertStringToWebelement(validation, driver);
		wdu.scrollUsingJSE(dynamicelement);
		String textfromDynamicElement = wp.getTextfromDynamicElement(validation, driver);
		uhp.userSignout(wdu);
		try {
			wdu.performValidationUsingAssert(updateRemark, textfromDynamicElement);
			System.out.println("TEST CASE IS PASSED");
		}
		catch (Exception e) {
			System.out.println("TEST CASE IS FAILED");
		}
		wdu.closeTheBrowser(driver);
	}
}