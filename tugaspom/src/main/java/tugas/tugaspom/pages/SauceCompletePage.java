package tugas.tugaspom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceCompletePage extends BasePage {
	
	By completeText = By.xpath("//div[@id='checkout_complete_container']//h2");

	public SauceCompletePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	public String assertComplete() {
		return getText(completeText);
	}

}
