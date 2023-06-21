package practicedatadriventest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FixDepositDemo1 {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

		String file = System.getProperty("user.dir") + "\\Excelsheets\\FixDepositData1.xlsx";

		int rows = ExcelUtils.getRowCount(file, "Sheet1");

		for (int r = 1; r <= rows; r++) {

			// Read data from excelsheet.
			String principal_amnt = ExcelUtils.getCellData(file, "Sheet1", r, 0);
			String RoI = ExcelUtils.getCellData(file, "Sheet1", r, 1);
			String period1 = ExcelUtils.getCellData(file, "Sheet1", r, 2);
			String period2 = ExcelUtils.getCellData(file, "Sheet1", r, 3);
			String frq = ExcelUtils.getCellData(file, "Sheet1", r, 4);
			String exp_mValue = ExcelUtils.getCellData(file, "Sheet1", r, 5);

			// pass data to the application.

			driver.findElement(By.id("principal")).sendKeys(principal_amnt);
			driver.findElement(By.id("interest")).sendKeys(RoI);
			driver.findElement(By.id("tenure")).sendKeys(period1);

			Select perioddrp = new Select(driver.findElement(By.id("tenurePeriod")));
			perioddrp.selectByVisibleText(period2);

			Select freqdrp = new Select(driver.findElement(By.id("frequency")));
			freqdrp.selectByVisibleText(frq);

			// Click on calculate button:
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement calculate_btn = driver.findElement(
					By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']"));
			js.executeScript("arguments[0].click()", calculate_btn);

			// validate and update result:

			String actual_mValue = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();

			if (Double.parseDouble(actual_mValue) == Double.parseDouble(exp_mValue)) {

				System.out.println("Test Passed");
				ExcelUtils.setCellData(file, "Sheet1", r, 7, "Passed");
				ExcelUtils.fillGreenColor(file, "Sheet1", r, 7);

			} else {

				System.out.println("Test Failed");
				ExcelUtils.setCellData(file, "Sheet1", r, 7, "Failed");
				ExcelUtils.fillRedColor(file, "Sheet1", r, 7);

			}
			Thread.sleep(3000);

			WebElement clear_btn = driver.findElement(By.xpath("//img[@class='PL5']"));
			js.executeScript("arguments[0].click()",clear_btn);

		}

	}

}
