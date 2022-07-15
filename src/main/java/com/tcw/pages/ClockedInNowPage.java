package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class ClockedInNowPage extends BasePage{

	@FindBy(xpath="(//th[@class='sorting_disabled' and  contains(text(),'Schedule')])[1]")
	public WebElement scheduleText;
	
	@FindBy(xpath="//li//a[text()='Not Clocked In Now']")
	public WebElement notClockInTab;
	
	@FindBy(xpath="(//th[@class='sorting_disabled' and contains(text(),'Schedule')])[2]")
	public WebElement schedule1Text;
	
	public ClockedInNowPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String clockInNow() {
		toWait();
		return scheduleText.getText();
	}
	
	public String notClockIn() {
		notClockInTab.click();
		return schedule1Text.getText();
	}
	
}
