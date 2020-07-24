package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CloseBrowser {

    @Test
    public void closeBrowser(){
        System.setProperty("webdriver.chrome.driver","E:\\WFF\\workspace\\automation\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        try {
            Thread.sleep(5000);
        }catch (Exception e){

        }

        //关闭当前页面
        webDriver.close();
        //关闭Chrome浏览器进程
        webDriver.quit();


    }
}
