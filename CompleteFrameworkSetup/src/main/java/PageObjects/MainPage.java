package PageObjects;

import org.openqa.selenium.WebDriver;

import AbstractComponents.AbstractMethods;

public class MainPage extends AbstractMethods {
	WebDriver driver;
public MainPage(WebDriver driver) {
	    super(driver);
		this.driver=driver;
	}

//Locators

//actions
public void GoTo() {
	driver.get("https://youtube.com");
}
public SubPage MainPageActions() {
	return new SubPage(driver);
}


}
