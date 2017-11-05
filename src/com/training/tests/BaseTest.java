package com.training.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected WebDriver driver;
	protected WebDriverWait driverWait;
	String AppURL = "http://medopsplus.techcanvass.co.in/";

	@BeforeClass
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumWebdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driverWait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void launchUrl(){
		driver.get(AppURL);
	}
	
	@AfterMethod
	public void cleanUp(){
		waitFor(5);
		driver.manage().deleteAllCookies();
	}
	
	@AfterClass
	public void tearDown(){
		waitFor(5);
		driver.close();
		driver.quit();
	}
	
	public void waitFor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Better move to basepage
	public WebElement findElement(By by){
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return driver.findElement(by);
	}
	
	public void findAndClickElement(By by){
		findElement(by).click();
	}
}
