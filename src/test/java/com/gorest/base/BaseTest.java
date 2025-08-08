package com.gorest.base;

import com.gorest.config.ConfigManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.baseURI;

public class BaseTest {

    protected RequestSpecification requestSpecification;

    @BeforeClass
    public void setUp(){
        baseURI=ConfigManager.getBaseURI();
        requestSpecification=new RequestSpecBuilder()
                .setBaseUri(baseURI)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization",ConfigManager.getAuthToken())
                .build();
    }
}
