package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractMethods {
WebDriver driver;
	public AbstractMethods(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public void WaitForElementVisible(By Locator)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}
	public void DoJavaScripExecutorCliCkontheElement(By Locator)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments.click()",driver.findElement(Locator));
	}
	public void WaitForElementDisAppear(By Locator)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(Locator)));
	}
	public void DoClicKAction(By Locator)
	{
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(Locator)).click().build().perform();
	}
	public void SwitchFrame(By Locator)
	{
		driver.switchTo().frame(driver.findElement(Locator));
	}
}
