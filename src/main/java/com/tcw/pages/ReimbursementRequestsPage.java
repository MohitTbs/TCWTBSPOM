package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class ReimbursementRequestsPage extends BasePage{
	
	
	@FindBy(id="btnSearchReimbursement")
	public WebElement srchBtn;
	
	@FindBy(xpath="//td[@class='td sorting_disabled']//strong[text()='Date']")
	public WebElement dateText;
	
	
	public ReimbursementRequestsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String reimbReqSrch() {
		toWait();
		srchBtn.click();
		return dateText.getText();
		
	}
	
	
}
