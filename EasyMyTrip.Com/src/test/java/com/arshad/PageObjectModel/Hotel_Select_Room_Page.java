package com.arshad.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.arshad.DriverManager.Webdriver_manager;

public class Hotel_Select_Room_Page {

	static WebDriver driver=Webdriver_manager.getDriver();

	@FindBy(xpath ="(//a[@id='room'])[1]")
	private static WebElement Select_room_btn;


	public static void Select_room() throws InterruptedException {

		Select_room_btn.click();

		List<WebElement >	type_of_rooms=driver.findElements(By.xpath("(//h4[@ng-bind='rooms[0].roomType'])"));
		System.out.println("These are the type of rooms available in this hotel: ");
		for (WebElement room_name : type_of_rooms) {
			System.out.println(room_name.getText());
		}

		Thread.sleep(2000);
		List<WebElement> book_now_btns =	driver.findElements(By.xpath("(//a[@class='fill-btns bdrds20'])"));
		
		for (WebElement book_now_button : book_now_btns) {
			if(book_now_button.isDisplayed()) {
				book_now_button.click();
			}
			break;
		}
	}
}
