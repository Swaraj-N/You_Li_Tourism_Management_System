package practiceTestNG;

import org.TourishManagement.GenericUtilities.WebDriverUtility;
import org.testng.annotations.Test;

public class Practice2 {
		@Test()
		public void Test2()
		{
			String browser=System.getProperty("b");
			String url=System.getProperty("u");
			WebDriverUtility wdu=new WebDriverUtility();
			wdu.commonOperation(browser, url, 10l);
		}
}
