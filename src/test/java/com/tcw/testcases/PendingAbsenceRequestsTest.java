package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.DashboardPage;
import com.tcw.pages.PendingAbsenceRequestsPage;

public class PendingAbsenceRequestsTest extends LogInTest {

	PendingAbsenceRequestsPage par;
	DashboardPage dashp;

	@Test(priority = 1)
	public void timesheetRequestListTest() {
		logIn();
		dashp = new DashboardPage(driver);

		par = new PendingAbsenceRequestsPage(driver);
		par = dashp.goToPendingAbsenceRequestsPage();
		String abReqLstTtl1 = par.absenceReqList();
		Assert.assertEquals(abReqLstTtl1, "Name");

	}
}
