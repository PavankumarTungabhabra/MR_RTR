package Flipkart.FlipKart.Order.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import AbstractMethods.AbstractMethodComponents;

public class MainPage extends AbstractMethodComponents {
WebDriver driver;
	public MainPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//Locators
	By xIcon=By.xpath("//span[text()='✕']");
	By searchTextField=By.xpath("//input[@title='Search for Products, Brands and More']");
	By searchIcon=By.xpath("//button[@type='submit']");
	
	
	
	//Actions
	public void Goto() {
		driver.get("https://www.flipkart.com/");
		
	}
	public ProductPage SearchProduct(String ItemRequired) throws InterruptedException
	{
		//Thread.sleep(50000);
		WaitForProductToLoad(xIcon);
		JavaScriptClickOnLocator(xIcon);
		driver.findElement(searchTextField).sendKeys(ItemRequired);
		driver.findElement(searchIcon).click();
		return new ProductPage(driver);
	}

}
