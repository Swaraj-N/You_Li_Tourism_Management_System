package org.tourismManagementScripts.Automated;

import org.TourishManagement.GenericUtilities.DataTypes;
import org.TourishManagement.GenericUtilities.ExcelUtilities;
import org.TourishManagement.GenericUtilities.GenerateRandomNumberUtility;
import org.TourishManagement.GenericUtilities.IConstantPath;
import org.TourishManagement.GenericUtilities.JavaOperationUtilities;
import org.TourishManagement.GenericUtilities.PropertyUtilities;
import org.TourishManagement.GenericUtilities.WebDriverUtility;
import org.TourismManagement.POMRepository.AdminFunctionalitiesPage;
import org.TourismManagement.POMRepository.WelcomePage;
import org.openqa.selenium.WebDriver;

public class CreateUserAndCheckCount {
	public static void main(String[] args) {
		ExcelUtilities Eu=new ExcelUtilities();
		PropertyUtilities Pu=new PropertyUtilities();
		WebDriverUtility wdu=new WebDriverUtility();
		GenerateRandomNumberUtility Grnu=new GenerateRandomNumberUtility();
		int RandomNumber = Grnu.setRandomNumber(1000);
		JavaOperationUtilities jou=new JavaOperationUtilities();
		String excelPath = IConstantPath.EXCEL_PATH;
		String UName = Eu.getValuesFromExcel(excelPath, "UserData", 0, 0);
		String UMNum = Eu.getValuesFromExcel(excelPath, "UserData", 0, 1);
		String UEmail = Eu.getValuesFromExcel(excelPath, "UserData", 0, 2);
		String UPass = Eu.getValuesFromExcel(excelPath, "UserData", 0, 3);
		String Browser = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "Browser");
		String Url = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "URL");
		String time = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "TimeUnit");
		String AUser = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "AdminUser");
		String APass = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "AdminPassword");
		long longtime = (long)jou.convertStringIntoAnyDatatype(time, DataTypes.LONG);
		WebDriver driver = wdu.commonOperation(Browser, Url, longtime);
		wdu.waitImplicityInSeconds(driver, longtime);
		WelcomePage wp=new WelcomePage(driver);
		AdminFunctionalitiesPage afp=new AdminFunctionalitiesPage(driver);
		wp.AdminLoginAction(AUser, APass);
		String userNumber = afp.userNumber();
		int ucountBeforCreatingUser = (int)jou.convertStringIntoAnyDatatype(userNumber, DataTypes.INT);
		afp.adminLogoutAction(wdu,driver);
		afp.backtohome();
		wp.signUp();
	//	wp.createUser(UName, UPass, UEmail, RandomNumber, UMNum);
		wp.AdminLoginAction(AUser, APass);
		String updateduserNumber = afp.userNumber();
		int ucountAfterCreatingUser = (int)jou.convertStringIntoAnyDatatype(updateduserNumber, DataTypes.INT);
		System.out.println("Count of users before creating a new user "+userNumber);
		System.out.println("Count of users after creating a new user "+updateduserNumber);
		if(ucountAfterCreatingUser>ucountBeforCreatingUser)
		{
			Eu.setValuesToExcel(excelPath, "TestCase", 1, 3, "Pass");
			System.out.println("TEST CASE IS PASSED");
		}
		else
		{
			Eu.setValuesToExcel(excelPath, "TestCase", 1, 3, "Fail");
			System.out.println("TEST CASE IS FAILED");
		}
		afp.adminLogoutAction(wdu,driver);
		wdu.closeTheBrowser(driver);

	}
}
