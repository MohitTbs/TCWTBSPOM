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
	
	@FindBy(xpath="//*[text()='Future timesheets are not allowed.']")
	WebElement errorMsg1;

	Actions act;
	WebDriverWait wait;

	public TimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String tsPageHit() {
		toWait();
		return tsSrchText.getText();
	}

	public void addTimeRecord(Hashtable<String, String> data) {
		act = new Actions(driver);
		act.moveToElement(addTimeRecordBtn).click().build().perform();

		Select selectEmpDrpDwn = new Select(empDrpDwn);
		//System.out.println(data.get("emp"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(empDrpDwn));
		selectEmpDrpDwn.selectByVisibleText(data.get("emp"));
		clockInDt.clear();
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
				driver.switchTo().frame("//iframe[@class='footervideoiframe']");
				//wait.until(ExpectedConditions.textToBePresentInElement(errorMsg, "Future timesheets are not allowed."));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("jError")));
				//String msg = errorMsg.getText();
				//wait.until(ExpectedConditions.visibilityOf(errorMsg1));
				List<WebElement> noOfLinks =driver.findElements(By.id("jError"));
				System.out.println(noOfLinks.size());
				System.out.println("Future timesheets are not allowed.");
			} catch (NoSuchElementException i) {
				i.printStackTrace();
			}
		}

	}

}
