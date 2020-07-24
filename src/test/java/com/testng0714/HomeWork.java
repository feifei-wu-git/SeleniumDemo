package com.testng0714;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWork {
    WebDriver webDriver;

    @BeforeMethod
    public void openBrowser() {
        //设置Chromedriver 路径
        System.setProperty("webdriver.chrome.driver","E:\\WFF\\workspace\\automation\\drivers\\chromedriver.exe");
        //实例化webDriver
        webDriver = new ChromeDriver();
        //打开百度
        webDriver.get("https://www.baidu.com");
    }

    @Test
    public void testCase01() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("第一次等待2s");
    }

    @Test
    public void testCase02() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("第二次等待2s");
        webDriver.navigate().back();
        Thread.sleep(1000);
        System.out.println("又等待了1s");

    }

    @Test
    public void testCase03() throws InterruptedException {

        Dimension dimension = new Dimension(300,300);
        webDriver.manage().window().setSize(dimension);
        Thread.sleep(2000);
        System.out.println("第三次等待2s");
        webDriver.manage().window().maximize();
        Thread.sleep(2000);
        System.out.println("第四次等待2s");
    }

    @Test
    public void case1() throws InterruptedException {
        Thread.sleep(2000);
        String url = webDriver.getCurrentUrl();
        String str = "/s?wd=高考&sa=searchpromo_gk_pc_ysj";
        webDriver.navigate().back();
        webDriver.get(url+str);
        Thread.sleep(2000);

    }

    @AfterMethod
    public void quitBrowser(){

        webDriver.quit();
    }


}
