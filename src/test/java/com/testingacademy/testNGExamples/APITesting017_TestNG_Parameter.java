package com.testingacademy.testNGExamples;

import com.beust.jcommander.Parameter;
import org.junit.jupiter.api.Test;
import org.testng.annotations.Parameters;

public class APITesting017_TestNG_Parameter {

    @Parameters("browser")
    @Test
    void demo1() {
        String value = "chrome";
        System.out.println("Browser is " +value);
        //open the browser and select etc.
        if (value.equalsIgnoreCase("chrome")) {
            System.out.println("Start my Testing");

        }
        if (value.equalsIgnoreCase("firefox")) {
            System.out.println("Start my Testing");
        }

    }
}