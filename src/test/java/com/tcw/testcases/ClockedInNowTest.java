package com.tcw.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tcw.pages.ClockedInNowPage;
import com.tcw.pages.DashboardPage;

public class ClockedInNowTest extends LogInTest{

	DashboardPage dashp;
	ClockedInNowPage cinp;
	
	
	@Test(priority=1)
	public void clockedInNowTest() {
		logIn();
		dashp = new DashboardPage(driver);
		cinp = new ClockedInNowPage(driver);
		cinp=dashp.goToClockedInNowPage();
		String scheduleText1 = cinp.clockInNow();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(scheduleText1, "Schedule");
		String schedule1Text1 = cinp.notClockIn();
		sa.assertEquals(schedule1Text1, "Schedule");
	
		sa.assertAll();
	}
	
}
