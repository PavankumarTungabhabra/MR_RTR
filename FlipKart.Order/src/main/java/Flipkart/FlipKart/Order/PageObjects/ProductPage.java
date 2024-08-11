package Flipkart.FlipKart.Order.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import AbstractMethods.AbstractMethodComponents;

public class ProductPage extends AbstractMethodComponents{
WebDriver driver;
	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Locators
	By searchedProduct=By.xpath("(//div[@class='MIXNux'])[1]");
	By productName=By.xpath("((//div[contains(@class,'col col')])[1]//div)[1]");
	By price=By.xpath("(//div[contains(@class,'col col')])[2]//div[contains(@class,'WHN')]");
	By capacity=By.xpath("((//span[contains(@id,'productRating')])[1]//following::div[@class='fMghEO'])[1]//li[1]");
	By displayMeasurements=By.xpath("((//span[contains(@id,'productRating')])[1]//following::div[@class='fMghEO'])[1]//li[2]");
	By cameraSpecifications=By.xpath("((//span[contains(@id,'productRating')])[1]//following::div[@class='fMghEO'])[1]//li[3]");
	By batteryInfo=By.xpath("((//span[contains(@id,'productRating')])[1]//following::div[@class='fMghEO'])[1]//li[4]");
	By processorInfo=By.xpath("((//span[contains(@id,'productRating')])[1]//following::div[@class='fMghEO'])[1]//li[5]");
	By guarrentyInfo=By.xpath("((//span[contains(@id,'productRating')])[1]//following::div[@class='fMghEO'])[1]//li[6]");
	
	//Actions
	public ProductDescriptionPage GetProductInfo() {
		WaitForProductToLoad(searchedProduct);
		System.out.println(driver.findElement(productName).getText().trim());
		System.out.println(driver.findElement(price).getText().trim());
		System.out.println(driver.findElement(capacity).getText().trim());
		System.out.println(driver.findElement(displayMeasurements).getText().trim());
		System.out.println(driver.findElement(cameraSpecifications).getText().trim());
		System.out.println(driver.findElement(batteryInfo).getText().trim());
		System.out.println(driver.findElement(processorInfo).getText().trim());
		System.out.println(driver.findElement(guarrentyInfo).getText().trim());
		driver.findElement(searchedProduct).click();
		return new ProductDescriptionPage(driver);
		
	}
	
}
