package GreenkartPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Greenkart.EcommarceApplication.AbstractComponents;

public class MainPage extends AbstractComponents{
WebDriver driver;

	public MainPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Locatores
	
	
	
	
	//Actions
	public void Goto() {
		driver.get("https://GreenKart.com");
	}
	public SubPage DoMainPageAction()
	{
		return new SubPage(driver);
	}

}
