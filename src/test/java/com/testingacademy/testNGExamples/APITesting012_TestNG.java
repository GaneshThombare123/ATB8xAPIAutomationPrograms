package com.testingacademy.testNGExamples;

import org.junit.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class APITesting012_TestNG {
    @BeforeTest
    public void getToken(){
        System.out.println("1");
    }
    @BeforeTest
public void getBookingID(){
    System.out.println("2");
}
@AfterTest
public void test_PUT(){
        //token and BookingID
    System.out.println("3");
    System.out.println("Close");

}
}
