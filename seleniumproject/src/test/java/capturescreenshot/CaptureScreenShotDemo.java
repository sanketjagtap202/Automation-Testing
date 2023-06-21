package capturescreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import io.netty.handler.codec.http.multipart.FileUpload;

public class CaptureScreenShotDemo {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.orangehrm.com/");

		// Take full screenshot:
		/*
		 * TakesScreenshot ts = (TakesScreenshot) driver; File src =
		 * ts.getScreenshotAs(OutputType.FILE); File trg = new File(
		 * "F:\\Automation_java_selenium\\seleniumproject\\src\\test\\java\\screenshots\\fullscreenshot.png"
		 * ); Files.copy(src, trg);
		 */

		// Take a specific element screenshot:

		WebElement src = driver.findElement(By.xpath("//nav[@class='navbar navbar-expand-lg navbar-light fixed-top']"));

		File scrennsht = src.getScreenshotAs(OutputType.FILE);
		File targ = new File(
				"F:\\\\Automation_java_selenium\\\\seleniumproject\\\\src\\\\test\\\\java\\\\screenshots\\\\specificelementss.png");
		Files.copy(scrennsht, targ);
	}

}
