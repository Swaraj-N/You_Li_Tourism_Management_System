package practiceTestNG;

import org.testng.annotations.Test;

public class Practice3  {
		@Test()
		public void Test3()
		{
			System.out.println("Browser3");	
			System.out.println(Thread.currentThread().getId());
		}
}
