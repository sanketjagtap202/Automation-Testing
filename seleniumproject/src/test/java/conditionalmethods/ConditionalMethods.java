package conditionalmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		/*
		 * For isDisplayed() And isEnabled() methods:
		 * 
		 * //driver.get("https://demo.nopcommerce.com/"); WebElement logo =
		 * driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		 * System.out.println(logo.isDisplayed());
		 * 
		 * WebElement searchBox =
		 * driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		 * System.out.println(searchBox.isEnabled());
		 * 
		 */

		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

		WebElement gender_male = driver.findElement(By.id("gender-male"));
		WebElement gender_female = driver.findElement(By.id("gender-female"));
		// Before click:
		System.out.println(gender_male.isSelected());
		System.out.println(gender_female.isSelected());

		// after click:
		// gender_male.click();
		Thread.sleep(5000);
		gender_female.click();
		System.out.println(gender_male.isSelected());
		System.out.println(gender_female.isSelected());

	}

}
