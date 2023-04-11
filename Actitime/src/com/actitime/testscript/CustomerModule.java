package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;

@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass {
	@Test
	public void testCreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		FileLib f = new FileLib();
		String custName = f.getExcelData("CreateCustomer", 1, 3);
		String custDesc = f.getExcelData("CreateCustomer", 1, 4);
		HomePage h = new HomePage(driver);
		h.setTasks();
		TaskListPage t = new TaskListPage(driver);
		t.setAddNew();
		t.setNewCustomer();
		t.setCustomerName(custName);
		t.setCustomerDescription(custDesc);
		t.setSelectCustomerDD();
		t.setOurCompany();
		t.setCreateCustomer();
		wait.until(ExpectedConditions.invisibilityOf(t.getPopup()));
		String actualData = t.getActualCustomerName().getText();
		Assert.assertEquals(actualData, custName);

	}
}
