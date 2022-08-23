package com.tcw.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.SchedulePage;
import com.tcw.utilities.DataUtil;

public class ScheduleTest extends LogInTest {

	SchedulePage sp;

	//@Test(priority = 1)
	public void landingOnSchedulePage() {

		logIn();
		sp = new SchedulePage(driver);
		String schdTtl1 = sp.goToSchedulePage();
		Assert.assertEquals(schdTtl1, "Schedule");

	}

	@Test(priority = 2, dataProviderClass = DataUtil.class, dataProvider = "dp2")
	public void addScheduleForEmpTest(Hashtable<String, String> data) {
		logIn();
		sp = new SchedulePage(driver);
		sp.goToSchedulePage();
		String msg = sp.addScheduleForEmp(data);
		System.out.println("After msg: "+msg);
		try {
			Assert.assertEquals(msg, "Information saved successfully.");

		} catch (Throwable t) {
			Assert.assertEquals(msg, "SCHEDULE OVERLAP !! !!");
		}
	}

	@Test(priority = 3, dataProviderClass = DataUtil.class, dataProvider = "dp2")
	public void deleteScheduleForEmpTest(Hashtable<String, String> data) {
		logIn();
		sp = new SchedulePage(driver);
		sp.goToSchedulePage();
		sp.deleteScheduleForEmp(data);
	}

}
