package com.mode;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import java.net.URL;
//import java.util.HashMap;
//import java.util.Map;

public class ModeTest1 {

//    // System.setProperty(); 设置驱动 注：代码启的时候必须要setProperty ;  hub的时候，jar包目录下必须有
//    @Test
//    public void start(){
//        System.setProperty("webdriver.chrome.driver","E:\\WFF\\workspace\\automation\\drivers\\chromedriver.exe");
//        WebDriver webDriver = new ChromeDriver(); // 本地启动浏览器
////        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome(); // hub启动
////        WebDriver webDriver = new RemoteWebDriver(new URL(""),desiredCapabilities);// url是hub地址如：192.168.0.1:8080/wd/hub
//        webDriver.get("");
//        webDriver.findElement(By.xpath("")).sendKeys("");//登录用户
//        webDriver.findElement(By.xpath("")).sendKeys("");//登录密码
//        webDriver.findElement(By.xpath("")).sendKeys("");//点击登录
//        webDriver.quit();// 关闭浏览器
//
//    }
//
//    @DataProvider(name = "data")
//    public Object[][] data(){
//
//        Map<Object,Object> map = new HashMap();
//        map.put("username","a");
//        map.put("password","123");
//        map.put("email","asd");
//        map.put("phone","123456788");
//
//        Map map1 = new HashMap();
//        map1.put("username","b");
//        map1.put("password","123");
//        map1.put("email","asd");
//        map1.put("phone","123456788");
//
//        Map map2 = new HashMap();
//        map2.put("username","c");
//        map2.put("password","123");
//        map2.put("email","asd");
//        map2.put("phone","123456788");
//
//        Map map3 = new HashMap();
//        map3.put("username","d");
//        map3.put("password","123");
//        map3.put("email","asd");
//        map3.put("phone","123456788");
//
//        Object[][] data = new Object[][]{
//                {map},{map1},{map2},{map3}};
//
//        return data;
//    }
//
//    @Test(dataProvider = "data")
//    public void case01(Map<Object,Object> map){
//        String username = String.valueOf(map.get("username"));
//        String password = String.valueOf(map.get("password"));
//        String email = String.valueOf(map.get("email"));
//        String phone = String.valueOf(map.get("phone"));
//
//        System.out.println(username);
//        System.out.println(password);
//        System.out.println(email);
//        System.out.println(phone);
//        System.out.println("----------------------------------------");
//    }

//    @Test
//    public void case2(){
//        System.setProperty("webdriver.chrome.driver","E:\\WFF\\workspace\\automation\\drivers\\chromedriver.exe");
//        WebDriver webDriver = new ChromeDriver(); // 本地启动浏览器
//        webDriver.get("www.163.com");
//        ElementTest.login(webDriver,"","");
//        webDriver.quit();// 关闭浏览器
//    }
}

//class ElementTest{
//    // 提取登录方法
//    public static void login(WebDriver webDriver,String username,String pwd){
//        webDriver.findElement(PageObjectTest.userBy).sendKeys(username);//登录用户
//        webDriver.findElement(PageObjectTest.pwdBy).sendKeys(pwd);//登录密码
//        webDriver.findElement(PageObjectTest.clickBy).click();//点击登录
//    }
//}
//
//class PageObjectTest{
//
//    public static By userBy = By.xpath("");
//    public static By pwdBy = By.xpath("");
//    public static By clickBy = By.xpath("");
//}