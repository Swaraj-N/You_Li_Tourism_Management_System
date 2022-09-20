package org.testNGTourismManagementScriptsTest;

import java.util.List;
import java.util.Map;

import org.TourishManagement.GenericUtilities.BaseClass;
import org.TourishManagement.GenericUtilities.WelcomePageLinks;
import org.testng.annotations.Test;

public class MakeEnquiryAndReaditAsAdminTest extends BaseClass {

	@Test
	public void FifthScript()
	{
		List<Map<String, String>> EnquiryData = eu.getDataFromExcelInList("Enquiry");
		String EnquirerName = EnquiryData.get(0).get("Full_Name")+RandomNumber;
		cp.performclick(driver, WelcomePageLinks.ENQUIRY);
		ep.fillEnquiryDetails(EnquiryData, RandomNumber);
		wp.AdminLoginAction(AUser, APass);
		afp.clickonManageEnquiriesButton();
		String ValidateEnquirer = afp.getFullnameofEnquirer(EnquirerName, driver, wdu);
		System.out.println(EnquirerName);
		System.out.println(ValidateEnquirer);
		afp.readTheEnquiry(wdu, driver);
		wdu.clickOnOK(driver);
		afp.adminLogoutAction(wdu, driver);
		try {
			wdu.performValidationUsingAssert(EnquirerName, ValidateEnquirer);
			System.out.println("TEST CASE IS PASSED");
		}
		catch (Exception e) {
			System.out.println("TEST CASE IS FAILED");
		}
	}

}
