package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class LoginPage extends BasePage{
	
	


	public LoginPage() {
		super();
		// TODO Auto-generated constructor stub
	}


	@FindBy(id="UserName")
	WebElement unameTxtBx;
	
	@FindBy(id="Password")
	WebElement pwdTxtBx;
	
	@FindBy(xpath="//div//button[@value='LogIn']")
	WebElement logInBtn;
	
	
	public DashboardPage loginIn() {
		
		unameTxtBx.sendKeys(Config.getProperty("username"));
		pwdTxtBx.sendKeys(Config.getProperty("password"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logInBtn.click();
		
		return new DashboardPage();
	}
	
	
	
	

}
