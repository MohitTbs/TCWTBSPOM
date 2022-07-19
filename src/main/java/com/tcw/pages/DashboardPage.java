package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	@FindBy(xpath = "//*[text()='Shift Switch Requests']")
	public WebElement shiftSwitchReqLink;

	@FindBy(xpath = "//*[text()='Pending Absence Requests']")
	public WebElement penAbsReqLink;

	@FindBy(xpath = "//div[contains(text(),'Timesheets To Verify')]")
	public WebElement tsToVerifyLink;
	
	@FindBy(xpath = "//div[contains(text(),'Reimbursement Requests')]")
	public WebElement reimbReqLink;
	
	@FindBy(xpath = "//div[contains(text(),'Self Registration Requests')]")
	public WebElement selfRegReqLink;
	
	@FindBy(xpath = "//div[text()='Scheduled Employees']")
	public WebElement schEmpLink;
	
	@FindBy(xpath = "//div[text()='Clocked In Now']")
	public WebElement clockedInNowLink;
	
	@FindBy(xpath = "//div[text()='Employees Clocked In Today']")
	public WebElement empClockTodayLink;
	
	@FindBy(xpath = "//div[text()='Not Clocked In Now']")
	public WebElement notClockedLink;
	
	@FindBy(id = "livestream_link")
	public WebElement liveStreamLink;
	
	@FindBy(xpath = "//a[@class='livestream_link']")
	public WebElement liveStreamMore;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

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

	public TimesheetsToVerifyPage goToTimesheetsToVerifyPage() {

		tsToVerifyLink.click();

		return new TimesheetsToVerifyPage(driver);
	}
	
	public ReimbursementRequestsPage goToReimbursementRequestsPage() {

		reimbReqLink.click();

		return new ReimbursementRequestsPage(driver);
	}

	public SelfRegistrationRequestsPage goToSelfRegistrationRequestsPage() {

		selfRegReqLink.click();

		return new SelfRegistrationRequestsPage(driver);
	}
	
	public ScheduledEmployeesPage goToScheduledEmployeesPage() {

		schEmpLink.click();

		return new ScheduledEmployeesPage(driver);
	}
	
	public ClockedInNowPage goToClockedInNowPage() {

		clockedInNowLink.click();

		return new ClockedInNowPage(driver);
	}
	
	public EmployeesClockedInTodayPage goToEmployeesClockedInTodayPage() {

		empClockTodayLink.click();

		return new EmployeesClockedInTodayPage(driver);
	}
	
	public NotClockedInNowPage goToNotClockedInNowPage() {

		notClockedLink.click();

		return new NotClockedInNowPage(driver);
	}
	
	public LiveStreamPage goToLiveStreamPage() {

		liveStreamLink.click();
		toWait();
		Actions act = new Actions(driver);
		act.moveToElement(liveStreamMore).click().build().perform();

		return new LiveStreamPage(driver);
	}

}
