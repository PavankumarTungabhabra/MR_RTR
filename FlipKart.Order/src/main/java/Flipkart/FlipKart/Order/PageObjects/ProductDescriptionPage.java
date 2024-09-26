package Flipkart.FlipKart.Order.PageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AbstractMethods.AbstractMethodComponents;

public class ProductDescriptionPage extends AbstractMethodComponents{
WebDriver driver;
	public ProductDescriptionPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		
	}

	//Locators
	By productImages=By.xpath("//ul[contains(@class,'GnUWp')]//li");
	By availableOffers=By.xpath("//div[text()='Available offers']//following::div[1]");
	By colorsOfProduct=By.xpath("//li[contains(@id,'color')]");
	By checkBox=By.xpath("//input[@type='checkbox']");
	By addToCart=By.xpath("//span[contains(text(),'Items to Cart')]");
	By dropDown=By.xpath("//div[contains(@class,'VfWRb VnysFO')]");
	
	
	//Actions
	public CartPage ProductDescriptionPageActions() throws InterruptedException {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String ParentWindow = it.next();
		String ChildWindow = it.next();
		driver.switchTo().window(ChildWindow);
		WaitForProductToLoad(addToCart);
		Thread.sleep(5000);
		//driver.findElement(dropDown).click();
		List<WebElement> images = driver.findElements(productImages);
		for (int i = 0; i < images.size()-5; i++) 
		{
			images.get(i).click();
			Thread.sleep(4000);
		}
		System.out.println(driver.findElement(availableOffers).getText().trim());
		Thread.sleep(5000);
//		List<WebElement> colour = driver.findElements(colorsOfProduct);
//		for (int i = 0; i < colour.size(); i++) {
//			colour.get(i).click();

		//Thread.sleep(3000);
//			

	//}
		List<WebElement> checkBoxes = driver.findElements(checkBox);
		for (int i = 1; i < checkBoxes.size(); i++)
		{
			JavaScriptClickOnwebElement(checkBoxes.get(i));
			Thread.sleep(2000);
		}
		driver.findElement(addToCart).click();
		Thread.sleep(4000);
		return new CartPage(driver);
	}
}
