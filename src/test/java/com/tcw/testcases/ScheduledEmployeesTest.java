package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.DashboardPage;
import com.tcw.pages.ScheduledEmployeesPage;

public class ScheduledEmployeesTest extends LogInTest {
	
	DashboardPage dashp;
	ScheduledEmployeesPage scp;
	
	@Test(priority=1)
	public void daySchTest() {
		logIn();
		dashp = new DashboardPage(driver);
		scp = new ScheduledEmployeesPage(driver);
		scp=dashp.goToScheduledEmployeesPage();
		String sxheduleText1=scp.daySchTest();
		Assert.assertEquals(sxheduleText1, "Schedule");
		
		
	}
	

}
