package com.arshad.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.arshad.Constant.constants;
import com.arshad.DriverManager.Webdriver_manager;
import com.aventstack.extentreports.ExtentTest;

public class Flight_ReviewPageSeats {

	static WebDriver driver = Webdriver_manager.getDriver();

	@FindBy(xpath="(//span[@class='co1'])[2]")
	private static WebElement continue_btn4;

	@FindBy(id="divAnciSeat")
	private static WebElement seat_page;

	@FindBy(xpath="//span[text()='Payment Mode']")
	public static WebElement payment_text;

	@FindBy(id="skipPop")
	public static WebElement skip_to_payment_btn;

	public static void passenger_selectseats() {

		int	a=Integer.parseInt(constants.ADULT_PASENGERS);
		try {
			if(seat_page.isDisplayed()) {
				for(int k=0 ; k<a ; k++) {
					if(k==0) {
						WebElement seat=	driver.findElement(By.xpath("//label[@for='"+constants.passenger1_seats+"']"));
						if(seat.getAttribute("ng-class").equalsIgnoreCase("no-seat")) {
							System.out.println("This seat already Booked! Kindly Modify the Input(seat) & run again");

							Webdriver_manager.getDriver().close();
						}
						else {
							seat.click();
						}
					}
					if(k==1) {
						WebElement seat=	driver.findElement(By.xpath("//label[@for='"+constants.passenger2_seats+"']"));
						if(seat.getAttribute("ng-class").equalsIgnoreCase("no-seat")) {
							System.out.println("This seat already Booked! Kindly Modify the Input(seat) & run again");
							Webdriver_manager.getDriver().close();
						}
						else {
							seat.click();
						}
					}
					if(k==2) {
						WebElement seat=	driver.findElement(By.xpath("//label[@for='"+constants.passenger3_seats+"']"));
						if(seat.getAttribute("ng-class").equalsIgnoreCase("no-seat")) {
							System.out.println("This seat already Booked! Kindly Modify the Input(seat) & run again");
							Webdriver_manager.getDriver().close();
						}
						else {
							seat.click();
						}
					}
					if(k==3) {
						WebElement seat=	driver.findElement(By.xpath("//label[@for='"+constants.passenger4_seats+"']"));
						if(seat.getAttribute("ng-class").equalsIgnoreCase("no-seat")) {
							System.out.println("This seat already Booked! Kindly Modify the Input(seat) & run again");
							Webdriver_manager.getDriver().close();
						}
						else {
							seat.click();
						}
					}
					if(k==4) {
						WebElement seat=	driver.findElement(By.xpath("//label[@for='"+constants.passenger5_seats+"']"));
						if(seat.getAttribute("ng-class").equalsIgnoreCase("no-seat")) {
							System.out.println("This seat already Booked! Kindly Modify the Input(seat) & run again");
							Webdriver_manager.getDriver().close();
						}
						else {
							seat.click();
						}
					}
					if(k==5) {
						WebElement seat=	driver.findElement(By.xpath("//label[@for='"+constants.passenger6_seats+"']"));
						if(seat.getAttribute("ng-class").equalsIgnoreCase("no-seat")) {
							System.out.println("This seat already Booked! Kindly Modify the Input(seat) & run again");
							Webdriver_manager.getDriver().close();
						}
						else {
							seat.click();
						}
					}
					if(k==6) {
						WebElement seat=	driver.findElement(By.xpath("//label[@for='"+constants.passenger7_seats+"']"));
						if(seat.getAttribute("ng-class").equalsIgnoreCase("no-seat")) {
							System.out.println("This seat already Booked! Kindly Modify the Input(seat) & run again");
							Webdriver_manager.getDriver().close();
						}
						else {
							seat.click();
						}
					}
					if(k==7) {
						WebElement seat=	driver.findElement(By.xpath("//label[@for='"+constants.passenger8_seats+"']"));
						if(seat.getAttribute("ng-class").equalsIgnoreCase("no-seat")) {
							System.out.println("This seat already Booked! Kindly Modify the Input(seat) & run again");
							Webdriver_manager.getDriver().close();
						}
						else {
							seat.click();
						}
					}
					if(k==8) {
						WebElement seat=	driver.findElement(By.xpath("//label[@for='"+constants.passenger9_seats+"']"));
						if(seat.getAttribute("ng-class").equalsIgnoreCase("no-seat")) {
							System.out.println("This seat already Booked! Kindly Modify the Input(seat) & run again");
							Webdriver_manager.getDriver().close();
						}
						else {
							seat.click();
						}
					}
				}}
		} catch (NoSuchElementException e) {
			System.out.println("For This Flight entered seats is not there kindly modify");
		}



	}
	public static void Child_selectseats() {
		int b = Integer.parseInt(constants.CHILD_PASSENGERS);
		try {
			if(seat_page.isDisplayed()) {
				for(int k=0 ; k<b ; k++) {
					if(k==0) {
						WebElement seat=	driver.findElement(By.xpath("//label[@for='"+constants.child_pasenger1_seats+"']"));
						if(seat.getAttribute("ng-class").equalsIgnoreCase("no-seat")) {
							System.out.println("This seat already Booked! Kindly Modify the Input(seat) & run again");

							Webdriver_manager.getDriver().close();
						}
						else {
							seat.click();
						}
					}
					if(k==1) {
						WebElement seat=	driver.findElement(By.xpath("//label[@for='"+constants.child_pasenger2_seats+"']"));
						if(seat.getAttribute("ng-class").equalsIgnoreCase("no-seat")) {
							System.out.println("This seat already Booked! Kindly Modify the Input(seat) & run again");
							Webdriver_manager.getDriver().close();
						}
						else {
							seat.click();
						}
					}
					if(k==2) {
						WebElement seat=	driver.findElement(By.xpath("//label[@for='"+constants.child_pasenger3_seats+"']"));
						if(seat.getAttribute("ng-class").equalsIgnoreCase("no-seat")) {
							System.out.println("This seat already Booked! Kindly Modify the Input(seat) & run again");
							Webdriver_manager.getDriver().close();
						}
						else {
							seat.click();
						}
					}
					if(k==3) {
						WebElement seat=	driver.findElement(By.xpath("//label[@for='"+constants.child_pasenger4_seats+"']"));
						if(seat.getAttribute("ng-class").equalsIgnoreCase("no-seat")) {
							System.out.println("This seat already Booked! Kindly Modify the Input(seat) & run again");
							Webdriver_manager.getDriver().close();
						}
						else {
							seat.click();
						}
					}
				}}	
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("For This Flight entered seats is not there kindly modify");
		}


	}

	public static void continue_book4() throws InterruptedException {
		
		if(constants.CLASS_DETAILS.equalsIgnoreCase("economy"))
		{
		continue_btn4.click();
		Thread.sleep(1000);
		continue_btn4.click();
		Thread.sleep(1000);
		continue_btn4.click();
		}
		else  {
			continue_btn4.click();
			Thread.sleep(1000);
			continue_btn4.click();
			Thread.sleep(1000);
		}
	}
	
	public static void SkipToPayment() {
		skip_to_payment_btn.click();
	}



}
