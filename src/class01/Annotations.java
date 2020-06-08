package class01;

import org.testng.annotations.*;

public class Annotations {
	/* @Test
	 * @BeforeTest
	 * @AfterTest
	 * @BeforeMthod
	 * @AfterMethod
	 * @BeforeClass
	 * @AfterClass
	 * @BeforeSuite
	 * @AfterSuite
	 */
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am before Suite Method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("I am after Method Method");
	}	
	
	@AfterClass
	public void afterClass() {
		System.out.println("I am after Class Method");
	}
	
	
	@AfterTest
	public void afterTest() {
		System.out.println("I am after Test Method");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("I am after Suite Method");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("I am before Test Method");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("I am before Class Method");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am before Method Method");
	}
	
	@Test (groups="smoke")
	public void testOne() {
		System.out.println("I am test ONE");
	}
	
	@Test (groups="regression")
	public void testTwo() {
		System.out.println("I am test TWO");
	}
	
}