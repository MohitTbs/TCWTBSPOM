package com.tcw.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class ShiftSwitchRequestsPage extends BasePage{
	
	@FindBy(xpath="//h1[text()='Switch schedule']")
	public WebElement switchScheduletTtl;
	
	public ShiftSwitchRequestsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	public String switchReqFromMeLst() {
		toWait();
		return switchScheduletTtl.getText();
		
		
		
		
		
	}
	
	
	
	
	

}
