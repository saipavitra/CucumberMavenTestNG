package com.mod.stepdefinitions;

import org.openqa.selenium.By;

import com.mod.configurations.Config;
import com.mod.configurations.Labels;
import com.mod.keywords.ActionLibrary;
import com.mod.objectrepository.LegacyCarrier;
import com.mod.objectrepository.LegacyHome;
import com.mod.pages.CommonPage;
import com.mod.pages.LegacyCarrierPage;

import io.cucumber.java.en.And;

public class LegacyCarrierSalesStep {
	
	
	@And("Navigate to Carrier Profile Page")
	public void CarrierProfilePageNavigation() {
		CommonPage.navigateToScreen(Config.driver.findElement(By.xpath(LegacyHome.CarrierSalesMenu)),Config.driver.findElement(By.xpath(LegacyHome.CarrierSearchSubMenu)));
		ActionLibrary.webDriverWait(LegacyCarrier.btnSearchCarrier, Labels.webDriverWait);
		LegacyCarrierPage.searchCarrier();
		ActionLibrary.clickElement(Config.driver.findElement(By.xpath(LegacyCarrier.lnkCarrier)));
		ActionLibrary.switchToWindow();	
		
	}
	@And("Edit the Contact of Driver in Carrier profile page of Mod Application")
	public void EditDriverContact(){
		ActionLibrary.clickElement(Config.driver.findElement(By.xpath(LegacyCarrier.btnQuickAdd)));
		ActionLibrary.switchToWindow();	
		ActionLibrary.webDriverWait(LegacyCarrier.btnEditDriver, Labels.webDriverWait);
		LegacyCarrierPage.editPrimaryPhoneNum();
			
	}
	

}
