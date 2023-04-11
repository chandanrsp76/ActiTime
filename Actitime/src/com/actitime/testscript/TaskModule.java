package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;

@Listeners(com.actitime.generic.ListenerImplementation.class)
public class TaskModule extends BaseClass {
	@Test
	public void testCreateNewTask() throws EncryptedDocumentException, IOException {
		FileLib f = new FileLib();
		String custname = f.getExcelData("CreateNewTask", 1, 5);
		String projectname = f.getExcelData("CreateNewTask", 1, 4);
		String taskname = f.getExcelData("CreateNewTask", 1, 6);
		HomePage h = new HomePage(driver);
		h.setTasks();
		TaskListPage t = new TaskListPage(driver);
		t.getAddNew().click();
		t.getNewTask().click();
		t.getSelectCustomerDDTask().click();
		t.getSelectCustomerSendKeysTask().sendKeys(custname);
		t.getSelectCustomerClickTask().click();
		t.getSelectProjectDDTask().click();
		t.getSelectProjectSendkeysTask().sendKeys(projectname);
		t.getSelectProjectClick().click();
		t.getTaskName().sendKeys(taskname);
		t.getCreateTask().click();
	}
}
