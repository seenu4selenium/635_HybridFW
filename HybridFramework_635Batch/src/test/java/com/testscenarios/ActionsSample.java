package com.testscenarios;

import org.testng.annotations.Test;

import com.utilities.CommonFunctions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class ActionsSample extends CommonFunctions {

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

	//@Test
	public void tc01() throws Exception {
		getURL("ActionsURL");
		//Create actions class reference to use inbuilt method in our current class
		doubleClick(loc.Act_Guru99_DoubleClick);
		alertHandleByAccept();
		
		//Do right click
		mouseHoverContextClick(loc.Act_Guru99_RightClick);

	}

	@Test
	public void tc02() throws Exception {
		getURL("Guru99ActionURL");
		dragandDrop(loc.Act_Guru99_BankButton, loc.Act_Guru99_BankTargetLocation);
		dragandDrop(loc.Act_Guru99_SalesButton, loc.Act_Guru99_SalesTargetLocation);
		dragandDrop(loc.Act_Guru99_500Amount, loc.Act_Guru99_500AmountTarget1);
		dragandDrop(loc.Act_Guru99_500Amount, loc.Act_Guru99_500AmountTarget2);

	}
}
