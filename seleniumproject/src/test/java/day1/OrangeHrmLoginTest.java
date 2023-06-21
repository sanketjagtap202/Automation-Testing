package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

/*
 * Test case:
  1) launch Browser.
  2) open url 
    	https://opensource-demo.orangehrmlive.com/
  3) provide username: Admin
  4) provide password: admin123
  5) Click on Login Button
  6) Verify the title of dashboard page: OrangeHRM
  7)close browser	
 */

public class OrangeHrmLoginTest {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * NOTES: Setup the browser: setUp is not required for launching the browser
		 * from 4.6.0 version. WebDriverManager.chromedriver().setup(); To launch the
		 * Browser: No need to have webdrivermanager dependencies in pom.xml file Just
		 * create object of the browser. Thats it.
		 */
		// Step1: launch the browser:
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // to maximize the window

		// Step2: Open the url:
		// https://opensource-demo.orangehrmlive.com/
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(5000);

		// Step3: provide the username: Admin
		// First we have to find, where to put the username.then we ca put.
		driver.findElement(By.name("username")).sendKeys("Admin");

		// Step4 : provide a password: admin123
		driver.findElement(By.name("password")).sendKeys("admin");

		// Step5: Click on Login Button:

		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

		Thread.sleep(2000);

		// Step6) Verify the page title: title should be OrangeHRM, is my test case.
		// Validation 1: Fails
		/*
		 * String act_title = driver.getTitle(); String exp_title = "OrangeHRM"; if
		 * (act_title.equals(exp_title)) { System.out.println("Test case passed"); }
		 * else { System.out.println("test case failed"); }
		 */

		// Validation2: Try to validate through Dashboard webElement:
		String act_res = "";
		try {
			act_res = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6"))
					.getText();
		} catch (NoSuchElementException ex) {

		}

		String exp_res = "Dashboard";
		if (act_res.equals(exp_res)) {
			System.out.println("case passed");
		} else {
			System.out.println("Case failed");
		}

		// Step7) Close the Browser:

		// driver.close();

	}

}
