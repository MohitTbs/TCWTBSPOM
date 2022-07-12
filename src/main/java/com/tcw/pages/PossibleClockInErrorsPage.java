package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class PossibleClockInErrorsPage extends BasePage {

	@FindBy(xpath="//h1[contains(text(),'Possible Clock In Errors List')]")
	public WebElement possClcokInErrLstTtl;
	
	
	
	public PossibleClockInErrorsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String getTtlPossClockInErr() {
		return possClcokInErrLstTtl.getText();
	}
	

}
