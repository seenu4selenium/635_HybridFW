package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.CommonFunctions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;

public class FB_Login extends CommonFunctions {	

	@BeforeTest
	public void url() {
		chromeBrowserLaunch();
	}

	@Test
	public void f() throws IOException, Exception {		

		getURL("FB_URL");
		sendKeysByAnyLocator(loc.fblogin_Email_EditBox, "Username");
		sendKeysByAnyLocator(loc.fblogin_Password_EditBox, "Passowrd");
		clickByAnyLocator(loc.fblogin_Login_Button);	
		implicitWait(10);
		
		// Verify the given fb credentials are valid / invalid
		if (driver.findElements(By.linkText("Find your account and log in.")).size() > 0) {
			System.out.println("given fb credentials are in-valid");
		} else {
			System.out.println("given fb credentials are valid");
		}
		

	}

	@AfterMethod
	public void afterMethod() throws Exception {		
		takeScreenshot();
	}

	@AfterClass
	public void afterClass() {
		// Close browser
		 driver.quit();
	}

}
