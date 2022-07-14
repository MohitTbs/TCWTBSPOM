package com.tcw.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tcw.base.BasePage;

public class PendingAbsenceRequestsPage extends BasePage{
	
	@FindBy(xpath="//th[text()='Name ']")
	public WebElement abReqLstTtl;
	
	@FindBy(id="btnSearchtimesheet")
	public WebElement srchBtn;
	
	
	Actions act;

	public PendingAbsenceRequestsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String absenceReqList() {
		toWait();
		act = new Actions(driver);
		act.moveToElement(srchBtn).click().build().perform();
		
		System.out.println(abReqLstTtl.getText());
		return abReqLstTtl.getText();
		
	}

}
