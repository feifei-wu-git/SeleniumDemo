package com.testng0718;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.PageElements;

import java.util.List;
import java.util.Set;

public class FrameCase {

    WebDriver webDriver;


    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\WFF\\workspace\\automation\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();

    }

    /**
     * 1. 打开“UI自动化测试”主页
     * 2. 点击Alert按钮
     * 3.  在alert警告框点击确定按钮
     */



    @Test
    public void alertCase() throws InterruptedException {
        webDriver.get("file:///E:/WFF/javaselenium/selenium_html/index.html");
        webDriver.manage().window().maximize();
        WebElement alertel = webDriver.findElement(PageElements.alerter);
        alertel.click();
        Thread.sleep(2000);
        Alert alert = webDriver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        String exText = "请点击确定";
        alert.accept();
        Assert.assertEquals(alertText,exText,"Alert弹框打开不成功");


    }


    /**
     * 1. 打开“UI自动化测试”主页
     * 2. 点击Confirm按钮
     * 3.  在Confirm警告框点击确定\取消按钮
     */

    @Test
    public void confirmCase() throws InterruptedException {
        webDriver.get("file:///E:/WFF/javaselenium/selenium_html/index.html");
        WebElement confirmElemenet = webDriver.findElement(PageElements.conElement);
        confirmElemenet.click();
        Alert alert = webDriver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();
//        alert.dismiss();
        String confirmText = alert.getText();
        String exceptedConfirmText = "你点击的结果是-确定";
        alert.accept();
        Assert.assertEquals(confirmText,exceptedConfirmText,"Confirm弹框点击确定不成功");


    }


    /**
     *
     *  1.打开“UI自动化测试”主页
     * 	2. 点击Prompt按钮
     * 	3. 在Prompt 弹窗中，输入“这个是Prompt”
     * 	4.  点击确定\取消按钮
     *
     */

    @Test
    public void promptCase() throws InterruptedException {
        webDriver.get("file:///E:/WFF/javaselenium/selenium_html/index.html");
        WebElement promptElement = webDriver.findElement(By.className("prompt"));
        promptElement.click();
//        Thread.sleep(2000);
        Alert promptAlert = webDriver.switchTo().alert();
        promptAlert.sendKeys("prompt窗口测试内容");
        Thread.sleep(5000);
        promptAlert.accept();
        String promptAcceptText = promptAlert.getText();
        String expectedAcceptText = "你点击的结果是-确定";
        promptAlert.accept();
        Assert.assertEquals(promptAcceptText,expectedAcceptText,"Prompt弹框测试不成功");



    }


    /**
     *
     *  1. 定位iFrame
     * 	2. driver控制权交给iFrame
     * 	3. 操作iFrame里面的元素
     * 	4. driver控制权交回原页面
     */

    @Test
    public void iframeCase() throws InterruptedException {
        webDriver.get("file:///E:/WFF/javaselenium/selenium_html/index.html");
        webDriver.manage().window().maximize();
        WebElement iframeElement = webDriver.findElement(By.name("aa"));
        webDriver.switchTo().frame(iframeElement);
        WebElement subIframeElement = webDriver.findElement(By.xpath("//*[@id=\"user\"]"));
        subIframeElement.sendKeys("iframe测试");
        Thread.sleep(2000);
        webDriver.switchTo().defaultContent();
        WebElement inputElement = webDriver.findElement(By.xpath("//*[@id=\"user\"]"));
        inputElement.sendKeys("testing");
        Thread.sleep(2000);


    }


    /**
     * 1.定位selector下拉框
     * 2.使用三种处理方式
     *
     * dropdownlist 三种处理方式：
     * 	1. selectByIndex() 根据索引来选取，从0开始
     * 	2. selectByValue() 根据属性value的属性值来选取
     * 	3. selectByVisibleText()根据标签之间的Text值，也就是页面显示的
     *
     */

    @Test
    public void dropDownListCase() throws InterruptedException {
        webDriver.get("file:///E:/WFF/javaselenium/selenium_html/index.html");
        WebElement selectorElement = webDriver.findElement(By.name("select"));
        //实例化一个Select 对象
        Select select = new Select(selectorElement);
//        select.selectByIndex(3);
//        Thread.sleep(2000);
//        select.selectByValue("oppe");
//        Thread.sleep(2000);
        select.selectByVisibleText("huawei");
        Thread.sleep(2000);


//        List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
//        System.out.println("下拉框选项有：" + );

        List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
        for (WebElement webElement : allSelectedOptions){
            String value = webElement.getAttribute("value");
            System.out.println("getallselectedoptions 是：" + value);
        }

//        for (int i = 0; i<allSelectedOptions.size();i++){
//            String value = allSelectedOptions.get(i).getAttribute("value");
//            System.out.println(value);
//        }

        List<WebElement> options = select.getOptions();
        for (WebElement webElement : options){
            String value = webElement.getAttribute("value");
            System.out.println("getoption的值是" + value);
        }

    }


    /**
     * 多窗口处理
     *  1.打开UI自动化测试页面
     *  2.定位打开新窗口
     *  3.在新窗口中选择下拉框第二个选项值
     *
     */

    @Test
    public void multiWindowTest(){
        webDriver.get("file:///E:/WFF/javaselenium/selenium_html/index.html");
        WebElement newWindowElement = webDriver.findElement(By.xpath("//*[@id=\"open\"]/a"));
        newWindowElement.click();
        //获取当前页面句柄
        String currentWindowHandle = webDriver.getWindowHandle();
//        String currentWindowHandle3 = "";
        //获取所有页面的句柄，如果不是当前页面的句柄，则使用switchto()
//        Set<String> windowHandles = webDriver.getWindowHandles();

        // 页面跳转提交控制权
        String currentWindowHandle2 = FrameCase.windowHand(webDriver, webDriver.getWindowHandle(), webDriver.getWindowHandles());

//        for(String currentWindowHandles:webDriver.getWindowHandles()){
////            if(currentWindowHandles.equals(currentWindowHandle)){
////                continue;
////            }else {
////                webDriver.switchTo().window(currentWindowHandles);
////                WebElement newElement = webDriver.findElement(By.xpath("//*[@id=\"user\"]"));
////                newElement.sendKeys("新窗口输入测试");
////            }
//            //如果获取的句柄和当前句柄不一样，则赋值给句柄2
//            if(!currentWindowHandles.equals(currentWindowHandle)){
//                currentWindowHandle2 = currentWindowHandles;
//                webDriver.switchTo().window(currentWindowHandles);
//                WebElement newElement = webDriver.findElement(By.xpath("//*[@id=\"user\"]"));
//                newElement.sendKeys("新窗口输入测试");
//            }
//
//        }

//        String currentWindowHandle3 = "";
//        currentWindowHandle3  = FrameCase.windowHand(webDriver, webDriver.getWindowHandle(), webDriver.getWindowHandles());
//            //如果获取的句柄和当前句柄不一样，与句柄2也不一样。则赋值给句柄3
//        for(String currentWindowHandles:webDriver.getWindowHandles()){
//            if(!currentWindowHandles.equals(currentWindowHandle)
//                    || !currentWindowHandles.equals(currentWindowHandle2)){
//                currentWindowHandle3 = currentWindowHandles;
//                webDriver.switchTo().window(currentWindowHandles);
//                WebElement newElement = webDriver.findElement(By.xpath("//*[@id=\"user\"]"));
//                newElement.sendKeys("新窗口输入测试");
//            }
//
//        }
            //如果想切换到指定窗口，传入指定窗口的句柄即可
        webDriver.switchTo().window(currentWindowHandle);

    }

    // 单个页面跳转
    public static String windowHand(WebDriver webDriver ,String window, Set<String> windowHandles){
        String windows = "";
        for (String windowHandle: windowHandles){
            if(!window.equals(windowHandle)){
//                currentWindowHandle2 = currentWindowHandles;
                webDriver.switchTo().window(windowHandle);
//                WebElement newElement = webDriver.findElement(By.xpath("//*[@id=\"user\"]"));
//                newElement.sendKeys("新窗口输入测试");
                windows = windowHandle;
                break;
            }
        }
        return windows;
    }

    @AfterMethod
    public void closeChrome() throws InterruptedException {
        Thread.sleep(2000);
        webDriver.quit();


    }


}

