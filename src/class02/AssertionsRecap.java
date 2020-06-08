package class02;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsRecap {

		/* Hard Assert - 
		 * Soft Assert */
		
//		@Test
//		public void testOne() {
//			System.out.println("Hello from test one");
//			
//			Assert.assertTrue(false);
//			
//			Assert.assertTrue(true);
//			System.out.println("Assertion Two");
//			Assert.assertTrue(true);
//			System.out.println("Assertion Three");
//			Assert.assertTrue(true);
//			System.out.println("Assertion Four");
//			
//		}
		
		@Test
		public void testTwo() {
			System.out.println("Hello from test one");
			
			SoftAssert sAssert=new SoftAssert();
			
			sAssert.assertTrue(false);
			sAssert.assertTrue(true);
			System.out.println("Assertion Two");
			
			sAssert.assertTrue(true);
			System.out.println("Assertion Three");
			sAssert.assertTrue(true);
			System.out.println("Assertion Four");
			
			sAssert.assertAll();
		}
	}

