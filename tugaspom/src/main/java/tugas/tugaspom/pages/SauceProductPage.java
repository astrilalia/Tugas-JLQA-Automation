package tugas.tugaspom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceProductPage extends BasePage {
	
	By product1 = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
	By product2 = By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']");
	By iconCart = By.xpath("//div[@id='shopping_cart_container']//a");
	By remove1 = By.xpath("//button[@id='remove-sauce-labs-backpack']");
	By remove2 = By.xpath("//button[@id='remove-sauce-labs-bolt-t-shirt']");
	By assertLogin = By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div/span[1]");

	public SauceProductPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	public void productWeb() {
		clickAndWait(product1);
		clickAndWait(product2);
		clickAndWait(iconCart);
	}
	
	public String assertProduct1() {
		return getText(remove1);
	}
	
	public String assertProduct2() {
		return getText(remove2);
	}
	
	public String assertLogin() {
		return getText(assertLogin);
	}

}
