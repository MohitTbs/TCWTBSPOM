package com.tcw.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tcw.base.BasePage;

public class ReportsPage extends BasePage {

	@FindBy(xpath = "//span[@class='sidebar_menu_link' and contains(text(),'Reports')]")
	WebElement reportsLnk;

	@FindBy(xpath = "//div[@id='site_name']//h1")
	WebElement reportsTtl;
	
	@FindBy(xpath="//button[contains(text(),'View Report')]")
	WebElement viewReportBtn;
	
	@FindBy(xpath="(//div[text()='Employee Name'])[1]")
	WebElement tsEmpNameTxt;
	
	@FindBy(id="IframeheaderSource")
	WebElement frameId;
	
	@FindBy(id="Timesheet_IsStandard")
	WebElement detailedTimesheetToggle;
	
	@FindBy(id="PTOBanks")
	WebElement ptoBankTab;
	
	@FindBy(id="ptoBankReport")
	WebElement ptoViewReportBtn;
	
	@FindBy(id="ContactBlock")
	WebElement empContactListTab;
	
	@FindBy(xpath="//a[@type='submit']")
	WebElement empContactListViewReportBtn;
	
	By tsEmpNameTxt_By =By.xpath("(//div[text()='Employee Name'])[1]");
	
	Actions act;

	WebDriverWait wait;
	
	public ReportsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Implicit wait changes
	public void waitForReport() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	// Landing on the Time sheet page
	public String goToReportsPage() {
		act = new Actions(driver);
		act.moveToElement(reportsLnk).click().build().perform();
		toWait();
		return reportsTtl.getText();
	}
	
	// Standard TimeSheet
	public String genStdTimesheet() {
		act = new Actions(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		act.moveToElement(viewReportBtn).click().build().perform();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		//driver.switchTo().frame(frameId);
		
		//wait.until(ExpectedConditions.visibilityOf(tsEmpNameTxt));
		wait.until(ExpectedConditions.presenceOfElementLocated(tsEmpNameTxt_By));
		act.moveToElement(tsEmpNameTxt).perform();
		return tsEmpNameTxt.getText();
		
	}
	
	//Detailed Timesheet
	public String genDtdTimesheet() {
		act = new Actions(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		act.moveToElement(detailedTimesheetToggle).click().build().perform();
		act.moveToElement(viewReportBtn).click().build().perform();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		//driver.switchTo().frame(frameId);
		
		//wait.until(ExpectedConditions.visibilityOf(tsEmpNameTxt));
		wait.until(ExpectedConditions.presenceOfElementLocated(tsEmpNameTxt_By));
		act.moveToElement(tsEmpNameTxt).perform();
		return tsEmpNameTxt.getText();
		
	}
	
	//Pto Banks
	public String genPTOBanks() {
		act = new Actions(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		act.moveToElement(ptoBankTab).click().build().perform();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
		act.moveToElement(ptoViewReportBtn).click().build().perform();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		wait.until(ExpectedConditions.presenceOfElementLocated(tsEmpNameTxt_By));
		act.moveToElement(tsEmpNameTxt).perform();
		return tsEmpNameTxt.getText();
	}

	//Emp Contact List
	public void genEmpContactList() {
		act = new Actions(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		act.moveToElement(empContactListTab).click().build().perform();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
		act.moveToElement(empContactListViewReportBtn).click().build().perform();
		
		
	}
}
