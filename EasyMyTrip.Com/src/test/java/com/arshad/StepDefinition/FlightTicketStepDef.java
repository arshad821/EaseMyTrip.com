package com.arshad.StepDefinition;

import java.nio.channels.SelectableChannel;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.arshad.Constant.constants;
import com.arshad.DriverManager.Webdriver_manager;
import com.arshad.PageObjectModel.Flight_HomePage;
import com.arshad.PageObjectModel.Flight_ReviewPage;
import com.arshad.PageObjectModel.Flight_ReviewPageSeats;
import com.arshad.PageObjectModel.Flight_SelectFlightPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;



public class FlightTicketStepDef {
	WebDriver driver = Webdriver_manager.getDriver();
	private static final Logger LOGGER = LogManager.getLogger(FlightTicketStepDef.class);
	//static ExtentReports extent = new ExtentReports();

	@When("^user can navigate to easymytrip.com in browser$")
	public void user_can_navigate_to_easymytrip_com_in_browser() throws Throwable {

		try {
			
			driver.manage().window().maximize();
			driver.get(constants.APP_URL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Flight_HomePage.FlightOption();
			LOGGER.info("user navigated to website and window is maximized");
			

		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	@Given("^user select from and to airport$")
	public void user_select_from_and_to_airport() throws Throwable {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			Flight_HomePage.fromlocation();
			Flight_HomePage.tolocation();
			

			Flight_HomePage.departure_date();
			//testcase1.info("These are the Total No.of Flights available before filtering: ");
			Thread.sleep(1000);


		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Given("^user can select no.of passenegers and select class$")
	public void user_can_select_no_of_passenegers_and_select_class() throws Throwable {
		try {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Flight_HomePage.travelDetails();
			Thread.sleep(2000);
			Flight_HomePage.classdetails();
			Thread.sleep(1000);
			Flight_HomePage.searchbtn();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Given("^User checks filter options and select desired flight and select booknow$")
	public void user_checks_filter_options_and_select_desired_flight_and_select_booknow() throws Throwable {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Flight_SelectFlightPage.error_screen();
			if(Flight_SelectFlightPage.BOOKNOW.isDisplayed()) {
				LOGGER.info("User is on Select Flight Page");
			}
			Flight_SelectFlightPage.selectflights();
			Thread.sleep(1000);
			Flight_SelectFlightPage.applyfilters();
			Thread.sleep(1000);
			Flight_SelectFlightPage.error_filters();
			//SelectFlightPage.price_range();           slider not working properly
			Thread.sleep(1000);
			Flight_SelectFlightPage.booknow();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


	}

	@Given("^user must fill passenger details$")
	public void user_must_fill_passenger_details() throws Throwable {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			if(Flight_ReviewPage.email_textbox.isDisplayed()) {
				LOGGER.info("User is on Review Page");
			}
			Flight_ReviewPage.insurance();
			Thread.sleep(1000);
			Flight_ReviewPage.entering_email();
			Flight_ReviewPage.entering_phone_num();
			Flight_ReviewPage.add_passesngers_adult_and_child();
			Flight_ReviewPage.enter_adultpassengers();

			Flight_ReviewPage.enter_child_passengers();
			Thread.sleep(3000);

		} catch (Exception e) //just to remove unwanted text on console 
		{
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Given("^user may selects desired seats and click Continue Booking$")
	public void user_may_selects_desired_seats_and_click_Continue_Booking() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		if(Flight_ReviewPageSeats.skip_to_payment_btn.isDisplayed()) {
			LOGGER.info("User is on Seat Selection Page");
		}
		if(constants.Seat_selection.equalsIgnoreCase("no")) {
			Flight_ReviewPageSeats.SkipToPayment();
			LOGGER.info("User has ignored seat selection and selected payment option");
			Thread.sleep(5000);
		}
		else if(constants.Seat_selection.equalsIgnoreCase("yes")){
			Flight_ReviewPageSeats.passenger_selectseats();
			Flight_ReviewPageSeats.Child_selectseats();
			try {
				Flight_ReviewPageSeats.continue_book4();
				Thread.sleep(3000);
			} catch (Exception ignore) {
				// TODO: handle exception
			}
			LOGGER.info("User has selected the desired seats selected payment option");
		}
	}

	@Then("^user should see the payment page now$")
	public void user_should_see_the_payment_page_now() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		if(Flight_ReviewPageSeats.payment_text.isDisplayed()) {

			LOGGER.info("User is on Payment Screen, captured and added to report");
			System.out.println("Payment screen has been displayed and captured!!");
		}

	}

}
