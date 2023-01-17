package dataDrivenFramework;

import org.testng.annotations.Test;
import com.utilities.CommonFunctions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class FbLoginTest extends CommonFunctions {
	String results;

	@BeforeTest
	public void url() throws Exception {
		chromeBrowserLaunch();
		getURL("FB_URL");
	}

	@Test
	public void fblogin() throws IOException, Exception {
		FileInputStream fi = new FileInputStream("./src/test/resources/testdata/TD.xlsx");
		Workbook wb = new XSSFWorkbook(fi);
		Sheet s = wb.getSheet("FBLoin");

		for (int i = 1; i <= s.getLastRowNum(); i++) {

			Row r = s.getRow(i);
			Cell username = r.getCell(0);
			Cell password = r.getCell(1);

			driver.findElement(loc.fblogin_Email_EditBox).sendKeys(username.getStringCellValue());
			driver.findElement(loc.fblogin_Password_EditBox).sendKeys(password.getStringCellValue());
			clickByAnyLocator(loc.fblogin_Login_Button);
			Thread.sleep(5000);

			// Verify the given fb credentials are valid / invalid
			if (driver.findElements(By.linkText("Find your account and log in.")).size() > 0
					|| driver.findElements(By.linkText("Create a new Facebook account.")).size() > 0) {

				System.out.println("given fb credentials are in-valid");
				results = "Fail";

			} else {
				System.out.println("given fb credentials are valid");
				results = "Pass";

			}
			System.out.println(results);
			Cell abc = r.createCell(2);
			abc.setCellValue(results);
			Thread.sleep(3000);
		}
		FileOutputStream fo = new FileOutputStream("./src/test/resources/testdata/TD.xlsx");
		wb.write(fo);
		wb.close();
	}

}
