package tugas.tugaspomtest;

import org.testng.annotations.Test;

import tugas.tugaspom.pages.ContentPage;
import tugas.tugaspom.pages.HomePage;
import tugas.tugaspom.pages.InboxPage;

public class WebYopmailTest extends BaseWebTestHeadless {
	
	String emailName = "automationtest";
	
	HomePage homePage = new HomePage(driver, explicitWait);
	InboxPage inboxPage = new InboxPage(driver, explicitWait);
	ContentPage contentPage = new ContentPage(driver, explicitWait);
	
	@Test
	public void testHome() {
		driver.get().get("https://yopmail.com");
		homePage.homeWeb(emailName);
		inboxPage.clickNewMail();
		contentPage.contentWeb(emailName, "test", "halo");
		inboxPage.clickInbox();
		
		System.out.println(inboxPage.testInbox());
	}
	

}
