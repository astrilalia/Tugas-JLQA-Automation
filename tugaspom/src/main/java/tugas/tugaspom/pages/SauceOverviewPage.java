package tugas.tugaspom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceOverviewPage extends BasePage {
	
	By btnFinish = By.xpath("//button[@id='finish']");

	public SauceOverviewPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	public void overviewWeb() {
		clickAndWait(btnFinish);
	}

}
