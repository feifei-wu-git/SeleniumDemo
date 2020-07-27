package com.testng0715;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobject.LoginTest;

import java.net.MalformedURLException;
import java.net.URL;


public class AdminToolTest {





    //先声明一个WebDriver 的对象
//    WebDriver webDriver;
//    @BeforeMethod
//    public void login(){
//        System.setProperty("webdriver.chrome.driver","E:\\WFF\\Automation\\hub\\chromedriver.exe");
//        webDriver = new ChromeDriver();
////        webDriver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS); //TimeUnit 类里的Seconds属性。
//
//    }
//    @Test
//    public void  adminToolLogin() throws InterruptedException {
//        WebElement username = webDriver.findElement(By.xpath("//*[@id=\"username\"]"));
//        username.sendKeys("wuff5");
//        WebElement pw = webDriver.findElement(By.xpath("//*[@id=\"password\"]"));
//        pw.sendKeys("620520Wff#");
//        WebElement loginbutton = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div/form/button"));
//        loginbutton.click();
//        webDriver.manage().window().maximize();
//
//
//    }

    @DataProvider(name = "loginAccount")
    public Object[][] loginAccount(){
        return new Object[][]{
                {"wuff5","620520Wff"}, {"yyc","12345"}
        };
    }

    @Test(dataProvider = "loginAccount")
    public void adminToolLogin(String username,String pwd,String a , String b){
        System.setProperty("webdriver.chrome.driver","E:\\WFF\\workspace\\automation\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.baidu.com/");
        LoginTest.login(webDriver,username,pwd);

    }

    @DataProvider(name = "data1" )
    public Object[][] dataProvider(){
        return new Object[][]{
                {"http://10.98.88.96:5551","chrome"},
                {"http://10.98.88.96:5551","firefox"}
        };

    }
    @Test(dataProvider = "data1")
    public void flagDefineCase(String url,String Browse) throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities;
        if (Browse.equals("chrome")){
            desiredCapabilities = DesiredCapabilities.chrome();

        }else if(Browse.equals("firefox")){
            desiredCapabilities = DesiredCapabilities.firefox();

        }else {
            desiredCapabilities = DesiredCapabilities.internetExplorer();
        }
        String url1= url + "/wd/hub";
        WebDriver webDriver = new RemoteWebDriver(new URL(url1),desiredCapabilities);
        webDriver.get("https://ui-data-portal-dpc-dev.earth-aws-us.xpaas.lenovo.com/");
//        webDriver.quit();
//        LoginTest loginTest = new LoginTest();
//        loginTest.login(webDriver,"wuff5","1234");
        LoginTest.login(webDriver,"wuff5","620520Wff");

//        WebElement username = webDriver.findElement(By.xpath("//*[@id=\"username\"]"));
//        username.sendKeys("wuff5");
//        WebElement pw = webDriver.findElement(By.xpath("//*[@id=\"password\"]"));
//        pw.sendKeys("620520Wff#");
//        WebElement loginbutton = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div/form/button"));
//        loginbutton.click();
        webDriver.manage().window().maximize();
        WebElement until = new WebDriverWait(webDriver, 11).
                until(ExpectedConditions.presenceOfElementLocated(By.linkText("Flags Define")));
//        Thread.sleep(10000);
        //flag define menu
        WebElement flagdefinemenu = webDriver.findElement(By.linkText("Flags Define"));
        flagdefinemenu.click();
        WebElement flagdefine = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div/div/div/div[1]"));
        String acfd = flagdefine.getText();
        String exfd = "Flags Define";
        System.out.println("预期结果是："+ acfd);
//        Assert.assertEquals(acfd,exfd,"页面打开不正常");
//        WebElement until = new WebDriverWait(webDriver, 5).
//                until(ExpectedConditions.presenceOfElementLocated(By.id("")));
        /**
         * 0.五秒钟内如果出现create button 则继续下面操作，超过五秒抛出异常
         * 1.点击create
         * 2.输入ATFlag
         * 3.保存
         */
        System.out.println("111111");
        Thread.sleep(5000);
        new WebDriverWait(webDriver,5000).
               until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div/div/div/div[3]/button")));
        System.out.println("111111");
        WebElement createButton = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div/div/div/div[3]/button"));
        System.out.println("2222");
        createButton.click();
        System.out.println("3333");
        new WebDriverWait(webDriver,3000).until(ExpectedConditions.presenceOfElementLocated(By.id("description")));
        System.out.println("4444");
        WebElement createInput = webDriver.findElement(By.id("description"));
       createInput.sendKeys("ATFlag");
       WebElement addButton = webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]"));
       new WebDriverWait(webDriver,5000).until(ExpectedConditions.presenceOfElementLocated(
               By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div/div/div/div[5]/div/div/div/div/div/table/tbody/tr[1]")));
       addButton.click();
       Thread.sleep(3000);
       WebElement wait2 = new WebDriverWait(webDriver,1000).
               until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div/div/div/div[5]/div/div/div/div/div/table/tbody/tr[1]/td[1]/span")));
       WebElement flag = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div/div/div/div[5]/div/div/div/div/div/table/tbody/tr[1]/td[1]/span"));
//       // delete flag
//        WebElement deleteIcon = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div/div/div/div[5]/div/div/div/div/div/table/tbody/tr[1]/td[3]/span/i[2]"));
//        deleteIcon.click();
//        Thread.sleep(3000);
//        WebElement deleteConfirm = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[2]"));
//        deleteConfirm.click();
//        Thread.sleep(3000);
//        //Search flag
//        WebElement searchBox = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div/div/div/div[3]/div/span/input"));
//        searchBox.sendKeys("ATFlag");
//        Thread.sleep(3000);
//        WebElement searchResult = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div/div/div/div[5]/div/div/div/div/div[2]/div/p/span/b"));
//        String resultText = searchResult.getText();
//        String exceptedText = "We didn’t find any results";
//        Assert.assertEquals(resultText,exceptedText,"刪除失敗");


       String acflag = flag.getText();
       System.out.println("acflag=" + acflag);
       String exflag = "ATFlag";
//       if(acflag == exflag){
//           System.out.println("Flag创建成功");
//       }else {
//           System.out.println("Flag创建失败");
//       }
       Assert.assertEquals(acflag,exflag,"创建失败");






    }

//    @Test
//    public void deleteFlagTest() throws InterruptedException {
//        webDriver.get("http://ui-data-portal-dpc-dev.earth-aws-us.xpaas.lenovo.com/");
//        webDriver.manage().window().maximize();
//        WebElement username = webDriver.findElement(By.xpath("//*[@id=\"username\"]"));
//        username.sendKeys("wuff5");
//        WebElement pw = webDriver.findElement(By.xpath("//*[@id=\"password\"]"));
//        pw.sendKeys("620520Wff#");
//        WebElement loginbutton = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div/form/button"));
//        loginbutton.click();
//        Thread.sleep(3000);
//        //flag define menu
//        WebElement flagdefinemenu = webDriver.findElement(By.linkText("Flags Define"));
//        flagdefinemenu.click();
//        Thread.sleep(3000);
//        // delete flag
//        WebElement deleteIcon = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div/div/div/div[5]/div/div/div/div/div/table/tbody/tr[1]/td[3]/span/i[2]"));
//        deleteIcon.click();
//        Thread.sleep(3000);
//        WebElement deleteConfirm = webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]"));
//        deleteConfirm.click();
//        Thread.sleep(3000);
//        //Search flag
//        WebElement searchBox = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div/div/div/div[3]/div/span/input"));
//        searchBox.sendKeys("ATFlag");
//        Thread.sleep(3000);
//        WebElement searchResult = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div/div/div/div[5]/div/div/div/div/div[2]/div/p/span/b"));
//        String resultText = searchResult.getText();
//        String exceptedText = "We didn’t find any results";
//        Assert.assertEquals(resultText,exceptedText,"刪除失敗");
//
//
//    }

//
//    @Test
//    public void screenShot(){
//        System.setProperty("webdriver.chrome.driver","E:\\WFF\\workspace\\automation\\drivers\\chromedriver.exe");
//        webDriver = new ChromeDriver();
//        webDriver.get("https://www.baidu.com/");
//        WebElement until = new WebDriverWait(webDriver, 5).
//                until(ExpectedConditions.presenceOfElementLocated(By.id("")));
//        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
//        File screenshotAs = takesScreenshot.getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(screenshotAs,new File("E:\\WFF\\workspace\\automation\\screenshot\\test01.jpg"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//    @AfterMethod
//    public void closeChrome() throws InterruptedException {
//        Thread.sleep(3000);
//        webDriver.quit();
//
//    }


}

