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

public class JRI_Recharge extends CommonFunctions{	

	@Test
	public void login() throws Exception {
		// Read the test data from property file
		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\testdata\\QA_TD.properties");
		prop.load(fi);

		chromeBrowserLaunch();
		driver.get(prop.getProperty("JRI_SIGN_URL"));
		driver.findElement(By.id("txtUserName")).sendKeys(prop.getProperty("JRI_Username"));
		driver.findElement(By.id("txtPasswd")).sendKeys(prop.getProperty("JRI_Passowrd"));
		// wait statement
		Thread.sleep(5000);
		// To retrive the console data, will use Scanner class

		// Create an object for existing java class[scanner]
		// CLASSNAME referenceName = new CLASSSNAME();
		Scanner s = new Scanner(System.in);
		driver.findElement(By.id("txtCaptcha")).sendKeys(s.next());

		driver.findElement(By.id("imgbtnSignin")).click();
		Thread.sleep(5000);

//		//Popup handle
//		clickByAnyLocator(loc.JRI_Directory_Recharge);
//		clickByAnyLocator(loc.JRI_Directory_ViewPopularRechargesLink);
//		
//		navigateToPopupWindow();
//		//click on 649 link in popup window
//		clickByAnyLocator(loc.JRI_Directory_649Link);
		
		//Delete one mobile row from directory table
		clickByAnyLocator(loc.JRI_Directory_DeleteIconForRow5);
		Thread.sleep(3000);
		//alertHandleByDismiss();//To click on Cancle button on alert
		alertHandleByAccept();//To click on Ok button on alert

	}
}
