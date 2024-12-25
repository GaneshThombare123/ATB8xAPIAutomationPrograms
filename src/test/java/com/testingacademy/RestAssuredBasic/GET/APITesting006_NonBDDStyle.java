package com.testingacademy.RestAssuredBasic.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Description;
import org.junit.Test;

public class APITesting006_NonBDDStyle {

    static RequestSpecification r = RestAssured.given();

    @Test
    public void test_NonBDDStyleGET_POSITIVE() {
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://www.zippopotam.us");
        r.basePath("/in/" + 500038);
        r.when().log().all().get();
        r.then().log().all().statusCode(200);

    }

    @Test
    public void test_NonBDDStyleGET_NEGATIVE() {
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://www.zippopotam.us");
        r.basePath("/in/" + 500038);
        r.when().log().all().get();
        r.then().log().all().statusCode(404);
    }
}