package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class SupportPage extends BasePage {

	@FindBy(xpath = "//span[@class='sidebar_menu_link' and contains(text(),'Support')]")
	WebElement supportLnk;

	@FindBy(xpath = "//div[@id='site_name']//h1")
	WebElement supportTtl;
	
	Actions act;

	public SupportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String goToSupportPage() {
		act = new Actions(driver);
		act.moveToElement(supportLnk).click().build().perform();
		toWait();
		return supportTtl.getText();
	}

}
