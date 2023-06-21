package practicedatadriventest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FixDepositDemo {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

		String file = System.getProperty("user.dir") + "\\Excelsheets\\FixDepositData.xlsx";
		int rows = ExcelUtils.getRowCount(file, "Sheet1");

		// Read data from excel sheet:

		for (int r = 1; r <= rows; r++) {

			String principal_amnt = ExcelUtils.getCellData(file, "Sheet1", r, 0);
			String rOI = ExcelUtils.getCellData(file, "Sheet1", r, 1);
			String period1 = ExcelUtils.getCellData(file, "Sheet1", r, 2);
			String period2 = ExcelUtils.getCellData(file, "Sheet1", r, 3);
			String frq = ExcelUtils.getCellData(file, "Sheet1", r, 4);
			String Exp_maturityVal = ExcelUtils.getCellData(file, "Sheet1", r, 5);

			// Pass data to the Application:

			driver.findElement(By.id("principal")).sendKeys(principal_amnt);
			driver.findElement(By.id("interest")).sendKeys(rOI);
			driver.findElement(By.id("tenure")).sendKeys(period1);

			Select period_drp = new Select(driver.findElement(By.id("tenurePeriod")));
			period_drp.selectByVisibleText(period2);

			Select frequency_drp = new Select(driver.findElement(By.id("frequency")));
			frequency_drp.selectByVisibleText(frq);

			// Click on calculate button:

			JavascriptExecutor js = (JavascriptExecutor) driver;
WebElement calculate_btn = driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']"));
			js.executeScript("arguments[0].click()", calculate_btn);

			// Validation:

			String Actual_mValue = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();

			if (Double.parseDouble(Actual_mValue) == Double.parseDouble(Exp_maturityVal)) {

				System.out.println("Test passed");
				ExcelUtils.setCellData(file, "Sheet1", r, 7, "Passed");
				ExcelUtils.fillGreenColor(file, "Sheet1", r, 7);

			} else {
				System.out.println("Test Failed");
				ExcelUtils.setCellData(file, "Sheet1", r, 7, "Failed");
				ExcelUtils.fillRedColor(file, "Sheet1", r, 7);
			}
			
			WebElement clear_btn = driver.findElement(By.xpath("//img[@class='PL5']"));
			js.executeScript("arguments[0].click()", clear_btn);
		}

	}

}
