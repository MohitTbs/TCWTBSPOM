package com.tcw.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class EmployeePage extends BasePage {

	@FindBy(xpath = "//span[@class='sidebar_menu_link' and contains(text(),'Employee')]")
	WebElement empLnk;

	@FindBy(xpath="//div[@id='site_name']//h1")
	WebElement empTtl;
	
	@FindBy(id="add_setting_link")
	WebElement globalSettingBtn;
	
	@FindBy(xpath="//div[@class='sel check_sel']/input")
	List<WebElement> clockInOutCheckBx;
	
	@FindBy(id="SMSEmailAlerts")
	WebElement notificationsTab;
	
	@FindBy(xpath="//div[@class='check_inform check_sel']/input[@name='ReceiveNotification']")
	List<WebElement> notificationCheckBx1;
	
	@FindBy(xpath="//div[@class='sel check_sel']/input[@class='checkbox smsEmailAlert emailAlert']")
	List<WebElement> notificationCheckBx2;
	
	@FindBy(xpath="//div[@class='col-md-6 col-sm-12']/input[@class='checkbox emailAlert']")
	List<WebElement> notificationCheckBx3;
	
	@FindBy(id="ClockPoints")
	WebElement clockPointsTab;
	
	@FindBy(xpath="//div[@class='title ml-sm-2']/input")
	WebElement clockPointNewUserCheckBx;
	
	@FindBy(xpath="//input[@name='ClockPointRestriction']")
	List<WebElement> clockPointRestCheckBx;
	
	@FindBy(id="Payroll")
	WebElement payrolLTab;
	
	@FindBy(xpath="//div[@class='col-sm-12']//input[1]")
	WebElement includeWagesCheckBx;
	
	@FindBy(xpath="//div[@class='one_check_permis']//input[@type='radio' and @name='PayEmployeesForBreaks']")
	List<WebElement> paidBreakCheckBx;
	
	@FindBy(xpath="//input[@name='TimeRounding']")
	List<WebElement> timeRoundingCheckBx;
	
	@FindBy(xpath="//input[@name='AllowOverTime']")
	List<WebElement> overtimeInfoCheckBx;
	
	@FindBy(id="Reimbursement")
	WebElement reimbursementTab;
	
	@FindBy(id="checkboxUpload")
	WebElement upoadCheckBx;
	
	@FindBy(id="GlobalPTO")
	WebElement ptoTab;
	
	@FindBy(id="dvGlobalPTOAbsencesName")
	List<WebElement> ptoNames;
	
	@FindBy(id="Schedule")
	WebElement scheduleTab;
	
	@FindBy(id="checkboxWeekly")
	WebElement weeklyCheckBx;
	
	@FindBy(id="checkboxMonthly")
	WebElement monthlyCheckBx;
	
	
	public EmployeePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String goToEmployeePage() {
		empLnk.click();
		toWait();
		return empTtl.getText();
	}
	
	// Global Setting Testing
	public void globalSettingTesting() {
		
		Actions act = new Actions(driver);
		act.moveToElement(globalSettingBtn).click().build().perform();
		getTheCheckBoxes(clockInOutCheckBx);

		//Notifications		
		act.moveToElement(notificationsTab).click().build().perform();
		System.out.println(notificationCheckBx1.size()+" "+notificationCheckBx2.size()+" "+notificationCheckBx3.size());
		
//		notificationCheckBx1.addAll(notificationCheckBx2);
//		notificationCheckBx1.addAll(notificationCheckBx3);
//		notificationCheckBx1.add(notificationCheckBx2.get(0));
//		notificationCheckBx1.add(notificationCheckBx2.get(1));
		
		//System.out.println(b1+" "+b2);
		

		getTheCheckBoxes(notificationCheckBx1);
		getTheCheckBoxes(notificationCheckBx2);
		getTheCheckBoxes(notificationCheckBx3);
		
		
		act.moveToElement(clockPointsTab).click().build().perform();
		getTheCheckBoxesSing(clockPointNewUserCheckBx);
		getTheCheckBoxes(clockPointRestCheckBx);
		
		
		act.moveToElement(payrolLTab).click().build().perform();
		getTheCheckBoxesSing(includeWagesCheckBx);
		getTheCheckBoxes(paidBreakCheckBx);
		getTheCheckBoxes(timeRoundingCheckBx);
		getTheCheckBoxes(overtimeInfoCheckBx);
		
		act.moveToElement(reimbursementTab).click().build().perform();
		getTheCheckBoxesSing(upoadCheckBx);
		
		act.moveToElement(ptoTab).click().build().perform();;
		getTheNames(ptoNames);
		
		act.moveToElement(scheduleTab).click().build().perform();
		getTheCheckBoxesSing(weeklyCheckBx);
		getTheCheckBoxesSing(monthlyCheckBx);
	}
	
	
	
	
	
	
	public void getTheCheckBoxes(List<WebElement> li) {
		for(WebElement e:li) {
			
			log.info(e.getAttribute("name"));
			log.info(e.isSelected());
			System.out.println(e.getAttribute("name"));
			System.out.println(e.isSelected());
		}
	}
	
	public void getTheCheckBoxesSing(WebElement e) {
		
			
			log.info(e.getAttribute("name"));
			log.info(e.isSelected());
			System.out.println(e.getAttribute("name"));
			System.out.println(e.isSelected());
		
	}
	
	public void getTheNames(List<WebElement> li) {
		for(WebElement e : li) {
			String name=e.getText();
			log.info(name);
			System.out.println(name);
		}
	}
	
	
	
}
