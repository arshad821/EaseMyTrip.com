package com.arshad.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.arshad.Constant.constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webdriver_manager {

	public static WebDriver driver;

	public static void launchbrowser() {

		try {
			switch (constants.BROWSER) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver= new EdgeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				break;

			default:
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
			}
			/*
			 * switch (constants.Browser2) { case "chrome":
			 * WebDriverManager.chromedriver().setup(); driver=new ChromeDriver(); break;
			 * case "edge": WebDriverManager.edgedriver().setup(); driver= new EdgeDriver();
			 * break; case "firefox": WebDriverManager.firefoxdriver().setup(); driver=new
			 * FirefoxDriver(); break;
			 * 
			 * default: WebDriverManager.chromedriver().setup(); driver=new ChromeDriver();
			 * break; }
			 */
		} catch (Exception e) {
			//throw new RuntimeException("Failed to initialize driver", e);
		}
	}


	public static WebDriver getDriver() {
		return driver;
	}

}
