package com.tcw.testcases;

import org.testng.annotations.Test;

import com.tcw.base.BasePage;
import com.tcw.base.BaseTest;
import com.tcw.pages.DashboardPage;

public class addTaskFromDashboardTest extends LogInTest {
	
	LogInTest lit;
	DashboardPage dashp;
	@Test(priority=1)
	public void addTaskTest() {
		System.out.println("Again opening the chrome browser");
		logIn();
		System.out.println("gOing to click on the task");
		dashp = new DashboardPage(driver);
		dashp.addTask();
		

		
	}

}
