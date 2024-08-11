package Flipkart.FlipKart.Order.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractMethods.AbstractMethodComponents;

public class CartPage extends AbstractMethodComponents {
WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}
	
	
	//Locators
	By cartIcon=By.xpath("//span[text()='Cart']");
	By proceDetails=By.xpath("//span[text()='Price details']//following-sibling::div");
	By placeTheOrder=By.xpath("//span[text()='Place Order']");
	
	//Actions
	
	public void CartPageActions() {
		driver.findElement(cartIcon).click();
		WaitForProductToLoad(proceDetails);
		System.out.println(driver.findElement(proceDetails).getText().trim());
		driver.findElement(placeTheOrder).click();
	}

}
