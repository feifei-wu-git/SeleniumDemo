package com.testng;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowSetTest {
    @Test

    public void winSetTest() throws InterruptedException {

        //设置Chrome driver 路径
        System.setProperty("webdriver.chrome.driver","E:\\WFF\\workspace\\automation\\drivers\\chromedriver.exe");

        //实例化webdriver
        WebDriver webDriver = new ChromeDriver();

        //实例化Dimension
        Dimension dimension = new Dimension(300,400);

        webDriver.manage().window().setSize(dimension);
        //等待3s


        Thread.sleep(3000);

    }
}
