package com.mod.keywords;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mod.configurations.Config;

public class DateLibrary {

	/**
	 * A method to get future dates
	 * 
	 * @param dateFormat
	 *            - pass the format of date
	 * @param days
	 *            - pass the number of days to get the future date
	 */
	//change to getDate
	public static String getDatePlusDays(String dateFormat, int days) {
		String result = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			Calendar c = Calendar.getInstance();
			c.setTime(new Date()); // Using today's date
			c.add(Calendar.DATE, days); // Adding n days
			String output = sdf.format(c.getTime());
			result = output;
			System.out.println(result);
			selectDateinCalendar(result);
			//Config.extentTest.pass("Fetched the future dates successfully");
		} catch (Exception e) {
			Config.extentTest.fail("Failed to fetch the future dates");
		}
		return result;
	}

	/**
	 * Method to get date in specific format
	 * 
	 * @param dateFormat
	 *            - format in which date should be generated
	 * @param extraDays
	 *            - no of days to increase from current date
	 * @throws InterruptedException
	 */
	public static void todaysDate() {
		//change to date variable
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		String stdDate = formatter.format(date);
		System.out.println(stdDate);
		String splitter[] = stdDate.split("-");
		String day = splitter[1];
		String year = splitter[2];
		int iMonth = Integer.parseInt(splitter[0]);
		String month = new DateFormatSymbols().getMonths()[iMonth-1];
		System.out.println(month);
		System.out.println(day);
		System.out.println(year);
		selectDate(month, day, year);
	}

	/**
	 * Select Date from Date Picker
	 * 
	 * @param strDate
	 *            is the Date String in mm-dd-yyyy format
	 */
	public static void selectDate(String month, String select_day, String year) {
		WebElement calmonth = Config.driver.findElement(By.xpath("//*[@id='ntg-om--container']/ntg-om-quick-quote-modal/div/ntg-om-quote-create-travel-path/div[2]/div/p-card[1]/div/div/div/ntg-om--quote-details-travel-segment/div/div/div[2]/div/div[3]/div/div[3]/ntg-date-picker/div[2]/form/p-calendar/span/div/div/div/div[1]/div/button[1]"));
		System.out.println(calmonth.getText());
		WebElement calyear = Config.driver.findElement(By.xpath("//*[@id='ntg-om--container']/ntg-om-quick-quote-modal/div/ntg-om-quote-create-travel-path/div[2]/div/p-card[1]/div/div/div/ntg-om--quote-details-travel-segment/div/div/div[2]/div/div[3]/div/div[3]/ntg-date-picker/div[2]/form/p-calendar/span/div/div/div/div[1]/div/button[2]"));
		System.out.println(calyear.getText());
		
		if ((calmonth.getText().equals(month)) && (calyear.getText().equals(year))) {
			for (int i = 1; i <= 5; i++) {
				for (int j = 1; j <= 7; j++) {
					String date = Config.driver.findElement(By.xpath("//*[@id='ntg-om--container']/ntg-om-quick-quote-modal/div/ntg-om-quote-create-travel-path/div[2]/div/p-card[1]/div/div/div/ntg-om--quote-details-travel-segment/div/div/div[2]/div/div[3]/div/div[3]/ntg-date-picker/div[2]/form/p-calendar/span/div/div/div/div[2]/table/tbody/tr["+i+"]/td["+j+"]")).getAttribute("class");
					WebElement calDay=Config.driver.findElement(By.xpath("//*[@id='ntg-om--container']/ntg-om-quick-quote-modal/div/ntg-om-quote-create-travel-path/div[2]/div/p-card[1]/div/div/div/ntg-om--quote-details-travel-segment/div/div/div[2]/div/div[3]/div/div[3]/ntg-date-picker/div[2]/form/p-calendar/span/div/div/div/div[2]/table/tbody/tr["+i+"]/td["+j+"]"));
					System.out.println(calDay.getText());
					if ((!date.contains("other-month"))&& calDay.getText().equals(select_day)) {
						calDay.click();
						calDay.click();
						return;
					}
				}
			}
		} else if ((calyear.getText().equals(year)) && (!calmonth.getText().equals(month))) {
			for (int k = 1; k <= 12; k++) {
				WebElement searchmonth = Config.driver.findElement(By.xpath("//*[@id='ntg-om--container']/ntg-om-quick-quote-modal/div/ntg-om-quote-create-travel-path/div[2]/div/p-card[1]/div/div/div/ntg-om--quote-details-travel-segment/div/div/div[2]/div/div[3]/div/div[3]/ntg-date-picker/div[2]/form/p-calendar/span/div/div[2]/span["+k+"]"));
				if (searchmonth.getText().equals(month)) {
					searchmonth.click();
					for (int i = 1; i <= 5; i++) {
						for (int j = 1; j <= 7; j++) {
							String date1 = Config.driver.findElement(By.xpath("//*[@id='ntg-om--container']/ntg-om-quick-quote-modal/div/ntg-om-quote-create-travel-path/div[2]/div/p-card[1]/div/div/div/ntg-om--quote-details-travel-segment/div/div/div[2]/div/div[3]/div/div[3]/ntg-date-picker/div[2]/form/p-calendar/span/div/div/div/div[2]/table/tbody/tr["+i+"]/td["+j+"]")).getAttribute("class");
							WebElement calDay=Config.driver.findElement(By.xpath("//*[@id='ntg-om--container']/ntg-om-quick-quote-modal/div/ntg-om-quote-create-travel-path/div[2]/div/p-card[1]/div/div/div/ntg-om--quote-details-travel-segment/div/div/div[2]/div/div[3]/div/div[3]/ntg-date-picker/div[2]/form/p-calendar/span/div/div/div/div[2]/table/tbody/tr["+i+"]/td["+j+"]"));
							System.out.println(calDay.getText());
							if ((!date1.contains("other-month"))&& calDay.getText().equals(select_day)) {
								calDay.click();
								calDay.click();
								return;
							}
						}
					}

				}
			}
		} else {
			for (int l = 1; l <= 10; l++) {
				WebElement searchYear = Config.driver.findElement(By.xpath("//*[@id='ntg-om--container']/ntg-om-quick-quote-modal/div/ntg-om-quote-create-travel-path/div[2]/div/p-card[1]/div/div/div/ntg-om--quote-details-travel-segment/div/div/div[2]/div/div[3]/div/div[3]/ntg-date-picker/div[2]/form/p-calendar/span/div/div[2]/span["+l+"]"));
				if (searchYear.getText().equals(year)) {
					searchYear.click();
					for (int k = 1; k <= 12; k++) {
						WebElement searchmonth = Config.driver.findElement(By.xpath("//*[@id='ntg-om--container']/ntg-om-quick-quote-modal/div/ntg-om-quote-create-travel-path/div[2]/div/p-card[1]/div/div/div/ntg-om--quote-details-travel-segment/div/div/div[2]/div/div[3]/div/div[3]/ntg-date-picker/div[2]/form/p-calendar/span/div/div[2]/span["+k+"]"));
						if (searchmonth.getText().equals(month)) {
							searchmonth.click();
							for (int i = 1; i <= 5; i++) {
								for (int j = 1; j <= 5; j++) {
									String date = Config.driver.findElement(By.xpath("//*[@id='ntg-om--container']/ntg-om-quick-quote-modal/div/ntg-om-quote-create-travel-path/div[2]/div/p-card[1]/div/div/div/ntg-om--quote-details-travel-segment/div/div/div[2]/div/div[3]/div/div[3]/ntg-date-picker/div[2]/form/p-calendar/span/div/div/div/div[2]/table/tbody/tr["+i+"]/td["+j+"]")).getAttribute("class");
									WebElement calDay=Config.driver.findElement(By.xpath("//*[@id='ntg-om--container']/ntg-om-quick-quote-modal/div/ntg-om-quote-create-travel-path/div[2]/div/p-card[1]/div/div/div/ntg-om--quote-details-travel-segment/div/div/div[2]/div/div[3]/div/div[3]/ntg-date-picker/div[2]/form/p-calendar/span/div/div/div/div[2]/table/tbody/tr["+i+"]/td["+j+"]"));
									System.out.println(calDay.getText());
									if ((!date.contains("other-month"))&& calDay.getText().equals(select_day)) {
										calDay.click();
										calDay.click();
										return;
									}
								}
							}

						}
					}
				}
			}
		}
	}
	
	public static void selectDateinCalendar(String strDate) throws InterruptedException {
		String splitter[] = strDate.split("-");//12-17-2023
		String day = splitter[1];
		String actualYear = splitter[2];
		int iMonth = Integer.parseInt(splitter[0]);
		String displayedMonth=Config.driver.findElement(By.xpath("//*[@id='ntg-om--container']/ntg-om-quick-quote-modal/div/ntg-om-quote-create-travel-path/div[2]/div/p-card[1]/div/div/div/ntg-om--quote-details-travel-segment/div/div/div[2]/div/div[3]/div/div[3]/ntg-date-picker/div[2]/form/p-calendar/span/div/div/div/div[1]/div/button[1]")).getText();
		String displayedYear=Config.driver.findElement(By.xpath("//*[@id='ntg-om--container']/ntg-om-quick-quote-modal/div/ntg-om-quote-create-travel-path/div[2]/div/p-card[1]/div/div/div/ntg-om--quote-details-travel-segment/div/div/div[2]/div/div[3]/div/div[3]/ntg-date-picker/div[2]/form/p-calendar/span/div/div/div/div[1]/div/button[2]")).getText();
		String actualMonth = new DateFormatSymbols().getMonths()[iMonth-1];
		if(!(actualYear.equalsIgnoreCase(displayedYear) && actualMonth.equalsIgnoreCase(displayedMonth))) {
			Config.driver.findElement(By.xpath("//*[@id=\"ntg-om--container\"]/ntg-om-quick-quote-modal/div/ntg-om-quote-create-travel-path/div[2]/div/p-card[1]/div/div/div/ntg-om--quote-details-travel-segment/div/div/div[2]/div/div[3]/div/div[3]/ntg-date-picker/div[2]/form/p-calendar/span/div/div/div/div[1]/button[2]"));
        }
        else {
            System.out.println("Year and Month are already matching");
        }
        Config.element =(Config.driver).findElement(By.xpath("//div[contains(@class, 'ng-star-inserted')]//span[not(contains(@class, 'disabled')) and text()=" + day + "]"));
        Config.element.click();
        Thread.sleep(3000);
		

}
}