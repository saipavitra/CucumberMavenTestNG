package com.mod.pages;

import org.openqa.selenium.By;

import com.mod.configurations.Config;
import com.mod.configurations.Labels;
import com.mod.keywords.ActionLibrary;
import com.mod.objectrepository.LegacyHome;
import com.mod.objectrepository.LoadBoard;
import com.mod.objectrepository.Login;

public class LoginPage {

	public static void launchApp() {
		try {
			//String encodeValue = ActionLibrary.encryptPassword(Config.encode);
            //String password = ActionLibrary.decodePassword(Config.encode);
            ActionLibrary.enterTextbox(Config.driver.findElement(By.xpath(Login.userName)),
                    Config.testdata.get("Username"));
            ActionLibrary.enterTextbox(Config.driver.findElement(By.xpath(Login.passWord)), Config.testdata.get("Password"));
            ActionLibrary.takeScreenshot();
            Config.extentTest.pass("Entered username and password successfully");
            ActionLibrary.clickElement(Config.driver.findElement(By.xpath(Login.loginButton)));
            ActionLibrary.webDriverWait(LoadBoard.loadNumberLink,Labels.webDriverWait);
            ActionLibrary.takeScreenshot();
            Config.extentTest.pass("Application launched successfully");
		}catch(Exception e)
		{
			Config.extentTest.fail("Failed to launch the application");
		}
    }
	
}
