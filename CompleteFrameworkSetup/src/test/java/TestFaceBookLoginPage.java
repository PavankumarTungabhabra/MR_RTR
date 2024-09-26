import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFaceBookLoginPage {
	
	@Test
	public void testFB() throws InterruptedException
	{
	
		ChromeDriver driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Email address or phone number']")).sendKeys("9945644656");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Tunga@1978");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}

}
