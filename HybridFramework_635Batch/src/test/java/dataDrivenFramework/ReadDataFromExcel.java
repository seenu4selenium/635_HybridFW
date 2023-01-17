package dataDrivenFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromExcel {
	
  @Test
  public void f() throws Exception {
	  //Find the workbook path
	  FileInputStream fi = new FileInputStream("./src/test/resources/testdata/TD.xlsx");
	  //Load the fi data into workbook varaible
	  Workbook wb = new XSSFWorkbook(fi);
	  //Find the sheet by name in above workbook
	  Sheet s = wb.getSheet("FBLoin");
	  
	  //Row
	  Row r = s.getRow(1);
	  //Column
	  Cell username = r.getCell(0);
	  Cell password = r.getCell(1);
	  
	  
	  System.out.println(username.getStringCellValue());
	  System.out.println(password.getStringCellValue());
	  
	  
	  //Find the last row number in excelsheet
	  System.out.println(s.getLastRowNum());
	  
	  
  }
}
