package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class SchedulePage extends BasePage{

	@FindBy(xpath="//span[@class='sidebar_menu_link' and contains(text(),'Schedule')]")
	WebElement schdLnk;
	
	@FindBy(xpath="//div[@id='site_name']//h1")
	WebElement schdTtl;
	
	public SchedulePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String goToSchedulePage() {
		schdLnk.click();
		toWait();
		return schdTtl.getText();
	}
}
