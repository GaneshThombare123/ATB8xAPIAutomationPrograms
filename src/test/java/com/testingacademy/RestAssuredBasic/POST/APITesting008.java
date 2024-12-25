package com.testingacademy.RestAssuredBasic.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.junit.Test;

public class APITesting008 {

    //https://restful-booker.herokuapp.com/auth

    //Content-Type: application/json

//{
//    "username" : "admin",
//    "password" : "password123"
//}

    @Description("Verify the POST Request by BDDStyle")
    @Test
    public void test_post_BDDStyle() {

        String payload = "{\n" +
                "   \"username\" : \"admin\",\n" +
                "   \"password\" : \"password123\"\n" +
                  "}";
        RestAssured
                .given()
                      .baseUri("https://restful-booker.herokuapp.com")
                      .basePath("/auth")
                      .contentType(ContentType.JSON)
                      .log().all().body(payload)
                .when().log().all()
                .post()
                .then().log().all()
                .statusCode(200);




    }
}
