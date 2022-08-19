package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class PayrollPage extends BasePage {

	@FindBy(xpath="//span[@class='sidebar_menu_link' and contains(text(),'Payroll')]")
	WebElement payrollLnk;
	
	@FindBy(xpath="//div[@id='site_name']//h1")
	WebElement payrollTtl;
	
	Actions act;
	
	public PayrollPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	public String goToPayrollPage() {
		act=new Actions(driver);
		act.moveToElement(payrollLnk).click().build().perform();
		toWait();
		return payrollTtl.getText();
	}
}
