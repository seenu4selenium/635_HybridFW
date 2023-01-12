package com.testscenarios;

import org.testng.annotations.Test;

import com.utilities.CommonFunctions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class CLG extends CommonFunctions {

	@BeforeClass
	public void beforeClass() {
		chromeBrowserLaunch();
	}

	@Test
	public void f() throws Exception {
		driver.get("https://collegeweeklive.com/go-signup/");
		// Thread.sleep(30000);
		// Thread.sleep will wait until given max time, even though element is displayed
		// with in the time

		// implicit wait: will wait until given max time, if the element is displayed
		// with in the time
		// next second it will go to next line of code for execution
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Check submit Button is clickable? wait few seconds...
		// explicit wait:
		WebDriverWait ww = new WebDriverWait(driver, Duration.ofSeconds(30));
		ww.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
		

		sendKeysByAnyLocator(By.id("firstName"), "FirstName");

	}

	@AfterMethod
	public void afterMethod() {

	}

	@AfterClass
	public void afterClass() {

	}

}
