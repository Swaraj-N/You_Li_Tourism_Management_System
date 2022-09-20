
package org.TourishManagement.GenericUtilities;

import org.TourismManagement.POMRepository.AdminFunctionalitiesPage;
import org.TourismManagement.POMRepository.AdminRemarkUpdateWindowPage;
import org.TourismManagement.POMRepository.CommonPage;
import org.TourismManagement.POMRepository.CreatePackagePage;
import org.TourismManagement.POMRepository.EnquiryPage;
import org.TourismManagement.POMRepository.ManageBookingPage;
import org.TourismManagement.POMRepository.PackageDetailsPage;
import org.TourismManagement.POMRepository.UserHomePage;
import org.TourismManagement.POMRepository.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	protected WebDriver driver;
	protected WebDriverUtility wdu;
	protected ExcelUtilities eu;
	protected String AUser;
	protected String APass;
	protected String comment;
	protected int RandomNumber;
	protected String UPassword;
	protected String UUser;
	protected String issuedesc;
	protected String issue;
	protected String remark;
	protected JavaOperationUtilities jou;
	protected WelcomePage wp;
	protected AdminFunctionalitiesPage afp;
	protected UserHomePage uhp;
	protected long longtime;
	protected CreatePackagePage cpp;
	protected ManageBookingPage mbp;
	protected PackageDetailsPage pdp;
	protected CommonPage cp;
	protected AdminRemarkUpdateWindowPage aruw;
	public static WebDriver sdriver;
	public static JavaOperationUtilities sjou;
	protected EnquiryPage ep;
	//@Parameters(value="browser")
	@BeforeClass
	public void classSetup()
	{
		//Initialize all the utilities
		PropertyUtilities Pu=new PropertyUtilities();
		wdu=new WebDriverUtility();
		GenerateRandomNumberUtility Grnu=new GenerateRandomNumberUtility();
		RandomNumber = Grnu.setRandomNumber(1000);
		jou=new JavaOperationUtilities();
		String Browser = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "Browser");
		String Url = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "URL");
		String time = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "TimeUnit");
		issue = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "bookingissue");
		issuedesc = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "issuedesc");
		remark = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "remark");
		UUser = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "UUserName");
		UPassword = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "UPassword");
		AUser = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "AdminUser");
		APass = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "AdminPassword");
		remark = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "remark");
		comment = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "comment");
		longtime = (long)jou.convertStringIntoAnyDatatype(time, DataTypes.LONG);
		driver = wdu.commonOperation(Browser, Url, longtime);
		sdriver = driver;
		sjou=jou;
		wdu.waitImplicityInSeconds(driver, longtime);
		wdu.initializeJSE(driver);
		wp=new WelcomePage(driver);
		afp=new AdminFunctionalitiesPage(driver);
	}

	@BeforeMethod
	public void methodSetup()
	{
		eu=new ExcelUtilities();
		wp=new WelcomePage(driver);
		afp=new AdminFunctionalitiesPage(driver);
		uhp=new UserHomePage(driver);
		cpp=new CreatePackagePage(driver);
		mbp=new ManageBookingPage(driver);
		pdp=new PackageDetailsPage(driver);
		eu.openExcel(IConstantPath.EXCEL_PATH);
		aruw=new AdminRemarkUpdateWindowPage(driver);
		cp=new CommonPage();
		ep=new EnquiryPage(driver);
	}

	
	@AfterClass
	public void classTearDown()
	{
		eu.closeExcel();
		wdu.closeTheBrowser(driver);
	}

}
