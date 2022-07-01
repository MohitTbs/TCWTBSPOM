package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class PendingTimesheetRequestsPage extends BasePage {
	
	@FindBy(xpath="//h2[text()='TimeSheets Request Search']")
	public WebElement tsReqSrchTtl;
	
	
	public PendingTimesheetRequestsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	

}
