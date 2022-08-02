package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class TimesheetPage extends BasePage {
	
	@FindBy(xpath = "//h2[text()='Timesheet search']")
	public WebElement tsSrchText;
	
	public TimesheetPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String tsPageHit() {
		toWait();
		return tsSrchText.getText();
	}

}
