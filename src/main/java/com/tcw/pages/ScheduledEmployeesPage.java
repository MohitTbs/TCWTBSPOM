package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class ScheduledEmployeesPage extends BasePage {
	
	@FindBy(xpath="//div[@id='site_name']//h1")
	public WebElement sxheduleText;
	
	
	
	public ScheduledEmployeesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String daySchTest() {
		toWait();
		return sxheduleText.getText();
	}

}
