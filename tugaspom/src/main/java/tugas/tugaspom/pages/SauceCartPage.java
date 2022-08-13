package tugas.tugaspom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceCartPage extends BasePage {
	
	By btnCheckOut = By.xpath("//button[@id='checkout']");

	public SauceCartPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	public void checkOutWeb() {
		clickAndWait(btnCheckOut);
	}

}
