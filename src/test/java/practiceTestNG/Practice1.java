package practiceTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice1 {
	@Test
	public void Test1()
	{
		//Changes done by Eng-1

		//Changes done by Eng-1 Second time

		//Changes done by Eng-2

		System.out.println("Browser1");	
		System.out.println(Thread.currentThread().getId());
		Assert.fail();
	}
}
