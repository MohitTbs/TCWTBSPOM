package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class NotClockedInNowPage extends BasePage {
	
	@FindBy(xpath = "//th[@class='sorting_disabled' and contains(text(),'Name')]")
	public WebElement nameText;
	
	
	public NotClockedInNowPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public String notclockedInTest() {
		toWait();
		return nameText.getText();
	}
}
