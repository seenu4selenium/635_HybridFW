package com.testscenarios;

import org.testng.annotations.Test;

import com.utilities.CommonFunctions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TS_Echallan extends CommonFunctions {

	@BeforeClass
	public void beforeClass() {
		chromeBrowserLaunch();
	}

	@Test
	public void f() throws Exception {
		getURL("TSechallan_URL");
		sendKeysByAnyLocator(loc.TS_VehicleNo, "TS_VehicleNo");
		sendKeysByAnyLocator(loc.TS_Cpatcha, "TS_Captcha");
		clickByAnyLocator(loc.TS_GoButton);
	}

	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClass() {
	}

}
