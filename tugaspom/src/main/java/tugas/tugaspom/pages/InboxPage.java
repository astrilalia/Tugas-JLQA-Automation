package tugas.tugaspom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxPage extends BasePage {
	
	By btnNewMail = By.xpath("//button[@id='newmail']//i");
	By iFrameMail = By.xpath("//iframe[@id='ifmail']");
	By iFrameInbox = By.xpath("//iframe[@id='ifinbox']");
	By btnInbox = By.xpath("(//div[@id='e_ZwVjBQRkZGD0AmV3ZQNjAQH3ZwZ0AD=='])[1]");
	By inboxText = By.xpath("//div[@id='mail']");

	public InboxPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	public void clickNewMail() {
		clickAndWait(btnNewMail);
	}
	
	public void clickInbox() {
		switchFrame(iFrameInbox);
		clickAndWait(btnInbox);
		switchParentFrame();
	}
	
	public String testInbox() {
		switchFrame(iFrameMail);
		return getText(inboxText);
	}
	
	

}
