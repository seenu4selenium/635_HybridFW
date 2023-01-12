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

public class ClassTemple extends CommonFunctions {

	@BeforeClass
	public void beforeClass() {
		chromeBrowserLaunch();
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		takeScreenshot();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void f() throws Exception {
		// Devlope the code from here

	}

}
