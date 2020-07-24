package com.testng0714;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 基本数据类型(8个)
 *         int a1;
 *         float a2;
 *         double a3;
 *         short a4;
 *         byte a5;
 *         boolean a6;
 *         char a7;
 *         long a8;
 *
 *
 *       基本数据类型的包装类
 *         Integer b1 = new Integer(9);
 *         Float b2;
 *         Double b3;
 *         Short b4;
 *         Byte b5;
 *         Boolean b6;
 *         Character b7;
 *         Long b8;
 */

public class TestNGAssert {

    @Test
    public void assertEqualTest(){

        String a = "1";
        int b = 1;
//        Assert.assertEquals(a,b,"a=b");
        Assert.assertEquals(a,b,"a和b不相等");

    }

    @Test
    public void assertNotEqualTest(){

        int a = 1;
        int b = 0;
        Assert.assertNotEquals(a,b,"a和b相等");
    }

    @Test
    public void assertNullTest(){
        String a = null;
        String b = "";
        Integer c = 1;



        Assert.assertNull(a,"a不为空");
        Assert.assertNull(c,"c不为空");
        Assert.assertNull(b,"b不为空");

    }
}
