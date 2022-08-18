package com.tcw.pages;

import java.time.Duration;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tcw.base.BasePage;

public class TimesheetPage extends BasePage {

	@FindBy(xpath = "//h2[text()='Timesheet search']")
	public WebElement tsSrchText;

	@FindBy(id = "add_task_link_two")
	public WebElement addTimeRecordBtn;

	@FindBy(id = "ddltmpopupEmployeeList")
	WebElement empDrpDwn;

	@FindBy(id = "txtStartDateClock")
	WebElement clockInDt;

	@FindBy(id = "txtEndDateClock")
	WebElement clockOutDt;

	@FindBy(id = "txtstartTimeClock")
	WebElement clockInTime;

	@FindBy(id = "txtEndTimeClock")
	WebElement clockOutTime;

	@FindBy(id = "ddlLocationClocked")
	WebElement addTimeLocation;

	@FindBy(id = "ddlJobClocked")
	WebElement addTimeJob;

	@FindBy(id = "txtNoteClocked")
	WebElement addTimeNotes;

	@FindBy(id = "btntimesheetpopupSave")
	WebElement addTimeRecordSaveBtn;

	@FindBy(id = "jSuccess")
	WebElement successMsg;

	@FindBy(id = "jError")
	WebElement errorMsg;

	@FindBy(xpath = "//*[text()='Future timesheets are not allowed.']")
	WebElement errorMsg1;

	@FindBy(id = "modalTimeRecord")
	WebElement tsOverlapMsg;

	@FindBy(xpath = "//a[@data-target='#Add_timeOff']")
	public WebElement addTimeOffBtn;

	@FindBy(id = "ddlAbsenceEmployeeList")
	public WebElement absenceEmpDrpDwn;

	@FindBy(id = "ddlAbsneceType")
	public WebElement absenceTypeDrpDwn;

	@FindBy(id = "txtstartdateAbsence")
	public WebElement absenceStDt;

	@FindBy(id = "txtenddateAbsence")
	public WebElement absenceEndDt;

	@FindBy(id = "txtStartTime")
	public WebElement absenceStTime;

	@FindBy(id = "txtEndTime")
	public WebElement absenceEndTime;

	@FindBy(id = "ddlLocationClockedAbsence")
	public WebElement absenceLocation;

	@FindBy(id = "ddlJobClockedAbsence")
	public WebElement absenceJob;

	@FindBy(id = "txtaAbsenceNote")
	public WebElement absenceNotes;

	@FindBy(id = "btnabsencepopupSave")
	public WebElement addAbsencesBtn;

	Actions act;
	WebDriverWait wait;

	public TimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	// Landing on the Timesheet Page
	public String tsPageHit() {
		toWait();
		return tsSrchText.getText();
	}

	// Adding the Timesheet
	public void addTimeRecord(Hashtable<String, String> data) {
		act = new Actions(driver);
		act.moveToElement(addTimeRecordBtn).click().build().perform();

		Select selectEmpDrpDwn = new Select(empDrpDwn);
		// System.out.println(data.get("emp"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(empDrpDwn));
		selectEmpDrpDwn.selectByVisibleText(data.get("emp"));
		clockInDt.clear();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		clockInDt.sendKeys(data.get("clockInDt"));
		clockOutDt.clear();
		clockOutDt.sendKeys(data.get("clockOutDt"));
		clockInTime.clear();
		clockInTime.sendKeys(data.get("clockInTime"));
		clockOutTime.clear();
		clockOutTime.sendKeys(data.get("clockOutTime"));
		Select selectAddTimeLocation = new Select(addTimeLocation);
		selectAddTimeLocation.selectByVisibleText(data.get("addTimeLocation"));
		Select selectAddTimeJob = new Select(addTimeJob);
		selectAddTimeJob.selectByVisibleText(data.get("addTimeJob"));
		addTimeNotes.sendKeys(data.get("addTimeNotes"));
		addTimeRecordSaveBtn.click();
		try {

			String msg = successMsg.getText();
			System.out.println(msg);
		} catch (NoSuchElementException e) {
			try {
				String msg = tsOverlapMsg.getText();
				System.out.println(msg);
			} catch (NoSuchElementException i) {
				i.printStackTrace();
			}
		}

	}
	// Adding the Absence
	public void addTimeOff(Hashtable<String, String> data) {
		act = new Actions(driver);
		act.moveToElement(addTimeOffBtn).click().build().perform();
		Select selectEmpDrpDwn = new Select(absenceEmpDrpDwn);
		selectEmpDrpDwn.selectByVisibleText(data.get("emp"));
		Select selectAbsenceTypeDrpDwn = new Select(absenceTypeDrpDwn);
		selectAbsenceTypeDrpDwn.selectByVisibleText(data.get("absenceType"));
		absenceStDt.clear();
		absenceStDt.sendKeys(data.get("absenceStDt"));
		absenceEndDt.clear();
		absenceEndDt.sendKeys(data.get("absenceEndDt"));
		absenceStTime.clear();
		absenceStTime.sendKeys(data.get("absenceStTime"));
		absenceEndTime.clear();
		absenceEndTime.sendKeys(data.get("absenceEndTime"));
		Select selectAbsenceLocation = new Select(absenceLocation);
		selectAbsenceLocation.selectByVisibleText(data.get("absenceLocation"));
		Select selectAbsenceJob = new Select(absenceJob);
		selectAbsenceJob.selectByVisibleText(data.get("absenceJob"));
		absenceNotes.sendKeys(data.get("absenceNotes"));
		addAbsencesBtn.click();
		try {
			String msg = successMsg.getText();
			System.out.println(msg);
		} catch (NoSuchElementException e) {
			try {
				String msg = tsOverlapMsg.getText();
				System.out.println(msg);
			} catch (NoSuchElementException i) {
				i.printStackTrace();
			}
		}

	}
}
