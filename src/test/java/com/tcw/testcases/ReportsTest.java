package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.ReportsPage;

public class ReportsTest extends LogInTest {
	
	ReportsPage rp;
	
	public void pageSetup() {
		logIn();
		rp = new ReportsPage(driver);
	}
	
	@Test(priority=1)
	public void landingOnReportsPage() {
//		logIn();
//		rp = new ReportsPage(driver);
		pageSetup();
		String reportsTtl1 = rp.goToReportsPage();
		Assert.assertEquals(reportsTtl1, "Reports");
	}

	@Test(priority=2)
	public void viewStdTimesheet() {
//		logIn();
//		rp = new ReportsPage(driver);
		pageSetup();
		rp.goToReportsPage();
		String txt = rp.genStdTimesheet();
		Assert.assertEquals("Employee Name", txt);	
	}
	
	@Test(priority=3)
	public void viewDetailedTimesheet() {
//		logIn();
//		rp = new ReportsPage(driver);
		pageSetup();
		rp.goToReportsPage();
		String txt = rp.genDtdTimesheet();
		Assert.assertEquals("Employee Name", txt);
	}
	
	@Test(priority=4)
	public void viewPtoBank() {
//		logIn();
//		rp = new ReportsPage(driver);
		pageSetup();
		rp.goToReportsPage();
		String txt = rp.genPTOBanks();
		Assert.assertEquals("Employee Name", txt);
	}
	
	@Test(priority=5)
	public void viewEmpContactList() {
//		logIn();
//		rp = new ReportsPage(driver);
		pageSetup();
		rp.goToReportsPage();
		String txt = rp.genEmpContactList();
		Assert.assertEquals("Employee Name", txt);
	}
}
