package com.actitime.pom;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {
	
	@FindBy(xpath = "//div[text()='Add New']")
	private WebElement addNew;

	@FindBy(xpath = "//div[text()='+ New Customer']")
	private WebElement newCustomer;

	@FindBy(xpath = "//input[@placeholder='Enter Customer Name' and @class='inputFieldWithPlaceholder newNameField inputNameField']")
	private WebElement customerName;

	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement customerDescription;

	@FindBy(xpath = "//div[text()='- Select Customer -' and @class='emptySelection']")
	private WebElement selectCustomerDD;

	@FindBy(xpath = "//div[@class='comboboxButton focused']//input")
	private WebElement ourCompany;

	@FindBy(xpath = "//div[text()='Create Customer']")
	private WebElement createCustomer;

	@FindBy(xpath = "//div[@class='titleEditButtonContainer']/div[1]")
	private WebElement actualCustomerName;

	@FindBy(id = "customerLightBox_content")
	private WebElement popup;

	@FindBy(xpath = "//div[text()='+ New Project']")
	private WebElement newProject;

	@FindBy(xpath = "//input[@placeholder='Enter Project Name' and @class='projectNameField inputFieldWithPlaceholder inputNameField' ]")
	private WebElement projectName;

	@FindBy(xpath = "//div[text()='-- Please Select Customer to Add Project for  --']")
	private WebElement selectCustomerToProjectDD;

	@FindBy(xpath = "(//input[@type='text' and @value])[2]")
	private WebElement SelectCustomer;

	@FindBy(xpath = "//span[text()='HDFC']")
	private WebElement customerNameclick;

	@FindBy(xpath = "//textarea[@placeholder='Add Project Description']")
	private WebElement projectDescription;

	@FindBy(xpath = "(//input[@class='inputFieldWithPlaceholder' and @type='text'])[1]")
	private WebElement taskName;

	@FindBy(xpath = "//div[text()='Create Project']")
	private WebElement createProject;

	@FindBy(xpath = "//div[@class='leftContainer']/div/div[1]")
	private WebElement actualProjectName;

	@FindBy(id = "createProjectPopup")
	private WebElement projectPopup;

	@FindBy(xpath = "//div[text()='+ New Tasks']")
	private WebElement newTask;

	@FindBy(xpath = "//tr[@class='selectCustomerRow']//div[@class='selectedItem']")
	private WebElement selectCustomerDDTask;

	@FindBy(xpath = "(//tr[@class='selectCustomerRow']//input)[1]")
	private WebElement SelectCustomerSendKeysTask;

	@FindBy(xpath = "//span[text()='Chandan']")
	private WebElement selectCustomerClickTask;

	@FindBy(xpath = "(//div[text()='- New Project -'][1])[1]")
	private WebElement selectProjectDDTask;

	@FindBy(xpath = "//tr[@class='selectProjectRow projectSelectorRow']//input")
	private WebElement selectProjectSendkeysTask;

	@FindBy(xpath = "//span[text()='Banking']")
	private WebElement selectProjectClick;

	@FindBy(xpath = "(//td[@class='nameCell first']//input[@class='inputFieldWithPlaceholder'])[4]")
	private WebElement taskNameTask;

	@FindBy(xpath = "//div[text()='Create Tasks']")
	private WebElement createTask;

	public TaskListPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public void setAddNew() {
		addNew.click();
	}

	public void setNewCustomer() {
		newCustomer.click();

	}

	public void setCustomerName(String custName) {
		customerName.sendKeys(custName);
	}

	public void setCustomerDescription(String custDescription) {
		customerDescription.sendKeys(custDescription);
	}

	public void setSelectCustomerDD() {
		selectCustomerDD.click();

	}

	public void setOurCompany() {
		ourCompany.sendKeys("Our company");

	}

	public void setCreateCustomer() {
		createCustomer.click();
	}

	public String setActualCustomerName() {
		return actualCustomerName.getText();
	}

	public WebElement getActualCustomerName() {
		return actualCustomerName;
	}

	public WebElement getPopup() {
		return popup;
	}

	public WebElement getAddNew() {
		return addNew;
	}

	public WebElement getNewProject() {
		return newProject;
	}

	public WebElement getProjectName() {
		return projectName;
	}

	public WebElement getSelectCustomerToProjectDD() {
		return selectCustomerToProjectDD;
	}

	public WebElement getSelectCustomer() {
		return SelectCustomer;
	}

	public WebElement getProjectDescription() {
		return projectDescription;
	}

	public WebElement getTaskName() {
		return taskName;
	}

	public WebElement getCreateProject() {
		return createProject;
	}

	public WebElement getCustomerNameclick() {
		return customerNameclick;
	}

	public WebElement getActualProjectName() {
		return actualProjectName;
	}

	public WebElement getProjectPopup() {
		return projectPopup;
	}

	public WebElement getNewTask() {
		return newTask;
	}

	public WebElement getSelectCustomerDDTask() {
		return selectCustomerDDTask;
	}

	public WebElement getSelectCustomerSendKeysTask() {
		return SelectCustomerSendKeysTask;
	}

	public WebElement getSelectCustomerClickTask() {
		return selectCustomerClickTask;
	}

	public WebElement getSelectProjectDDTask() {
		return selectProjectDDTask;
	}

	public WebElement getSelectProjectSendkeysTask() {
		return selectProjectSendkeysTask;
	}

	public WebElement getSelectProjectClick() {
		return selectProjectClick;
	}

	public WebElement getTaskNameTask() {
		return taskNameTask;
	}

	public WebElement getCreateTask() {
		return createTask;
	}

}
