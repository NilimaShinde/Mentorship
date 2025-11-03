package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import com.qa.utils.TestUtil;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static Properties or;
	public static Properties td;
	//private static String OS = System.getProperty("os.name").toLowerCase();
	public static Logger log = Logger.getLogger(TestBase.class.getName());

	public TestBase() {
		try {
			FileInputStream ip = new FileInputStream(".\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop= new Properties();
			prop.load(ip);
			
			FileInputStream fs = new FileInputStream(".\\src\\main\\java\\com\\qa\\config\\locators.properties");
			or= new Properties();
			or.load(fs);
			
			FileInputStream ts = new FileInputStream(".\\src\\main\\java\\com\\qa\\config\\testdata.properties");
			td= new Properties();
			td.load(ts);
			log.info("Properties File Loaded Successfully");

		} catch (FileNotFoundException e) {
			log.severe("Properties File not found");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		try {
			if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
			 {
				log.info("Browser Name : " + prop.getProperty("browser"));
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("safebrowsing.enabled", "true");
				ChromeOptions options = new ChromeOptions();
				// options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				options.addArguments("disable-popup-blocking");
				options.addArguments("--disable-backgrounding-occluded-windows");
				options.addArguments("--no-sandbox");
				driver = new ChromeDriver(options); 
             }
			/*
            else if(prop.getProperty("browser").equalsIgnoreCase("edge"))
            {
			   System.setProperty("webdriver.edge.driver" ,".\\src\\com\\webshop\\drivers\\msedgedriver.exe");
			   driver = new EdgeDriver(); 
             }*/
			else 
			{
			   System.out.println("no browser found");
			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		log.info("Implicit Wait : " + TestUtil.IMPLICIT_WAIT);
		log.info("Launch URL : " + prop.getProperty("URL"));
		driver.get(prop.getProperty("URL"));
		
		
	}

}
