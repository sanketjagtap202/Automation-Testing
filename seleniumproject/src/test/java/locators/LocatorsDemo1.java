package locators;

import java.sql.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo1 {

	public static void main(String[] args) throws InterruptedException {

		// Launch the browser: (no need to setup the browser from version 4.6.0)

		WebDriver driver = new ChromeDriver();

		// open the app:

		driver.get("http://automationpractice.pl/index.php");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		// Search box: used id locator

		driver.findElement(By.id("search_query_top")).sendKeys("T-shirts");

		// click on search button: used name locator
		driver.findElement(By.name("submit_search")).click();
		Thread.sleep(2000);
		// linktext & partiallinktext:

		// driver.findElement(By.linkText("Printed Summer Dress")).click();
		driver.findElement(By.partialLinkText("Blouse")).click();
		
		
	}

}
