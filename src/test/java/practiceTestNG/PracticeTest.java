package practiceTestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeTest {

//		@BeforeSuite
//		public void Beforesuite()
//		{
//			Reporter.log("This is Before Suite", true);
//		}
//		@BeforeTest
//		public void BeforeTest()
//		{
//			Reporter.log("This is Before Test", true);
//		}
//		@BeforeClass
//		public void BeforeClass()
//		{
//			Reporter.log("This is Before Class", true);
//		}
//		@BeforeMethod
//		public void BeforeMethod()
//		{
//			Reporter.log("This is Before Method", true);
//		}
		@Test
		public void Demo()
		{
			Reporter.log("This is Test Annotation", true);
		}
//		@AfterMethod
//		public void AfterMethod()
//		{
//			Reporter.log("This is After Method", true);
//		}
//		@AfterClass
//		public void AfterClass()
//		{
//			Reporter.log("This is After Class", true);
//		}
//		@AfterTest
//		public void AfterTest()
//		{
//			Reporter.log("This is After Test", true);
//		}
//		@AfterSuite
//		public void Aftersuite()
//		{
//			Reporter.log("This is After Suite", true);
//		}
	}

