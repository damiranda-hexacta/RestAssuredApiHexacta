package com.hexacta.api.tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import static com.hexacta.api.automation.helpers.SpecialMethods.*;

public class TestBase {
    @BeforeEach
    public void setUp(){
        configPropertiesRead();
        RestAssured.baseURI = properties.getProperty("baseUri");
        RestAssured.basePath = "/";
        RestAssured.filters(new RequestLoggingFilter(),new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).build();
    }
}
