package com.hexacta.api.tests;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static com.hexacta.api.automation.helpers.SpecialMethods.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RequestResponseTest extends TestBase{


    @Test
    public void getAdminById() throws IOException {
       String response = given()
                .header(properties.getProperty("authKey"), properties.getProperty("authValue"))
                .get(properties.getProperty("getAdminPath"))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("username", equalTo("admin"))
                .extract().jsonPath().getString("passHash");
        assertThat(response,equalTo("49dc52e6bf2abe5ef6e2bb5b0f1ee2d765b922ae6cc8b95d39dc06c21c848f8c"));
    }

    @Test
    public void postUser() throws IOException{
        String response = given()
                .header(properties.getProperty("authKey"), properties.getProperty("authValue"))
                .body("{\n" +
                        "  \"id\": 10,\n" +
                        "  \"name\": \"namePost\",\n" +
                        "  \"lastName\": \"lastnamePost\",\n" +
                        "  \"phoneNumber\": numberPost,\n" +
                        "  \"email\": \"emailPost@gmail.com\"\n" +
                        "}")
                .post(properties.getProperty("usersPath"))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("email",equalTo("emailPost@gmail.com"))
                .extract().jsonPath().getString("name");
        assertThat(response,equalTo("namePost"));
    }
}
