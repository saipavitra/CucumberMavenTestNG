package com.mod.pages;

import org.openqa.selenium.WebElement;

import com.mod.configurations.Config;
import com.mod.keywords.ActionLibrary;

public class CommonPage {

	public static void navigateToScreen(WebElement parentMenu, WebElement childMenu) {
		try {
		ActionLibrary.mouseHovering(parentMenu);
		ActionLibrary.takeScreenshot();
        Config.extentTest.pass("Navigated to Sub Menu");
		ActionLibrary.clickElement(childMenu);
		}catch(Exception e)
		{
			Config.extentTest.fail("Failed to navigate to child Menu");
		}
	}
}
