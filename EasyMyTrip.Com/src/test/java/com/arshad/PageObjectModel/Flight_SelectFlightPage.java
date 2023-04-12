package com.arshad.PageObjectModel;

import java.io.Console;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arshad.Constant.constants;
import com.arshad.DriverManager.Webdriver_manager;
import com.arshad.StepDefinition.FlightTicketStepDef;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Flight_SelectFlightPage {

	static WebDriver driver = Webdriver_manager.getDriver();
	private static final Logger LOGGER = LogManager.getLogger(Flight_SelectFlightPage.class);

	@FindBy(id="pAirAsia")
	public static WebElement SELECTAIRASIA;

	@FindBy(id="pSpiceJet")
	public static WebElement SELECTSPICEJET;

	@FindBy(id="pIndigo")
	public static WebElement SELECTINDIGO;

	@FindBy(xpath="(//button[text()='Book Now'])")
	public static WebElement BOOKNOW;

	@FindBy(xpath = "//p[@class='fl-head']")
	public static WebElement eror_lotof_filters;

	@FindBy(id="OopMsg")
	public static WebElement error_screen;


	public static void applyfilters() {

		try {
			String  filter = constants.FILTER;
			driver.findElement(By.xpath("//label[normalize-space()='"+filter+"']")).click();
			LOGGER.info("User selected "+filter+" filter option");
		} catch (Exception e) {
			System.out.println("No Filter Options like Non_stop/Deprature has been selected so continuing to select flights");
			LOGGER.info("User has selected No Filter like Non_stop/Departure");
		}


	}

	public static void selectflights() {

		WebDriverWait explicitwait = new WebDriverWait(driver, Duration.ofSeconds(20));

		List<WebElement> flight_checkboxes =  driver.
				findElements(By.xpath("//div[@class='prc_val airl1-sec2']//input[@ng-bind='GetAirLineName(id)']"));
		//System.out.println(flight_checkboxes.size());//for checking only
		explicitwait.until(ExpectedConditions.visibilityOf(BOOKNOW));

		for (WebElement flight_chek_box : flight_checkboxes) {


			String flight_checkbox_name= flight_chek_box.getAttribute("id");

			String f1 =constants.FILTER_FLIGHT1;      String f2 = constants.FILTER_FLIGHT2;
			String f3 = constants.FILTER_FLIGHT3;   String f4 = constants.FILTER_FLIGHT4;  
			String f5 = constants.FILTER_FLIGHT5;    String f6 = constants.FILTER_FLIGHT6;
			String f7 = constants.FILTER_FLIGHT7;   String f8 = constants.FILTER_FLIGHT8;

			if(flight_checkbox_name.equalsIgnoreCase(f1)        || flight_checkbox_name.equalsIgnoreCase(f2)
					||	flight_checkbox_name.equalsIgnoreCase(f3) ||  flight_checkbox_name.equalsIgnoreCase(f4) 
					||  flight_checkbox_name.equalsIgnoreCase(f5)   ||  flight_checkbox_name.equalsIgnoreCase(f6)
					|| flight_checkbox_name.equalsIgnoreCase(f7)   ||   flight_checkbox_name.equalsIgnoreCase(f8) ) {

				flight_chek_box.click();

				LOGGER.info("Desired Flight company has been selected");

			}
		}
	}

	public static void error_filters() {
		if(eror_lotof_filters.isDisplayed()) {
			System.out.println("Ooops! More Filters has been selected and Try Filtering and run again");
			LOGGER.info("Due to more filters, Error screen displayed and Website is closed");
			driver.close();
		}
	}
	public static void error_screen() {

		if (error_screen.isDisplayed()) {
			//System.out.println("HOO");
			System.out.println("Ooops! Try Changing the date & class and run again"); 
			LOGGER.info("Due to wrong date and class, Error screen displayed and Website is closed");
			driver.close();
		}
	}

	public static void price_range() {

		WebElement slide=driver.findElement(By.xpath(
				"//*[@id='slider-range']/span[2]"));    //Location->(43, 408)  size->(17, 17)
		System.out.println(slide.getLocation());
		System.out.println(slide.getSize());
		Actions action = new Actions(Webdriver_manager.getDriver());
		action.dragAndDropBy(slide, 100, 0).perform();
		System.out.println(slide.getLocation());
		System.out.println(slide.getSize());
	}

	public static void booknow() {


		try {
			List<WebElement> book_now_btns =	driver.findElements(By.xpath("(//button[text()='Book Now'])"));
			System.out.println("These are the Total No.of Flights available before filtering: "+ book_now_btns.size());
			LOGGER.info("Total Number of Flights before filtering: "+book_now_btns.size());
			List<WebElement> prices_flights = driver.findElements(By.xpath("//div[@class='col-md-8 col-sm-8 col-xs-9 txt-r6-n ng-binding']"));

			for (WebElement cheap_flight : prices_flights) {
				if(cheap_flight.isDisplayed()) {

					System.out.println("This is the Cheapest Flight for " +constants.ADULT_PASENGERS + " adults & " +constants.CHILD_PASSENGERS+ "children, after filtering for this Route :"+ cheap_flight.getText());

					break;
				}

			}

			for (WebElement book_now_button : book_now_btns) {
				//bcoz booknow button button is hdden when we apply filter so i have used if class
				//due to stale element using try catch

				if(book_now_button.isDisplayed() ) {
					book_now_button.click(); //clicking first booknow button since it is cheaper
					LOGGER.info("Cheapest Flight for this route has been select and booknow is clicked");
				}
			}
		}
		catch(Exception ignore){
			//e.printStackTrace(); //stale element exception thrown and printing some exception so ignored but code wooking well
		}
	}

}

