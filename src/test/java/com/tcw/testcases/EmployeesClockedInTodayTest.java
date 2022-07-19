package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.DashboardPage;
import com.tcw.pages.EmployeesClockedInTodayPage;

public class EmployeesClockedInTodayTest extends LogInTest{

	DashboardPage dasp;
	EmployeesClockedInTodayPage ectp;
	
	@Test(priority=1)
	public void timesheetSrchTest() {
		logIn();
		dasp = new DashboardPage(driver);
		ectp = new EmployeesClockedInTodayPage(driver);
		ectp=dasp.goToEmployeesClockedInTodayPage();
		String timesheetText1=ectp.timesheetSrch();
		Assert.assertEquals(timesheetText1, "TIMESHEET SEARCH");
		
	}
	
}
