package com.arshad.CommonUtilities;

import java.sql.DriverManager;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v107.page.Page;
import org.openqa.selenium.support.PageFactory;

import com.arshad.Constant.constants;
import com.arshad.DriverManager.Webdriver_manager;
import com.arshad.PageObjectModel.Flight_HomePage;
import com.arshad.PageObjectModel.Hotel_DetailsPage;
import com.arshad.PageObjectModel.Flight_ReviewPage;
import com.arshad.PageObjectModel.Flight_ReviewPageSeats;
import com.arshad.PageObjectModel.Flight_SelectFlightPage;
import com.arshad.PageObjectModel.Hotel_Select_Page;
import com.arshad.PageObjectModel.Hotel_Select_Room_Page;
import com.arshad.PageObjectModel.Hotel_review_page;

public class commonutils {

	private static commonutils commonutilInstance;

	public commonutils() {

	}

	public static commonutils getInstance() {

		if(commonutilInstance==null) {
			commonutilInstance=new commonutils();
		}

		return commonutilInstance;

	}

	public synchronized void loadproperties() {

		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/Config_FlightTicket.properties"));
			properties.load(getClass().getResourceAsStream("/Config_HotelBooking.properties"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
//Fligh Ticket
		constants.BROWSER=properties.getProperty("BROWSER");
		constants.APP_URL=properties.getProperty("APP_URL");
		constants.FROM_CITY=properties.getProperty("FROM_CITY");
		constants.TO_CITY=properties.getProperty("TO_CITY");
		constants.DEPARTURE_MONTH=properties.getProperty("DEPARTURE_MONTH");
		constants.DEPARTURE_DATE=properties.getProperty("DEPARTURE_DATE");
		constants.ADULT_PASENGERS=properties.getProperty("PASSENGERS_ADULTS");
		constants.CHILD_PASSENGERS=properties.getProperty("PASSENGERS_CHILDREN");
		constants.CLASS_DETAILS=properties.getProperty("CLASS_DETAILS");
		constants.FILTER=properties.getProperty("FILTER");
		constants.FILTER_FLIGHT1=properties.getProperty("FILTER_FLIGHT1");
		constants.FILTER_FLIGHT2=properties.getProperty("FILTER_FLIGHT2");
		constants.FILTER_FLIGHT3=properties.getProperty("FILTER_FLIGHT3");
		constants.FILTER_FLIGHT4=properties.getProperty("FILTER_FLIGHT4");
		constants.FILTER_FLIGHT5=properties.getProperty("FILTER_FLIGHT5");
		constants.FILTER_FLIGHT6=properties.getProperty("FILTER_FLIGHT6");
		constants.FILTER_FLIGHT7=properties.getProperty("FILTER_FLIGHT7");
		constants.FILTER_FLIGHT8=properties.getProperty("FILTER_FLIGHT8");
		constants.INSURANCE=properties.getProperty("INSURANCE");
		constants.EMAIL_ID=properties.getProperty("EMAIL_ID");
		constants.PHONE_NUM=properties.getProperty("PHONE_NUM");
		
		constants.passenger1_title=properties.getProperty("1_passenger_title");
		constants.passenger2_title=properties.getProperty("2_passenger_title");
		constants.passenger3_title=properties.getProperty("3_passenger_title");
		constants.passenger4_title=properties.getProperty("4_passenger_title");
		constants.passenger5_title=properties.getProperty("5_passenger_title");
		constants.passenger6_title=properties.getProperty("6_passenger_title");
		constants.passenger7_title=properties.getProperty("7_passenger_title");
		constants.passenger8_title=properties.getProperty("8_passenger_title");
		constants.passenger9_title=properties.getProperty("9_passenger_title");
		
		constants.passenger1_fname=properties.getProperty("1_Pasenger_fname");
		constants.passenger2_fname=properties.getProperty("2_Pasenger_fname");
		constants.passenger3_fname=properties.getProperty("3_Pasenger_fname");
		constants.passenger4_fname=properties.getProperty("4_Pasenger_fname");
		constants.passenger5_fname=properties.getProperty("5_Pasenger_fname");
		constants.passenger6_fname=properties.getProperty("6_Pasenger_fname");
		constants.passenger7_fname=properties.getProperty("7_Pasenger_fname");
		constants.passenger8_fname=properties.getProperty("8_Pasenger_fname");
		constants.passenger9_fname=properties.getProperty("9_Pasenger_fname");

		constants.passenger1_lname=properties.getProperty("1_Passenger_Lname");
		constants.passenger2_lname=properties.getProperty("2_Passenger_Lname");
		constants.passenger3_lname=properties.getProperty("3_Passenger_Lname");
		constants.passenger4_lname=properties.getProperty("4_Passenger_Lname");
		constants.passenger5_lname=properties.getProperty("5_Passenger_Lname");
		constants.passenger6_lname=properties.getProperty("6_Passenger_Lname");
		constants.passenger7_lname=properties.getProperty("7_Passenger_Lname");
		constants.passenger8_lname=properties.getProperty("8_Passenger_Lname");
		constants.passenger9_lname=properties.getProperty("9_Passenger_Lname");
		
		constants.child_pasenger_title_1=properties.getProperty("1_Child_passenger_title");
		constants.child_pasenger_title_2=properties.getProperty("2_Child_passenger_title");
		constants.child_pasenger_title_3=properties.getProperty("3_Child_passenger_title");
		constants.child_pasenger_title_4=properties.getProperty("4_Child_passenger_title");
		
		constants.child_pasenger_fname_1=properties.getProperty("1_Child_Passenger_fname");
		constants.child_pasenger_fname_2=properties.getProperty("2_Child_Passenger_fname");
		constants.child_pasenger_fname_3=properties.getProperty("3_Child_Passenger_fname");
		constants.child_pasenger_fname_4=properties.getProperty("4_Child_Passenger_fname");
		
		constants.child_pasenger_lname_1=properties.getProperty("1_Child_Passenger_Lname");
		constants.child_pasenger_lname_2=properties.getProperty("2_Child_Passenger_Lname");
		constants.child_pasenger_lname_3=properties.getProperty("3_Child_Passenger_Lname");
		constants.child_pasenger_lname_4=properties.getProperty("4_Child_Passenger_Lname");
		
		constants.passenger1_seats=properties.getProperty("1_passenger_seat");
		constants.passenger2_seats=properties.getProperty("2_passenger_seat");
		constants.passenger3_seats=properties.getProperty("3_passenger_seat");
		constants.passenger4_seats=properties.getProperty("4_passenger_seat");
		constants.passenger5_seats=properties.getProperty("5_passenger_seat");
		constants.passenger6_seats=properties.getProperty("6_passenger_seat");
		constants.passenger7_seats=properties.getProperty("7_passenger_seat");
		constants.passenger8_seats=properties.getProperty("8_passenger_seat");
		constants.passenger9_seats=properties.getProperty("9_passenger_seat");
		
		constants.child_pasenger1_seats=properties.getProperty("1_child_seat");
		constants.child_pasenger2_seats=properties.getProperty("2_child_seat");
		constants.child_pasenger3_seats=properties.getProperty("3_child_seat");
		constants.child_pasenger4_seats=properties.getProperty("4_child_seat");
		
		
		constants.Seat_selection=properties.getProperty("Seat_selection");
		
//HotelBooking
		//constants.Browser2=properties.getProperty("browser_name_2");
		//constants.aPP_URL=properties.getProperty("app_url");
		constants.hotel_city=properties.getProperty("City");
		constants.Check_in_date=properties.getProperty("Check_in_date");
		constants.Check_in_month=properties.getProperty("Check_in_Month");
		constants.Check_out_month=properties.getProperty("Check_out_Month");
		constants.Check_out_date=properties.getProperty("Check_out_Date");
		constants.No_of_rooms=properties.getProperty("No_of_Rooms");
	    constants.No_of_Adults_Room1=properties.getProperty("No_of_Adults_for_Room1","0");
	    constants.No_of_Adults_Room2=properties.getProperty("No_of_Adults_for_Room2","0");
	    constants.No_of_Adults_Room3=properties.getProperty("No_of_Adults_for_Room3","0");
	    constants.No_of_Childs_Room1=properties.getProperty("No_of_Childs_for_Room1","0");
	    constants.No_of_Childs_Room2=properties.getProperty("No_of_Childs_for_Room2","0");
	    constants.No_of_Childs_Room3=properties.getProperty("No_of_Childs_for_Room3","0");
		constants.room1_child1=properties.getProperty("Room1_Child1_age");
		constants.room1_child2=properties.getProperty("Room1_Child2_age");
		constants.room2_child1=properties.getProperty("Room2_Child1_age");
		constants.room2_child2=properties.getProperty("Room2_Child2_age");
		constants.room3_child1=properties.getProperty("Room3_Child1_age");
		constants.room3_child2=properties.getProperty("Room3_Child2_age");
		
		constants.star_rating=properties.getProperty("Star_Rating");
		constants.amenity_1=properties.getProperty("Amenity_1");
		constants.amenity_2=properties.getProperty("Amenity_2");
		constants.amenity_3=properties.getProperty("Amenity_3");
		constants.min_budget=properties.getProperty("Minimum_Budget");
		constants.max_budget=properties.getProperty("Maximum_Budget");
		
		constants.Popularity_dropdown=properties.getProperty("Popularity_Dropdwon");
		
		constants.title_adult_r1=properties.getProperty("Adult_R1_Title");
		constants.title_adult_r2=properties.getProperty("Adult_R2_Title");
		constants.title_adult_r3=properties.getProperty("Adult_R3_Title");
		
		constants.F_name_Adult_Room1=properties.getProperty("F_name_Adult_Room1");
		constants.L_name_Adult_Room1=properties.getProperty("L_name_Adult_Room1");
		constants.F_name_Child1_Room1=properties.getProperty("F_name_Child1_Room1");
		constants.L_name_Child1_Room1=properties.getProperty("L_name_Child1_Room1");
		constants.F_name_Child2_Room1=properties.getProperty("F_name_Child2_Room1");
		constants.L_name_Child2_Room1=properties.getProperty("L_name_Child2_Room1");
		
		constants.F_name_Adult_Room2=properties.getProperty("F_name_Adult_Room2");
		constants.L_name_Adult_Room2=properties.getProperty("L_name_Adult_Room2");
		constants.F_name_Child1_Room2=properties.getProperty("F_name_Child1_Room2");
		constants.L_name_Child1_Room2=properties.getProperty("L_name_Child1_Room2");
		constants.F_name_Child2_Room2=properties.getProperty("F_name_Child2_Room2");
		constants.L_name_Child2_Room2=properties.getProperty("L_name_Child2_Room2");
		
		constants.F_name_Adult_Room3=properties.getProperty("F_name_Adult_Room3");
		constants.L_name_Adult_Room3=properties.getProperty("L_name_Adult_Room3");
		constants.F_name_Child1_Room3=properties.getProperty("F_name_Child1_Room3");
		constants.L_name_Child1_Room3=properties.getProperty("L_name_Child1_Room3");
		constants.F_name_Child2_Room3=properties.getProperty("F_name_Child2_Room3");
		constants.L_name_Child2_Room3=properties.getProperty("L_name_Child2_Room3");
		
	}
	public void initWebelements() {

		PageFactory.initElements(Webdriver_manager.getDriver(), Flight_HomePage.class);
		PageFactory.initElements(Webdriver_manager.getDriver(), Flight_SelectFlightPage.class);
		PageFactory.initElements(Webdriver_manager.getDriver(), Flight_ReviewPage.class);
		PageFactory.initElements(Webdriver_manager.getDriver(), Flight_ReviewPageSeats.class);
		PageFactory.initElements(Webdriver_manager.getDriver(), Hotel_DetailsPage.class);
		PageFactory.initElements(Webdriver_manager.getDriver(), Hotel_Select_Page.class);
		PageFactory.initElements(Webdriver_manager.getDriver(), Hotel_Select_Room_Page.class);
		PageFactory.initElements(Webdriver_manager.getDriver(), Hotel_review_page.class);
	}

}
