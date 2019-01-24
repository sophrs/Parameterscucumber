package com.soph.parametersCucumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = Constants.featureFile)
public class ParaTestRunner {
	
	  static ExtentReports report;
	
	@BeforeClass
	public static void setup() {
		report = new ExtentReports(Constants.reportPath,true);
	}
	
	@AfterClass
	public static void teardown(){
			report.flush();
		}
		
				
	}

	


