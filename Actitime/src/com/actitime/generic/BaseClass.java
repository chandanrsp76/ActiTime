package com.actitime.generic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pom.HomePage;
import com.actitime.pom.LoginPage;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");

	}
	public WebDriver driver;
	public   WebDriverWait wait;

	@org.testng.annotations.Parameters("browser")
	@BeforeTest
	public void openBrowser(String browser) {
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("msedge")) {
			// driver=new FirefoxDriver();
			driver = new EdgeDriver();
		}
		//driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

	@BeforeMethod
	public void login() throws IOException {
		FileLib f = new FileLib();
		String ur = f.getPropertyData("url");
		String un = f.getPropertyData("username");
		String pw = f.getPropertyData("password");
		driver.get(ur);
		LoginPage l = new LoginPage(driver);
		l.setLogin(un, pw);
	}

	@AfterMethod
	public void logout(){
		HomePage h = new HomePage(driver);
		h.setLogOut();
		
	}
}
