package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tcw.base.BasePage;

public class PendingTimesheetRequestsPage extends BasePage {
	
	@FindBy(xpath="//h2[text()='TimeSheets Request Search']")
	public WebElement tsReqSrchTtl;
	
	@FindBy(id="btnSearchtimesheet")
	public WebElement tsReqSrchBtn;
	
	@FindBy(xpath="//th[text()='Name']")
	public WebElement tsReqLstTtl;
	
	Actions act;
	
	public PendingTimesheetRequestsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String timesheetRequestList() {
		wait.until(ExpectedConditions.elementToBeClickable(tsReqLstTtl));
		act = new Actions(driver);
		act.moveToElement(tsReqSrchBtn).click().build().perform();
		//tsReqSrchBtn.click();
		return tsReqLstTtl.getText();
	}
	

}
