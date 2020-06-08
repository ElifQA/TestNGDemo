package class01;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.CommonMethods;

public class Dataprovider extends CommonMethods{
	/* Steps
	 * 1. Open browser and navigate to OrangeHRM
	 * 2. Login on Orange HRM
	 * 3. Navigate to Add Employee Page
	 * 4. Enter Employee name and lastname - click save
	 * 5. Verify that employee is added successfully
	 * 6. Close browser
	 * 
	 */
	
	@BeforeClass
	public void openBrowserNavigateOrangeHRM() {
		setUp("chrome", ORANGE_HMR_URL);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void login() throws InterruptedException {
		// enter username and password
		
		
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		// click Login button
		
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Test (groups="smoke", dataProvider = "getData")
	public void addEmployee(String name, String middleName, String lastName, String username, String password) throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver, 10);		
		WebElement PIMButton=driver.findElement(By.id("menu_pim_viewPimModule"));		
		wait.until(ExpectedConditions.elementToBeClickable(PIMButton));
		jsClick(PIMButton);		
		WebElement addEmpButton=driver.findElement(By.id("menu_pim_addEmployee"));
		wait.until(ExpectedConditions.elementToBeClickable(addEmpButton));
		jsClick(addEmpButton);

		driver.findElement(By.id("firstName")).sendKeys(name);
		driver.findElement(By.id("middleName")).sendKeys(middleName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		
		driver.findElement(By.id("chkLogin")).click();
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("re_password")).sendKeys(password);
		
		driver.findElement(By.id("btnSave")).click();
		
		String actEmpFullName=driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		String expName=name+" "+middleName+" "+lastName;
		
		Assert.assertEquals(actEmpFullName, expName, "Name MISMATCH");
		
		takeScreenShot((name+lastName));
	}
	
	@DataProvider  // provide argument for @Test method 
	public Object[][] getData(){
		Object[][] data= {
				{"John2", "Jack8", "Smith9", "johnsmith", "Johnsmith123-="},
				{"James1", "Trump","Brown4", "jamestrump", "Jamestrump123-="},
				
		};
		return data;		
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void logout() throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		WebElement btn=driver.findElement(By.id("welcome"));
		wait.until(ExpectedConditions.elementToBeClickable(btn));
		jsClick(btn);

		WebElement logoutBtn=driver.findElement(By.linkText("Logout"));
		wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
		jsClick(logoutBtn);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}	
}