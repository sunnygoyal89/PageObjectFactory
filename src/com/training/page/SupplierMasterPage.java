package com.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SupplierMasterPage extends MyHomePage {

	// extends MyHomePage because the navigation pane is common for all pages
	// no need of driver here because it will be inherited from super class

	@FindBy(how = How.XPATH, using = ".//span[contains(text(), 'Supplier Master')]")
	WebElement label_SupplierMaster;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lbaddnew")
	WebElement lnk_AddNew;

	public SupplierMasterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
		//PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		// verify that page is really present
		validatePageAppeared();
	}

	public void validatePageAppeared() {
		Assert.assertTrue(label_SupplierMaster.isDisplayed(), "SupplierMaster page is not displayed");
	}

	public AddSupplierMaster clickAddNew() {
		lnk_AddNew.click();
		return new AddSupplierMaster(driver);
	}
	
	public class AddSupplierMaster {
		
		@FindBy(id = "ctl00_ContentPlaceHolder1_txtName")
		WebElement tb_Name;

		@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave")
		WebElement btn_Save;

		@FindBy(id = "ctl00_ContentPlaceHolder1_txtAdd")
		WebElement tb_Address;

		@FindBy(id = "ctl00_ContentPlaceHolder1_txtEmail")
		WebElement tb_Email;

		@FindBy(id = "ctl00_ContentPlaceHolder1_txtCountry")
		WebElement dd_Country;

		public AddSupplierMaster(WebDriver driver){
			//PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
			PageFactory.initElements(driver, this);
			validatePageAppeared1();
		}

		public void validatePageAppeared1() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(tb_Address.isDisplayed(), "AddSupplierMaster page is not displayed");
		}
		
		public void setName(String name) {
			System.out.println("Name displayed? " + tb_Name.isDisplayed());
			tb_Name.sendKeys(name);
		}

		public void clickSave() {
			btn_Save.click();
		}

		public void selectCountry() {
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtCountry")).click();
			dd_Country.click();
		}
	}

}