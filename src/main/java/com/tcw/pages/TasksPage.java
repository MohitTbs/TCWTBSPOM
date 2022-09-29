package com.tcw.pages;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class TasksPage extends BasePage {

	@FindBy(xpath = "//span[@class='sidebar_menu_link' and text()='Tasks']")
	public WebElement goToTaskPageLnk;

	@FindBy(xpath = "//*[@id='site_name']//h1")
	public WebElement taskPageTtl;

	@FindBy(id = "btnnew")
	public WebElement addTaskBtn;

	@FindBy(id = "txtTaskName")
	public WebElement taskNameBx;

	@FindBy(xpath = "//input[@value='Select Employee']")
	public WebElement empDrpDwn;

	@FindBy(xpath = "//li[@class='active-result']")
	public List<WebElement> empSelList;

	@FindBy(xpath = "(//span[@class='input-group-addon'])[2]")
	public WebElement dueDate;

	@FindBy(id = "TaskNote")
	public WebElement descriptionBx;

	@FindBy(id = "btn_saveTask")
	public WebElement saveBtn;
	
	@FindBy(xpath="(//div[@class='sel']//a[contains(text(),'Close')])[1]")
	public WebElement closeBtn;
	
	@FindBy(id="jSuccess")
	public WebElement succMsg;

	Actions act;

	public TasksPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String goToTaskPage() {
		goToTaskPageLnk.click();
		return taskPageTtl.getText();

	}
	//Adding the Task
	public String addActualTask(Hashtable<String,String> data) {
		toWait();
		act = new Actions(driver);
		act.moveToElement(addTaskBtn).click().build().perform();
		taskNameBx.sendKeys(data.get("task"));
		empDrpDwn.click();
		for (WebElement emp : empSelList) {
			if (emp.getText().equalsIgnoreCase(data.get("emp"))) {
				emp.click();
				break;
			}
		}
		dueDate.click();
		descriptionBx.sendKeys(data.get("description"));
		
		saveBtn.click();
		
		try {
			return succMsg.getText();
			
			
		}catch(NoSuchElementException e) {
			return null;
		}
		
		

	}
}
