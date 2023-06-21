package datadriventest;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//ExcelFile-->WorkBook-->Sheets-->Rows--->Cells

public class WriteExcelsheetDemo {

	public static void main(String[] args) throws IOException {

		FileOutputStream file = new FileOutputStream(
				"F:\\Automation_java_selenium\\seleniumproject\\src\\test\\java\\excelsheets\\myfile.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet();
		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("Sanket");
		row1.createCell(1).setCellValue("jagtap");
		row1.createCell(2).setCellValue("Testing");

		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("12325");
		row2.createCell(1).setCellValue("Job");
		row2.createCell(2).setCellValue("Pune");

		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("Write done");

	}

}
