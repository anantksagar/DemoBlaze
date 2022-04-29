package com.qa.testBase;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.qa.pageLayer.HomePage;
import com.qa.testData.TestData;
import com.qa.utilities.UtilityClass;
import com.qa.utilities.WebDriverListener;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	String url = "https://demoblaze.com/index.html";
	public static WebDriverListener eventListener;
	public static EventFiringWebDriver event_driver;
	public static Logger logger;
	public HomePage h;
	public UtilityClass util;
	public TestData data;
	public String value;
	@BeforeClass
	public void startLogger() {
		logger = Logger.getLogger("DemoBlaze FreameWork");
		PropertyConfigurator.configure("Log4j.properties");
	}

	@AfterClass
	public void endLogger() {
		logger.info("Automation Script Ends");
	}

	@BeforeMethod
	public void openBrowser() {

		String browser = "chrome";

		if (browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome Launched");
			
		} else if (browser.equalsIgnoreCase("firefox")) {
		
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("Firefox Launched");
			
		} else if (browser.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("Edge Launched");
			
		} else {
			System.out.println("Browser Not Found Please Verify It And Try Again");
		}

		driver.get(url);
		logger.info("URl Hit in Browser");
		driver.manage().window().maximize();
		logger.info("Window Maximized");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		eventListener = new WebDriverListener();
		event_driver = new EventFiringWebDriver(driver);
		event_driver.register(eventListener);
		driver = event_driver;

		h = new HomePage();

		util = new UtilityClass();
		
		data = new TestData();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
