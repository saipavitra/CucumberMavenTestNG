package com.mod.keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Arrays;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mod.configurations.Config;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionLibrary {
	// public static WebDriver driver;
	//WebDriver driver =new RemoteWebDriver(capabilities)

	/**
	 * Initialize drivers
	 * 
	 * @param- pass the browser's name
	 */
	public static WebDriver driverInitialisation(String browserType) {
		try {
			if (browserType.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
//				WebDriverManager.chromedriver().browserVersion("93")//to set up browser's version and run 
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\184540\\Downloads\\V.1.0\\V.1.0\\com.ModCucumberPOC_3\\driver\\chromedriver.exe");
//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--test-type");
				Config.driver = new ChromeDriver();
				//WebDriver driver = new ChromeDriver(options);
			} else if (browserType.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				Config.driver = new FirefoxDriver();
			} else if (browserType.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				Config.driver = new EdgeDriver();
			}
			//Config.extentTest.pass("Initialized Driver successfully");
		} catch (Exception e) {
			Config.extentTest.fail("Failed to initialize the Driver");
		}
		return Config.driver;
	}

	/*
	 * launch application
	 * 
	 * @param browser - which browser to launch, url - pass the application url
	 * 
	 */

	public static void launchApplication(String url) {
		try {
			Config.driver.manage().window().maximize();// at JDK 1.8 we have minimize as well
			//Config.driver.manage().window().minimize();
			Config.driver.get(url);
			//Config.extentTest.pass("Application launched Successfully");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to launch application");
		}
	}

	/*
	 * refresh the application
	 * 
	 */

	public static void refreshApplication() {
		try {
			Config.driver.navigate().refresh();
			//Config.extentTest.pass("Application refreshed successfully");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to refresh the application");
		}
	}

	/*
	 * select the value from the drop down
	 * 
	 * @param element - action to the particular object, testData - pass the string
	 * value to select the date
	 * 
	 */

	public static void selectValueFromDropDown(WebElement element, String testData) {
		try {
			Select value = new Select(element);
			List<WebElement> allOptions = value.getOptions();
			for (WebElement options : allOptions) {
				String optionValue = options.getText();
				if (optionValue.equalsIgnoreCase(testData)) {
					options.click();
				}
			}
			//Config.extentTest.pass("Value selected from the Dropdown successfully");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to select the value from the Dropdown");
		}
	}

	/*
	 * select by visible text from the drop down
	 * 
	 * @param element - action to the particular object, testData - pass the string
	 * value value to select the date
	 * 
	 */

	public static void selectByText(WebElement element, String testData) {
		try {
			Select value = new Select(element);
			value.selectByVisibleText(testData);
			//Config.extentTest.pass("Value selected from the Dropdown successfully");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to select the value from the Dropdown");
		}
	}

	/*
	 * click the element
	 * 
	 * @param element - action to the particular object
	 */

	public static void clickElement(WebElement element) {
		try {
			element.click();
			//Config.extentTest.pass("Click the element successfully");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to click the element");
		}
	}

	/*
	 * double click the element
	 * 
	 * @param element - action to the particular object, xpath - pass the xpath of
	 * the element
	 */

	public static void doubleClickElement(WebElement element, String xpath) {
		try {
			Config.action = new Actions(Config.driver);
			element = Config.driver.findElement(By.xpath(xpath));
			Config.action.doubleClick(element).perform();//.perform() is very important function when using action class , without ".perform()" this action class will not function 
			//Config.action.keyDown(element, Keys.SHIFT).sendKeys("sai").keyUp(element, Keys.SHIFT) -> keyDown is same as keypress , if element is textbox , this will perform a combined action as by pressing shift button and enter all the texts together such that it will result in uppercase letters , after that release will be initiated to release the keys
			//Config.action.doubleClick(element).click().build().perform();//.build() is used when multiple actions are performed 
			//Config.extentTest.pass("Click the element successfully");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to click the element");
		}
	}

	/*
	 * clear the textbox field
	 * 
	 * @param element - action to the particular object
	 */

	public static void clearText(WebElement element) {
		try {
			element.clear();
			//Config.extentTest.pass("Clear the text box field successfully");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to clear the text box");
		}
	}

	/*
	 * select by value from the drop down
	 * 
	 * @param element - action to the particular object, testData - pass the string
	 * value value to select the date
	 */

	public static void selectByValue(WebElement element, String testData) {
		try {
			Select value = new Select(element);
			value.selectByValue(testData);
			//Config.extentTest.pass("Value selected from the Dropdown successfully");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to select the value from the Dropdown");
		}
	}

	/*
	 * select by index from the drop down
	 * 
	 * @param element - action to the particular object, testData - pass the int
	 * value value to select the date
	 */

	public static void selectByIndex(WebElement element, int testData) {
		try {
			Select value = new Select(element);
			value.selectByIndex(testData);
			//value.getAllSelectedOptions()// is the user is able to click multiple options this method is used
			//value.getOptions()//all the options will be displayed , return type -> list of webElements
			//Config.extentTest.pass("Value selected from the Dropdown successfully");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to select the value from the Dropdown");
		}
	}

	/*
	 * click the button or the link from web table
	 * 
	 * @param element - action to the particular object, testData - pass the string
	 * value to select the date
	 */

	public static void clickElementFromWebTable(WebElement element, String testdata) {
		try {
			List<WebElement> tr = element.findElements(By.tagName("tr"));
			for (int i = 0; i <= tr.size(); i++) {
				List<WebElement> td = tr.get(i).findElements(By.tagName("td"));
				for (int j = 0; j < td.size(); j++) {
					if (td.get(j).getText().equalsIgnoreCase(testdata)) {
						td.get(j).click();
					}
				}
			}
			//Config.extentTest.pass("Click the value from web table successfully");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to click the value from web table");
		}
	}

	/*
	 * Verify page title 
	 * 
	 * @param element - action to the particular object
	 */

	public static void verifyPageTitle(String testData) {
		try {
			String title = Config.driver.getTitle();
			Assert.assertEquals(testData, title);
			//Config.extentTest.pass("Application closed successfully");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to close the application");
		}
	}

	/*
	 * java script click the element
	 * 
	 * @param element - action to the particular object
	 */

	public static void javaClick(WebElement element) {
		try {
			Config.javaScript = (JavascriptExecutor) Config.driver;
			Config.javaScript.executeScript("arguments[0].click();", element);
			//Config.extentTest.pass("Click the element successfully");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to click the element");
		}
	}

	/*
	 * mouse hovering the element
	 * 
	 * @param element - action to the particular object, xpath - pass the xpath of
	 * the element
	 */

	public static void mouseHovering(WebElement element) {
		try {
			Config.element=element;
			Config.action = new Actions(Config.driver);
			Config.action.moveToElement(Config.element).perform();
			//Config.extentTest.pass("Mouse Hovering the element successfully");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to Mouse Hovering the element");
		}
	}

	/*
	 * enter the value in text box field
	 * 
	 * @param element - action to the particular object, testdata - pass the string
	 * value
	 */

	public static void enterTextbox(WebElement element, String testData) {
		try {
			element.clear();
			element.sendKeys(testData);
			//Config.extentTest.pass("Enter the value successfully in text box field");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to enter the value in text box field");
		}
	}

	/*
	 * accept the pop up window
	 * 
	 */

	public static void alertAccept() {
		try {
			Config.driver.switchTo().alert().accept();
			//Config.extentTest.pass("Accept the pop up window successfully");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to accept the pop up window");
		}
	}

	/*
	 * dismiss the pop up window
	 * 
	 */

	public static void alertDismiss() {
		try {
			Config.driver.switchTo().alert().dismiss();
			//Config.extentTest.pass("Dismiss the pop up window successfully");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to dismiss the pop up window");
		}
	}

	/*
	 * switch window from one to other
	 * 
	 */

	public static void switchToWindow() {
		try {
			String parentWindow = Config.driver.getWindowHandle();
			Set<String> childWindow = Config.driver.getWindowHandles();
//			List<String> windows= new LinkedList<String>(); //index based windows handling
//			windows.addAll(childWindow);//adds the set variables to list
//			windows.get(1);
			for (String allWindow : childWindow) {
				if (allWindow != parentWindow) {
					Config.driver.switchTo().window(allWindow);
				}
			}
			//Config.extentTest.pass("Window got switched successfully");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to switch the window");
		}
	}

	/*
	 * scroll function for the page
	 * 
	 */

	public static void scrollFunction(WebElement element) {
		try {
			Config.javaScript = (JavascriptExecutor) Config.driver;
			Config.javaScript.executeScript("arguments[0].scrollIntoView(true)", element);
			//Config.extentTest.pass("Scroll successfully to the page");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to scroll the page");
		}
	}
	/*
	 * wait until the element is visible
	 * 
	 * @param xpath - action to the particular object
	 * 
	 * @param duration- seconds that the element needs to stop until the element is
	 * visible
	 * 
	 */

	public static void webDriverWait(String xpath, int duration) {
		try {
			Config.wait = new WebDriverWait(Config.driver, Duration.ofSeconds(duration));
			//Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
			
//			FluentWait<WebDriver> w=new FluentWait<WebDriver>(Config.driver);
//			w.withTimeout(Duration.ofSeconds(duration)).pollingEvery(Duration.ofSeconds(2)).ignoring(Throwable.class);// throwable.class can handle all type of exception// pollingEvery - waits for every 2 secs till the element is found
		
//			Config.driver.manage().timeouts().pageLoadTimeout(duration);// waits until the Whole DOM is visible
			//Config.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			//Config.extentTest.pass("Wait until the Required Element is identified Successfully");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to wait for the element");
		}

	}

	/*
	 * close the application
	 * 
	 * @param element - action to the particular object
	 * 
	 */

	public static void closeApplication() {
		try {
			Config.driver.quit();
			Config.extentTest.pass("Application closed successfully");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to close the application");
		}
	}

	/**
	 * Validate Checkbox isSelected method and click
	 * 
	 * @param xpath-
	 *            the actual xpath of element
	 */
	public static void clickCheckBox(WebElement element) {
		try {
			Config.element = element;
			boolean isSelected = Config.element.isSelected();

			// performing click operation if element is not checked
			if (isSelected == false) {
				Config.element.click();
			}
			//Config.extentTest.pass("checkbox checked-in successfully");
		} catch (Exception e) {
			Config.extentTest.fail("Failed to check-in the checkbox/ already checkbox has been checked-in");
		}
	}

	/**
	 * To take screenshot
	 */
	public static void takeScreenshot() {
		try {
			String imgData = "<img src='data:image/png;base64, " + getBase64Image()
					+ "' alt='Screenshot' width='1000' height ='350'/>";
			Config.extentTest.info(imgData);
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to take the screenshot");
		}
	}

	public static String getBase64Image() {
		return ((TakesScreenshot) Config.driver).getScreenshotAs(OutputType.BASE64);

	}


	/**
	 * To verify if the element is enabled
	 * 
	 * @param xpath
	 *            - the actual xpath of element
	 */
	public static boolean isEnabled(WebElement element) {
		boolean flag = false;
		try {
			Config.element = element;
			if (Config.element.isEnabled()) {
				flag = true;
			}
			//Config.extentTest.pass("WebElement enabled successfully");
		} catch (Exception e) {
			Config.extentTest.fail("Failed to enable the WebElement");
		}
		return flag;
	}

	/**
	 * To verify if the textBox is empty
	 * 
	 * @param xpath
	 *            - the actual xpath of textbox
	 * @param attributeValue-
	 *            pass the attribute of Textbox's input
	 */
	public static boolean isTextboxEmpty(WebElement element, String attributeValue) {
		boolean flag = false;
		try {
			Config.element = element;
			String textBox = Config.element.getAttribute(attributeValue);

			if (textBox.isEmpty()) {
				flag = true;
			}
			//Config.extentTest.pass("Textbox is empty as expected");
		} catch (Exception e) {
			Config.extentTest.fail("Failed to get the Textbox as empty");
		}
		return flag;
	}

	/**
	 * Get the attribute value from the element
	 * 
	 * @param xpath
	 *            - the actual xpath of webelement
	 * @param string
	 *            to pass the attribute value
	 * @return string
	 */
	public static String getAttribute(WebElement element, String testData) {
		String attributeData = null;
		try {
			Config.element = element;
			attributeData = Config.element.getAttribute(testData);
			//Config.extentTest.pass("Able to get the WebElement's attribute value successfully");
		} catch (Exception e) {
			Config.extentTest.fail("Failed to get the WebElement's attribute value");
		}
		return attributeData;
	}

	/**
	 * This method is to check the focus the element in the web page
	 * 
	 * @param xpath-
	 *            pass the xpath of the WebElement
	 */
	public static void focusWebElement(WebElement element) {
		try {
			Config.element = element;
			Config.javaScript = (JavascriptExecutor) Config.driver;
			Config.javaScript.executeScript("arguments[0].focus()", Config.element);
//			Config.javaScript.executeScript("arguments[0].setAttribute('value', '40')",Config.element); - sendKeys
//			Config.javaScript.executeScript("arguments[0].setAttribute('value', '40')",Config.element, Config.element);
//			Object executeScript = Config.javaScript.executeScript("return arguments[0].getAttribute('value')",Config.element, Config.element);- getText
//			System.out.println(executeScript.toString());
//			Config.javaScript.executeScript("arguments[0].scrollToView(true)",Config.element);//scroll to down and view the element
//			Config.javaScript.executeScript("arguments[0].scrollToView(false)",Config.element);//scroll to up and view the element
//			Config.javaScript.executeScript("arguments[0].click()",Config.element);
			//Config.extentTest.pass("Able to focus the WebElement successfully");
		} catch (Exception e) {
			Config.extentTest.fail("Failed to focus the WebElement");
		}
	}

	/**
	 * To verify if element is present or not
	 * 
	 * @param xpath
	 *            - pass the xpath of the WebElement
	 */
	public static boolean isElementPresent(String xpath) {
		boolean flag = false;
		try {
			Config.element = Config.driver.findElement(By.xpath(xpath));
			if (Config.element.isDisplayed()) {
				flag = true;
			} else {
				flag = false;
			}
			//Config.extentTest.pass("Captured the element successfully");
		} catch (Exception e) {
			Config.extentTest.fail("Failed to capture the element's presence");
		}
		return flag;
	}

	/**
	 * Get the text from the element
	 * 
	 * @param xpath-pass
	 *            the xpath of webelement
	 * @return required element's text
	 */
	public static String getText(String xpath) {
		String text = null;
		try {
			Config.element = Config.driver.findElement(By.xpath(xpath));
			text = Config.element.getText();
			//System.out.println(text);
			//Config.extentTest.pass("Got the text for the required WebElement successfully");
		} catch (Exception e) {
			Config.extentTest.fail("Failed to get the text for the required WebElement");
		}
		return text;
	}

	/**
	 * Fetch the specific value from the table
	 * 
	 * @param element
	 *            - action to the particular object, testData - pass the string
	 *            value to select the date
	 */

	public static String getElementFromWebTable(WebElement element, String testdata) {
		String tableValue = null;
		try {
			List<WebElement> tr = element.findElements(By.tagName("tr"));
			for (int i = 0; i <= tr.size(); i++) {
				List<WebElement> td = tr.get(i).findElements(By.tagName("td"));
				for (int j = 0; j < td.size(); j++) {
					if (td.get(j).getText().equalsIgnoreCase(testdata)) {
						tableValue = td.get(j).getText();
					}
				}
			}
			//Config.extentTest.pass("Get the value from web table successfully");
		} catch (Throwable e) {
			Config.extentTest.fail("Fail to get the value from web table");
		}
		return tableValue;
	}

	/**
	 * Check if page is loaded and ready
	 */
	@SuppressWarnings("unused")
	public static void waitPageToLoad() {
		try {
			for (int i = 0; i < 30; i++) {
				Thread.sleep(1000);
				if ("complete"
						.equalsIgnoreCase(Config.javaScript.executeScript("return document.readyState").toString()))
					;
				{
					Thread.sleep(3000);
					break;
				}
			}
		} catch (Exception ex) {
			Config.extentTest.fail("Page not loaded");

		}
	}

	/**
	 * Check whether element is disabled
	 * 
	 * @param Obj
	 * @return
	 */
	public static void elementDisabled(WebElement element, String attribute, String expectedValue) {
		try {
			Config.javaScript = (JavascriptExecutor) Config.driver;
			String actualValue = element.getAttribute(attribute).toString();
			System.out.println(actualValue);
			Assert.assertEquals(actualValue, expectedValue);
		} catch (Exception e) {
			Config.extentTest.fail("No disabled text is present");
		}
	}

	/**
	 * Clear Input text of element using Executor
	 */
	public static void clearElementTextUsingJS(WebElement element) {
		Config.javaScript.executeScript("arguments[0].value=''", Arrays.asList(element));
	}

	/**
	 * A method for clicking a text box Clear value from text box and send new value
	 * 
	 * @param element
	 *            - WebElement
	 * @param inputValue
	 *            - String (needed value)
	 */
	public static void enterTextByJS(WebElement element, String inputValue) {
		// added a delay to work also on other browsers than CHROME_DRIVER
		Config.javaScript = (JavascriptExecutor) Config.driver;
		Config.javaScript.executeScript("arguments[0].scrollIntoView(true)", element);
		clickElement(element);
		clearElementTextUsingJS(element);
		element.sendKeys(inputValue);
	}

	/**
	 * scroll the page down
	 */
	public static void scrollDownToThePage() {
		try {
			Actions pageDown = new Actions(Config.driver);
			pageDown.sendKeys(Keys.PAGE_DOWN).build().perform();
		} catch (Exception e) {
			Config.extentTest.fail("Unable to down the page");
		}
	}
	/**
	 * scroll to the right of the page
	 */
	public static void scrollRightToThePage() {
		try {
			Actions pageDown = new Actions(Config.driver);
			pageDown.sendKeys(Keys.ARROW_RIGHT).build().perform();
		} catch (Exception e) {
			Config.extentTest.fail("Unable to down the page");
		}
	}

	/**
	 * scroll to the last element
	 */
	public static void scrollToLast(String path) {
		try {
			WebElement scrollArea = Config.driver.findElement(By.xpath(path));
			((JavascriptExecutor) Config.driver).executeScript("arguments[0].scrollIntoViewIfNeeded()", scrollArea);
			Thread.sleep(500);
			//Config.extentTest.pass("Scroll to the last element successfully");
		} catch (Exception e) {
			Config.extentTest.fail("Unable to scroll the page");
		}
	}

	/**
	 * scroll till particular element
	 */
	public static void scrollToParticularElement(String path) {
		try {
			WebElement scrollArea = Config.driver.findElement(By.xpath(path));
			((JavascriptExecutor) Config.driver).executeScript("arguments[0].scrollIntoView(true)", scrollArea);
			Thread.sleep(500);
		} catch (Exception e) {
			Config.extentTest.fail("Unable to scroll the page");
		}
	}


	/**
	 * This method is used to upload any type of files
	 * 
	 * @param tstObj
	 *            is the Test Object of the upload button
	 * @param filePath
	 *            is the path of the file needs to be uploaded
	 * @param fileFormat
	 *            is the format of the file to be uploaded
	 */
	public static void uploadFile(String fileUploadXpath, String filePath, String submitXpath) {
		Config.driver.findElement(By.xpath(fileUploadXpath)).sendKeys(filePath);
		Config.driver.findElement(By.xpath(submitXpath)).submit();
		if (Config.driver.getPageSource().contains("File Uploaded")) {
			//Config.extentTest.pass("file uploaded");
		} else {
			Config.extentTest.fail("file not uploaded");
		}
		Config.driver.quit();
	}

	/**
	 * Method to Download PDF file
	 * 
	 * @throws AWTException
	 */
	public static void downloadPDF(String filePath) throws AWTException {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_S);

		r.keyRelease(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_CONTROL);

		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		r.delay(2000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.delay(1000);

		r.keyPress(KeyEvent.VK_ENTER);
		r.mousePress(InputEvent.BUTTON1_DOWN_MASK);//left click
		r.mousePress(InputEvent.BUTTON2_DOWN_MASK);// middle click
		r.mousePress(InputEvent.BUTTON3_DOWN_MASK);//right click

		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * Method to ignore special characters in a string
	 * @param value 
	 */
	public static String ignoreSpecialCharacters(String testData) {
		try {
		testData = testData.replaceAll("[\\D]", "");
		//Config.extentTest.pass("Special Character ignored successfully");
		}catch(Exception e)
		{
		Config.extentTest.fail("Failed to ignore Special Character");
		}
		return testData;
	}
	
	/**
     * Method to encode the  string
     * @ decodeString - pass the sting value to decode
     */
    
    
    public static String encryptPassword(String decodeString) {
        String encodePassword = "";
        try {
            String password = decodeString;
            byte[] passwordByte = password.getBytes();
            encodePassword = Base64.getEncoder().encodeToString(passwordByte);
            //Config.extentTest.pass("Encoded the string successfully");
        } catch (Throwable e) {
            Config.extentTest.fail("Fail to endoded the string");
        }
        System.out.println(encodePassword);
        return encodePassword;
    }
    
    
    
    /**
     * Method to encode the  string
     * @ encodeString - pass the sting value to decode
     */
    
    
    public static String decodePassword(String encodeString) {
        String decodePassword = "";
        try {
            byte[] Password = Base64.getDecoder().decode(encodeString);
            decodePassword = new String(Password);
            //Config.extentTest.pass("Decode the string successfully");
        } catch (Throwable e) {
            Config.extentTest.fail("Fatil to decode the string");
        }
        return decodePassword;
    }


}
//handle tooltip -> refer this page ->https://www.guru99.com/verify-tooltip-selenium-webdriver.html
//assert vs verify vs waitFor-> Assert -> execution will be fail and stopped inbetween if any of the assert condition fails , To overcome this issue, there is a concept of Soft Assertion or Verify commands. Here, if there is a failure, the test execution continues and the failure logs are captured......
//A “waitFor” command waits for some condition to become true. They will fail and halt the test if the condition does not become true within the current timeout setting
//Hard Assert using TestNg 1)assertEquals(Assert.assertEquals(actual,expected);) , 2)assertNotEquals(Assert.assertNotEquals(actual,expected,Message);), 3)assertTrue( Assert.assertTrue(3<5);), 4)assertFalse (Assert.assertFalse(3>5)), 5)assertNull( Assert.assertNull(null);), 6)assertNotNull
//Soft Assertion In WebDriver Using TestNg -> SoftAssert softAssert = new SoftAssert(); 1)softAssert.assertNull("assertion"); 2)softAssert.assertAll();

//chromeOptions
//ChromeOptions options = new ChromeOptions()
//options.addArgument("start-maximized");//start-maximized or incognito or headless or disable-extensions or disable-popup-blocking or make-default-browser or disable-infobars: Prevents Chrome from displaying the notification ‘Chrome is being controlled by automated software
//ChromeDriver driver = new ChromeDriver(options);

//type of exception in selenium webdriver: https://katalon.com/resources-center/blog/selenium-exceptions