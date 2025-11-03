package com.qa.utils;

import java.io.File;
import java.time.Duration;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	public static void getWebElementText(String xpathkey) {
		String getTextOfWebElement = driver.findElement(By.xpath(or.getProperty(xpathkey))).getText();
		System.out.println(getTextOfWebElement);
	}

	public static void clickWebElement(String xpathkey) {
		driver.findElement(By.xpath(or.getProperty(xpathkey))).click();
	}

	public static void clearData(String xpathkey) {
		driver.findElement(By.xpath(or.getProperty(xpathkey))).clear();
	}

	public static void enterData(String xpathkey, String testData) {
		driver.findElement(By.xpath(or.getProperty(xpathkey))).sendKeys(td.getProperty(testData));
	}

	public static void moveToElement(String xpathkey) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(or.getProperty(xpathkey)))).build().perform();
	}

	public static void selectDropDownValue(String xpathkey, String testData) {
		WebElement ele = driver.findElement(By.xpath(or.getProperty(xpathkey)));
		Select webElem = new Select(ele);
		webElem.selectByVisibleText(td.getProperty(testData));
	}
/*
	public static void readExcelData(String xpathkey, int rowNo, int columnNo, String excelSheetName) throws Exception {
		File src = new File(".\\src\\com.webshop.resources\\Excel Test Data.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(prop.getProperty(excelSheetName));
		String abc = sh.getRow(rowNo).getCell(columnNo).getStringCellValue();
		driver.findElement(By.xpath(or.getProperty(xpathkey))).sendKeys(abc);
					
	}*/


	public static void handleExplicitWait_visibilityOfElementLocated(String xpathkey, String testData) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty(xpathkey)))).sendKeys(td.getProperty(testData));
		
	}

	public static void handleExplicitWait_elementToBeClickable(String xpathkey) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty(xpathkey)))).click();
		
	}

	public static void handleLogger(String logClassName, String loggerText) {
		Logger logger = Logger.getLogger(logClassName);
		//PropertyConfigurator.configure(prop.getProperty("log4JPropertiesFileLoc"));
		LoggerContext context = (LoggerContext) LogManager.getContext(false);
		File file = new File(prop.getProperty("log4JPropertiesFileLoc")); 
		context.setConfigLocation(file.toURI());
		logger.info(loggerText);
		

	}

	public static void captureScreenshot(ITestResult result ) throws Exception {
	if (ITestResult.FAILURE == result.getStatus()) {
		TakesScreenshot ts = (TakesScreenshot)driver; 
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destFolder = new File("./screenshots/screenshots"+result.getName()+ ".png");
		FileUtils.copyFile(sourceFile, destFolder);
		System.out.println(result.getName()+"method() failed, Screenshot captured");
	}
	}
	

}
