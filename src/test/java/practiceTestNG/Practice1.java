package practiceTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice1 {
	@Test
	public void Test1()
	{
		
		System.out.println("Browser1");	
		System.out.println(Thread.currentThread().getId());
		Assert.fail();
	}
}
