package com.testng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * 测试TestPage 类里面的方法
 */
public class TestPageCase {

//    @BeforeTest
//    public void beforeTest(){
//        System.out.println("访问页面");
//    }
//
//    @AfterTest
//    public void afterTest(){
//        System.out.println("已完成查看和搜索");
//    }
//
//    @Test
//    public void viewCase(){
//       TestPage tp = new TestPage();    // 普通方法必须先实例化： 先new一个对象，对象名是即将要引用的类名。再将该对象实例化。
//        tp.pageView();
//    }
//
//    @Test
//    public void searchCase(){
//        TestPage.pageSearch();    // 静态方法虽然可以实例化调用。但是一般会直接用 类名.方法名进行调用
//
//    }

    @BeforeTest
    public void testCase01(){
        TestPage.c();
    }

    @BeforeMethod
    public void testCase02(){
        TestPage.b();
    }

    @Test
    public void testCase03(){
        TestPage.a();
    }

    @Test
    public void testCase04(){
        TestPage.a();
    }

    @AfterTest
    public void testCase06(){
        TestPage.d();
    }
}
