package com.testingacademy.testNGExamples;

import groovyjarjarantlr4.v4.runtime.Dependents;
import org.junit.Assert;
import org.testng.annotations.Test;

public class APITesting016_TestNG_DependsOnMethod {

    @Test
    public void serverStartedOK() {
        System.out.println("I Will run first");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOK")
    public void method1() {
        System.out.println("method1");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOK")
    public void method2() {
        System.out.println("method2");
        Assert.assertTrue(true);

    }
}
