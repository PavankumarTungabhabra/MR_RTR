

 package Selenium.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Selenium.Productspage;
import Selenium.UserLogin;
import io.github.bonigarcia.wdm.WebDriverManager;

public class copy  {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
	System.setProperty("webdriver.chrome.driver","C:\\Users\\SHWETHA\\OneDrive\\Desktop\\Selenium softwares\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		Actions a= new Actions(driver);
		 driver.manage().window().maximize();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
UserLogin userlogin= new UserLogin(driver);
Productspage productspage= new Productspage(driver);



//url
driver.get("https://rahulshettyacademy.com/client");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//login credentials user name

userlogin.DoLogin("tunga@example.com", "Tunga@0109");
//password

String itemsreq= "ZARA COAT 3";
//productspage

List<WebElement> items = driver.findElements(By.xpath("//div[@class='card-body']/h5"));
for (int i = 0; i <items.size() ; i++) 
{
	String item = items.get(i).getText();
	if (item.contains(itemsreq))
			{
		//add to cart button.
		items.get(i).findElement(By.xpath("//button[.=' Add To Cart']")).click();
	}
}
//toast container
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
//animating
wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
// Product Added To Cart 

String alertmsg = null;
if (alertmsg.equalsIgnoreCase("Product Added To Cart")) 
{
	System.out.println("Product Added To Cart");
}
//cart icon
driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();
//cart products
List<WebElement> cartItems = driver.findElements(By.xpath("//img[@class='itemImg']//following-sibling::h3"));
cartItems.stream().filter(s->s.getText().trim().equalsIgnoreCase(itemsreq)).forEach(s->System.out.println("Proceed execution your on the right path!!!"));
//checkout
driver.findElement(By.xpath("//li[@class='totalRow'] //button")).click();
//cvv
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='input txt'])[1]")));
//cvv
driver.findElement(By.xpath("(//input[@class='input txt'])[1]")).sendKeys("0109");
//name on card
driver.findElement(By.xpath("//div[.='Name on Card ']/input")).sendKeys("Pavankumar T");
//coupon
driver.findElement(By.xpath("//div[.='Apply Coupon ']/input")).sendKeys("Dhanalaxmi");
//country
driver.findElement(By.xpath("//div[@class='user__address']//following-sibling::div[1]")).click();
Thread.sleep(2000);
//driver.findElement(By.xpath("(//input[@class='input txt text-validated'])[2]")).sendKeys("Ind");
//selectcountry
wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@placeholder='Select Country']")));
a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
//autosuggestivedropdown
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//india
WebElement india = driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]"));
a.moveToElement(india).click().build().perform();
Thread.sleep(1000);
//place order
driver.findElement(By.xpath("//a[.='Place Order ']")).click();
String Thanku="Thankyou for the order.";
String tq = Thanku.toUpperCase();
//thanks for the order.
String tqpage = driver.findElement(By.xpath("//h1[.=' Thankyou for the order. ']")).getText().trim();
Assert.assertEquals(tqpage, tq);
	}
}
