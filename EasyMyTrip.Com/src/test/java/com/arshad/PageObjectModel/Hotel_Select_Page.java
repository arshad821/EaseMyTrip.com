package com.arshad.PageObjectModel;

import java.sql.Time;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arshad.Constant.constants;
import com.arshad.DriverManager.Webdriver_manager;

import io.cucumber.java.PendingException;
import io.cucumber.java.Scenario;


public class Hotel_Select_Page {

	static WebDriver driver = Webdriver_manager.getDriver();

	@FindBy(id="drpHighList")
	public static WebElement popularity_dropdown;

	@FindBy(id="txtPrcMin")
	public static WebElement enter_min_price;

	@FindBy(id="txtPrcMax")
	public static WebElement enter_max_price;

	@FindBy(className = "srchgo")
	public static WebElement go_btn;

	@FindBy(className = "oop-txt")
	private static WebElement error_message;
	
	public static void error_meesage() throws InterruptedException {
		Thread.sleep(3000);
		if(error_message.isDisplayed()) {
			System.out.println("Date or Location Need to Modified; Modify the code and run again");
			driver.close();
		}
	}
	

	public static void select_popularity_dropdown() {

		Select select = new Select(popularity_dropdown);
		select.selectByVisibleText(constants.Popularity_dropdown);

	}
	
	

	public static void Select_star_rating() {

		String star_rating = constants.star_rating;

		driver.findElement(By.xpath("//span[text()='"+star_rating+" Star']")).click();
	}


	public static void Select_Amentities() throws InterruptedException {
		//ElementClickIntercepted Excpetion --> so using Explicit wait(not worked); so used JS executor also
		//explicit wait didn't worked so added some addional time using thread.sleep
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		if (!constants.amenity_1.isEmpty()) {
			
			WebElement amenity1=	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/label[text()[normalize-space() ='"+constants.amenity_1+"']]")));
			//amenity1.click();
		    executor.executeScript("arguments[0].click();", amenity1);

		} else {
			System.out.println("Skipping step because Amenity_1 value is empty");
		}

		if (!constants.amenity_2.isEmpty()) {
			Thread.sleep(2000);
			WebElement amenity2 =	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/label[text()[normalize-space() ='"+constants.amenity_2+"']]")));
			executor.executeScript("arguments[0].click();", amenity2);
			//amenity2.click();
		} else {
			System.out.println("Skipping step because Amenity_2 value is empty");
		}

		if (!constants.amenity_3.isEmpty()) {
			Thread.sleep(2000);
			WebElement amenity3 =	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/label[text()[normalize-space() ='"+constants.amenity_3+"']]")));
			executor.executeScript("arguments[0].click();", amenity3);
			//amenity3.click();
		} else {
			System.out.println("Skipping step because Amenity_3 value is empty");
		}

	}


	public static void Enter_Budget() {
		//not working properly problem in WebSite i guess
		enter_min_price.sendKeys(constants.min_budget);
		enter_max_price.sendKeys(constants.max_budget);
		go_btn.click();

	}

	public static void Select_Hotels() {

		List<WebElement> list_of_hotels	= driver.findElements(By.xpath("(//span[@ng-bind='_htl.prc-_htl.disc'])"));
		System.out.println("These are the list of hotels after filering: " + list_of_hotels.size());

		String filtered_hotel_price =	driver.findElement(By.xpath("(//span[@ng-bind='_htl.prc-_htl.disc'])[1]")).getText();
		System.out.println("This is the price of  hotel after filtering user is going to select: ₹" + filtered_hotel_price);

		List<WebElement> view_room_buttons=	driver.findElements(By.xpath("//div[text()=' View Room']"));
		for (WebElement view_room : view_room_buttons) {
			if(view_room.isDisplayed());{
				view_room.click();
			}
			break;
		}
		
	}


}
