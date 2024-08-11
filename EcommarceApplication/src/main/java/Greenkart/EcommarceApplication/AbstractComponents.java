package Greenkart.EcommarceApplication;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		
	}
	public void WaitForProductToLoad(By locator)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void WaitForElementToDissappear(By animating) throws InterruptedException
	{ 
		Thread.sleep(3000);
		/*WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOf(locator));*/
	}
	public void ActionSendKeysToLocator(WebElement locator, String country)
	{
		Actions a= new Actions(driver);
		a.sendKeys(locator, country).build().perform();
	}
	public void ActionClickOnLocator(By locator) throws InterruptedException
	{
		Thread.sleep(4000);
		Actions a= new Actions(driver);
		a.moveToElement(driver.findElement(locator)).click().build().perform();
	}
	public void JavaScriptClickOnWebelement(By locator)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", driver.findElement(locator));
	}
	
	public void JavaScriptScrollWindow(int x, int y)
	{

		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo("+x+","+y+")");
	}
	public void SwitchToFrame(WebElement locator)
	{
		
		driver.switchTo().frame(locator);
		
	}

}
