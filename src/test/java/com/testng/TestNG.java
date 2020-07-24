package com.testng;

import org.testng.annotations.*;

public class TestNG {

    @Test
    // @Test注解
    public void testCase01(){
        System.out.println("这是@Test注解，case1");
    }

    @Test
    public void testCase02(){
        System.out.println("这是@Test注解，case2");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("这是@BeforeTest注解");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("这是@AfterTest注解");
    }

    @BeforeMethod
    public void beforMethod(){
        System.out.println("这是@BeforeMethod注解");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("这是@AfterMethod注解");
    }

}
