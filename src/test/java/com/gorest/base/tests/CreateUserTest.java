package com.gorest.base.tests;

import com.gorest.base.BaseTest;
import com.gorest.constants.Endpoints;
import com.gorest.models.User;
import com.gorest.utils.JsonDataReader;
import com.gorest.utils.RetryAnalyzer;
import io.restassured.response.Response;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.UUID;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

@Listeners(com.gorest.utils.TestListener.class)
public class CreateUserTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void createUserTest() {
        String email = "test_" + UUID.randomUUID() + "@mail.com";

        //User user = new User("Test User", email, "male", "active");

        //now instead of above statement we will use Builder pattern for our data

        User user=new User.Builder()
                .setName("Priya Automation")
                .setEmail(email)
                .setGender("female")
                .setStatus("active")
                .build();

        Response response = given().spec(requestSpecification)
                .body(user)
                .when()
                .post(Endpoints.USERS)
                .then()
                .log().all()
                .assertThat()
                .statusCode(201)
                .body("email", equalTo(email))
                .extract().response();
    }

    @Test(dataProvider = "userDataFromJson",dataProviderClass= JsonDataReader.class)
    public void createUserFromJson(User userData) {
        // Build the request payload via builder
        given().spec(requestSpecification)
                .body(userData)
                .when().post(Endpoints.USERS)
                .then()
                .statusCode(201)
                .body("name", equalTo(userData.getName()));

    }

}
