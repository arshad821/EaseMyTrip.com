package com.arshad.CommonStepDefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.arshad.CommonUtilities.commonutils;
import com.arshad.DriverManager.Webdriver_manager;
import com.arshad.PageObjectModel.Flight_ReviewPageSeats;
import com.arshad.PageObjectModel.Hotel_review_page;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;



public class commonstepdef {
	private static final Logger LOGGER = LogManager.getLogger(commonstepdef.class);


	@Before
	public void beforescenario() {
		LOGGER.info("Execution Started");
		try {
			LOGGER.info("Instantiating Common Utils");
			commonutils cmnutils = new commonutils();
			LOGGER.info("Loading Properties");
			cmnutils.getInstance().loadproperties();
			LOGGER.info("Checking driver is null or not");
			if (Webdriver_manager.getDriver() == null) {
	            Webdriver_manager.launchbrowser();
	            LOGGER.info("browser Launched ");
	             cmnutils.getInstance().initWebelements();
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@After("@bookticket or @HotelBooking")
	public static void takeScreenshot(Scenario scenario) throws IOException, InterruptedException {
	    JavascriptExecutor js = (JavascriptExecutor) Webdriver_manager.getDriver();
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // scroll to bottom of page
	    
	    //scenario.getSourceTagNames().contains("@bookticket") --> using this we can work for multiple tags which will be useful for project which has multiple scenarios.
	    if (scenario.getSourceTagNames().contains("@bookticket") && Flight_ReviewPageSeats.payment_text.isDisplayed()) {
	        byte[] screenshot = ((TakesScreenshot) Webdriver_manager.getDriver()).getScreenshotAs(OutputType.BYTES);
	        scenario.attach(screenshot, "image/png", "Flight Payment Screen");
	        System.out.println("Flight Payment Screen captured & added in report");
	    }
	    else if (scenario.getSourceTagNames().contains("@HotelBooking") && Hotel_review_page.payment_page_text.isDisplayed()) {
	        byte[] screenshot = ((TakesScreenshot) Webdriver_manager.getDriver()).getScreenshotAs(OutputType.BYTES);
	        scenario.attach(screenshot, "image/png", "Hotel Payment Screen");
	        System.out.println("Hotel Payment Screen captured & added in report");
	        
	    } 
	    else  {
	        byte[] screenshot = ((TakesScreenshot) Webdriver_manager.getDriver()).getScreenshotAs(OutputType.BYTES);
	        scenario.attach(screenshot, "image/png", "Scenario Failed Screenshot");
	        System.out.println("Scenario Failed");
	        Webdriver_manager.getDriver().quit();

	    }
	}

}
