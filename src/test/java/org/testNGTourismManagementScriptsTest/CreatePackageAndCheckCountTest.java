package org.testNGTourismManagementScriptsTest;

import java.util.List;
import java.util.Map;

import org.TourishManagement.GenericUtilities.BaseClass;
import org.TourishManagement.GenericUtilities.DataTypes;
import org.testng.annotations.Test;

public class CreatePackageAndCheckCountTest extends BaseClass {

	
	@Test
	public void ThirdScriptTest()
	{
		List<Map<String, String>> map = eu.getDataFromExcelInList("CreatePackage");
		wp.AdminLoginAction(AUser, APass);
		String packageNumber = afp.packageNumber();
		int PKGCountBeforCreatingPKG = (int)jou.convertStringIntoAnyDatatype(packageNumber, DataTypes.INT);
		afp.adminLogoutAction(wdu,driver);
		afp.backtohome();
		wp.AdminLoginAction(AUser, APass);
		afp.Tourpackagebutton();
		afp.CreateOptionbutton(wdu);
		cpp.CreatPackagedetails(map,RandomNumber,wdu);
		cpp.CreateButton();
		afp.DashBoardButton();
		String UpackageNumber = afp.packageNumber();
		int UPKGCountAfterCreatingPKG = (int)jou.convertStringIntoAnyDatatype(UpackageNumber, DataTypes.INT);
		try {
			wdu.performValidationUsingAssert(UPKGCountAfterCreatingPKG,PKGCountBeforCreatingPKG+1);
			System.out.println("TEST CASE IS PASSED"); 
		}
		catch (Exception e) {
			System.out.println("TEST CASE IS FAILED");
			}
		afp.adminLogoutAction(wdu, driver);
	}
}
