package com.testng0718;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class ActionsCases {
    WebDriver webDriver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\WFF\\workspace\\automation\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();

    }

    /**
     * 单击，双击某个按钮
     */
    @Test
    public void actionCase(){
        webDriver.get("file:///E:/WFF/javaselenium/selenium_html/index.html");
        //定位 action button
        WebElement actionButton = webDriver.findElement(By.xpath("//*[@id=\"action\"]/input"));
        //实例化一个Actions 对象
        Actions ac = new Actions(webDriver);
        //右键action button
        ac.contextClick(actionButton).perform();
        //双击action button
        ac.doubleClick(actionButton).perform();
        WebElement tipTextElement = webDriver.findElement(By.xpath("//*[@id=\"over\"]"));
        String text = tipTextElement.getText();
        System.out.println(text);


    }

/**
 *
 * 上传
 *
 */
    @Test
    public void uploadTestCase() throws InterruptedException, AWTException {
        webDriver.get("https://ui-data-portal-dpc-dev.earth-aws-us.xpaas.lenovo.com/");
        WebElement username = webDriver.findElement(By.xpath("//*[@id=\"username\"]"));
        username.sendKeys("wuff5");
        WebElement pw = webDriver.findElement(By.xpath("//*[@id=\"password\"]"));
        pw.sendKeys("620520Wff#");
        WebElement loginbutton = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div/form/button"));
        loginbutton.click();
        webDriver.manage().window().maximize();
        //等待Flag upload菜单名出现 并点击进入 flag upload 页面
        WebElement until = new WebDriverWait(webDriver, 11).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/aside/div/div[1]/ul/li[3]/span/a")));
        webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/aside/div/div[1]/ul/li[3]/span/a")).click();
        Thread.sleep(3000);
        //等待country组件出现，并点击展开箭头
        new WebDriverWait(webDriver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div/div/ul/li[1]/span/span")));
        webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div/div/ul/li[1]/span/span")).click();
        //等待country组件下拉列表出现，选择LA
        new WebDriverWait(webDriver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"rc-tree-select-list_1\"]/ul/li[4]/span[2]/span")));
        webDriver.findElement(By.xpath("//*[@id=\"rc-tree-select-list_1\"]/ul/li[4]/span[2]/span")).click();
        //等待flag下拉框出现，点击展开箭头
        new WebDriverWait(webDriver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div/div/ul/li[2]/div[1]/div/div/div[1]")));
        webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div/div/ul/li[2]/div[1]/div/div/div[1]")).click();
        //等待flag选项出现，点击第一个选项
        new WebDriverWait(webDriver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div/div/ul/li[2]/div[2]/div/div/div/ul/li[1]")));
        WebElement element1 = webDriver.findElement(By.className("ant-select-dropdown-menu-item"));

        Actions actions = new Actions(webDriver);
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div/div/ul/li[2]/div[2]/div/div/div/ul/li[1]"));
        System.out.println("================="+element.getText());
        System.out.println("================="+element1.getText());
        actions.moveToElement(element1).click().perform();

        //点击Import按钮
        new WebDriverWait(webDriver,20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div/div/div[4]/span[1]/div[1]/span/button")));
        webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div/div/div[4]/span[1]/div[1]/span/button")).click();
        Thread.sleep(5000);
        //指定上传文件路径
        StringSelection uploadFile = new StringSelection("D:\\DCG\\Test\\upload test files\\Flags upload-2PN.csv");
        //把上传文件路径复制到剪切板
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(uploadFile,null);

        //模拟键盘 ctrl+V 和Enter
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_C);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


    }
}
