package rahulshettyacademy.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest1 {
	
	public class SubmitOrderTest extends BaseTest{
		
		@Test
		public void submitOrder() throws IOException, InterruptedException
		{
			String productName = "ZARA COAT 3";
			ProductCatalogue productCatalogue = landingPage.loginApplication("riyalakha003@gmail.com", "Priyalakha@12");
			List<WebElement> products = productCatalogue.getProductsList();
			productCatalogue.addProductToCart(productName);
			CartPage cartPage = productCatalogue.goToCartPage();
			
			Boolean match = cartPage.verifyProductDisplay(productName);
			Assert.assertTrue(match);
			CheckoutPage checkoutPage = cartPage.goToCheckout();
			checkoutPage.selectCountry("india");
			ConfirmationPage conPage = checkoutPage.submitOrder();
			String confirmMessage = conPage.getConfirmationMessage();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		}
	}
}
