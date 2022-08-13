package tugas.tugaspom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContentPage extends BasePage {
	
	By toName = By.xpath("//input[@id='msgto']");
	By subject = By.xpath("//input[@id='msgsubject']");
	By content = By.xpath("//div[@id='msgbody']");
	By btnSend = By.xpath("//button[@id='msgsend']");
	By btnRefresh = By.xpath("//button[@id='refresh']");
	By iFrameMail = By.xpath("//iframe[@id='ifmail']");

	public ContentPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	public void contentWeb(String name, String subj, String mail) {
		switchFrame(iFrameMail);
		setText(toName, name);
		setText(subject, subj);
		setText(content, mail);
		clickAndWait(btnSend);
		switchParentFrame();
		clickAndWait(btnRefresh);
	}

}
