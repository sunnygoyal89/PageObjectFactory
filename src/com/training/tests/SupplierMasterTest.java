package com.training.tests;

import org.testng.annotations.Test;

import com.training.page.LoginPage;
import com.training.page.MyHomePage;
import com.training.page.SupplierMasterPage;
import com.training.page.SupplierMasterPage.AddSupplierMaster;


public class SupplierMasterTest extends BaseTest{

	@Test
	public void test1(){
		LoginPage loginPage = new LoginPage(driver);
		MyHomePage myHomePage = loginPage.performValidLogin("avinash", "avinash");
		myHomePage.mouseHoverManage();
		SupplierMasterPage supplierPage = myHomePage.clickSupplierMaster();
		AddSupplierMaster addSupplier = supplierPage.clickAddNew();
		addSupplier.setName("Arun");
		addSupplier.selectCountry();
		//fill other fields in the form
		
		addSupplier.clickSave();
		driver.switchTo().alert().accept();
	}
	

	
}
