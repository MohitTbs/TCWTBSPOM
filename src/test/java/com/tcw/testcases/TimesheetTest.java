package com.tcw.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.DashboardPage;
import com.tcw.pages.TimesheetPage;
import com.tcw.utilities.DataUtil;

public class TimesheetTest extends LogInTest {

	DashboardPage dasp;
	TimesheetPage tp;

	// @Test(priority=1)
	public void tsPageHitTest() {
		logIn();
		dasp = new DashboardPage(driver);
		tp = new TimesheetPage(driver);
		dasp.goToTimesheetPage();
		String tsSrchText1 = tp.tsPageHit();
		Assert.assertEquals(tsSrchText1, "TIMESHEET SEARCH");
	}

	// Adding the Timesheet
	// @Test(priority = 2, dataProviderClass = DataUtil.class, dataProvider = "dp2")
	public void addTimeSheetTest(Hashtable<String, String> data) {
		logIn();
		dasp = new DashboardPage(driver);
		tp = new TimesheetPage(driver);
		dasp.goToTimesheetPage();
		tp.tsPageHit();
		tp.addTimeRecord(data);

	}

	// Adding the Absence
	@Test(priority = 3, dataProviderClass = DataUtil.class, dataProvider = "dp2")
	public void addAbsenceTest(Hashtable<String, String> data) {
		logIn();
		dasp = new DashboardPage(driver);
		tp = new TimesheetPage(driver);
		dasp.goToTimesheetPage();
		tp.tsPageHit();
		tp.addTimeOff(data);

	}

}
