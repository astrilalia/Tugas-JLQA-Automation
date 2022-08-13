package tugas.tugaspomtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import tugas.tugaspom.pages.SauceAddressPage;
import tugas.tugaspom.pages.SauceCartPage;
import tugas.tugaspom.pages.SauceCompletePage;
import tugas.tugaspom.pages.SauceLoginPage;
import tugas.tugaspom.pages.SauceOverviewPage;
import tugas.tugaspom.pages.SauceProductPage;

public class WebSauceDemoTest extends BaseWebTest {
	
	String user = "standard_user";
	String pass = "secret_sauce";
	String wrongUser = "standuser";
	String wrongPass = "secretsauce";
	String first = "Anya";
	String last = "Forger";
	String zipCode = "12345";
	
	SauceLoginPage loginPage = new SauceLoginPage(driver, explicitWait);
	SauceProductPage productPage = new SauceProductPage(driver, explicitWait);
	SauceCartPage cartPage = new SauceCartPage(driver, explicitWait);
	SauceAddressPage addressPage = new SauceAddressPage(driver, explicitWait);
	SauceOverviewPage overviewPage = new SauceOverviewPage(driver, explicitWait);
	SauceCompletePage completePage = new SauceCompletePage(driver, explicitWait);
	
	@Test
	public void testSauceDemo() {
		driver.get().get("https://saucedemo.com");
		loginPage.loginWeb(user, pass);
		String actualLogin = productPage.assertLogin();
		String expectedLogin = "PRODUCTS";
		Assert.assertTrue(actualLogin.contains(expectedLogin));
		
		productPage.productWeb();
		cartPage.checkOutWeb();
		addressPage.addressWeb(first, last, zipCode);
		overviewPage.overviewWeb();
		String actualResult = completePage.assertComplete();
		String expectedResult = "THANK YOU FOR YOUR ORDER";
		Assert.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testSauceDemoWrongUsername() {
		driver.get().get("https://saucedemo.com");
		loginPage.loginWeb(wrongUser, pass);
		String actualLogin = loginPage.assertLogin();
		String expectedLogin = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertTrue(actualLogin.contains(expectedLogin));
	}
	
	@Test
	public void testSauceDemoWrongPassword() {
		driver.get().get("https://saucedemo.com");
		loginPage.loginWeb(user, wrongPass);
		String actualLogin = loginPage.assertLogin();
		System.out.println(loginPage.assertLogin());
		String expectedLogin = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertTrue(actualLogin.contains(expectedLogin));
	}
	
	@Test
	public void testSauceDemoWrongUsernamePassword() {
		driver.get().get("https://saucedemo.com");
		loginPage.loginWeb(wrongUser, wrongPass);
		String actualLogin = loginPage.assertLogin();
		String expectedLogin = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertTrue(actualLogin.contains(expectedLogin));
	}

}
