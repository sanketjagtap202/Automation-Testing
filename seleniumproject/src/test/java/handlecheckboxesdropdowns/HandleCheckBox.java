package handlecheckboxesdropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckBox {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://itera-qa.azurewebsites.net/home/automation");

		// get total no.of checkboxes:

		List<WebElement> checkboxes = driver
				.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

		System.out.println("Total checkboxes: " + checkboxes.size());
//		for (WebElement webElement : checkboxes) {
//			webElement.click();
//		}

		for (int i = 5; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}

	}

}
