package com.tcw.pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tcw.base.BasePage;

public class LoginPage extends BasePage{
	
	


	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}


	@FindBy(id="UserName")
	public WebElement unameTxtBx;
	
	@FindBy(id="Password")
	public WebElement pwdTxtBx;
	
	@FindBy(xpath="//div//button[@value='LogIn']")
	public WebElement logInBtn;
	
	
	public void loginIn() {
		
		unameTxtBx.sendKeys(Config.getProperty("username"));
		pwdTxtBx.sendKeys(Config.getProperty("password"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logInBtn.click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divLoading")));
		System.out.println("1");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
		System.out.println("2");
		
		//return new DashboardPage();
	}
	
	
	
	

}
