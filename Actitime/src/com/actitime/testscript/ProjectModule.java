package com.actitime.testscript;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;

@Listeners(com.actitime.generic.ListenerImplementation.class)
public class ProjectModule extends BaseClass {
	@Test
	public void testCreateNewproject() throws EncryptedDocumentException, IOException, InterruptedException {
		FileLib f = new FileLib();
		String customerName = f.getExcelData("CreateCustomer", 1, 3);
		String projectname = f.getExcelData("CreateNewProject", 1, 3);
		String projectdecription = f.getExcelData("CreateNewProject", 1, 4);
		String taskname = f.getExcelData("CreateNewProject", 1, 5);
		HomePage h = new HomePage(driver);
		h.setTasks();
		TaskListPage t = new TaskListPage(driver);
		t.getAddNew().click();
		t.getNewProject().click();
		t.getProjectName().sendKeys(projectname);
		t.getSelectCustomerToProjectDD().click();
		t.getSelectCustomer().sendKeys(customerName);
		t.getCustomerNameclick().click();
		t.getProjectDescription().sendKeys(projectdecription);
		t.getTaskName().sendKeys(taskname);
		t.getCreateProject().click();
		wait.until(ExpectedConditions.invisibilityOf(t.getProjectPopup()));
		String actualProjectName = t.getActualCustomerName().getText();
		assertEquals(actualProjectName, projectname);

	}
}
