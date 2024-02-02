package com.mod.testrunner;

import java.io.IOException;

import org.openqa.selenium.By;

import com.mod.configurations.Config;
import com.mod.configurations.Labels;
import com.mod.keywords.ActionLibrary;
import com.mod.keywords.DateLibrary;
import com.mod.keywords.FileLibrary;
import com.mod.objectrepository.LoadBoard;
import com.mod.objectrepository.Login;
import com.mod.pages.LoginPage;

public class calendarCheck {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		FileLibrary.readData("CarrierProfile","DriverContactEditability","DriverContactEditability");
		Config.driver=ActionLibrary.driverInitialisation(Config.browserType);
		ActionLibrary.launchApplication(Config.url);
		ActionLibrary.enterTextbox(Config.driver.findElement(By.xpath(Login.userName)),
                Config.testdata.get("Username"));
        ActionLibrary.enterTextbox(Config.driver.findElement(By.xpath(Login.passWord)), Config.testdata.get("Password"));
        ActionLibrary.clickElement(Config.driver.findElement(By.xpath(Login.loginButton)));
        ActionLibrary.webDriverWait(LoadBoard.loadNumberLink,Labels.webDriverWait);
		Config.driver.findElement(By.xpath("//*[@id='customer']")).click();
		Thread.sleep(4000);
		Config.driver.findElement(By.xpath("//*[@id='header']/ntg-menu/nav/p-megamenu/div/ul/li[3]/div/div/div/ul[1]/li[3]/a/span")).click();
		Thread.sleep(4000);
		Config.driver.findElement(By.xpath("//*[@id='ntg-om--customer-search-typeahead']/span/input")).sendKeys("sentaida");
		Thread.sleep(4000);
		Config.driver.findElement(By.xpath("//*[contains(text(),'SENTAIDA INTERNATIONAL, INC.')]")).click();
		Thread.sleep(4000);
		Config.driver.findElement(By.xpath("//*[@id='ntg-om--container']/ntg-om-quick-quote-modal/div/ntg-om-quote-create-travel-path/div[2]/div/p-card[1]/div/div/div/ntg-om--quote-details-travel-segment/div/div/div[2]/div/div[3]/div/div[3]/ntg-date-picker/div[1]/span/input")).click();
//		DateLibrary.todaysDate();
		String date=DateLibrary.getDatePlusDays("MM-dd-yyyy",0);
		System.out.println(date);
//		ActionLibrary.closeApplication();

	}

}
