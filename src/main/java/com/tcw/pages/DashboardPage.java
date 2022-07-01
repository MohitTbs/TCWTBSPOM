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

}
