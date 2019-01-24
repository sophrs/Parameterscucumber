package com.soph.parametersCucumber;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingHome {

	
	@FindBy(xpath = "//*[@id=\"sb_form_q\"]")
	private WebElement searchinput;
	
	public void search(String searchwords) {
		searchinput.sendKeys(searchwords, Keys.ENTER);
	}
	
	
}
