package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	String productName = "ZARA COAT 3";
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	
	LandingPage landingPage = new LandingPage(driver);
	landingPage.goTo();
	
	ProductCatalogue pC = landingPage.loginApplication("riyalakha003@gmail.com", "Priyalakha@12");
	List<WebElement> products = pC.getProductsList();
	pC.addProductToCart(productName);
	CartPage cartPage = pC.goToCartPage();
	
	Boolean match = cartPage.verifyProductDisplay(productName);
	Assert.assertTrue(match);
	CheckoutPage checkoutPage = cartPage.goToCheckout();
	checkoutPage.selectCountry("india");
	ConfirmationPage conPage = checkoutPage.submitOrder();
	String confirmMessage = conPage.getConfirmationMessage();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	
	driver.close();
	
	}
}
