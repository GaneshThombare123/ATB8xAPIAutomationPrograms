package com.testingacademy.RestAssuredBasic.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Description;
import org.junit.Test;

public class APITesting009_NonBDDStyle {
    @Description("Verify the POST Request by NonBDDStyle")
    @Test
    public void test_post_NonBDDStyle() {

        String payload = "{\n" +
                "   \"username\" : \"admin\",\n" +
                "   \"password\" : \"password123\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
                r.baseUri("https://restful-booker.herokuapp.com");
                r.basePath("/auth");
                r.contentType(ContentType.JSON).log().all();
                r.body(payload);
        r.when().post();
        r.then().log().all().statusCode(200);
    }
}