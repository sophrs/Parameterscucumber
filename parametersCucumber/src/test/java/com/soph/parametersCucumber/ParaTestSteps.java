package com.soph.parametersCucumber;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ParaTestSteps {
	WebDriver driver;
	ExtentTest test;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", Constants.driverLocation);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		test = ParaTestRunner.report.startTest("Bing Search");
	}

	@After
	public void teardown() {
		driver.quit();
		ParaTestRunner.report.endTest(test);
	}

	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1)  {
		driver.get(arg1);
		
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) {
		BingHome home = PageFactory.initElements(driver, BingHome.class);
		home.search(arg1);
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search() {
		BingSearch results = PageFactory.initElements(driver, BingSearch.class);
		
		if(results.getTitleAll().equals("All")) {
			test.log(LogStatus.PASS, "searched item");
		}
		else {
			test.log(LogStatus.FAIL, "didnt search item");
		}
		assertEquals("All", results.getTitleAll());
		
	
	}

}
