package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.objectrepository.Locators;

public class CommonFunctions {
	public static WebDriver driver;

	public String propertyFile = "QA_TD.properties";
	//public String propertyFile = "Live_TD.properties";
	//public String propertyFile = "UAT_TD.properties";

	public Locators loc = new Locators();
	public Properties prop = new Properties();
	public Scanner s = new Scanner(System.in);
	
	
//	public Actions actions;
//	public JavascriptExecutor js;
	public FileInputStream fi;	
	
	
	public void chromeBrowserLaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void firefoxBrowserLaunch() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	public void edgeBrowserLaunch() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}

	
	public void getURL(String URL) throws Exception {
		fi = new FileInputStream(".\\src\\test\\resources\\testdata\\" + propertyFile);
		prop.load(fi);
		driver.get(prop.getProperty(URL));
	}
	
	
	public String timeStamp() {
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("ddMMMyyyy_HHmmss");
		String timestamp = df.format(d);
		return timestamp;
	}

	// Takescreenshot code
	public void takeScreenshot() throws Exception {
		File abc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(abc, new File(".\\screenshots\\test" + timeStamp() + ".png"));
	}

	public void verifyWebelementIsDisplayedOnScreen(By locator) {
		if (driver.findElements(locator).size() > 0) {
			System.out.println("Given Webelement Is Displayed On Screen***");
		} else {
			System.out.println("Given Webelement Is NOT Displayed  On Screen***");
		}
	}

	/*******
	 * SendKeys
	 * 
	 * @throws Exception
	 ************************/
	public void sendKeysByAnyLocator(By locator, String inputdata) throws Exception {
		fi = new FileInputStream(".\\src\\test\\resources\\testdata\\" + propertyFile);
		prop.load(fi);

		WebElement element = driver.findElement(locator);

		// Check your locator is displayed?
		if (driver.findElements(locator).size() > 0) {
			// Check your element is in enable state?
			if (element.isEnabled()) {
				System.out.println("Given locator is enable state ***");
				// Clear any existing data
				highlightElement(element);
				element.clear();
				// Send the test data to Edit box
				highlightElement(element);
				element.sendKeys(prop.getProperty(inputdata));
			} else {
				System.out.println("Given locator is not enable state on DOM(Current page***");
			}
		} else {
			System.out.println("Given locator is not displayed on DOM(Current page***");
		}
	}
	/*******
	 * Click
	 * 
	 * @throws Exception
	 ************************/
	public void clickByAnyLocator(By locator) throws Exception {
		implicitWait(3);
		WebElement element = driver.findElement(locator);
		// Check your locator is displayed?
		if (driver.findElements(locator).size() > 0) {
			// Check your element is in enable state?
			if (element.isEnabled()) {
				// Click on Button/radiobutton/checkbox/Link...
				highlightElement(element);
				element.click();
			} else {
				System.out.println("Given locator is not enable state on DOM(Current page***");
			}
		} else {
			System.out.println("Given locator is not displayed on DOM(Current page***");
		}
	}

	public void clickUsingJavaScript(By locator) throws Exception {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		highlightElement(element);
		executor.executeScript("arguments[0].click();", element);
		
	}
	

	public void highlightElement(WebElement element) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='6px groove green'", element);
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='6px groove green'", element);
	}
	
	/************ waits inselenium ***********************/
	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		System.out.println("Implicit wait method used***");
	}
	
	public void explicitWaitForVisibilityOf(By locator, int timeinSeconds) {
		WebElement element = driver.findElement(locator);
		// webdriver wait (Explicit wait)
		WebDriverWait ww = new WebDriverWait(driver, Duration.ofSeconds(timeinSeconds));
		ww.until(ExpectedConditions.visibilityOf(element));	
		System.out.println("Explicit wait method used***");
	}
	public void explicitWaitForelementToBeClickable(By locator, int timeinSeconds) {
		WebElement element = driver.findElement(locator);
		// webdriver wait (Explicit wait)
		WebDriverWait ww = new WebDriverWait(driver, Duration.ofSeconds(timeinSeconds));
		ww.until(ExpectedConditions.elementToBeClickable(element));	
		System.out.println("Explicit wait method used***");
	}

	

	/***
	 * instead of fluent wait use customized While loop statement**@throws Exception
	 *****/

	public void waitforElement(By locater) throws Exception {
		int i = 0;
		while (driver.findElements(locater).size() < 1) {
			Thread.sleep(500);
			System.out.println("Wait for the element***************");
			// Suppose system has not present the element it will repeat 30 time
			// then stop
			// the execution using break
			if (i > 30) {
				System.out.println("Element is not present");
				break;
			}
			i++;
		}
	}
	
	//Scanner method
	public String scnnerByString() {
		Scanner s = new Scanner(System.in);
		String value= s.next();
		return value;
	}
	
	
	/*********** SwithchToWindow using Tab ***************************/
	public void switchToNewTab() {
		ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allTabs.get(1));		
	}

	/***********
	 * SwithchToWindow using Tab then close the New Tab againg back to Parent Window
	 ***************************/
	public void switchAndCloseNewTab() {
		// Get the current window handle
		String parentWindow = driver.getWindowHandle();
		//Switch to New tab [chilld window]
		ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allTabs.get(1));
		// Close the newly Opened Window[chilld window]
		driver.close();
		// Switch back to original window[parentWindow]
		driver.switchTo().window(parentWindow);
	}
	
	
	
	
}
