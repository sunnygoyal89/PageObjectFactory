package com.training.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyHomePage {

	protected WebDriver driver;
	
	@FindBy(id = "NavigationMenun2")
	WebElement nav_Manage;
	
	@FindBy(how= How.LINK_TEXT,  using = "Supplier Master") //same as above just another way of writing
	WebElement nav_SupplierMaster;

	@FindBy(how = How.XPATH, using=".//span[contains(text(), 'Welcome')]")
	WebElement label_Welcome;
	
	public MyHomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//verify that page is really present
		validatePageAppeared();
	}
	
	public void validatePageAppeared(){
		Assert.assertTrue(label_Welcome.isDisplayed(), "My Home Page is not displayed");
	}
	
	public void mouseHoverManage(){
		Actions actions = new Actions(driver);
		actions.moveToElement(nav_Manage).build().perform();
	}
	
	public SupplierMasterPage clickSupplierMaster(){
		nav_SupplierMaster.click();
		return new SupplierMasterPage(driver);
	}
}
