package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class LiveStreamPage extends BasePage {
	
	@FindBy(xpath = "//h2[text()='Activity Information']")
	public WebElement activityText;
	
	public LiveStreamPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public String liveStream() {
		toWait();
		return activityText.getText();
		
	}
}
