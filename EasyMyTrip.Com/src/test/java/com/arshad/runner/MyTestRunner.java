package com.arshad.runner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;






@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/FeatureFiles",
		glue= {"com.arshad.StepDefinition","com.arshad.CommonStepDefinition",},
		dryRun=false,
		monochrome=true,
				plugin= {
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						},
		publish = true,
		tags ="@HotelBooking" 
		)
public class MyTestRunner{

	

	}

