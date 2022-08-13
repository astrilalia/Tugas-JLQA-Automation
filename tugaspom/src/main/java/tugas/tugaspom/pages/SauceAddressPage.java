package tugas.tugaspom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceAddressPage extends BasePage {
	
	By firstName = By.xpath("//input[@id='first-name']");
	By lastName = By.xpath("//input[@id='last-name']");
	By zipCode = By.xpath("//input[@id='postal-code']");
	By btnContinue = By.xpath("//input[@id='continue']");
	By flash = By.xpath("//h3[@data-test='error']");

	public SauceAddressPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	public void addressWeb(String first, String last, String code) {
		setText(firstName, first);
		setText(lastName, last);
		setText(zipCode, code);
		clickAndWait(btnContinue);
	}
	
	public String assertAddress() {
		return getText(flash);
	}

}
