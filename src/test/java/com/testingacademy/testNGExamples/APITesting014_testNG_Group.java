package com.testingacademy.testNGExamples;

import org.junit.Assert;
import org.junit.Test;

public class APITesting014_testNG_Group {

    @Test
    public void sanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }
    @Test
public void RegRun(){
    System.out.println("Reg");
    Assert.assertTrue(false);
}
    @Test
public void SmokeRun(){
    System.out.println("Smoke");
    Assert.assertTrue(false);
}
    @Test
    public void SanityRun1() {
        System.out.println("Sanity");
        System.out.println("QA");
        boolean True = false;
        Assert.assertTrue(True);
    }
    @Test
    public void SmokeRun3(){
        System.out.println("Smoke");
        boolean fales = false;
        Assert.assertTrue(fales);
    }
}

