package tugas.tugasapi;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.Locale;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class APITestSignUp extends BaseAPITestSignUp {
	
	@Test
	public void signUpAPI() {
		Faker faker = new Faker(new Locale("en-ID"));
		
		firstName = faker.name().firstName();
		lastName = faker.name().lastName();
		phoneNumber = faker.numerify("+62-###-####-####");
		email = faker.internet().emailAddress();
		password = faker.internet().password();
//		System.out.println(firstName + " " + lastName + ". No: " + phoneNumber + " email: " + email + " pass: " + password);
		
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
	
}
