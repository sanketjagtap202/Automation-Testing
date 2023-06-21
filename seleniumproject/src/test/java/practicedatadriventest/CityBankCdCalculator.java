package practicedatadriventest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CityBankCdCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator/");

		String file = System.getProperty("user.dir") + "\\Excelsheets\\caldata2.xlsx";
		int rows = ExcelUtils.getRowCount(file, "Sheet1");

		WebElement intDepo = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
		WebElement len = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
		WebElement inR = driver.findElement(By.xpath("//input[@id='mat-input-2']"));

		for (int r = 1; r <= rows; r++) {

			// read data from sheet:

			String initDepoAmnt = ExcelUtils.getCellData(file, "Sheet1", r, 0);
			String length = ExcelUtils.getCellData(file, "Sheet1", r, 1);
			String Int_rate = ExcelUtils.getCellData(file, "Sheet1", r, 2);
			String compounding = ExcelUtils.getCellData(file, "Sheet1", r, 3);
			String exp_total = ExcelUtils.getCellData(file, "Sheet1", r, 4);

			// pass date to the application
			intDepo.clear();
			len.clear();
			inR.clear();
			Thread.sleep(3000);
			intDepo.sendKeys(initDepoAmnt);
			len.sendKeys(length);
			inR.sendKeys(Int_rate);

			WebElement compoundrp = driver.findElement(By.xpath("//mat-select[@id='mat-select-0']")); // select class //
																										// object

			compoundrp.click();

			List<WebElement> options = driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//mat-option"));

			for (WebElement option : options) {
				if (option.getText().equals(compounding))
					option.click();
			}

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement run_btn = driver
					.findElement(By.xpath("//button[@id='CIT-chart-submit']//div[@class='mdc-button__ripple']"));

			js.executeScript("arguments[0].click()", run_btn);

			String actual_total = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();

			if (actual_total.equals(exp_total)) {

				System.out.println("Test passed");
				ExcelUtils.setCellData(file, "Sheet1", r, 6, "Passed");
				ExcelUtils.fillGreenColor(file, "Sheet1", r, 6);

			} else {
				System.out.println("Test Failed");
				ExcelUtils.setCellData(file, "Sheet1", r, 6, "Failed");
				ExcelUtils.fillRedColor(file, "Sheet1", r, 6);
			}

		}

		System.out.println("Calculation completed");
		driver.close();

	}

}
