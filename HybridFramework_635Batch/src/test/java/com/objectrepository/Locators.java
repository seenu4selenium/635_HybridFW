package com.objectrepository;

import org.openqa.selenium.By;

//Here QA will store Application locators
public class Locators {

	// FaceBook locators
	// public final By Pagename_WebElementName_ElementType = By.id("email");

	public final By fblogin_Email_EditBox = By.id("email");
	public final By fblogin_Password_EditBox = By.id("pass");
	public final By fblogin_Login_Button = By.name("login");
	
//	JRI locators
	
	
	//TS echallan
	public final By TS_VehicleNo  = By.id("REG_NO");
	public final By TS_Cpatcha = By.id("captchatab1");
	public final By TS_GoButton = By.id("tab1btn");
	
	
	
	public final By Clg_terms = By.linkText("terms & conditions");
	public final By Clg_Submit =  By.id("submit");
	
	
	
}
