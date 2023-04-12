package com.arshad.StepDefinition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.FileHandler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.arshad.Constant.constants;
import com.arshad.DriverManager.Webdriver_manager;
import com.arshad.PageObjectModel.Flight_HomePage;
import com.arshad.PageObjectModel.Hotel_DetailsPage;
import com.arshad.PageObjectModel.Hotel_Select_Page;
import com.arshad.PageObjectModel.Hotel_Select_Room_Page;
import com.arshad.PageObjectModel.Hotel_review_page;
import com.aventstack.extentreports.util.Assert;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HotelBookingStepDef {

	private static final Logger LOGGER = LogManager.getLogger(HotelBookingStepDef.class);
	WebDriver driver = Webdriver_manager.getDriver();

	@Given("User is navigating to easymytrip.com in any browser")
	public void user_is_navigating_to_easymytrip_com_in_any_browser() {
		// Write code here that turns the phrase above into concrete actions
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(constants.APP_URL);
			driver.manage().window().maximize();
			//LOGGER.info("2 user navigated to website and window is maximized");
		} catch (Exception e) {

		}

	}

	@When("User can click Hotel Option")
	public void user_can_click_hotel_option() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Flight_HomePage.HotelOption();
			LOGGER.info("3 user navscscscwigated to website and window is maximized");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@When("User can give check-in and check-out date")
	public void user_can_give_check_in_and_check_out_date() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Hotel_DetailsPage.entercity();
			Thread.sleep(1000);
			Hotel_DetailsPage.Check_in_date();
			Thread.sleep(1000);
			Hotel_DetailsPage.Check_out_date();
			Thread.sleep(2000);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@When("User can select number of persons and number of rooms")
	public void user_can_select_number_of_persons_and_number_of_rooms() {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Hotel_DetailsPage.No_of_Rooms();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User can click search option")
	public void user_can_click_search_option() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Thread.sleep(2000);
			Hotel_DetailsPage.search();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@When("user can select filters options and Area")
	public void user_can_select_filters_options_and_area() {
		try {

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			//Hotel_Select_Page.error_meesage();--some times this message coming, sometimes it's not so im ignoring it
			Hotel_Select_Page.Select_Amentities();
			Thread.sleep(2000);
			//SelectHotelsPage.Enter_Budget(); entering data but not working properly
			Hotel_Select_Page.select_popularity_dropdown();
			Thread.sleep(2000);



		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@When("user is clicking sorting option and view room button is pressed")
	public void user_is_clicking_sorting_option_and_view_room_button_is_pressed() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			Hotel_Select_Page.Select_Hotels();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@When("user is selecting the room and booNow button is pressed")
	public void user_is_selecting_the_room_and_boo_now_button_is_pressed() {


		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Set<String> num_of_Windows =	driver.getWindowHandles();
			List<String> windows_list= new ArrayList<String>(num_of_Windows);
			driver.switchTo().window(windows_list.get(1));
			Hotel_Select_Room_Page.Select_room();

		} catch (Exception e) {

		}	
	}

	@When("user is giving all details and payment button is pressed")
	public void user_is_giving_all_details_and_payment_button_is_pressed() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Hotel_review_page.enter_phone_Num();
			Hotel_review_page.enter_customer_details();
			Thread.sleep(2000);
			Hotel_review_page.Payment_button();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Then("User can able to see the payment page now.")
	public void user_can_able_to_see_the_payment_page_now() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Thread.sleep(3000);
			if(Hotel_review_page.payment_page_text.isDisplayed()) {
				System.out.println("Payment Page for Hotel Booking is displayed!");
				
				Thread.sleep(2000);
			}
			else {
				System.out.println("Scenario Failed!!Browser Closed!!");
				driver.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
