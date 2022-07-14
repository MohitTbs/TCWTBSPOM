package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tcw.base.BasePage;

public class DashboardPage extends BasePage {

	@FindBy(id = "add_task_link")
	public WebElement addTaskBtn;

	@FindBy(xpath = "//a[@id='btn_saveTask']//following-sibling::a")
	public WebElement taskCloseBtn;

	@FindBy(xpath = "//div[contains(text(),'Pending Timesheet Requests')]")
	public WebElement pendTsRqLink;

	@FindBy(xpath = "//div[contains(text(),'Possible Clock In Errors')]")
	public WebElement possClockInErrLink;
	
	@FindBy(xpath="//*[text()='Shift Switch Requests']")
	public WebElement shiftSwitchReqLink;

	@FindBy(xpath = "//*[text()='Pending Absence Requests']")
	public WebElement penAbsReqLink;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void addTask() {
		System.out.println(driver.getTitle());
		log.info("Inside the addTaskBtn");
		addTaskBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(taskCloseBtn));
		taskCloseBtn.click();

	}

	public PendingTimesheetRequestsPage goToPendingTimesheetReq() {

		pendTsRqLink.click();

		return new PendingTimesheetRequestsPage(driver);

	}

	public PossibleClockInErrorsPage goToPossibleClockInErrorsPage() {

		possClockInErrLink.click();

		return new PossibleClockInErrorsPage(driver);

	}

	public PendingAbsenceRequestsPage goToPendingAbsenceRequestsPage() {

		penAbsReqLink.click();

		return new PendingAbsenceRequestsPage(driver);

	}
	
	public ShiftSwitchRequestsPage goToShiftSwitchRequestsPage() {

		shiftSwitchReqLink.click();

		return new ShiftSwitchRequestsPage(driver);

	}

}
