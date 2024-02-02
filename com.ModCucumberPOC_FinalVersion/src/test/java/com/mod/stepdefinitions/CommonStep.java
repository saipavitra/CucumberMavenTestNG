package com.mod.stepdefinitions;

import com.mod.configurations.Config;
import com.mod.configurations.Labels;
import com.mod.keywords.ActionLibrary;
import com.mod.objectrepository.LegacyHome;
import com.mod.pages.LoginPage;

import io.cucumber.java.en.And;

public class CommonStep {

	@And("Launch Mod Application")
	public void LaunchApplication() {
		Config.driver=ActionLibrary.driverInitialisation(Config.browserType);
		ActionLibrary.launchApplication(Config.url);
		ActionLibrary.takeScreenshot();
		Config.extentTest.pass("Launched application successfully");
		LoginPage.launchApp();
	}
	
	@And("Navigate to Legacy Application")
	public void LaunchLegacyApplication() {
		String urlMOD = Config.driver.getCurrentUrl();
		//System.out.println(urlMOD);
		if (Config.urlQA.contains(urlMOD)|| Config.urlSTG.contains(urlMOD)) {
			Config.driver.navigate().to(Config.urlLegacySTG);
			ActionLibrary.webDriverWait(LegacyHome.welcomeTitle,Labels.webDriverWait);
			ActionLibrary.takeScreenshot();
            Config.extentTest.pass("Legacy Application launched successfully");
		}else{
			Config.extentTest.info("Already Landed successfully in Legacy home page");
		}
	}
	
	
	@And("Close the Application")
	public void CloseApplication()
	{
		ActionLibrary.closeApplication();	
	}
	
}
