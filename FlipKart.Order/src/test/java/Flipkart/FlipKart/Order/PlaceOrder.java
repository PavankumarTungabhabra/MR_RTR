package Flipkart.FlipKart.Order;

import org.testng.annotations.Test;

import FlipKartTestComponents.BaseTest;
import Flipkart.FlipKart.Order.PageObjects.CartPage;
import Flipkart.FlipKart.Order.PageObjects.ProductDescriptionPage;
import Flipkart.FlipKart.Order.PageObjects.ProductPage;

public class PlaceOrder extends BaseTest{

	@Test
	public void SearchOrder() throws InterruptedException {
		String Product="Samsung S23 Ultra";
		ProductPage productPage=mainPage.SearchProduct(Product);
		ProductDescriptionPage productDescriptionPage = productPage.GetProductInfo();
		CartPage cartPage = productDescriptionPage.ProductDescriptionPageActions();
		cartPage.CartPageActions();
		
	}
}
