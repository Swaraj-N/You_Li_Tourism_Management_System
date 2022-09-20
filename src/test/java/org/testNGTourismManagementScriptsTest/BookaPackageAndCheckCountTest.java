package org.testNGTourismManagementScriptsTest;

import java.util.List;
import java.util.Map;

import org.TourishManagement.GenericUtilities.BaseClass;
import org.TourishManagement.GenericUtilities.WelcomePageLinks;
import org.testng.annotations.Test;

public class BookaPackageAndCheckCountTest extends BaseClass {

	@Test
	public void bookPackageCheckCountIncreases()
	{
		List<Map<String, String>> map = eu.getDataFromExcelInList("CreatePackage");
		wp.AdminLoginAction(AUser, APass);
		afp.ManageBookingTab();
		afp.CloseSidebarTab();
		mbp.scrollBookingId(wdu);
		String value = mbp.fetchLastBookingId();
		String fString = value.toString();
		String[] str = fString.split("-");
		System.out.println("Count Before Booking "+str[1]);
		afp.Tourpackagebutton();
		afp.CreateOptionbutton(wdu);
		cpp.CreatPackagedetails(map,RandomNumber,wdu);
		cpp.CreateButton();
		afp.adminLogoutAction(wdu, driver);
		afp.backtohome();
		wp.userSignInAction(UUser, UPassword, wdu, driver);
		cp.performclick(driver, WelcomePageLinks.TOURPACKAGES);
		String packageName = map.get(0).get("Package_Name");
		String data = map.get(0).get("Package_Name");
		String newPackage = data+RandomNumber;
		uhp.ViewSpecifiedPackage(newPackage, driver);
		pdp.FillPackageDetailsAction();
		pdp.ScrollTillComment(wdu, driver);
		pdp.PassTheCommentIntoTextField(comment);
		pdp.BookButton();
		uhp.userSignout(wdu);
		wp.AdminLoginAction(AUser, APass);		
		afp.ManageBookingTab();
		afp.CloseSidebarTab();
		mbp.scrollBookingId(wdu);
		String value1 = mbp.fetchLastBookingId();
		String String = value1.toString();
		String[] str1 = String.split("-");
		System.out.println("Count After Booking "+str1[1]);
		String xyz = str[1];
		String abc = str1[1];
		int BeforeBookCount = Integer.parseInt(xyz);
		int AfterBookCount = Integer.parseInt(abc);
		try {
			wdu.performValidationUsingAssert(AfterBookCount, BeforeBookCount+1);
			System.out.println("TEST CASE IS PASSED");
		}
		catch (Exception e) {
			System.out.println("TEST CASE IS FAILED");
		}
	afp.adminLogoutAction(wdu, driver);
	}	
}
