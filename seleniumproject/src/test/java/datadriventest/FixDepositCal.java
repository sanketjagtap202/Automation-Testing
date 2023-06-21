package datadriventest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import practicedatadriventest.ExcelUtils;

public class FixDepositCal {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

		// get excelsheet path:

		String file = System.getProperty("user.dir") + "\\Excelsheets\\calData.xlsx";

		int rows = ExcelUtils.getRowCount(file, "Sheet1");

		for (int r = 1; r <= rows; r++) {
			// read data from excelsheet:

			String principl_amnt = ExcelUtils.getCellData(file, "Sheet1", r, 0);
			String roI = ExcelUtils.getCellData(file, "Sheet1", r, 1);
			String period_time1 = ExcelUtils.getCellData(file, "Sheet1", r, 2);
			String period_time2 = ExcelUtils.getCellData(file, "Sheet1", r, 3);
			String frq = ExcelUtils.getCellData(file, "Sheet1", r, 4);
			String mValue = ExcelUtils.getCellData(file, "Sheet1", r, 5);

			// pass data to the app:

			driver.findElement(By.id("principal")).sendKeys(principl_amnt);
			driver.findElement(By.id("interest")).sendKeys(roI);
			driver.findElement(By.id("tenure")).sendKeys(period_time1);
			
			// Here we have to handle dropdown using select class:
			Select perdrp = new Select(driver.findElement(By.id("tenurePeriod")));
			perdrp.selectByVisibleText(period_time2);

			Select frqdrp = new Select(driver.findElement(By.id("frequency")));
			frqdrp.selectByVisibleText(frq);

			// click on calculate button:

			JavascriptExecutor js = (JavascriptExecutor) driver;

			WebElement calculate_btn = driver.findElement(
					By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']"));

			js.executeScript("arguments[0].click()", calculate_btn);
			// Validation & Update result in excel:

			String actual_mValue = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();

			if (Double.parseDouble(mValue) == Double.parseDouble(actual_mValue)) {

				System.out.println("test passed");
				ExcelUtils.setCellData(file, "Sheet1", r, 7, "Passed");
				ExcelUtils.fillGreenColor(file, "Sheet1", r, 7);
			} else {
				System.out.println("Test failed");
				ExcelUtils.setCellData(file, "Sheet1", r, 7, "Failed");
				ExcelUtils.fillRedColor(file, "Sheet1", r, 7);
			}

			WebElement clear_btn = driver.findElement(By.xpath("//img[@class='PL5']"));
			js.executeScript("arguments[0].click()", clear_btn); // clear button

		}

	}

}
