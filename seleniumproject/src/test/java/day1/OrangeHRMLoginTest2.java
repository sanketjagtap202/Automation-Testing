package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Test case: Login to the OrangeHRM page
 * Test case Steps:
 * 1) launch the browser
 * 2) open the url: https://opensource-demo.orangehrmlive.com/
 * 3) provide a username: Admin
 * 4) provide a password: admin123
 * 5) Click on Login button
 * 6) Verify the title of page: Should be OrangeHRM
 * 7) Close the browser
 */

public class OrangeHRMLoginTest2 {

	public static void main(String[] args) throws InterruptedException {

		// Stp1) Launch the browser:
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // to maximize the screen.

		// Step2: Open the url: https://opensource-demo.orangehrmlive.com/

		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(5000);

		// Step3: Provide the username: Admin
		driver.findElement(By.name("username")).sendKeys("Admin");

		// Step4) Provide a password: admin123
		driver.findElement(By.name("password")).sendKeys("admin123");

		// Step5) Click on Login button:
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

		Thread.sleep(5000);

		// Step6) Verify the title of page: Should be OrangeHRM (Validation)

		String act_title = driver.getTitle();
		String exp_title = "OrangeHRM";
		if (act_title.equals(exp_title)) {
			System.out.println("test case passed");
		} else {
			System.out.println("test case failed");
		}

		// Step7) Close Browser:

		driver.quit();
	}

}
