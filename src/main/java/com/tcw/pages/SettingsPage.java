package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class SettingsPage extends BasePage {

	@FindBy(xpath="//span[@class='sidebar_menu_link' and contains(text(),'Settings')]")
	WebElement settLnk;
	
	@FindBy(xpath="//div[@id='site_name']//h1")
	WebElement settTtl;
	
	Actions act;
	
	public SettingsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String goToSettingsPage() {
		act = new Actions(driver);
		act.moveToElement(settLnk).click().build().perform();
		toWait();
		return settTtl.getText();
	}
	
}
