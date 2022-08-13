package tugas.tugaspom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	
	By email = By.xpath("//input[@id='login']");
	By loginBtn = By.xpath("//i[@class='material-icons-outlined f36']");
	
	public HomePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	public void homeWeb(String emailName) {
		setText(email, emailName);
		clickAndWait(loginBtn);
	}

}
