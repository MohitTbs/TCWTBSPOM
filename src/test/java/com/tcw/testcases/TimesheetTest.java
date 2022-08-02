package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.DashboardPage;
import com.tcw.pages.TimesheetPage;

public class TimesheetTest extends LogInTest{
	
	DashboardPage dasp;
	TimesheetPage tp;
	
	@Test(priority=1)
	public void tsPageHitTest() {
		logIn();
		dasp = new DashboardPage(driver);
		tp = new TimesheetPage(driver);
		dasp.goToTimesheetPage();
		String tsSrchText1 = tp.tsPageHit();
		Assert.assertEquals(tsSrchText1, "TIMESHEET SEARCH");
	}

}
