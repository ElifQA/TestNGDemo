package class01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo {
	@Test(groups="regression")
	public void methodOne() {
		System.out.println("Hello from method-1");
	}
	
	@Test(groups="smoke")
	public void methodTwo() {
		System.out.println("Hello from method-2");
		//Assert.assertTrue(false);
	}
	
	@Test (dependsOnMethods = "methodTwo", groups="smoke")
	public void methodThree() {
		System.out.println("Hello from method-3");
	}
	@Test(groups="smoke")
	public void methodFour() {
		System.out.println("Hello from method-4");
		//Assert.assertTrue(false);
	}
	@Test(groups="regression")
	public void methodfive() {
		System.out.println("Hello from method-5");
		Assert.assertTrue(false);
	}
	@Test(groups="smoke")
	public void methodsix() {
		System.out.println("Hello from method-6");
		
	}
}



