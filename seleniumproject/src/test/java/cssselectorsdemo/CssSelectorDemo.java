package cssselectorsdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * app link : https://demo.nopcommerce.com/
 */
public class CssSelectorDemo {

	public static void main(String[] args) {

		// launch the browser:

		WebDriver driver = new ChromeDriver();

		// Open the link:
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		//

		// 1. using cssSelector: tag & id:
		// driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("MacBook");

		// 2. using cssSelector: tag & class:
		// driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Samsung");

		// 3. using cssSelector: tag & attribute:

		// driver.findElement(By.cssSelector("input[placeholder='Search
		// store']")).sendKeys("Blackberry");
		
		// 4. using cssSelector: tag & class & attribute:

		driver.findElement(By.cssSelector(""));
		
		////img[@alt='nopCommerce demo store']  ////input[@id='small-searchterms']
	}

}
