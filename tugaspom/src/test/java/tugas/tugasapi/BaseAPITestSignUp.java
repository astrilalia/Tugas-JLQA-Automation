package tugas.tugasapi;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseAPITestSignUp {
	
	String firstName;
	String lastName;
	String phoneNumber;
	String email;
	String password;
	
	RequestSpecification commonJsonSpec = new RequestSpecBuilder()
			.setBaseUri("https://api-staging-builder.engineer.ai/")
			.setContentType(ContentType.JSON)
			.build().log().all();

}
