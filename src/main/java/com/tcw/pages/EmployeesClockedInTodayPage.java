package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class EmployeesClockedInTodayPage extends BasePage {
	
	@FindBy(xpath="//div//h2[text()='Timesheet search']")
	public WebElement timesheetText;
	
	public EmployeesClockedInTodayPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String timesheetSrch() {
		toWait();
		return timesheetText.getText();
	}
	
}
