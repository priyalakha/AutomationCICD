package rahulshettyacademy.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidations extends BaseTest{
	
	@Test
	public void LoginErrorValidation() {
		
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("riyalakha@gmail.com", "Priyalakha@3");
		AssertJUnit.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		
	}
	
	@Test
    public void ProductErrorValidation() throws InterruptedException {
		
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("riyalakha@gmail.com", "Priyalakha@3");
		List<WebElement> products = productCatalogue.getProductsList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		
		Boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
	}
	
}
