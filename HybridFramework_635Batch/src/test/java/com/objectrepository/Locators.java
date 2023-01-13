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
	
	
	public final By JRI_Directory_Recharge = By.id("listingtable_ImgRecharge_4");
	public final By JRI_Directory_ViewPopularRechargesLink = By.id("lnkPopularRecharge");
	public final By JRI_Directory_649Link = By.linkText("649");	
	public final By JRI_Directory_DeleteIconForRow5 = By.id("listingtable_btnGridDelete_5");
	

	//TS echallan
	public final By TS_VehicleNo  = By.id("REG_NO");
	public final By TS_Cpatcha = By.id("captchatab1");
	public final By TS_GoButton = By.id("tab1btn");
	
	
	
	public final By Clg_terms = By.linkText("terms & conditions");
	public final By Clg_Submit =  By.id("submit");
	
	public final By Popup_NewWndw =  By.xpath("/html/body/div[1]/div/div[2]/a[2]/button");
	public final By Popup_NewMsgWndw =  By.xpath("/html/body/div[1]/div/div[2]/a[3]/button");
	
	public final By Act_Guru99_DoubleClick =  By.xpath("//*[@id='authentication']/button");
	public final By Act_Guru99_RightClick =  By.xpath("//*[@id='authentication']/span");
	public final By Act_Guru99_500Amount =  By.xpath("//*[@id='fourth']/a");
	public final By Act_Guru99_500AmountTarget1 =  By.xpath("//*[@id='amt7']/li");
	public final By Act_Guru99_500AmountTarget2 =  By.xpath("//*[@id='amt8']/li");	
	public final By Act_Guru99_BankButton =  By.xpath("//*[@id='credit2']/a");
	public final By Act_Guru99_SalesButton =  By.xpath("//*[@id='credit1']/a");
	public final By Act_Guru99_BankTargetLocation =  By.xpath("//*[@id=\"bank\"]/li");
	public final By Act_Guru99_SalesTargetLocation =  By.xpath("//*[@id='loan']/li");

	
	

}
