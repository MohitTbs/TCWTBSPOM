package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class LoginPage extends BasePage{
	
	


	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}


	@FindBy(id="UserName")
	public WebElement unameTxtBx;
	
	@FindBy(id="Password")
	public WebElement pwdTxtBx;
	
	@FindBy(xpath="//div//button[@value='LogIn']")
	public WebElement logInBtn;
	
	
	public void loginIn() {
		
		String uname = Config.getProperty("username");
		System.out.println(uname);
		String pwd = Config.getProperty("password");
		unameTxtBx.sendKeys(uname);
		pwdTxtBx.sendKeys(pwd);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logInBtn.click();
		
		//return new DashboardPage();
	}
	
	
	
	

}
