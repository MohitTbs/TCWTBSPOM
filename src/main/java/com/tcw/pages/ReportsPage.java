package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.performance.Performance;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class ReportsPage extends BasePage {

	@FindBy(xpath = "//span[@class='sidebar_menu_link' and contains(text(),'Reports')]")
	WebElement reportsLnk;

	@FindBy(xpath = "//div[@id='site_name']//h1")
	WebElement reportsTtl;
	
	Actions act;

	public ReportsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String goToReportsPage() {
		act = new Actions(driver);
		act.moveToElement(reportsLnk).click().build().perform();
		toWait();
		return reportsTtl.getText();
	}

}
