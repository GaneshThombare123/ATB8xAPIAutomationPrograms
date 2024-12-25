package com.testingacademy.RestAssuredBasic.GET;

import io.restassured.RestAssured;
import org.junit.Test;

public class APITesting005_BDDStyleGET {

    @Test
    public void test_GET_Req_POSITIVE() {
        String pin_code = "500038";

        RestAssured
                .given()
                .baseUri("https://www.zippopotam.us")
                .basePath("/in/" + pin_code)

                .when()
                .log()
                .all()
                .get()
                .then()
                .log().all()

                .statusCode(200);


    }

// NEGATIVE TEST CASE PART

    public void test_GET_Req_NEGATIVE() {
        String pin_code = "-1";

        RestAssured
                .given()
                .baseUri("https://www.zippopotam.us")
                .basePath("/in/" + pin_code)

                .when()
                .log()
                .all()
                .get()
                .then()
                .log().all()

                .statusCode(200);


    }


}