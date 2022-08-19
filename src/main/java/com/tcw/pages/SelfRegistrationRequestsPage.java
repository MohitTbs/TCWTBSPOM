package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class SelfRegistrationRequestsPage extends BasePage{
	
	@FindBy(id="btnSearchSelfReg")
	public WebElement srchBtn;
	
	@FindBy(xpath="//th[@class='sorting_disabled' and contains(text(),'Date')]")
	public WebElement dateText;
	
	public SelfRegistrationRequestsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String selfRegUserSrch() {
		toWait();
		srchBtn.click();
		return dateText.getText();
		
	}
	
	

}
