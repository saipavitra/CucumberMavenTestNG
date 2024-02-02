package com.mod.configurations;

import java.util.HashMap;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Config {

	public static RemoteWebDriver rDriver;
	public static WebDriver driver;
	public static String browserType = "chrome";
	public static String url = "https://staging.boslegacy.gobeon.com/Account/Login.aspx";
	public static WebElement element;
	public static JavascriptExecutor javaScript;
	public static WebDriverWait wait;
	public static Actions action;
	public static HashMap<String,String> testdata = new HashMap<String,String>();
	public static boolean flag = false;
	public static String testdataPath = System.getProperty("user.dir")+"/testData/";
	public static ExtentReports extentReport;
    public static ExtentTest extentTest;
    public static ExtentSparkReporter sparkReport;
    public static String urlQA ="https://qa.bos.gobeon.com/load-board";
    public static String urlSTG ="https://stg.bos.gobeon.com/load-board";
    public static String urlLegacySTG= "https://staging.boslegacy.gobeon.com/Home/AdminDefault.aspx";
    public static String encode="RnJlaWdodDEyMyE=";



}
