package com.training.tests;

import org.testng.annotations.Test;

import com.training.data.ExternalDP;
import com.training.page.LoginPage;

public class LoginTest extends BaseTest{
		
	//when dataProvider is another class than we also need to provide the class name (ExternalDP)
	@Test(dataProvider = "validLoginDataProvider", dataProviderClass = ExternalDP.class)
	public void checkValidLogin(String username, String password){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.performValidLogin(username, password);
	}
	
	@Test(dataProvider = "invalidLoginDataProvider", dataProviderClass = ExternalDP.class)
	public void checkInvalidLogin(String username, String password){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setLoginId(username);
		loginPage.setPassword(password);
		loginPage.clickLogin();
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void test2(){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setLoginId("avinash");
	}
}
