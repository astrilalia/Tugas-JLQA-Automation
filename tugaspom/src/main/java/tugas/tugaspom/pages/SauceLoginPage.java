package tugas.tugaspom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceLoginPage extends BasePage {
	
	By username = By.xpath("//input[@id='user-name']");
	By password = By.xpath("//input[@id='password']");
	By loginBtn = By.xpath("//input[@id='login-button']");
	By flash = By.xpath("//h3[@data-test='error']");

	public SauceLoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	public void loginWeb(String user, String pass) {
		setText(username, user);
		setText(password, pass);
		clickAndWait(loginBtn);
	}
	
	public String assertLogin() {
		return getText(flash);
	}

}
