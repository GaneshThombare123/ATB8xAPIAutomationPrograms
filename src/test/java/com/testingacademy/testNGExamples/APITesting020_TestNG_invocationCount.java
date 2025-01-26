package com.testingacademy.testNGExamples;

import org.junit.Assert;
import org.junit.Test;

public class APITesting020_TestNG_invocationCount {

  //  @Test(invocationCount = 5) -- not working here for me
    @Test
    public void test01(){Assert.assertTrue(true); }

}