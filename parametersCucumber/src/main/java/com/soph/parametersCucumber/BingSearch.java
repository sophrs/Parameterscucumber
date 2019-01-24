package com.soph.parametersCucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingSearch {
	
	@FindBy(xpath = "//*[@id=\"b_header\"]/nav/ul/li[1]/a")
	private WebElement alltext;
	
	public String getTitleAll() {
		return alltext.getText();		
		
	}

}
