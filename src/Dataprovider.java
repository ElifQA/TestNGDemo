import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.CommonMethods;

public class Dataprovider extends CommonMethods{
	 @BeforeMethod
	 public void openBrowser() {
		 setUp("chrome", "https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		 
		 
	 }
	 @AfterMethod
	 public void closeBrowser() {
		 driver.quit();
	 }
	 @Test(dataProvider= "getData")
	 public void addEmployee(String name, String lastname) {
		 driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();
			//navigate to edd employee
			driver.findElement(By.id("menu_pim_viewPimModule")).click();
			driver.findElement(By.id("menu_pim_addEmployee")).click();
			driver.findElement(By.id("firstName")).sendKeys(name);
			driver.findElement(By.id("lastName")).sendKeys(lastname);
			String expected=driver.findElement(By.id("employeeId")).getAttribute("value");
			driver.findElement(By.id("btnSave")).click();
			String actual=driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
			Assert.assertEquals(actual, expected);
			
	 }
	 @DataProvider
	 public  Object[][] getData(){
		 Object [][] data= {
				 {"covid19", "corona"}};
		 return data;
		 
		 
	 }
	 
	 
	 


}
