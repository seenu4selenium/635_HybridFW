package dataDrivenFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteDataToExceSheet {

	@Test
	public void f() throws Exception {
		// Find the workbook path
		FileInputStream fi = new FileInputStream("./src/test/resources/testdata/TD.xlsx");
		// Load the fi data into workbook varaible
		Workbook wb = new XSSFWorkbook(fi);
		// Find the sheet by name in above workbook
		Sheet s = wb.getSheet("FBLoin");

		// Row
		Row r = s.getRow(0);
		// Column
		Cell abc = r.createCell(2);
		// Push some data into cell: Temp it will store the data in RAM location
		abc.setCellValue("Results");

		FileOutputStream fo = new FileOutputStream("./src/test/resources/testdata/TD.xlsx");
		wb.write(fo);
		wb.close();

	}
}
