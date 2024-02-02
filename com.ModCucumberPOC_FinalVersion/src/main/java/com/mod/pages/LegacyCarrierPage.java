package com.mod.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.mod.configurations.Config;
import com.mod.configurations.Labels;
import com.mod.keywords.ActionLibrary;
import com.mod.objectrepository.LegacyCarrier;
import com.mod.objectrepository.LegacyHome;

public class LegacyCarrierPage {
	
	public static String carrierIndex="0";
	
	public static void searchCarrier() {
		try {
			CommonPage.navigateToScreen(Config.driver.findElement(By.xpath(LegacyHome.CarrierSalesMenu)),Config.driver.findElement(By.xpath(LegacyHome.CarrierSearchSubMenu)));
			ActionLibrary.webDriverWait(LegacyCarrier.btnSearchCarrier, Labels.webDriverWait);	
	ActionLibrary.enterTextbox(Config.driver.findElement(By.xpath(LegacyCarrier.txtbxFromPowerUnit)),Config.testdata.get("FromPowerUnit"));
	ActionLibrary.enterTextbox(Config.driver.findElement(By.xpath(LegacyCarrier.txtbxToPowerUnit)),Config.testdata.get("ToPowerUnit"));
	ActionLibrary.enterTextbox(Config.driver.findElement(By.xpath(LegacyCarrier.txtbxCarrierName)),Config.testdata.get("CarrierName"));
	ActionLibrary.clickElement(Config.driver.findElement(By.xpath(LegacyCarrier.btnSearchCarrier)));
	ActionLibrary.webDriverWait(LegacyCarrier.lnkCarrier, Labels.webDriverWait);
	String carrierName=ActionLibrary.getText(LegacyCarrier.lnkCarrier);
	String carrierNameTestData=Config.testdata.get("CarrierName");
	ActionLibrary.takeScreenshot();
	Assert.assertEquals(carrierName,carrierNameTestData);
	boolean contains = carrierName.contains("Carrier");
	Assert.assertTrue(contains);

	Config.extentTest.pass("Searched the Carrier successfully");
		}catch(Exception e)
		{
			Config.extentTest.fail("Failed to Search the Carrier");
		}
	}
	
	public static void editPrimaryPhoneNum(){
		try {
		ActionLibrary.clickElement(Config.driver.findElement(By.xpath(LegacyCarrier.btnEditDriver)));
		ActionLibrary.webDriverWait(LegacyCarrier.txtbxPrimaryphone, Labels.webDriverWait);
		ActionLibrary.takeScreenshot();
		Config.extentTest.pass("Navigated to Edit Pop up window");
		ActionLibrary.webDriverWait(LegacyCarrier.txtbxPrimaryphone, Labels.webDriverWait);
    	ActionLibrary.clearText(Config.driver.findElement(By.xpath(LegacyCarrier.txtbxPrimaryphone)));
		//ActionLibrary.enterTextbox(Config.driver.findElement(By.xpath(LegacyCarrier.txtbxPrimaryphone)),Config.testdata.get("Primaryphone"));
		ActionLibrary.enterTextByJS(Config.driver.findElement(By.xpath(LegacyCarrier.txtbxPrimaryphone)),Config.testdata.get("Primaryphone"));
		String txtPrimaryPhonepop = Config.testdata.get("Primaryphone");  
		ActionLibrary.takeScreenshot();
		Config.extentTest.pass("New Primary phone number added successfully");
		ActionLibrary.clickElement(Config.driver.findElement(By.xpath(LegacyCarrier.btnSave)));
		//ActionLibrary.webDriverWait(LegacyCarrier.lblPrimaryPhone, 60);
		Thread.sleep(3000);
		String txtPrimaryPhonepage=ActionLibrary.getText(LegacyCarrier.txtfirstPrimaryphone).toString();
		String txtPrimaryPhonepagespl=ActionLibrary.ignoreSpecialCharacters(txtPrimaryPhonepage);  
		Assert.assertEquals(txtPrimaryPhonepagespl, txtPrimaryPhonepop);
		ActionLibrary.takeScreenshot();
		Config.extentTest.pass("Driver contact number updated successfully");
	}catch(Exception e)
		{
		Config.extentTest.fail("Fail to edit the driver contact number");
		}

}
}
