package dataDrivenFramework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utilities.CommonFunctions;

public class OrangeHRMPAgeLogin extends CommonFunctions{
	String results;

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		chromeBrowserLaunch();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test
	public void login() throws Exception {
		FileInputStream fi = new FileInputStream("./src/test/resources/testdata/TD.xlsx");
		Workbook wb = new XSSFWorkbook(fi);
		Sheet sh = wb.getSheet("HRM");

		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			Row row1 = sh.getRow(i);
			Cell UName = row1.getCell(0);
			Cell PWD = row1.getCell(1);

			//Explicit wait
			explicitWaitForelementToBeClickable(By.name("username"), 20);	
					
			//control+a: to selecte all chars
			//delete: 
			
			String clear = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
			
			driver.findElement(By.name("username")).sendKeys(clear);			
			driver.findElement(By.name("username")).sendKeys(UName.getStringCellValue());	
			
			driver.findElement(By.name("password")).sendKeys(clear);			
			driver.findElement(By.name("password")).sendKeys(PWD.getStringCellValue());

			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"))
					.click();
			Thread.sleep(5000);

			// Validate the results
			if (driver.findElements(By.xpath("//*[text()='Invalid credentials']")).size() > 0) {
				System.out.println("Given credentials are in-valid");
				results = "Fail";
			} else {
				System.out.println("Given credentials are valid");
				results = "Pass";
				// Prepare the Logout script
				driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i"))
						.click();
				driver.findElement(By.xpath("//*[text()='Logout']")).click();	
				Thread.sleep(3000);
			}
			
			Cell abc = row1.createCell(2);
			abc.setCellValue(results);
			Thread.sleep(3000);

		} // for loop end

		// push results from RAM location to excel sheet
		FileOutputStream fo = new FileOutputStream("./src/test/resources/testdata/TD.xlsx");
		wb.write(fo);
		wb.close();

	}
}
