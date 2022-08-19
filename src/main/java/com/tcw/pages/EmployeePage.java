package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class EmployeePage extends BasePage {

	@FindBy(xpath = "//span[@class='sidebar_menu_link' and contains(text(),'Employee')]")
	WebElement empLnk;

	@FindBy(xpath="//div[@id='site_name']//h1")
	WebElement empTtl;
	
	public EmployeePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String goToEmployeePage() {
		empLnk.click();
		toWait();
		return empTtl.getText();
	}
	
}
