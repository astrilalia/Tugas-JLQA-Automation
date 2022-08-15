# Kumpulan Tugas QA Automation JLabs Batch 10
By: Astrila Ikhlasia Eprina (Lia)

## Overview

- Tugas 1: Buat TreeMap & TreeSet
- Tugas 2: Buat Kalkulator dengan OOP
- Tugas 3: YopMail Testing dengan switch iFrame
- Tugas 4: SauceDemo Testing dengan POM
- Tugas 5: API testing dengan Rest Assured dan Faker untuk generate fake value.
- Tugas 6: Upload semua tugas ke Repository dan buat ReadME.
- Tugas 7: Upload file JMeter.

# Tugas 1
Buat TreeMap & TreeSet dengan minimum 3 member

File tugas:
- [Tugas-QA/TugasJava/src/com/tugassatu/](https://github.com/astrilalia/Tugas-QA/blob/main/TugasJava/src/com/tugassatu/TugasSatu.java)

```java
import java.util.TreeMap;
import java.util.TreeSet;

public class FirstTask {

	public static void main(String[] args) {
		
		//TreeSet
		TreeSet<String> listBatch10 = new TreeSet<>();
		listBatch10.add("Arif");
		listBatch10.add("Silvi");
		listBatch10.add("Devi");
		
		for (String item : listBatch10) {
			System.out.println(item);
		}
		
		//TreeMap
		TreeMap<Integer, String> listNumberBatch10 = new TreeMap<>();
		listNumberBatch10.put(11, "John");
		listNumberBatch10.put(3, "Sri");
		listNumberBatch10.put(5, "Andin");
		
		for (Integer key : listNumberBatch10.keySet()) {
			System.out.println(key + " " + listNumberBatch10.get(key));
		}
		

	}

}
```
Output tugas 1
```
Arif
Devi
Silvi
3 Sri
5 Andin
11 John
```

# Tugas 2
Buat kalkulator dengan OOP. Jika input berupa String maka throw error karena bukan angka.

File Tugas: 
- [Tugas-QA/TugasJava/src/com/tugasdua/Calculator.java](https://github.com/astrilalia/Tugas-QA/blob/main/TugasJava/src/com/tugasdua/Calculator.java)
- [Tugas-QA/TugasJava/src/com/tugasdua/CalculatorGetterSetter.java](https://github.com/astrilalia/Tugas-QA/blob/main/TugasJava/src/com/tugasdua/CalculatorGetterSetter.java)
- [Tugas-QA/TugasJava/src/com/tugasdua/CalculationSyso.java](https://github.com/astrilalia/Tugas-QA/blob/main/TugasJava/src/com/tugasdua/CalculationSyso.java)

## Case positive: 
Gunakan int val1 dengan value ``calculator.getValue1()`` untuk mengisi value pertama dengan angka.

```java
try {
	CalculatorGetterSetter calculator = new CalculatorGetterSetter(9, 3);
	IsStringCalculator calculate = new IsStringCalculator();

//			String valString = ""; 
//			int val1 = Integer.parseInt(valString); //Value untuk test input string
	int val1 = calculator.getValue1(); //Value untuk test input integer
	int val2 = calculator.getValue2();
```

Output case positive:
```
Hasil penjumlahan 9 + 3 = 12
Hasil pengurangan 9 - 3 = 6
Hasil pembagian 9 / 3 = 3
Hasil perkalian 9 * 3 = 27
```

## Case negative: 
Gunakan int val1 dengan value ``Integer.parseInt(valString)`` untuk mengisi value pertama dengan string.

```java
try {
	CalculatorGetterSetter calculator = new CalculatorGetterSetter(9, 3);
	IsStringCalculator calculate = new IsStringCalculator();

	String valString = ""; 
	int val1 = Integer.parseInt(valString); //Value untuk test input string
//			int val1 = calculator.getValue1(); //Value untuk test input integer
	int val2 = calculator.getValue2();
```

Output case negative:
```
java.lang.NumberFormatException: For input string: ""
	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.lang.Integer.parseInt(Integer.java:592)
	at java.lang.Integer.parseInt(Integer.java:615)
	at com.tugas.Calculator.main(Calculator.java:12)
Exception in thread "main" java.lang.Exception: Sorry you aren't number!
	at com.tugas.Calculator.main(Calculator.java:30)
```
# Tugas 3
1. Go to yopmail.com
2. Input automationtest as email
3. Use switch iframe to get inbox content
4. Syso content of inbox

File tugas:
- [Web Test Yopmail](https://github.com/astrilalia/Tugas-QA/blob/main/tugaspom/src/test/java/tugas/tugaspomtest/WebYopmailTest.java)
- [Inbox Page - iFrame](https://github.com/astrilalia/Tugas-QA/blob/main/tugaspom/src/main/java/tugas/tugaspom/pages/InboxPage.java)
- [Base Page](https://github.com/astrilalia/Tugas-QA/blob/main/tugaspom/src/main/java/tugas/tugaspom/pages/BasePage.java)
- [dll](https://github.com/astrilalia/Tugas-QA/tree/main/tugaspom/src) (ada di dlm file src)

```java
public void switchFrame(By locator) {
	driver.get().switchTo().frame(driver.get().findElement(locator));
}
```
```java
public class InboxPage extends BasePage {
	
	By btnNewMail = By.xpath("//button[@id='newmail']//i");
	By iFrameMail = By.xpath("//iframe[@id='ifmail']");
	By iFrameInbox = By.xpath("//iframe[@id='ifinbox']");
	By btnInbox = By.xpath("(//button[@onclick='g(this);'])[1]");
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
```
```java
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
		
		System.output.println(inboxPage.testInbox());
	}
	
}
```

Output tugas 3
```
halo
PASSED: testHome

===============================================
    Default test
    Tests run: 1, Failures: 0, Skips: 0
===============================================
```
# Tugas 4
1. Go to saucedemo.com
2. Input username and password
3. Add 2 product
4. Checkout and pay
5. Please create all of this using POM

File tugas: 
- [Web Test Saucedemo](https://github.com/astrilalia/Tugas-QA/blob/main/tugaspom/src/test/java/tugas/tugaspomtest/WebSauceDemoTest.java)

Contoh positive case di Saucedemo:
```java
@Test
public void testSauceDemo() {
	driver.get().get("https://saucedemo.com");
	loginPage.loginWeb(user, pass);
	String actualLogin = productPage.assertLogin();
	String expectedLogin = "PRODUCTS";
	Assert.assertTrue(actualLogin.contains(expectedLogin));

	productPage.productWeb();
	cartPage.checkOutWeb();
	addressPage.addressWeb(first, last, zipCode);
	overviewPage.overviewWeb();
	String actualResult = completePage.assertComplete();
	String expectedResult = "THANK YOU FOR YOUR ORDER";
	Assert.assertTrue(actualResult.contains(expectedResult));
}
```
Output tugas 4
```
PASSED: testSauceDemo
PASSED: testSauceDemoWrongPassword
PASSED: testSauceDemoWrongUsername
PASSED: testSauceDemoWrongUsernamePassword

===============================================
    Default test
    Tests run: 4, Failures: 0, Skips: 0
===============================================
```
# Tugas 5
1. Find API to signup for engineer.ai
2. User faker to create a dummy email, dummy name, and dummy phone number
3. Assert to get 200OK

File tugas:
- [Base API SignUp](https://github.com/astrilalia/Tugas-QA/blob/main/tugaspom/src/test/java/tugas/tugasapi/BaseAPITestSignUp.java)
- [API Test SignUp](https://github.com/astrilalia/Tugas-QA/blob/main/tugaspom/src/test/java/tugas/tugasapi/APITestSignUp.java)

```java
@Test
public void signUpAPI() {
	Faker faker = new Faker(new Locale("en-ID"));

	firstName = faker.name().firstName();
	lastName = faker.name().lastName();
	phoneNumber = faker.numerify("+62-###-####-####");
	email = faker.internet().emailAddress();
	password = faker.internet().password();

	String payload = String.format("{\r\n" + 
			"    \"user\": {\r\n" + 
			"        \"first_name\": \"%1$s\",\r\n" + 
			"        \"last_name\": \"%2$s\",\r\n" + 
			"        \"email\": \"%3$s\",\r\n" + 
			"        \"password\": \"%4$s\",\r\n" + 
			"        \"phone_number\": \"%5$s\",\r\n" + 
			"        \"user_type\": \"User\",\r\n" + 
			"        \"currency_id\": 2\r\n" + 
			"    }\r\n" + 
			"}", firstName, lastName, email, password, phoneNumber);

	Response responseSignup = given().spec(commonJsonSpec)
			.body(payload)
			.when().post("/users");

	assertEquals(responseSignup.statusCode(), 200);
}
```
Output tugas 5
```
Body:
{
    "user": {
        "first_name": "Dana",
        "last_name": "Homenick",
        "email": "devin.bosco@gmail.com",
        "password": "m012clzjfb",
        "phone_number": "+62-024-2389-4492",
        "user_type": "User",
        "currency_id": 2
    }
}
PASSED: signUpAPI

===============================================
    Default test
    Tests run: 1, Failures: 0, Skips: 0
===============================================
```
# Tugas 6
1. Create readme.md for all your assignment
2. Create a repository that contains all your assignment
3. Add andromedasiddhik or cupidline as collaborator
4. To get a full marks must be uploaded in 12 Agustus 2022

```
Selamat membaca README ini! :D
```
# Tugas 7
Upload .jmx ke repository tugas yang berisi
1. Simple load test
2. Data driven load test
3. GraphQL load test
4. Spike load test
5. Database loadtest

File tugas:
- [File jmx](https://github.com/astrilalia/Tugas-QA/blob/main/Thread%20Group.jmx)

# Ucapan terima kasih
Terima kasih banyak mas Andro atas ilmunya yg banyaaaak banget dan pastinya sangat berguna.
Senang rasanya bisa belajar QA Automation di sini.

Sehat selalu mas!
