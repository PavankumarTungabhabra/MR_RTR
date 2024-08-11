package FlipKartTestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Flipkart.FlipKart.Order.PageObjects.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
public WebDriver driver;
public MainPage mainPage;
	public WebDriver InitilizeApplication() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Flipkart//FlipKart//Order//Resources//GlobalData.properties");
		prop.load(fis);
		 String BrowserName = prop.getProperty("browser");
		 
		 if (BrowserName.equalsIgnoreCase("chrome")) 
		 {
			 WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		 if (BrowserName.equalsIgnoreCase("edge")) {
			 WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			
		}
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		 return driver;
		
	}
	@BeforeMethod
	public MainPage LaunchApplication() throws IOException {
		driver=InitilizeApplication();
	 mainPage=new MainPage(driver);
		mainPage.Goto();
		return mainPage;
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
