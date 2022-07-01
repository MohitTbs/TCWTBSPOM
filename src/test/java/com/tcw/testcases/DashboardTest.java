package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.DashboardPage;
import com.tcw.pages.PendingTimesheetRequestsPage;

public class DashboardTest extends LogInTest {

	DashboardPage dashp;
	PendingTimesheetRequestsPage ptr;

	@Test(priority = 1)
	public void addTaskTest() {

		logIn();

		dashp = new DashboardPage(driver);
		dashp.addTask();

	}

	@Test(priority = 2)
	public void goToPendingTimesheetReqTest() {
		logIn();
		System.out.println("hello error 1");
		ptr=new PendingTimesheetRequestsPage(driver);
		System.out.println("hello error 2");
		System.out.println(driver);
		dashp = new DashboardPage(driver);
		ptr=dashp.goToPendingTimesheetReq();
		System.out.println(driver);
		String tsReqSrchTtl1=ptr.tsReqSrchTtl.getText();
		Assert.assertEquals(tsReqSrchTtl1, "TIMESHEETS REQUEST SEARCH");
	}

}
