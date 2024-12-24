package com.testingacademy.sampleCheck;

public class APITest003_NonDesignPattern {
    public void step1(){
        System.out.println("Step 1");
    }
    public void step2(){
        System.out.println("Step 2");
    }
    public void step3(String pramod){
        System.out.println("Step 3");
    }
public static void main(String[] args){
    APITest003_NonDesignPattern np = new APITest003_NonDesignPattern();
    np.step1();
    np.step2();
    np.step3("Pramod");

}


}
