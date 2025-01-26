package com.testingacademy.Assertions;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting013_Assertions {

    // TestNG Assertion
    // Verifying ER == AR

@Test
    public void test_hardAssertExample(){
    System.out.println("Start of the program");
    Assert.assertTrue(false);
    System.out.println("End of the program");

    Assert.assertEquals("Pramod", "Pramod");  //True
    Assert.assertEquals("Pramod", "pramod");  // False

    }
@Test
    public void test_softAssertExample(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("This line will be executed");
        softAssert.assertAll();
    }

}
