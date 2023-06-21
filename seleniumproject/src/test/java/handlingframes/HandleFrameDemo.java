package handlingframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrameDemo {

	public static void main(String[] args) {

		// packageFrame
		// classFrame

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		driver.switchTo().frame("packageListFrame"); //frame1
		driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium']")).click();
		driver.switchTo().defaultContent(); // back to page
		driver.switchTo().frame("packageFrame"); //frame2
		driver.findElement(By.xpath("//span[normalize-space()='Alert']")).click();
		driver.switchTo().defaultContent(); // back to page
		driver.switchTo().frame("classFrame"); //frame3
		driver.findElement(By.cssSelector("div[class='topNav'] li[class='navBarCell1Rev']")).click();
		driver.switchTo().defaultContent(); //back to page
		
	}

}
