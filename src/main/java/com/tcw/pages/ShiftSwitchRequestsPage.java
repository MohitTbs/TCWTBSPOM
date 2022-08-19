package com.tcw.pages;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tcw.base.BasePage;

public class ShiftSwitchRequestsPage extends BasePage{
	
	@FindBy(xpath="//h1[text()='Switch schedule']")
	public WebElement switchScheduletTtl;
	
	@FindBy(xpath="(//th[@class='sorting_disabled' and contains(text(),'Date')])[3]")
	public WebElement switchScheduletToMeDt;
	
	@FindBy(xpath="(//th[contains(text(),'Start')])[2]")
	public WebElement switchScheduletToMeStart;
	
	@FindBy(xpath="//*[@id=\"switchEmpTab\"]/li[2]")
	public WebElement switchScheduleToMeTab;
	
	@FindBy(xpath="//*[@id=\"switchEmpTab\"]/li[3]/a")
	public WebElement allEmpSwitchReqTab;
	
	public ShiftSwitchRequestsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	public String switchReqFromMeLst() {
		toWait();
		return switchScheduletTtl.getText();
		

	}
	
	public String switchReqToMeLst() {
		switchScheduleToMeTab.click();
		return switchScheduletToMeDt.getText();
		
	}
	
	public String allEmpSwitchReqLst() {
		allEmpSwitchReqTab.click();
		return switchScheduletToMeStart.getText();
	}
	
	
	

}
