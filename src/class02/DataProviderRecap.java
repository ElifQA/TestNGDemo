package class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import Utils.CommonMethods;

public class DataProviderRecap extends CommonMethods{
	//Open browser  and navigate to url
	/*login on Orange HRM
	 * navigate to add employee page
	 * enter empl name lastname click
	 * verify taht emp is added successfull
	 * close browser
	 * 
	 */
	
	@BeforeMethod
	public void login() throws InterruptedException {
		setUp("chrome", ORANGE_HMR_URL);
		
	}
	@AfterMethod
	public void logout() {
//		driver.findElement(By.id("welcome")).click();
//		driver.findElement(By.linkText("Logout")).click();
		driver.quit();
		
	}
	@Test(dataProvider= "getData")
	public void addEmployee(String name, String lastname) throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		WebDriverWait wait= new WebDriverWait(driver, 10);
		
	//WebElement PIM= 
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
	//wait.until(ExpectedConditions.elementToBeClickable(PIM));
	
	driver.findElement(By.id("menu_pim_addEmployee")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("firstName")).sendKeys(name);
	driver.findElement(By.id("lastName")).sendKeys(lastname);
	//String expected=driver.findElement(By.id("employeeId")).getAttribute("value");
	driver.findElement(By.id("btnSave")).click();
	String actual=driver.findElement(By.xpath("//*[@id='profile-pic']/h1")).getText();
	String expected=name+" "+lastname;
	Assert.assertEquals(actual, expected, "Name Mismatch");
	//TakeScreenShot((name+lastname));
}

	 @DataProvider
	 public  Object[][] getData(){
		 Object [][] data= {
				 {"Ascovid19", "decorona"},
				 {"samsun", "19mayis"}
				 };
		 return data;
		 
		 
	 }


}



















