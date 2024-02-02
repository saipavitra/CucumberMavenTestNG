package com.mod.stepdefinitions;

import java.io.IOException;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.JsonFormatter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mod.configurations.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


	public class Hooks {
		
		@Before
		public void launchBrowser(Scenario scenario) throws IOException{
			SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	        System.out.println(date);
	        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
	        System.out.println(timeStamp);
	        String timeSnap = date.format(timeStamp).replaceAll(":", "-").replace(" ", "_");
	        Config.extentReport = new ExtentReports();     
	        //Config.sparkReport = new ExtentSparkReporter("Report/" + timeSnap);
	        Config.sparkReport = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/extentReport "+timeSnap);
	        Config.sparkReport.config().setTheme(Theme.DARK);
	        //Config.sparkReport.config().setDocumentTitle("MOD POC Automation");
	        //Config.sparkReport.config().setReportName("Regression Report");
	        //Config.sparkReport.config().setReportName(scenario.getName());
	        Config.extentReport.attachReporter(Config.sparkReport);
	        Config.extentTest = Config.extentReport.createTest(scenario.getName());	
	        //Config.extentTest.pass(Config.sparkReport);     
		}
		
//		Note  : refer @before(order=1) tag below similarily we do have the same thing for aftertag

//order=1 will be executed first before that @before tag	
		
		@Before(value="@SmokeTest", order=1)//order : tells which Test Case should execute first based on order declared //value: tags which have smoke functionalities which needs to be executed (excludes smokeTest Regression alone)
//		public void launchBrowsernew(Scenario scenario) throws IOException{
//			SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
//	        System.out.println(date);
//	        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
//	        System.out.println(timeStamp);
//	        String timeSnap = date.format(timeStamp).replaceAll(":", "-").replace(" ", "_");
//	        Config.extentReport = new ExtentReports();     
//	        //Config.sparkReport = new ExtentSparkReporter("Report/" + timeSnap);
//	        Config.sparkReport = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/extentReport "+timeSnap);
//	        Config.sparkReport.config().setTheme(Theme.DARK);
//	        //Config.sparkReport.config().setDocumentTitle("MOD POC Automation");
//	        //Config.sparkReport.config().setReportName("Regression Report");
//	        //Config.sparkReport.config().setReportName(scenario.getName());
//	        Config.extentReport.attachReporter(Config.sparkReport);
//	        Config.extentTest = Config.extentReport.createTest(scenario.getName());	
//	        //Config.extentTest.pass(Config.sparkReport);     
//	   
//		}
		
		@After
		public void closeBrowser(){	
			Config.extentReport.flush();
		}
}
