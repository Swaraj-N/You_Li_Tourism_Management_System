package org.TourishManagement.GenericUtilities;

import org.testng.annotations.BeforeClass;

public class DummyBaseClass {
	@BeforeClass
	public void BaseSetup(String browser)
	{
		WebUtilDummy wud=new WebUtilDummy();
		wud.launchTheBrowser(browser);
	}

}
