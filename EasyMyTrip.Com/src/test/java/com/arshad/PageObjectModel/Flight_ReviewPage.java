package com.arshad.PageObjectModel;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arshad.Constant.constants;
import com.arshad.DriverManager.Webdriver_manager;

public class Flight_ReviewPage {

	static WebDriver driver = Webdriver_manager.getDriver();
	private static final Logger LOGGER = LogManager.getLogger(Flight_ReviewPage.class);

	@FindBy(id="txtEmailId")
	public static WebElement email_textbox;

	@FindBy(xpath="(//div[@class='con']//span)[1]")
	public static WebElement continue_boooking_button1;

	@FindBy(xpath="(//div[@class='con1']//span)[2]")
	public static WebElement continue_booking_btn2;

	@FindBy(id="txtCPhone")
	public static WebElement phone_num_textbox;

	@FindBy(linkText="+ Add Adult")
	public static WebElement add_adult;

	@FindBy(linkText="+Add Child")
	public static WebElement add_child;


	public static void insurance() throws InterruptedException {


		JavascriptExecutor js = (JavascriptExecutor) driver; 
		WebDriverWait explicitwait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitwait.until(ExpectedConditions.visibilityOf(email_textbox));

		WebElement yes_insurance =	driver.findElement(By.xpath("(//input[@name='rdoInsuNew']/following-sibling::span)[1]"));
		WebElement no_insurance =	driver.findElement(By.xpath("(//input[@name='rdoInsuNew']/following-sibling::span)[2]"));
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)","" );//scroll to bttom of page
		Thread.sleep(1000);
		String insurance=constants.INSURANCE;
		if(insurance.equals("yes")) {
			yes_insurance.click();
			LOGGER.info("user has selected insurance option");
		}
		else {
			no_insurance.click();
			LOGGER.info("user has not selected insurance option");
		}
	} 


	public static void entering_email() throws InterruptedException {


		email_textbox.sendKeys(constants.EMAIL_ID);
		Thread.sleep(1000);
		continue_boooking_button1.click();
		LOGGER.info("Email ID has been entered");

	}


	public static void entering_phone_num() throws InterruptedException {


		phone_num_textbox.sendKeys(constants.PHONE_NUM);
		Thread.sleep(1000);
		LOGGER.info("Phone Number has been entered");

	} 





	public static void add_passesngers_adult_and_child() {

		int a=Integer.parseInt(constants.ADULT_PASENGERS);
		int b = Integer.parseInt(constants.CHILD_PASSENGERS);

		for(int i = 0 ;  i< a  ; i++)
			add_adult.click();
		for(int j= 0 ; j<b ; j++)
			add_child.click();

	}

	public static void enter_adultpassengers() {
		int a=Integer.parseInt(constants.ADULT_PASENGERS);



		for(int k = 0; k<a ; k++) {
			if(k==0) {
				Select Adult_Title_Dropdown = new Select(driver.findElement(By.xpath("//select[@id='titleAdult"+k+"']")));
				Adult_Title_Dropdown.selectByVisibleText(constants.passenger1_title);
				WebElement fname=	driver.findElement(By.xpath("//input[@name='txtFNAdult"+k+"']"));
				fname.sendKeys(constants.passenger1_fname);
				WebElement lname = driver.findElement(By.xpath("//input[@name='txtLNAdult"+k+"']"));
				lname.sendKeys(constants.passenger1_lname);
			} 
			if(k==1) {
				Select Adult_Title_Dropdown = new Select(driver.findElement(By.xpath("//select[@id='titleAdult"+k+"']")));
				Adult_Title_Dropdown.selectByVisibleText(constants.passenger2_title);
				WebElement fname=	driver.findElement(By.xpath("//input[@name='txtFNAdult"+k+"']"));
				fname.sendKeys(constants.passenger2_fname);
				WebElement lname = driver.findElement(By.xpath("//input[@name='txtLNAdult"+k+"']"));
				lname.sendKeys(constants.passenger2_lname);
			}
			if(k==2) {
				Select Adult_Title_Dropdown = new Select(driver.findElement(By.xpath("//select[@id='titleAdult"+k+"']")));
				Adult_Title_Dropdown.selectByVisibleText(constants.passenger3_title);
				WebElement fname=	driver.findElement(By.xpath("//input[@name='txtFNAdult"+k+"']"));
				fname.sendKeys(constants.passenger3_fname);
				WebElement lname = driver.findElement(By.xpath("//input[@name='txtLNAdult"+k+"']"));
				lname.sendKeys(constants.passenger3_lname);
			}
			if(k==3) {
				Select Adult_Title_Dropdown = new Select(driver.findElement(By.xpath("//select[@id='titleAdult"+k+"']")));
				Adult_Title_Dropdown.selectByVisibleText(constants.passenger4_title);
				WebElement fname=	driver.findElement(By.xpath("//input[@name='txtFNAdult"+k+"']"));
				fname.sendKeys(constants.passenger4_fname);
				WebElement lname = driver.findElement(By.xpath("//input[@name='txtLNAdult"+k+"']"));
				lname.sendKeys(constants.passenger4_lname);
			}
			if(k==4) {
				Select Adult_Title_Dropdown = new Select(Webdriver_manager.getDriver().findElement(By.xpath("//select[@id='titleAdult"+k+"']")));
				Adult_Title_Dropdown.selectByVisibleText(constants.passenger5_title);
				WebElement fname=	driver.findElement(By.xpath("//input[@name='txtFNAdult"+k+"']"));
				fname.sendKeys(constants.passenger5_fname);
				WebElement lname = driver.findElement(By.xpath("//input[@name='txtLNAdult"+k+"']"));
				lname.sendKeys(constants.passenger5_lname);
			}
			if(k==5) {
				Select Adult_Title_Dropdown = new Select(driver.findElement(By.xpath("//select[@id='titleAdult"+k+"']")));
				Adult_Title_Dropdown.selectByVisibleText(constants.passenger6_title);
				WebElement fname=	driver.findElement(By.xpath("//input[@name='txtFNAdult"+k+"']"));
				fname.sendKeys(constants.passenger6_fname);
				WebElement lname = driver.findElement(By.xpath("//input[@name='txtLNAdult"+k+"']"));
				lname.sendKeys(constants.passenger6_lname);
			}
			if(k==6) {
				Select Adult_Title_Dropdown = new Select(driver.findElement(By.xpath("//select[@id='titleAdult"+k+"']")));
				Adult_Title_Dropdown.selectByVisibleText(constants.passenger7_title);
				WebElement fname=	driver.findElement(By.xpath("//input[@name='txtFNAdult"+k+"']"));
				fname.sendKeys(constants.passenger7_fname);
				WebElement lname = driver.findElement(By.xpath("//input[@name='txtLNAdult"+k+"']"));
				lname.sendKeys(constants.passenger7_lname);
			}
			if(k==7) {
				Select Adult_Title_Dropdown = new Select(driver.findElement(By.xpath("//select[@id='titleAdult"+k+"']")));
				Adult_Title_Dropdown.selectByVisibleText(constants.passenger8_title);
				WebElement fname=	driver.findElement(By.xpath("//input[@name='txtFNAdult"+k+"']"));
				fname.sendKeys(constants.passenger8_fname);
				WebElement lname =driver.findElement(By.xpath("//input[@name='txtLNAdult"+k+"']"));
				lname.sendKeys(constants.passenger8_lname);
			}
			if(k==8) {
				Select Adult_Title_Dropdown = new Select(driver.findElement(By.xpath("//select[@id='titleAdult"+k+"']")));
				Adult_Title_Dropdown.selectByVisibleText(constants.passenger9_title);
				WebElement fname=	driver.findElement(By.xpath("//input[@name='txtFNAdult"+k+"']"));
				fname.sendKeys(constants.passenger9_fname);
				WebElement lname = driver.findElement(By.xpath("//input[@name='txtLNAdult"+k+"']"));
				lname.sendKeys(constants.passenger9_lname);
			}
		}
		LOGGER.info("Adult Passengers Name and gender has been typed");
	}

	public static void enter_child_passengers() {

		int b = Integer.parseInt(constants.CHILD_PASSENGERS);

		for(int l=0 ; l<b ; l++) {
			if(l==0) {
				Select Child_Title_Dropdown = new Select(driver.findElement(By.xpath("//select[@id='titleChild"+l+"']")));
				Child_Title_Dropdown.selectByVisibleText(constants.child_pasenger_title_1);	
				WebElement fname=	driver.findElement(By.xpath("//input[@name='txtFNChild"+l+"']"));
				fname.sendKeys(constants.child_pasenger_fname_1);
				WebElement lname = driver.findElement(By.xpath("//input[@name='txtLNChild"+l+"']"));
				lname.sendKeys(constants.child_pasenger_lname_1);
			}
			if(l==1) {
				Select Child_Title_Dropdown = new Select(driver.findElement(By.xpath("//select[@id='titleChild"+l+"']")));
				Child_Title_Dropdown.selectByVisibleText(constants.child_pasenger_title_2);	
				WebElement fname=	driver.findElement(By.xpath("//input[@name='txtFNChild"+l+"']"));
				fname.sendKeys(constants.child_pasenger_fname_2);
				WebElement lname = driver.findElement(By.xpath("//input[@name='txtLNChild"+l+"']"));
				lname.sendKeys(constants.child_pasenger_lname_2);
			}
			if(l==2) {
				Select Child_Title_Dropdown = new Select(driver.findElement(By.xpath("//select[@id='titleChild"+l+"']")));
				Child_Title_Dropdown.selectByVisibleText(constants.child_pasenger_title_3);	
				WebElement fname=	driver.findElement(By.xpath("//input[@name='txtFNChild"+l+"']"));
				fname.sendKeys(constants.child_pasenger_fname_3);
				WebElement lname = driver.findElement(By.xpath("//input[@name='txtLNChild"+l+"']"));
				lname.sendKeys(constants.child_pasenger_lname_3);
			}
			if(l==3) {
				Select Child_Title_Dropdown = new Select(driver.findElement(By.xpath("//select[@id='titleChild"+l+"']")));
				Child_Title_Dropdown.selectByVisibleText(constants.child_pasenger_title_4);	
				WebElement fname=	driver.findElement(By.xpath("//input[@name='txtFNChild"+l+"']"));
				fname.sendKeys(constants.child_pasenger_fname_4);
				WebElement lname = driver.findElement(By.xpath("//input[@name='txtLNChild"+l+"']"));
				lname.sendKeys(constants.child_pasenger_lname_4);
			}
		}
		LOGGER.info("Child Passengers Name and gender has been typed");
		continue_booking_btn2.click();

	} 
}
