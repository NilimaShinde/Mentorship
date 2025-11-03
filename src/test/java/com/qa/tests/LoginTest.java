package com.qa.tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
public class LoginTest extends TestBase  {
	LoginPage login = new LoginPage();
	 //SoftAssert softAssert = new SoftAssert();
	    public LoginTest() {
		    super();
	      }
	    @BeforeMethod
		public void setup() {
			initialization();
		}
		@Test
		public void loginTest() throws Exception {
			Assert.assertTrue(driver.findElement(By.xpath(or.getProperty("Email"))).isDisplayed(), "Email field is visible");
			login.clickEmail();
			login.enterEmail();
			Assert.assertTrue(driver.findElement(By.xpath(or.getProperty("Password"))).isDisplayed(), "Password field is visible");
			login.clickPassword();
			login.enterPassword();
			Thread.sleep(1000);
			Assert.assertTrue(driver.findElement(By.xpath(or.getProperty("LoginButton"))).isDisplayed(), "Login Button is visible");
			login.clickLoginButton();
			Thread.sleep(1000);
			Assert.assertEquals(driver.getTitle(), "Demo Web Shop", "Login Successful");
			 //softAssert.assertAll(); 

			/*login.clearEmail();
			login.clearPassword();
			login.clickLoginButton();
			login.getWebshopText();
			Thread.sleep(000);
			login.readExcelData("Email", 2, 1, "ExcelSheetName");
			Thread.sleep(1000);1
			login.readExcelData("Password", 2, 2, "ExcelSheetName");*/
		}
		
		/*@AfterMethod 
		public void takeScreenshot(ITestResult result) throws Exception {
			LoginPage login = new LoginPage();
			login.captureScreenshot(result);
		}*/
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
   }


