package com.testscenarios;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.CommonFunctions;

public class JRI_AddMobile extends CommonFunctions{
	

	@Test
	public void addmobile() throws Exception {
		// Read the test data from property file
		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\testdata\\QA_TD.properties");
		prop.load(fi);
		

		// Click on Add mobile number link
		driver.findElement(By.id("divLnkAddMobile")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("txtpopMobileNo")).sendKeys("9685741203");
		Thread.sleep(3000);
		// By default Service provider will come based on the mobule number
		// User has to change the service provider (choose another provider)
		new Select(driver.findElement(By.name("ddlpopMobileSP"))).selectByVisibleText("Jio");
		Thread.sleep(3000);
		driver.findElement(By.id("txtpopMobileNickname")).sendKeys("testUser");
		// Check the Location element is displayed or not?
		if (driver.findElements(By.name("ddlpopMobileLocation")).size() > 0) {
			System.out.println(" Location element is displayed");
			new Select(driver.findElement(By.name("ddlpopMobileLocation"))).selectByVisibleText("Assam");
		} else {
			System.out.println(" Location element is NOT displayed, check the locator properly");
		}

	}
}
