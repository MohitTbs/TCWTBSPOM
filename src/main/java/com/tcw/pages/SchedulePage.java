package com.tcw.pages;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.tcw.base.BasePage;

public class SchedulePage extends BasePage {

	@FindBy(xpath = "//span[@class='sidebar_menu_link' and contains(text(),'Schedule')]")
	WebElement schdLnk;

	@FindBy(xpath = "//div[@id='site_name']//h1")
	WebElement schdTtl;

	@FindBy(xpath = "//div[@class='fc-bg']//td[@data-date]")
	List<WebElement> multipleDates;

	@FindBy(xpath = "//a[contains(text(),'Add schedule')]")
	WebElement addSchBtn;

	@FindBy(xpath = "//ul[@class='chosen-choices']")
	WebElement empDrpDwn;

	@FindBy(xpath = "//li[@class='active-result']")
	List<WebElement> empDrpDwnLst;

	@FindBy(xpath = "//li[@class='search-choice'][1]//a")
	WebElement selectedEmpCloseBtn;

	@FindBy(id = "txtScheduleFromTime")
	WebElement stTime;

	@FindBy(id = "txtScheduleToTime")
	WebElement endTime;

	@FindBy(id = "ddlScheduleLocation")
	WebElement locDrpDwn;

	@FindBy(id = "ddlSchedulePosition")
	WebElement jobDrpDwn;

	@FindBy(id = "Pricerate")
	WebElement customPay;

	@FindBy(id = "Comment")
	WebElement Notes;

	@FindBy(id = "PesonalNote")
	WebElement PesonalNote;

	@FindBy(xpath = "//div[@class='col-xs-12']//a[text()='Save']")
	WebElement saveBtn;

	@FindBy(id = "jSucces")
	WebElement successMsg;

	@FindBy(xpath = "//h4[@class='modal-title warning']")
	WebElement errorMsg;

	@FindBy(xpath = "//div[@class='userNamee-month pull-left']")
	List<WebElement> editEmpList;

	@FindBy(xpath = "//div[@class='block_one_pep ']/div[1]/h5")
	List<WebElement> editEmpListContent;

	@FindBy(xpath = "//a[contains(@onclick,'confirmDeleteShift')]")
	WebElement deleteSch;

	@FindBy(id = "aSYesConfirm")
	WebElement onlyThisInstanceBtn;
	
	@FindBy(id = "jSucces")
	List<WebElement> successMsgList;

	public SchedulePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String goToSchedulePage() {
		schdLnk.click();
		toWait();
		return schdTtl.getText();
	}
	// Adding the Schedule
	public String addScheduleForEmp(Hashtable<String, String> data) {
		Actions act = new Actions(driver);
		for (WebElement singleDate : multipleDates) {
			String singleDateTxt = singleDate.getAttribute("data-date");
			if (singleDateTxt.equalsIgnoreCase(data.get("desiredDate"))) {
				act.moveToElement(singleDate).click().build().perform();
				break;
			}

		}
		addSchBtn.click();
		empDrpDwn.click();

		for (WebElement singleEmp : empDrpDwnLst) {
			String singleEmpTxt = singleEmp.getText();
			if (singleEmpTxt.equalsIgnoreCase(data.get("desiredEmp"))) {
				singleEmp.click();
				selectedEmpCloseBtn.click();
				break;
			}
		}

		stTime.clear();
		stTime.sendKeys(data.get("stTime"));
		endTime.clear();
		endTime.sendKeys(data.get("endTime"));
		Select selectLocDrpDwn = new Select(locDrpDwn);
		selectLocDrpDwn.selectByVisibleText(data.get("locDrpDwn"));
		Select selectJobDrpDwn = new Select(jobDrpDwn);
		selectJobDrpDwn.selectByVisibleText(data.get("jobDrpDwn"));
		customPay.sendKeys(data.get("customPay"));
		Notes.sendKeys(data.get("Notes"));
		PesonalNote.sendKeys(data.get("PesonalNote"));
		act.moveToElement(saveBtn).click().build().perform();
		System.out.println(successMsgList.size());
		try {
			//wait.until(ExpectedConditions.visibilityOf(successMsg));
			return successMsg.getAttribute("innerHTML");
		} catch (Throwable e) {
			return errorMsg.getText();
		}
		
	}
	//Deleting the Schedule
	public void deleteScheduleForEmp(Hashtable<String, String> data) {
		Actions act = new Actions(driver);
		for (WebElement singleDate : multipleDates) {
			String singleDateTxt = singleDate.getAttribute("data-date");
			if (singleDateTxt.equalsIgnoreCase(data.get("desiredDate"))) {
				act.moveToElement(singleDate).click().build().perform();
				break;
			}

		}
		int no = 0;
		for (WebElement editEmpListSingle : editEmpList) {
			// System.out.println(editEmpListSingle.getText());
			// System.out.println(editEmpListSingle.getAttribute("innerHTML"));
			if (editEmpListSingle.getAttribute("innerHTML").equalsIgnoreCase(data.get("desiredEmp"))) {
				//System.out.println("Desired Emp"+data.get("desiredEmp"));
				act.moveToElement(editEmpListContent.get(no)).click().build().perform();
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Inside If");
				break;
			}
			no++;
		}
		wait.until(ExpectedConditions.elementToBeClickable(deleteSch));
		act.moveToElement(deleteSch).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(onlyThisInstanceBtn));
		onlyThisInstanceBtn.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
