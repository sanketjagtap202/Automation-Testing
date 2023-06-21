package datadriventest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//ExcelFile--->WorkBook--->Sheets---->Rows---->Cells ==> Hierarchy

public class ReadingExcelDemo {

	public static void main(String[] args) throws IOException {

		// To get a excelfile:
		FileInputStream file = new FileInputStream(
				"F:\\Automation_java_selenium\\seleniumproject\\src\\test\\java\\excelsheets\\myfile.xlsx");

		// got to the workbook:

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet0");

		int totalrows = sheet.getLastRowNum();
		int totalcells = sheet.getRow(1).getLastCellNum();

		System.out.println("Total rows: " + totalrows);
		System.out.println("Total Columns: " + totalcells);

		for (int r = 0; r <= totalrows; r++) {
			XSSFRow currentrow = sheet.getRow(r);

			for (int c = 0; c < totalcells; c++) {
				String cells = currentrow.getCell(c).toString();
				System.out.print(cells+ "  ");
			}
			System.out.println("  ");
		}

	}

}
