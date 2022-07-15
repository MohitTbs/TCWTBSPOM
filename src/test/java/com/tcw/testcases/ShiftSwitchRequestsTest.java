package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tcw.pages.DashboardPage;
import com.tcw.pages.ShiftSwitchRequestsPage;

public class ShiftSwitchRequestsTest extends LogInTest {

	DashboardPage dashp;
	ShiftSwitchRequestsPage ssrp;

	@Test(priority = 1)
	public void switchScheduleReqTest() {
		logIn();
		dashp = new DashboardPage(driver);
		ssrp = new ShiftSwitchRequestsPage(driver);
		ssrp = dashp.goToShiftSwitchRequestsPage();
		String switchScheduletTtl1 = ssrp.switchReqFromMeLst();
		// Assert.assertEquals(switchScheduletTtl1, "Switch schedule");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(switchScheduletTtl1, "Switch schedule");
		String switchScheduletToMeDt1 = ssrp.switchReqToMeLst();
		sa.assertEquals(switchScheduletToMeDt1, "Date");
		String switchScheduletToMeStart1 = ssrp.allEmpSwitchReqLst();
		sa.assertEquals(switchScheduletToMeStart1, "Start");
		sa.assertAll();
	}

}
