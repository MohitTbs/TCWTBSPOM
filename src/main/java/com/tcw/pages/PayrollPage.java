package com.tcw.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tcw.base.BasePage;

public class PayrollPage extends BasePage {

	@FindBy(xpath = "//span[@class='sidebar_menu_link' and contains(text(),'Payroll')]")
	WebElement payrollLnk;

	@FindBy(xpath = "//div[@id='site_name']//h1")
	WebElement payrollTtl;

	@FindBy(xpath = "//select[@id='ddlweekly']")
	WebElement dateDd;

	@FindBy(xpath = "//select[@id='ddlweekly']/option")
	List<WebElement> listOfDatesForPayroll;

	@FindBy(id = "aGeneratePayroll")
	WebElement generatePayrollBtn;

	@FindBy(xpath = "//div[@id='jSuccess' and contains(text(),'generated')]")
	WebElement payrollGeneratedMsg;

	@FindBy(xpath = "//div[@id='jError' and contains(text(),'already')]")
	WebElement payrollErrorMsg;

	Actions act;

	public PayrollPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Landing on the Payroll Page
	public String goToPayrollPage() {
		act = new Actions(driver);
		act.moveToElement(payrollLnk).click().build().perform();
		toWait();
		return payrollTtl.getText();
	}

	// Generating the Payroll
	public String GeneratePayroll() {
		act = new Actions(driver);
		act.moveToElement(dateDd).click().build().perform();
		listOfDatesForPayroll.get(1).click();
		generatePayrollBtn.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
			wait.until(ExpectedConditions.visibilityOf(payrollGeneratedMsg));
			return payrollGeneratedMsg.getText();
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return payrollErrorMsg.getText();
		}
		
		
	}
}
