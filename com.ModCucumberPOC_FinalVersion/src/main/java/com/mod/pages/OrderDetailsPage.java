package com.mod.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.mod.configurations.Config;
import com.mod.keywords.ActionLibrary;
import com.mod.objectrepository.LoadBoard;
import com.mod.objectrepository.OrderDetails;

public class OrderDetailsPage {

	public static void verifyLoadId() {
		try {
			ActionLibrary.webDriverWait(LoadBoard.legacyLoadId, 60);
			String lBloadId = ActionLibrary.getText(LoadBoard.legacyLoadId);
			//System.out.println(lBloadId);
			String[] loadBoardOrder = lBloadId.split("L");
			ActionLibrary.takeScreenshot();
			Config.extentTest.pass("Navigated to load-board page succesfully");
			//System.out.println(loadBoardOrder[1]);
			// scroll function check
			//ActionLibrary.scrollDownToThePage();
			//ActionLibrary.focusWebElement(Config.driver.findElement(By.xpath(LoadBoard.lastLoad)));
			//ActionLibrary.webDriverWait(LoadBoard.lastLoad, 120);
			//ActionLibrary.takeScreenshot();
			//Config.extentTest.pass("Scrolled to the bottom of the page");
			//ActionLibrary.scrollRightToThePage();
			//ActionLibrary.scrollFunction(Config.driver.findElement(By.xpath(LoadBoard.customerClassification)));
			//ActionLibrary.webDriverWait(LoadBoard.customerClassification, 120);
			//ActionLibrary.takeScreenshot();
			//Config.extentTest.pass("Scrolled to the right side of the page");

			ActionLibrary.clickElement(Config.driver.findElement(By.xpath(LoadBoard.modLoadIdIcon)));
			ActionLibrary.switchToWindow();
			ActionLibrary.webDriverWait(OrderDetails.loadId, 120);
			ActionLibrary.takeScreenshot();
			Config.extentTest.pass("Navigated to Load details page succesfully");
			String oDloadId = ActionLibrary.getText(OrderDetails.loadId);
			String[] orderDetailLoadId = oDloadId.split("#");
			//System.out.println(orderDetailLoadId[1]);
			//System.out.println(loadBoardOrder[1]); 
			//System.out.println(orderDetailLoadId[1]); 
			Assert.assertEquals(loadBoardOrder[1], orderDetailLoadId[1]);
			Config.extentTest.pass("Load Number validated successfully in Load details page");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to validate the load number in load details page");
		}

	}
}
