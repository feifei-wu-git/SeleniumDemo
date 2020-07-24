package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenBrowser {

    @Test
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\WFF\\workspace\\automation\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

    }
    @Test
    public void openFF() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","E:\\WFF\\workspace\\automation\\drivers\\geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("http://baidu.com");
        Thread.sleep(2000);
        webDriver.navigate().back();
        Thread.sleep(5000);
        webDriver.quit();
    }



}
