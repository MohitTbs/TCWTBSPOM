package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.TasksPage;

public class TaskTest extends LogInTest {

	TasksPage tp;

	@Test(priority = 1)
	public void addTaskTest() {
		logIn();
		tp = new TasksPage(driver);
		String taskPageTtl1 = tp.goToTaskPage();
		System.out.println(taskPageTtl1);
		//Assert.assertEquals(taskPageTtl1, "Tasks");
		tp.addActualTask();

	}

}
