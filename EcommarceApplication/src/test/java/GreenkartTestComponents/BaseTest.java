package GreenkartTestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.google.common.io.Files;

import GreenkartPageObjects.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	public MainPage mainPage;
	public WebDriver Initilizer() throws IOException {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Greenkart\\EcommarceApplication\\Resources\\GlobalData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		return driver;
	}
	@BeforeTest
	public MainPage LaunchApplication() throws IOException
	{
		driver=Initilizer();
		mainPage=new MainPage(driver);
		mainPage.Goto();
		return mainPage;
	}
	@AfterTest
	public void TearDown()
	{
		driver.close();
	}
	public String TakesceenShot(WebDriver driver, String TestCaseName) throws IOException
	{
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File Src = ts.getScreenshotAs(OutputType.FILE);
		File filePath = new File(System.getProperty("user.dir")+"//ScreenShots"+TestCaseName+".png");
		Files.copy(Src, filePath);
		return System.getProperty("user.dir")+"//ScreenShots"+TestCaseName+".png";
		
	}

}
