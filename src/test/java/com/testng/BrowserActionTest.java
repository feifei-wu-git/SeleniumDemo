package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserActionTest {
    //声明一个webDriver 对象
    WebDriver webDriver ;

    @BeforeMethod
    public void openBrowser(){
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","E:\\WFF\\workspace\\automation\\drivers\\chromedriver.exe");
//        //实例化webdriver
        webDriver = new ChromeDriver();
        //打开Admin Tool首页
        webDriver.get("https://ui-data-portal-dpc-dev.earth-aws-us.xpaas.lenovo.com/");
        //等待2s
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void browserActionTest(){
//        //设置chromedriver路径
//        System.setProperty("webdriver.chrome.driver","E:\\WFF\\workspace\\automation\\drivers\\chromedriver.exe");
////        //实例化webdriver
////        WebDriver webDriver = new ChromeDriver();
//        //打开Admin Tool首页
//        webDriver.get("https://ui-data-portal-dpc-dev.earth-aws-us.xpaas.lenovo.com/");
//        //等待2s
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //浏览器最大化
        webDriver.manage().window().maximize();
        String currentURL = webDriver.getCurrentUrl();
        System.out.println(currentURL);
//
//        webDriver.navigate().back();
//        webDriver.navigate().forward();

        //关闭Chrome 进程
        webDriver.quit();


    }







}
