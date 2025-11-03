package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.TestBase;
import com.qa.utils.TestUtil;

public class LoginPage extends TestBase {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));	
	//TestUtil utils = new TestUtil();
	public void clickEmail() {
		TestUtil.clickWebElement("Email");
		TestUtil.handleLogger("LoginPage","Click email field");
	}
	
	public void enterEmail() {
		TestUtil.enterData("Email","TestData1");
		TestUtil.handleLogger("LoginPage","Enter email");
		}
	public void clearEmail() {
		TestUtil.clearData("Email");
		TestUtil.handleLogger("LoginPage","Clear email field");
	}
	public void clickPassword() {
		TestUtil.clickWebElement("Password");
		TestUtil.handleLogger("LoginPage","Click password field");
	}
	
	public void enterPassword() {
		TestUtil.enterData("Password","TestData2");
		TestUtil.handleLogger("LoginPage","Enter password");
		}
	public void clearPassword() {
		TestUtil.clearData("Password");
		TestUtil.handleLogger("LoginPage","Clear password field");
	}
	public void clickLoginButton() {
		TestUtil.clickWebElement("LoginButton");
		TestUtil.handleLogger("LoginPage","Click login button");
	}
	public void getWebshopText() {
		TestUtil.getWebElementText("WebshopText");
		TestUtil.handleLogger("LoginPage","fetching webshop text");
	}

}
