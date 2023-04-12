package com.arshad.PageObjectModel;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.arshad.Constant.constants;
import com.arshad.DriverManager.Webdriver_manager;


public class Flight_HomePage {

	private static final Logger LOGGER=LogManager.getLogger(Flight_HomePage.class);

	@FindBy(id="FromSector_show")
	private static WebElement FROM;

	@FindBy(id="a_FromSector_show") 
	private static WebElement FROMInput;

	@FindBy(id="tocity")
	private static WebElement TO;

	@FindBy(id="a_Editbox13_show")
	private static WebElement TOINPUT;


	@FindBy(id="ddate") 
	private static WebElement DATEBOX;


	@FindBy(id="iDownArr")
	private static WebElement DOWNARROW;

	@FindBy(xpath="//div[@id='field1']//button[@id='add']")
	private static WebElement ADDPASSENGER_ADULTS;

	@FindBy(xpath = "//div[@id='field2']//button[@id='add']")
	private static WebElement ADDPASSENGERS_CHILDREN;

	@FindBy(xpath = "//a[@id='traveLer']")
	private static WebElement DONE_BTN;
	@FindBy(className="srchBtnSe") 
	private static WebElement SearchButton;

	@FindBy(xpath="//a[contains(text(),'Hotels')]")
	private static WebElement Hotelbtn;

	@FindBy(xpath="//a[contains(text(),'Flights')]")
	private static WebElement Flightbtn;

	static WebDriver driver =	Webdriver_manager.getDriver() ;

	public static void FlightOption() {
		Flightbtn.click();
	}

	public static void HotelOption() {
		Hotelbtn.click();
	}


	public static void fromlocation() throws InterruptedException {


		FROM.click();
		Thread.sleep(1000);
		FROMInput.sendKeys(constants.FROM_CITY+Keys.ENTER);
		LOGGER.info("user has given the FROM location");
	}


	public static void tolocation() throws InterruptedException {
		TO.click();
		Thread.sleep(1000);
		TOINPUT.sendKeys(constants.TO_CITY+Keys.ENTER);
		LOGGER.info("user has given the TO Location");
	}



	public static void departure_date(){

		DATEBOX.click();

		String expected_month=constants.DEPARTURE_MONTH;
		String expected_date = constants.DEPARTURE_DATE;


		while (true) {
			String text =	driver.findElement(By.xpath("//div[@class='month2']")).getText();
			//System.out.println(text); //for checking
			if(text.equals(expected_month)) {
				break;
			}
			else {
				driver.findElement(By.id("img2Nex")).click();
			}
		}
		driver.findElement(By.xpath("//li[contains(text(),'"+expected_date+"')]")).click();
		LOGGER.info("User has given the DEPARTURE DATE");
	}


	public static void travelDetails() {

		String passengers_adult=constants.ADULT_PASENGERS;
		int i =	Integer.parseInt(passengers_adult);
		String passengers_child=constants.CHILD_PASSENGERS;
		int j =	Integer.parseInt(passengers_child);


		DOWNARROW.click();

		for(int a=0 ; a <i-1 ; a++) //by default one adult added so
			ADDPASSENGER_ADULTS.click();
		for(int b=0 ; b<j ; b++)	
			ADDPASSENGERS_CHILDREN.click();
		LOGGER.info("user has added the passengers");

	}


	public static void classdetails() throws InterruptedException {

		String class_details = constants.CLASS_DETAILS;
		driver.findElement(By.xpath("//label[contains(text(),' "+class_details+"')]")).click();
		Thread.sleep(2000);
		DONE_BTN.click();
		LOGGER.info("user has added the class details and search button pressed");

	}

	public static void searchbtn(){
		SearchButton.click();
	}
}
