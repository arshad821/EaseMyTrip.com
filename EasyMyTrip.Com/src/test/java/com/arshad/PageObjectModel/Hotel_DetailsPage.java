package com.arshad.PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arshad.Constant.constants;
import com.arshad.DriverManager.Webdriver_manager;

public class Hotel_DetailsPage {

	static WebDriver driver= Webdriver_manager.getDriver();
	@FindBy(className="hp_city")
	private static WebElement CityBox;

	@FindBy(id="txtCity")
	private static WebElement cityName;

	@FindBy(id = "htl_dates")
	private static WebElement CheckinDateBox;

	@FindBy(id ="htl_dates1")
	private static WebElement CheckoutDateBox;

	@FindBy(id="Adults_room_1_1_plus")
	private static WebElement adult_plus_btn1;

	@FindBy(id="Adults_room_2_2_plus")
	private static WebElement adult_plus_btn2;

	@FindBy(id="Adults_room_3_3_plus")
	private static WebElement adult_plus_btn3;

	@FindBy(id="Children_room_1_1_plus")
	private static WebElement child_plus_btn1;

	@FindBy(id="Children_room_2_2_plus")
	private static WebElement child_plus_btn2;

	@FindBy(id="Children_room_3_3_plus")
	private static WebElement child_plus_btn3;

	@FindBy(id="Child_Age_1_1")
	private static WebElement Child1_room1_age_dropdown;

	@FindBy(id="Child_Age_1_2")
	private static WebElement Child2_room1_age_dropdown;

	@FindBy(id="Child_Age_2_1")
	private static WebElement Child1_room2_age_dropdown;

	@FindBy(id="Child_Age_2_2")
	private static WebElement Child2_room2_age_dropdown;

	@FindBy(id="Child_Age_3_1")
	private static WebElement Child1_room3_age_dropdown;

	@FindBy(id="Child_Age_3_2")
	private static WebElement Child2_room3_age_dropdown;

	@FindBy(id="addhotelRoom")
	private static WebElement add_room_btn;

	@FindBy(id="exithotelroom")
	private static WebElement done_btn;

	@FindBy(id="btnSearch")
	private static WebElement search_btn;

	public static void entercity() throws InterruptedException {
		CityBox.click();
		cityName.sendKeys(constants.hotel_city);
		Thread.sleep(1000);
		cityName.sendKeys(Keys.ENTER);

	}

	public static void Check_in_date() {

		CheckinDateBox.click();


		String cin_date=constants.Check_in_date;
		String cin_month=constants.Check_in_month;

		while(true) {
			String month_text =	driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[1]")).getText();
			//System.out.println(month_text);
			if(month_text.equals(cin_month)) {
				break;
			}
			else {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
		}
		driver.findElement(By.xpath("//a[contains(text(),'"+cin_date+"')]")).click();
	}

	public static void Check_out_date() {

		//CheckoutDateBox.click();
		String cout_date=constants.Check_out_date;
		String cout_month=constants.Check_out_month;
		while(true) {
			String month_text =	driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[1]")).getText();

			if(month_text.equals(cout_month)) {
				break;
			}
			else {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
		}
		driver.findElement(By.xpath("//a[contains(text(),'"+cout_date+"')]")).click();

	}


	public static void search() throws InterruptedException {
		
		//System.out.println(done_btn.isEnabled()); for checking
		done_btn.click();
		Thread.sleep(2000);
		search_btn.click();
	}

	public static void No_of_Rooms(){
		String rooms=constants.No_of_rooms;           int No_of_rooms=Integer.parseInt(rooms);

		String adult1=constants.No_of_Adults_Room1;   int room1_adult=Integer.parseInt(adult1);
		String adult2=constants.No_of_Adults_Room2;   int room2_adult=Integer.parseInt(adult2);
		String adult3=constants.No_of_Adults_Room3;   int room3_adult=Integer.parseInt(adult3);

		String child1=constants.No_of_Childs_Room1;   int room1_child=Integer.parseInt(child1);    
		String child2=constants.No_of_Childs_Room2;   int room2_child=Integer.parseInt(child2);    
		String child3=constants.No_of_Childs_Room3;   int room3_child=Integer.parseInt(child3);

		String Child_1_age_r1= constants.room1_child1;  int r1_child1=Integer.parseInt(Child_1_age_r1);
		String Child_2_age_r1=constants.room1_child2;    int r1_child2=Integer.parseInt(Child_2_age_r1);

		String Child_1_age_r2=constants.room2_child1;     int r2_child1=Integer.parseInt(Child_1_age_r2);
		String Child_2_age_r2=constants.room2_child2;     int r2_child2=Integer.parseInt(Child_2_age_r2);

		String Child_1_age_r3=constants.room3_child1;    int r3_child1=Integer.parseInt(Child_1_age_r3);
		String Child_2_age_r3=constants.room3_child2;    int r3_child2=Integer.parseInt(Child_2_age_r3);

		int[] all_adults = {room1_adult,room2_adult,room3_adult};
		int[] all_childs= {room1_child,room2_child,room3_child};
		int[] all_child_age= {r1_child1,r1_child2,r2_child1,r2_child2,r3_child1,r3_child2};

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		if(No_of_rooms>3) {
			System.out.println("Only 3 rooms can be added! Please Modify it");
			driver.close();
		}
		for(int i = 1; i <= No_of_rooms; i++) {

			int room_adults=all_adults[i-1];//array index starts from 0
			int all_Childs=all_childs[i-1];

			for(int j = 1; j <= room_adults-2; j++) {
				WebElement adultPlusBtn = driver.findElement(By.xpath("//a[@id='Adults_room_"+i+"_"+i+"_plus']"));
				adultPlusBtn.click();
			}

			for(int k = 1; k <= all_Childs; k++) {
				WebElement childPlusBtn = driver.findElement(By.xpath("//a[@id='Children_room_"+i+"_"+i+"_plus']"));
				childPlusBtn.click();

				int child_age = all_child_age[((i - 1) * 2) + (k - 1)];
				//ElementNotInteractableException due to time issue so used ex. wait with condition
				WebElement childAgeDropdown	= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='Child_Age_"+i+"_"+k+"']")));
				//WebElement childAgeDropdown = driver.findElement(By.xpath("//select[@id='Child_Age_"+i+"_"+k+"']"));
				Select ageSelect = new Select(childAgeDropdown);
				ageSelect.selectByVisibleText(String.valueOf(child_age));

			}
			if(i != No_of_rooms) {
				add_room_btn.click();
			}
		}

	}
	//1.0*2 + 1-1 =0 -->0th indx   , 0*2 + 2-1=1 --> 1st indx
	//2.1*2 + 1-1 =2-->2nd  indx   , 1*2 + 2-1 =3 --> 3rd indx
	//3.2*2 + 1-1 =4 -->4th index , 2*2 + 1   =5 -->5th indx





















	//code written by me
	public static void room_guests() throws InterruptedException{

		String rooms=constants.No_of_rooms;           int No_of_rooms=Integer.parseInt(rooms);

		String adult1=constants.No_of_Adults_Room1;   int room1_adult=Integer.parseInt(adult1);
		String adult2=constants.No_of_Adults_Room2;   int room2_adult=Integer.parseInt(adult2);
		String adult3=constants.No_of_Adults_Room3;   int room3_adult=Integer.parseInt(adult3);


		String child1=constants.No_of_Childs_Room1;   int room1_child=Integer.parseInt(child1);    
		String child2=constants.No_of_Childs_Room2;   int room2_child=Integer.parseInt(child2);    
		String child3=constants.No_of_Childs_Room3;   int room3_child=Integer.parseInt(child3);

		if(No_of_rooms==1) {
			for(int a=0;  a<room1_adult-2; a++)
				adult_plus_btn1.click();
			for(int b=0; b<room1_child; b++)
				child_plus_btn1.click();
			if(room1_child==1) {
				Select select =new Select(Child1_room1_age_dropdown);
				select.selectByVisibleText(constants.room1_child1);
			}
			if(room1_child==2) {
				Select select =new Select(Child1_room1_age_dropdown);
				select.selectByVisibleText(constants.room1_child1);
				Select select2 =new Select(Child2_room1_age_dropdown);
				select2.selectByVisibleText(constants.room1_child2);
			}
		}
		else if(No_of_rooms==2) {
			for(int a=0;  a<room1_adult-2; a++)
				adult_plus_btn1.click();
			for(int b=0; b<room1_child; b++)
				child_plus_btn1.click();
			if(room1_child==1) {
				Select select =new Select(Child1_room1_age_dropdown);
				select.selectByVisibleText(constants.room1_child1);
			}
			if(room1_child==2) {
				Select select =new Select(Child1_room1_age_dropdown);
				select.selectByVisibleText(constants.room1_child1);
				Select select2 =new Select(Child2_room1_age_dropdown);
				select2.selectByVisibleText(constants.room1_child2);
			}
			add_room_btn.click();
			for(int a=0;  a<room2_adult-2; a++)
				adult_plus_btn2.click();
			for(int b=0; b<room2_child; b++)
				child_plus_btn2.click();
			if(room2_child==1) {
				Select select =new Select(Child1_room2_age_dropdown);
				select.selectByVisibleText(constants.room2_child1);
			}
			if(room2_child==2) {
				Select select =new Select(Child1_room2_age_dropdown);
				select.selectByVisibleText(constants.room2_child1);
				Select select2 =new Select(Child2_room2_age_dropdown);
				select2.selectByVisibleText(constants.room2_child2);
			}
		}
		else if(No_of_rooms==3)
		{
			for(int a=0;  a<room1_adult-2; a++)
				adult_plus_btn1.click();
			for(int b=0; b<room1_child; b++)
				child_plus_btn1.click();
			if(room1_child==1) {
				Select select =new Select(Child1_room1_age_dropdown);
				select.selectByVisibleText(constants.room1_child1);
			}
			if(room1_child==2) {
				Select select =new Select(Child1_room1_age_dropdown);
				select.selectByVisibleText(constants.room1_child1);
				Select select2 =new Select(Child2_room1_age_dropdown);
				select2.selectByVisibleText(constants.room1_child2);
			}
			add_room_btn.click();
			for(int a=0;  a<room2_adult-2; a++)
				adult_plus_btn2.click();
			for(int b=0; b<room2_child; b++)
				child_plus_btn2.click();
			if(room2_child==1) {
				Select select =new Select(Child1_room2_age_dropdown);
				select.selectByVisibleText(constants.room2_child1);
			}
			if(room2_child==2) {
				Select select =new Select(Child1_room2_age_dropdown);
				select.selectByVisibleText(constants.room2_child1);
				Select select2 =new Select(Child2_room2_age_dropdown);
				select2.selectByVisibleText(constants.room2_child2);
			}
			add_room_btn.click();
			for(int a=0;  a<room3_adult-2; a++)
				adult_plus_btn3.click();
			for(int b=0; b<room3_child; b++)
				child_plus_btn3.click();
			if(room3_child==1) {
				Select select =new Select(Child1_room3_age_dropdown);
				select.selectByVisibleText(constants.room3_child1);
			}
			if(room3_child==2) {
				Select select =new Select(Child1_room3_age_dropdown);
				select.selectByVisibleText(constants.room3_child1);
				Select select2 =new Select(Child2_room3_age_dropdown);
				select2.selectByVisibleText(constants.room3_child2);
			}
		}
		else
		{
			System.out.println("Only 3 rooms can be added! Please Modify it");
			driver.close();
		}
		Thread.sleep(2000);
		done_btn.click();
	}

}
