package com.training.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class LoginPage {

	private WebDriver driver;
	
	@FindBy(id = "txtUserName")
	WebElement tb_loginId;
	
	@FindBy(how= How.ID,  using = "txtPassword") //same as above just another way of writing
	WebElement tb_password;

	@FindBy(id = "LoginButton")
	WebElement bt_login;
	
	@FindBy(how= How.LINK_TEXT,  using = "Forgot Password?")
	WebElement lnk_forgotPassword;

	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//verify that LoginPage is really present
		validatePageAppeared();
	}
	
	public void validatePageAppeared(){
		Assert.assertTrue(bt_login.isDisplayed(), "Login Page is not displayed");
	}
	
	public void setLoginId(String loginId){
		tb_loginId.sendKeys(loginId);
	}
	
	public void setPassword(String password){
		tb_password.sendKeys(password);
	}
	
	public void clickLogin(){
		bt_login.click();
	}
	
	public MyHomePage performValidLogin(String username, String password){
		tb_loginId.sendKeys(username);
		tb_password.sendKeys(password);
		bt_login.click();
		return new MyHomePage(driver);
	}
}
