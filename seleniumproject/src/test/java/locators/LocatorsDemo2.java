package locators;

import java.sql.DriverManager;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo2 {

	public static void main(String[] args) throws InterruptedException {

		// Launch the browser: (no need to setup the browser from version 4.6.0)

		WebDriver driver = new ChromeDriver();

		// open the app:

		driver.get("http://automationpractice.pl/index.php");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		// Finding a number of sliders on home page:
		List<WebElement> slides = driver.findElements(By.className("homeslider-container"));

		System.out.println("Total number of slides: " + slides.size());
	}

}
