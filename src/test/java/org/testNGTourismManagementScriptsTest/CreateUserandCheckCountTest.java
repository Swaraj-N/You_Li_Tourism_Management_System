package org.testNGTourismManagementScriptsTest;

import java.util.List;
import java.util.Map;

import org.TourishManagement.GenericUtilities.BaseClass;
import org.TourishManagement.GenericUtilities.DataTypes;
import org.testng.annotations.Test;

public class CreateUserandCheckCountTest extends BaseClass{


	@Test
	public void FirstScriptTest()
	{
		List<Map<String, String>> CreateUserData = eu.getDataFromExcelInList("CreateUser");
		wp.AdminLoginAction(AUser, APass);
		String userNumber = afp.userNumber();
		int ucountBeforCreatingUser = (int)jou.convertStringIntoAnyDatatype(userNumber, DataTypes.INT);
		afp.adminLogoutAction(wdu,driver);
		afp.backtohome();
		wp.signUp();
		wp.createUser(RandomNumber, CreateUserData);
		wp.AdminLoginAction(AUser, APass);
		String updateduserNumber = afp.userNumber();
		int ucountAfterCreatingUser = (int)jou.convertStringIntoAnyDatatype(updateduserNumber, DataTypes.INT);
		System.out.println("Count of users before creating a new user "+userNumber);
		System.out.println("Count of users after creating a new user "+updateduserNumber);
		try {
			wdu.performValidationUsingAssert(ucountAfterCreatingUser,ucountBeforCreatingUser+1);
			System.out.println("TEST CASE IS PASSED");
		}
		catch (Exception e)
		{
			System.out.println("TEST CASE IS FAILED");
		}
		afp.adminLogoutAction(wdu,driver);
	}

}
