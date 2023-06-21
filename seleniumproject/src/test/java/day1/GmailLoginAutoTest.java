package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Test case: to login to gmail account:
 * step1: Launch the browser
 * step2: Open the link: https://www.orangehrm.com/
 * Step3: Click on Book a free Demo
 * Step4: Scroll down
 * Step5: Provide Full name: Sanket Jagtap
 * Step6: Provide Business Email: sanketjagtap202@gmail.com
 * Step7: Provide Country: India
 * Step8: provide phone number: 8530589695
 * Step9: Check to I am not robot box.
 * step10: Close the browser
*/

public class GmailLoginAutoTest {

	public static void main(String[] args) throws InterruptedException {

		// step1: Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Step2: Open the link:
		driver.get("https://www.orangehrm.com/");
		Thread.sleep(5000);

		// Step3 : Click on Book a free Demo:
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div[2]/ul/li[1]/a/button")).click();

		// Step4: Scroll down: Step5: Provide Full name: Sanket Jagtap
		driver.findElement(By.name("FullName")).sendKeys("Sanket Jagtap");

		// Step6: Provide Business Email: sanketjagtap202@gmail.com
		driver.findElement(By.name("Email")).sendKeys("sanketjagtap202@gmail.com");

		// Step7: Provide Country: India
		driver.findElement(By.name("Country")).sendKeys("India");

		// Step8: provide phone number: 8530589695
		driver.findElement(By.name("Contact")).sendKeys("8530589695");

		// Step9: Check to I am not robot box.
		driver.findElement(By.cssSelector("span[aria-checked=\"true\"]")).click();
	}

}
