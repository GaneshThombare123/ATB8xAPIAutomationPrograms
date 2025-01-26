package com.testingacademy.Integration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class APITesting011_IntegrationTestCase {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    String token;
    String bookingId;

         public String getToken(){

             String payload = "{\n" +
                     "   \"username\" : \"admin\",\n" +
                     "   \"password\" : \"password123\"\n" +
                     "}";

             requestSpecification = RestAssured.given();
             requestSpecification.baseUri("https://restful-booker.herokuapp.com");
             requestSpecification.basePath("/auth");
             requestSpecification.contentType(ContentType.JSON).log().all();
             requestSpecification.body(payload);
// when- Response

             Response response = requestSpecification.when().post();

//Then- ValidableResponse

             ValidatableResponse validatableResponse = response.then();
             validatableResponse.statusCode(200);

//Extract the token

             token = response.jsonPath().getString("token");
             System.out.println(token);

             // AssertJ

             assertThat(token).isNotEmpty().isNotNull().isAlphanumeric().isNotBlank();

             return token;
    }
       public String getBookingId(){
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

           bookingId = response.jsonPath().getString("bookingid");
           System.out.println(bookingId);

           assertThat(bookingId).isNotNull().isNotBlank().isNotEmpty();


           return bookingId;
       }
     @Test
    public void test_update_request_put(){

             String token = getToken();
             String bookingId = getBookingId();
         System.out.println(token);
         System.out.println(bookingId   );

         }
@Test
    public void test_delete_booking(){
    System.out.println(bookingId);
    System.out.println(token);

}
@Test
    public void test_after_delete_request_get(){
    System.out.println(bookingId);

}

}
