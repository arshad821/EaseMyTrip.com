package com.arshad.PageObjectModel;

import org.hamcrest.Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.arshad.Constant.constants;
import com.arshad.DriverManager.Webdriver_manager;
public class Hotel_review_page {

	static WebDriver driver = Webdriver_manager.getDriver();

	@FindBy(id="txtEmailId")
	private static WebElement email_id_box;

	@FindBy(id="txtCPhone")
	private static WebElement phone_text_box;

	@FindBy(xpath="(//input[@id='txtFirstName1'])[1]")
	private static WebElement adult_fname_R1;

	@FindBy(xpath="(//input[@id='txtLastName1'])[1]")
	private static WebElement adult_lname_R1;

	@FindBy(xpath="(//input[@id='txtFirstName1'])[2]")
	private static WebElement adult_fname_R2;

	@FindBy(xpath="(//input[@id='txtLastName1'])[2]")
	private static WebElement adult_lname_R2;

	@FindBy(xpath="(//input[@id='txtFirstName1'])[3]")
	private static WebElement adult_fname_R3;

	@FindBy(xpath="(//input[@id='txtLastName1'])[3]")
	private static WebElement adult_lname_R3;

	@FindBy(xpath="(//select[@id='ddlGender1'])[1]")
	private static WebElement dropdown_adult_r1;

	@FindBy(xpath="(//select[@id='ddlGender1'])[2]")
	private static WebElement dropdown_adult_r2;

	@FindBy(xpath="(//select[@id='ddlGender1'])[3]")
	private static WebElement dropdown_adult_r3;
	
	@FindBy(className="coonpayment")
	private static WebElement payment_butn;

	@FindBy(xpath="//div[@class='entr-crd-mn']")
	public static WebElement payment_page_text;

	public static void enter_phone_Num() throws InterruptedException {
		email_id_box.sendKeys(constants.EMAIL_ID);
		Thread.sleep(1000);
		phone_text_box.sendKeys(constants.PHONE_NUM);
	}

	//below 3 methods are only to use in this same class
	//if possible in future i will try to iterate this methods that's why i havent used @findBy ; bcoz need to use dynamic xpath!
	public static void room1_details() {

		String child1=constants.No_of_Childs_Room1;   int room1_child=Integer.parseInt(child1);   

		Select select = new Select(dropdown_adult_r1);
		select.selectByVisibleText(constants.title_adult_r1);
		adult_fname_R1.sendKeys(constants.F_name_Adult_Room1);
		adult_lname_R1.sendKeys(constants.L_name_Adult_Room1);
		if(room1_child==1) {
			driver.findElement(By.xpath("(//input[@id='txtFirstNameChild1'])[1]")).sendKeys(constants.F_name_Child1_Room1);
			driver.findElement(By.xpath("(//input[@id='txtLastNameChild1'])[1]")).sendKeys(constants.L_name_Child1_Room1);
		}
		if(room1_child==2) {
			driver.findElement(By.xpath("(//input[@id='txtFirstNameChild1'])[1]")).sendKeys(constants.F_name_Child1_Room1);
			driver.findElement(By.xpath("(//input[@id='txtLastNameChild1'])[1]")).sendKeys(constants.L_name_Child1_Room1);
			driver.findElement(By.xpath("(//input[@id='txtFirstNameChild2'])[1]")).sendKeys(constants.F_name_Child2_Room1);
			driver.findElement(By.xpath("(//input[@id='txtLastNameChild2'])[1]")).sendKeys(constants.L_name_Child2_Room1);
		}

	}

	public static void room2_details() {

		String child2=constants.No_of_Childs_Room2;   int room2_child=Integer.parseInt(child2);

		Select selecct = new Select(dropdown_adult_r2);
		selecct.selectByVisibleText(constants.title_adult_r2);
		adult_fname_R2.sendKeys(constants.F_name_Adult_Room2);
		adult_lname_R2.sendKeys(constants.L_name_Adult_Room2);
		if(room2_child==1) {
			driver.findElement(By.xpath("(//input[@id='txtFirstNameChild1'])[2]")).sendKeys(constants.F_name_Child1_Room2);
			driver.findElement(By.xpath("(//input[@id='txtLastNameChild1'])[2]")).sendKeys(constants.L_name_Child1_Room2);
		}
		if(room2_child==2) {
			driver.findElement(By.xpath("(//input[@id='txtFirstNameChild1'])[2]")).sendKeys(constants.F_name_Child1_Room2);
			driver.findElement(By.xpath("(//input[@id='txtLastNameChild1'])[2]")).sendKeys(constants.L_name_Child1_Room2);
			driver.findElement(By.xpath("(//input[@id='txtFirstNameChild2'])[2]")).sendKeys(constants.F_name_Child2_Room2);
			driver.findElement(By.xpath("(//input[@id='txtLastNameChild2'])[2]")).sendKeys(constants.L_name_Child2_Room2);
		}
	}

	public static void room3_details() {
		String child3=constants.No_of_Childs_Room3;   int room3_child=Integer.parseInt(child3);

		Select selecctt = new Select(dropdown_adult_r3);
		selecctt.selectByVisibleText(constants.title_adult_r3);
		adult_fname_R3.sendKeys(constants.F_name_Adult_Room3);
		adult_lname_R3.sendKeys(constants.L_name_Adult_Room3);
		if(room3_child==1) {
			driver.findElement(By.xpath("(//input[@id='txtFirstNameChild1'])[3]")).sendKeys(constants.F_name_Child1_Room3);
			driver.findElement(By.xpath("(//input[@id='txtLastNameChild1'])[3]")).sendKeys(constants.L_name_Child1_Room3);
		}
		if(room3_child==2) {
			driver.findElement(By.xpath("(//input[@id='txtFirstNameChild1'])[3]")).sendKeys(constants.F_name_Child1_Room3);
			driver.findElement(By.xpath("(//input[@id='txtLastNameChild1'])[3]")).sendKeys(constants.L_name_Child1_Room3);
			driver.findElement(By.xpath("(//input[@id='txtFirstNameChild2'])[3]")).sendKeys(constants.F_name_Child2_Room3);
			driver.findElement(By.xpath("(//input[@id='txtLastNameChild2'])[3]")).sendKeys(constants.L_name_Child2_Room3);
		}
	}

	//not made changes for child dropdown since it's same procedure.
	//calling the above 3 methods in this method..
	public static void  enter_customer_details() {
		String room = constants.No_of_rooms;       int No_of_room = 	Integer.parseInt(room);

		if(No_of_room==1) {
			room1_details();
		}
		else if(No_of_room==2) {
			room1_details();
			room2_details();
		}

		else if (No_of_room==3) {
			room1_details();
			room2_details();
			room3_details();	
		}
	}
	
	public static void Payment_button() {
		payment_butn.click();
	}

}
