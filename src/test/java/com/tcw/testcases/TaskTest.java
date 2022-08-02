package com.tcw.testcases;

import org.testng.annotations.Test;

import com.tcw.pages.TasksPage;
import com.tcw.utilities.DataUtil;

public class TaskTest extends LogInTest {

	TasksPage tp;

	@Test(priority=1,dataProviderClass=DataUtil.class, dataProvider="dp1")
	public void addTaskTest(String task, String description) {
		logIn();
		tp = new TasksPage(driver);
		String taskPageTtl1 = tp.goToTaskPage();
		System.out.println(taskPageTtl1);
		//Assert.assertEquals(taskPageTtl1, "Tasks");
		tp.addActualTask(task,description);

	}

}
