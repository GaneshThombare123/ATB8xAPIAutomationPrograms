package com.testingacademy.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.assertj.core.api.Assertions.*;


public class APITesting014_Assertions_REAL {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;

@Test
    public void test_post(){
    String payload_POST = "{\n"+
            "     \"firstname\" : \"James\",\n"+
            "      \"lastname\" : \"Brown\",\n"+
            "    \"totalprice\" : 111,\n"+
            "    \"depositpaid\" : true,\n"+
            "    \"bookingdates\" : {\n"+
            "    \"checkin\" : \"2018-01-01\",\n"+
            "    \"checkout\" : \"2019-01-01\"\n"+
            "   },\n"+
            "   \"additionalneeds\" : \"Breakfast\"\n"+
            "}";
    requestSpecification = RestAssured.given();
    requestSpecification.baseUri("https://restful-booker.herokuapp.com");
    requestSpecification.basePath("/booking");
    requestSpecification.contentType(ContentType.JSON).log().all();
    requestSpecification.body(payload_POST).log().all();

    Response response = requestSpecification.when().post();

//Then- ValidableResponse

    validatableResponse = response.then().log().all();
    validatableResponse.statusCode(200);

    // Validatable resposnce I

    validatableResponse.body("booking.firstname", Matchers.equalTo("James"));
    validatableResponse.body("booking.lastname", Matchers.equalTo("Brown"));
    validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
    validatableResponse.body("bookingid", Matchers.notNullValue());

    // TestNG Assertions

    bookingId = response.then().extract().path("bookingid");
    String firstname = response.then().extract().path("booking.firstname");
    String lastname = response.then().extract().path("booking.lastname");

    Assert.assertNotNull(bookingId);
    Assert.assertEquals(firstname, "James");
    Assert.assertEquals(lastname, "Brown");

    // AssertJ

    assertThat(bookingId).isNotNull().isPositive().isNotZero();
    assertThat(firstname).isEqualTo("James").isNotNull().isNotBlank().isNotEmpty().isAlphanumeric();


}

}
